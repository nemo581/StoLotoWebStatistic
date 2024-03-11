package com.stoloto.webstatic.service;

import com.stoloto.webstatic.model.StatisticModel;
import com.stoloto.webstatic.repository.StatisticRepository;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
public class StatisticService {
    private final StatisticRepository statisticRepository;

    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    public List<StatisticModel> getStatisticList(Integer circulation) {
        if (circulation != null) return statisticRepository.findStatisticModelByCirculation(circulation);
        return statisticRepository.findAll();
    }

    public StatisticModel getStatisticByCirculation(Integer circulation) {
        return statisticRepository.findById(circulation).orElse(null);
    }

    public void saveStatisticData(StatisticModel statisticModel) {
        log.info("Saving new {}", statisticModel);
        statisticRepository.save(statisticModel);
    }

    public void updateStatistic() throws IOException {
        StatisticModel updateStatisticModel;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter dateTimeFormatter_temp = DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm");
        LocalDateTime dateTime_from;

        if (getStatisticList(null).isEmpty()) {
            dateTime_from = LocalDateTime.of(2016, Month.DECEMBER, 30, 0, 0, 0);
            System.out.println("\u001B[36m" + "Тumber of elements: " + getStatisticList(null).size() + ", starting date: " + dateTime_from.format(dateTimeFormatter) + "\u001B[0m");
        } else {
            dateTime_from = getStatisticList(getStatisticList(null).size()).get(0).getDate();
            System.out.println("\u001B[36m" + "Тumber of elements: " + getStatisticList(null).size() + ", starting date: " + dateTime_from.format(dateTimeFormatter) + "\u001B[0m");
        }

        System.out.println("\u001B[31m" + "The update has started" + LocalDateTime.now().format(dateTimeFormatter_temp) + "\u001B[0m");
        while (!(dateTime_from.toLocalDate().equals(LocalDateTime.now().toLocalDate().plusDays(1)))) {
            String url = "https://www.stoloto.ru/4x20/archive?from=" + dateTimeFormatter.format(dateTime_from) + "&to=" + dateTimeFormatter.format(dateTime_from) + "&firstDraw=1&lastDraw=7500&mode=date";
            Document document = null;
            System.out.println("\u001B[31m" + dateTime_from.format(dateTimeFormatter_temp) + "\u001B[0m");
            try {
                document = Jsoup.connect(url).get();
                Elements elements = document.getElementsByClass("main");
                for (Element el : elements) {
                    if (getStatisticList(Integer.parseInt(el.getElementsByTag("a").text().replace('⚲', ' ').strip())).isEmpty() && dateTime_from.toLocalDate().equals(LocalDateTime.now().toLocalDate())) {
                        updateStatisticModel = new StatisticModel(LocalDate.parse(el.getElementsByClass("draw_date").text().substring(0, 10), dateTimeFormatter)
                                .atTime(Integer.parseInt(el.getElementsByClass("draw_date").text().substring(11, 13)),
                                        Integer.parseInt(el.getElementsByClass("draw_date").text().substring(14, 16))),
                                Integer.parseInt(el.getElementsByTag("a").text().replace('⚲', ' ').strip()),
                                Byte.parseByte(el.getElementsByTag("b").get(0).text()),
                                Byte.parseByte(el.getElementsByTag("b").get(1).text()),
                                Byte.parseByte(el.getElementsByTag("b").get(2).text()),
                                Byte.parseByte(el.getElementsByTag("b").get(3).text()),
                                Byte.parseByte(el.getElementsByTag("b").get(4).text()),
                                Byte.parseByte(el.getElementsByTag("b").get(5).text()),
                                Byte.parseByte(el.getElementsByTag("b").get(6).text()),
                                Byte.parseByte(el.getElementsByTag("b").get(7).text()),
                                el.getElementsByClass("prize").text());
                        saveStatisticData(updateStatisticModel);
                    }
                }
            } catch (UnknownHostException e) {
                System.out.println(e.getMessage() + ": " + "\u001B[31m" + " not connection" + "\u001B[0m \n" + url);
            }
            dateTime_from = dateTime_from.plusDays(1);
        }
        System.out.println("\u001B[31m" + "The update is over" + LocalDateTime.now().format(dateTimeFormatter_temp) + "\u001B[0m");
    }
}
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
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StatisticService {
    private final StatisticRepository statisticRepository;

    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    public List<StatisticModel> getStatisticList(Long id) {
        if (id != null) return statisticRepository.findStatisticModelById(id);
        return statisticRepository.findAll();
    }

    public void saveStatisticData(StatisticModel statisticModel) {
        log.info("Saving new {}", statisticModel);
        statisticRepository.save(statisticModel);
    }

    public StatisticModel getStatisticById(Long id) {
        return statisticRepository.findById(id).orElse(null);
    }

/*
        Добавление метода получения данных с сайта:
 */
    public List<StatisticModel> uploadingData() throws IOException {
        StatisticModel statisticModel = null;
        List<StatisticModel> stat = new ArrayList<>();
        String url = "https://www.stoloto.ru/4x20/archive?from=18.01.2024&to=18.01.2024&firstDraw=1&lastDraw=7500&mode=date";
        Document document = Jsoup.connect(url).get();
        Elements elements = document.getElementsByClass("main");
        for (Element el : elements) {
            statisticModel = new StatisticModel(Long.parseLong(el.getElementsByTag("a").text().replace('⚲', ' ').strip()),
                                                el.getElementsByClass("draw_date").text(),
                                                Byte.parseByte(el.getElementsByTag("b").get(0).text()),
                                                Byte.parseByte(el.getElementsByTag("b").get(1).text()),
                                                Byte.parseByte(el.getElementsByTag("b").get(2).text()),
                                                Byte.parseByte(el.getElementsByTag("b").get(3).text()),
                                                Byte.parseByte(el.getElementsByTag("b").get(4).text()),
                                                Byte.parseByte(el.getElementsByTag("b").get(5).text()),
                                                Byte.parseByte(el.getElementsByTag("b").get(6).text()),
                                                Byte.parseByte(el.getElementsByTag("b").get(7).text()));
            stat.add(statisticModel);
        }
        return stat;
    }
}
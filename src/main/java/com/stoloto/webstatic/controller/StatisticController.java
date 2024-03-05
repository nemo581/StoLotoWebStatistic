package com.stoloto.webstatic.controller;

import com.stoloto.webstatic.model.StatisticModel;
import com.stoloto.webstatic.service.StatisticService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Controller
public class StatisticController {
    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }
    @GetMapping("/")
    public String getStatistic(@RequestParam(name = "circulation", required = false) Integer circulation, Model model) {
        System.out.println("getStatistic method" + " " + circulation);
        model.addAttribute("getStatisticList", statisticService.getStatisticList(circulation));
        return "statistic";
    }

    @GetMapping("/statistic/{circulation}")
    public String getStatisticDetails(@PathVariable Integer circulation, Model model) {
        model.addAttribute("getStatisticByCirculation", statisticService.getStatisticByCirculation(circulation));
        return "statistic-info";
    }

//    @PostMapping("/statistic/create/")
//    public String addStatistic(StatisticModel statisticModel) {
//        statisticService.saveStatisticData(statisticModel);
//        return "redirect:/";
//    }

    @GetMapping("/updateData")
    public String updateData() throws IOException {
        StatisticModel statisticModel;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime dateTime_from;

        if (statisticService.getStatisticList(null).isEmpty()) {
            dateTime_from = LocalDateTime.of(2016, Month.DECEMBER, 30, 0, 0, 0);
        } else {
            dateTime_from = LocalDate.parse(statisticService.getStatisticList(statisticService.getStatisticList(null).size()).
                                            get(0).getDate().substring(0, 10), dateTimeFormatter).atStartOfDay();
        }

        while (!(LocalDateTime.now().minusDays(1).toLocalDate().equals(dateTime_from.toLocalDate()))) {
            dateTime_from = dateTime_from.plusDays(1);
            String url = "https://www.stoloto.ru/4x20/archive?from=" + dateTimeFormatter.format(dateTime_from) + "&to=" + dateTimeFormatter.format(dateTime_from) + "&firstDraw=1&lastDraw=7500&mode=date";
            Document document = null;
            try {
                document = Jsoup.connect(url).get();
                Elements elements = document.getElementsByClass("main");
                for (Element el : elements) {
                    statisticModel = new StatisticModel(el.getElementsByClass("draw_date").text(),
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
                    statisticService.saveStatisticData(statisticModel);
                }
            } catch (UnknownHostException e) {
                System.out.println(e.getMessage() + ": " + "\u001B[31m" + " not connection" + "\u001B[0m \n" + url);
            }
        }
        return "redirect:/";
    }




//    @PostMapping("/")
//    public String newMethod() {
//        try {
//            for(StatisticModel st : statisticService.uploadingData()) {
//                addStatistic(st);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return "redirect:/";
//    }
}
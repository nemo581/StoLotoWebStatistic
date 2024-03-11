package com.stoloto.webstatic.controller;

import com.stoloto.webstatic.service.StatisticService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class StatisticController {
    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/")
    public String getAllStatistic(@RequestParam(name = "circulation", required = false) Integer circulation, Model model) {
        model.addAttribute("getStatisticList", statisticService.getStatisticList(circulation));
        return "statistic";
    }

    @GetMapping("/statistic/{circulation}")
    public String getStatisticDetails(@PathVariable Integer circulation, Model model) {
        model.addAttribute("getStatisticByCirculation", statisticService.getStatisticByCirculation(circulation));
        return "statistic-info";
    }

    @GetMapping("/updateData")
    public String updateData() throws IOException {
        statisticService.updateStatistic();
        return "redirect:/";
    }
}
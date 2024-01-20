package com.stoloto.webstatic.controller;

import com.stoloto.webstatic.model.StatisticModel;
import com.stoloto.webstatic.service.StatisticService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StatisticController {
    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }
    @GetMapping("/")
    public String getStatistic(@RequestParam(name = "id", required = false)Long id, Model model) {
        model.addAttribute("getStatisticList", statisticService.getStatisticList(id));
        return "statistic";
    }

    @GetMapping("/statistic/{id}")
    public String getStatisticDetails(@PathVariable Long id, Model model) {
        model.addAttribute("getStatisticById", statisticService.getStatisticById(id));
        return "statistic-info";
    }

    @PostMapping("/statistic/create/")
    public String addStatistic(StatisticModel statisticModel) {
        statisticService.saveStatisticData(statisticModel);
        return "redirect:/";
    }
}
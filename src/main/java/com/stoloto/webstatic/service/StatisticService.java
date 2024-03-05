package com.stoloto.webstatic.service;

import com.stoloto.webstatic.model.StatisticModel;
import com.stoloto.webstatic.repository.StatisticRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
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

    public void saveStatisticData(StatisticModel statisticModel) {
        log.info("Saving new {}", statisticModel);
        statisticRepository.save(statisticModel);
    }

    public StatisticModel getStatisticByCirculation(Integer circulation) {
        return statisticRepository.findById(circulation).orElse(null);
    }

//    public List<StatisticModel> getLastDate() {
//        return statisticRepository.findAll();
//    }
}
package com.stoloto.webstatic.service;

import com.stoloto.webstatic.model.StatisticModel;
import com.stoloto.webstatic.repository.StatisticRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
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
}
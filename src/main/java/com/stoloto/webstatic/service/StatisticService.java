package com.stoloto.webstatic.service;

import com.stoloto.webstatic.model.StatisticModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticService {
    private List<StatisticModel> statisticList = new ArrayList<>();
    private long ID = 0;

    {
        statisticList.add(new StatisticModel(++ID, "20.01.2024 0:59", (byte) 1, (byte) 15, (byte) 4, (byte) 20, (byte) 6, (byte) 13, (byte) 1, (byte) 1));
        statisticList.add(new StatisticModel(++ID, "20.01.2024 0:59", (byte) 8, (byte) 10, (byte) 13, (byte) 18, (byte) 5, (byte) 2, (byte) 6, (byte) 18));
    }

    public List<StatisticModel> getStatisticList() {
        return statisticList;
    }

    public void saveStatisticData(StatisticModel statisticModel) {
        statisticModel.setId(++ID);
        statisticList.add(statisticModel);
    }

    public StatisticModel getStatisticById(Long id) {
        for (StatisticModel statisticModel : statisticList) {
            if (statisticModel.getId().equals(id)) return statisticModel;
        }
        return null;
    }
}

package com.stoloto.webstatic.repository;

import com.stoloto.webstatic.model.StatisticModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StatisticRepository extends JpaRepository<StatisticModel, Integer> {
    List<StatisticModel> findStatisticModelByCirculation(Integer circulation);
}
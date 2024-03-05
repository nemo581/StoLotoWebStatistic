package com.stoloto.webstatic;

import com.stoloto.webstatic.controller.StatisticController;
import com.stoloto.webstatic.repository.StatisticRepository;
import com.stoloto.webstatic.service.StatisticService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileWriter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@SpringBootTest
class StoLotoWebStaticApplicationTests {
    public static void main(String[] args) throws IOException {
        LocalDateTime dateTime_from = LocalDateTime.of(2024, Month.MARCH, 4, 0, 0, 0);
        LocalDateTime dateTime_to = LocalDateTime.now();
        System.out.println(dateTime_from + " " + dateTime_to + " " +
                dateTime_from.toLocalDate().equals(dateTime_to.toLocalDate()));

    }

//    @Test
//    void contextLoads() {
//    }
}

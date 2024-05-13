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
    public static void main(String[] args) {
    }

    @Test
    void contextLoads() {

    }
}

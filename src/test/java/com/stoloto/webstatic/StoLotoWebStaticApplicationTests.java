package com.stoloto.webstatic;

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
    String date;
    String circulation;
    byte d_1, d_2, d_3, d_4, d_5, d_6, d_7, d_8;
    String prize;

    public StoLotoWebStaticApplicationTests(String date, String circulation, byte d_1, byte d_2, byte d_3, byte d_4, byte d_5, byte d_6, byte d_7, byte d_8, String prize) {
        this.date = date;
        this.circulation = circulation;
        this.d_1 = d_1;
        this.d_2 = d_2;
        this.d_3 = d_3;
        this.d_4 = d_4;
        this.d_5 = d_5;
        this.d_6 = d_6;
        this.d_7 = d_7;
        this.d_8 = d_8;
        this.prize = prize;
    }

    public static void main(String[] args) throws IOException {
        StoLotoWebStaticApplicationTests stoLotoWebStaticApplicationTests;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime dateTime_from = LocalDateTime.of(2016, Month.DECEMBER, 30, 0, 0, 0);
        LocalDateTime dateTime_to = LocalDateTime.now();

        while (!(dateTime_to.toLocalDate().equals(dateTime_from.toLocalDate()))) {
            dateTime_from = dateTime_from.plusDays(1);
            String url = "https://www.stoloto.ru/4x20/archive?from=" + dateTimeFormatter.format(dateTime_from) + "&to=" + dateTimeFormatter.format(dateTime_from) + "&firstDraw=1&lastDraw=7500&mode=date";
            Document document = null;
            try {
                document = Jsoup.connect(url).get();
                Elements elements = document.getElementsByClass("main");
                for (Element el : elements) {
                    stoLotoWebStaticApplicationTests = new StoLotoWebStaticApplicationTests(el.getElementsByClass("draw_date").text(),
                            el.getElementsByTag("a").text().replace('⚲', ' ').strip(),
                            Byte.parseByte(el.getElementsByTag("b").get(0).text()),
                            Byte.parseByte(el.getElementsByTag("b").get(1).text()),
                            Byte.parseByte(el.getElementsByTag("b").get(2).text()),
                            Byte.parseByte(el.getElementsByTag("b").get(3).text()),
                            Byte.parseByte(el.getElementsByTag("b").get(4).text()),
                            Byte.parseByte(el.getElementsByTag("b").get(5).text()),
                            Byte.parseByte(el.getElementsByTag("b").get(6).text()),
                            Byte.parseByte(el.getElementsByTag("b").get(7).text()),
                            el.getElementsByClass("prize").text());
                    System.out.println(stoLotoWebStaticApplicationTests);
                }
            } catch (UnknownHostException e) {
                System.out.println(e.getMessage() + ": " + "\u001B[31m" + " not connection" + "\u001B[0m \n" + url);
                return;
            }
        }
    }

//    @Test
//    void contextLoads() {
//    }

    @Override
    public String toString() {
        return String.format("%-34s %-18s %-3s [%-3d %-3d %-3d %-3d |  %-3d %-3d %-3d %-2d]   %s",
                getClass().getSimpleName(),
                date,
                circulation,
                d_1, d_2, d_3, d_4,
                d_5, d_6, d_7, d_8, prize);


//        return String.format("\u001b[38;5;39m%-34s\u001b[38;5;31m %-18s %-6s \u001b[38;5;106m[%-3d %-3d %-3d %-3d |  %-3d %-3d %-3d %-2d] \u001b[38;5;31m%16s\u001B[0m",
//                getClass().getSimpleName(),
//                date,
//                circulation,
//                d_1, d_2, d_3, d_4,
//                d_5, d_6, d_7, d_8, prize);
    }

}

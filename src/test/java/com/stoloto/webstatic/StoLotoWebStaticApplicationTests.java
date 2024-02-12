package com.stoloto.webstatic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

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
        String url = "https://www.stoloto.ru/4x20/archive?from=18.01.2024&to=18.01.2024&firstDraw=1&lastDraw=7500&mode=date";
        Document document = Jsoup.connect(url).get();
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
            System.out.println(stoLotoWebStaticApplicationTests + "\n");
        }
    }

//    @Test
//    void contextLoads() {
//    }

    @Override
    public String toString() {
        return "StoLotoWebStaticApplicationTests{ " +
                date + " " + circulation + " [ " +
                d_1 + " " + d_2 + " " + d_3 + " " + d_4 + " | " +
                d_5 + " " + d_6 + " " + d_7 + " " + d_8 + " ] " +
                prize +
                " }";
    }

}

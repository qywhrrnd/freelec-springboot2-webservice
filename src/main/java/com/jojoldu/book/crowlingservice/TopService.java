package com.jojoldu.book.crowlingservice;


import com.jojoldu.book.crowling.TopStats;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.io.IOException;

@Service
public class TopService {

    private static String MUSIC_NAVER_URL = "https://music.naver.com/listen/top100.nhn?domain=DOMESTIC_V2";

    @PostConstruct
    public void getMusicNaver() throws IOException {

        Document doc = Jsoup.connect(MUSIC_NAVER_URL).get();
        Elements contents = doc.select("table tbody tr._tracklist_move");

        for (Element tdContents : contents) {



            TopStats topStats = TopStats.builder()

                    .num(tdContents.select("td.ranking").text())
                    .change(tdContents.select("td.change").text())
                    .name(tdContents.select("td.name").text())
                    .artist(tdContents.select("td._artist.artist").text())
                    .lylic(tdContents.select("td.ico._lyric lyric").text())
                    .build();



            System.out.println(topStats);
        }
    }
}



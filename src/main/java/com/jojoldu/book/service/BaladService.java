package com.jojoldu.book.service;


import com.jojoldu.book.dto.BaladDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BaladService {

    private static String MUSIC_NAVER_URL = "https://music.naver.com/listen/genre/top100.nhn?domain=DOMESTIC&genre=K01";

    @PostConstruct
    public List<BaladDto> getMusicNaver() throws IOException {


        List<BaladDto> baladList = new ArrayList<>();
        Document doc = Jsoup.connect(MUSIC_NAVER_URL).get();
        Elements contents = doc.select("table tbody tr._tracklist_move");

        for (Element tdContents : contents) {

            BaladDto baladStats = BaladDto.builder()

                    .num(tdContents.select("td.ranking").text())
                    .change(tdContents.select("td.change").text())
                    .name(tdContents.select("td.name").text())
                    .artist(tdContents.select("td._artist.artist").text())
                    .lyric(tdContents.select("td.ico._lyric lyric").text())
                    .build();

            System.out.println(baladStats.toString());

            baladList.add(baladStats);
        }
        return baladList;
    }
}



/*
package com.jojoldu.book.service;


import com.jojoldu.book.domain.MusicEntity;
import com.jojoldu.book.domain.MusicRepository;
import com.jojoldu.book.dto.TopDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j //로그 처리
@RequiredArgsConstructor
@Service
public class BaladService {

    private static String MUSIC_NAVER_URL = "https://music.naver.com/listen/top100.nhn?domain=DOMESTIC_V2";
    private final MusicRepository musicRepository;

    //    @PostConstruct
    public List<MusicEntity> getMusicNaver() throws IOException {

        List<MusicEntity> baladList = new ArrayList<MusicEntity>();
        Document doc = Jsoup.connect(MUSIC_NAVER_URL).get();
        Elements contents = doc.select("table tbody tr._tracklist_move");

        int i = 1;
        for (Element tdContents : contents) {

            MusicEntity musicEntity = MusicEntity.builder()
                    .num(tdContents.select("td.ranking").text())
                    .change(tdContents.select("td.change").text())
                    .name(tdContents.select("td.name").text())
                    .artist(tdContents.select("td._artist.artist").text())
                    .lyric(tdContents.select("td.ico._lyric lyric").text())
                    .build();
            musicRepository.save(musicEntity);
            baladList.add(musicEntity);

            log.info("---------------------------");
            log.info(i+"번째 노래 크롤링 시작");
            log.info("순위"+tdContents.select("td.ranking").text());
            log.info("순위 변동값"+tdContents.select("td.change").text());
            log.info("제목"+tdContents.select("td.name").text());
            log.info("가수"+tdContents.select("td._artist.artist").text());
            log.info("가사"+tdContents.select("td.ico._lyric lyric").text());
            log.info("---------------------------");
            i++;
        }
        return baladList;
    }
}


*/

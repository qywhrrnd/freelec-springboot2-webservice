package com.jojoldu.book.service;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class CrawlingService {

    public static void main(String[] args) throws IOException {
        baladCrawling();
    }

    public static void baladCrawling() throws IOException {

        int i=1;
        for(int page=1;page<3;page++) {
            String url = "https://music.naver.com/listen/genre/top100.nhn?domain=DOMESTIC&genre=K01&page=" + page;
            Document doc = Jsoup.connect(url).get();

            for (int n = 2; n < 51; n++) {
                Elements trElement = doc.select("tr._tracklist_move:nth-child(" + n + ")");

                String rank = trElement.select("td.ranking span").text();
                log.info(rank);
                String name = trElement.select("td.name a._title span.ellipsis").text();
                String detailUrl = "https://music.naver.com" + trElement.select("td.name a.thumb").text();
                log.info(detailUrl);
                String genre = "발라드";
                String artist = trElement.select("td._artist a._artist span.ellipsis").text();
                log.info(trElement.select("td.name a._title").attr("href"));
                String lyricUrl = "https://music.naver.com/lyric/index.nhn?trackId=" + trElement.select("td.name a._title").attr("href").substring(1);
                Document lyricDoc = Jsoup.connect(lyricUrl).get();
                String lyric = lyricDoc.select("div.section_lyrics div#lyricText").text();

                log.info("------------------------------");
                log.info(i + "번째 노래 크롤링 시작");
                log.info("순위: " + rank);
                log.info("제목: " + name);
                log.info("장르: " + genre);
                log.info("가수: " + artist);
                log.info("가사: " + lyric);
                log.info("------------------------------");
                i++;
            }
        }




        }


    }

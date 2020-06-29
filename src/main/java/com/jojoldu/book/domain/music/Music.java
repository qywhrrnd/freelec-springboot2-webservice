package com.jojoldu.book.domain.music;

import lombok.*;

import javax.persistence.*;

@Builder @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Music {

    @Id @GeneratedValue
    private Long id;

    //크롤링 시작 -> 날짜별로 크롤링한 값들 구분하기 위한 컬럼값
    private String searchDate;

    //순위
    private String rank;

//    변동값
//    private String change;

    //제목
    private String name;

    //이미지
    private String img;

    //장르
    private String genre;

    //가수
    private String artist;

    //가사
    @Lob @Basic(fetch = FetchType.LAZY)
    private String lyric;
}

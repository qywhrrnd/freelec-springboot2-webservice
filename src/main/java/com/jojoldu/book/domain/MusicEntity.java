package com.jojoldu.book.domain;

import lombok.*;

import javax.persistence.*;

@Builder @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class MusicEntity {

    @Id @GeneratedValue
    private Long id;

    //순위
    private String num;

    //변동값
    private String change;

    //제목
    private String name;

    //가수
    private String artist;

    //가사
    @Lob @Basic(fetch = FetchType.LAZY)
    private String lyric;
}

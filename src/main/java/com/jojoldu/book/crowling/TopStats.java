package com.jojoldu.book.crowling;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class TopStats {

    private String num;
    private String change;
    private String name;
    private String artist;
    private String lylic;

}

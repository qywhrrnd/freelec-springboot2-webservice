package com.jojoldu.book.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class TopDto {

    private String num;
    private String change;
    private String name;
    private String artist;
    private String lylic;
}

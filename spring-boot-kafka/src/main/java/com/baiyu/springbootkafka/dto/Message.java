package com.baiyu.springbootkafka.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Message {


    private Long id;

    private String msg;

    private LocalDateTime sendTime;
}
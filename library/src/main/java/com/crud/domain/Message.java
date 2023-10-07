package com.crud.domain;

import lombok.Data;

@Data
public class Message {
    private Integer id;
    private String msg;
    private String isread;
}

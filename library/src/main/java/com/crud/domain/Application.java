package com.crud.domain;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Data
public class Application {
    public Integer id;
    public Integer user_id;
    public String user_name;
    public String application_data;
    public String application_reason;
    public String number;
    public String handleby;
    public String handleResult;
}

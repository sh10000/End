package com.crud.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class UserInform {
    private Integer id;
    private String username;
    private String address;
    private String number;
    private String isnull;
    private Integer gasid;
    private Integer groupid;
    private Integer price;
    @TableField(select = false)
    private String groupname;
}

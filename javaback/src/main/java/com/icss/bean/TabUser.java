package com.icss.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TabUser {
    private Integer uid;

    private String username;

    private String password;

    private String name;

    private Date birthday;

    private String sex;

    private String telephone;

    private String email;
}
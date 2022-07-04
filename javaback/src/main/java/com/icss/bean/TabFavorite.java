package com.icss.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TabFavorite {
    private Integer rid;

    private Integer uid;

    private Date date;
}
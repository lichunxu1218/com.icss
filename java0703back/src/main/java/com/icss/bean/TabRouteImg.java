package com.icss.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TabRouteImg {
    private Integer rgid;

    private Integer rid;

    private String bigpic;

    private String smallpic;
}
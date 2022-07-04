package com.icss.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TabSeller {
    private Integer sid;

    private String sname;

    private String consphone;

    private String address;
}
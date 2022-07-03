package com.icss.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResResult<T> {
    private int code;
    private String msg;
    private T data;

    public ResResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

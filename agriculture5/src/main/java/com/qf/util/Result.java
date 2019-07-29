package com.qf.util;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 8676131899637805509L;

    // 返回编码
    private String code;
    // 返回信息
    private String msg;
    // 返回数据封装
    private T data;
}

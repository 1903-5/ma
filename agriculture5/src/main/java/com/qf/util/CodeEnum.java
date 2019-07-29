package com.qf.util;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CodeEnum {

    OK("0", "成功"),
    NAME_NULL("63001", "用户名为空"),
    PASS_ERROR("64005", "密码错误");

    private String code;
    private String msg;

    // 根据code返回msg信息
    public String getMsgByCode(String code) {
        for (CodeEnum entry : CodeEnum.values()) {
            if (Objects.equals(entry.getCode(), code)) {
                return entry.getMsg();
            }
        }
        return "";
    }
}

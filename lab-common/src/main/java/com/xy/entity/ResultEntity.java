package com.xy.entity;

import com.xy.constant.Constant;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultEntity<T> {
    private int code; // 状态码
    private String message; //
    private T data; // 数据

    public ResultEntity(T data) {
        this(Constant.SUCCESS_CODE, Constant.SUCCESS_MESSAGE, data);
    }

    public ResultEntity(int code, String message) {
        this(code, message, null);
    }

    public ResultEntity(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}

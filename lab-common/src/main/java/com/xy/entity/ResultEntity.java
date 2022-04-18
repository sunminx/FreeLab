package com.xy.entity;

import com.xy.constant.Constant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "服务接口响应实体")
@Data
@NoArgsConstructor
public class ResultEntity<T> {
    @ApiModelProperty("状态码")
    private int code;

    @ApiModelProperty("接口响应信息")
    private String message;

    @ApiModelProperty("接口响应数据")
    private T data;

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

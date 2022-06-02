package com.example.dstimer.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接口统一返回的包装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    //状态码
    private String code;

    //提示信息
    private String msg;

    //返回给前端的数据 可以是任何类型 这里用Object
    private Object data;

    //默认成功 没有提升不给数据
    public static Result success() {
        return new Result(Constants.CODE_200, "", null);
    }

    //成功 数据返回 没有提示
    public static Result success(Object data) {
        return new Result(Constants.CODE_200, "", data);
    }

    //错误的时候 传Null 不给数据 给提示
    public static Result error(String code,String msg) {
        return new Result(code, msg, null);
    }

    //无脑报系统错误
    public static Result error() {
        return new Result(Constants.CODE_500, "系统错误", null);
    }

}

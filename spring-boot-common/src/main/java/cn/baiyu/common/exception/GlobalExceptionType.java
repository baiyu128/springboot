package cn.baiyu.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GlobalExceptionType implements BaseGlobalException.ExceptionType {
    /**
     * 异常类型
     */
    // 用户和我们的交互异常
    BUSINESS_EXCEPTION("业务异常"),
    // 用户和他们自己的数据库交互异常
    DATABASE_EXCEPTION("数据库异常"),
    // 传参有误异常
    INVALID_ARGUMENT_EXCEPTION("参数不合法异常");

    private final String zh;
}
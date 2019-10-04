package cn.baiyu.common.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auther baiyu
 * @date 2019/10/4
 */
@Getter
@AllArgsConstructor
public enum ErrorEnum implements ResultEnum {
    /**
     * 请求成功
     */
    SUCCESS(10000, "成功"),

    /**
     * 错误枚举, -2000~-2999
     */
    ERROR_NOUSERS(-1000, "不存在该用户"),
    ERROR_PARAMS(-1001, "传入参数错误"),
    USER_DATABASE_ERROR(-1002, "用户的数据库异常");

    /**
     * 错误码
     */
    private Integer resCode;
    /**
     * 错误信息
     */
    private String resMsg;
}

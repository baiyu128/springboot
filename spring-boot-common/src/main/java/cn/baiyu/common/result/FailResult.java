package cn.baiyu.common.result;


import cn.baiyu.common.exception.BaseGlobalException;

/**
 * 请求处理失败结果
 * @auther baiyu
 * @date 2019/10/4
 */
public interface FailResult extends Result {

    /**
     * 请求处理失败
     *
     * @return
     */
    @Override
    default Boolean isSuccess() {
        return false;
    }

    /**
     * 异常类型
     *
     * @return
     */
    BaseGlobalException.ExceptionType getExceptionType();
}

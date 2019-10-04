package cn.baiyu.common.result.fail;

import cn.baiyu.common.enumeration.ResultEnum;
import cn.baiyu.common.exception.BaseGlobalException;
import cn.baiyu.common.result.FailResult;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

/**
 * @auther baiyu
 * @date 2019/10/4
 */
abstract class AbstractFailResult implements FailResult {

    private static final long serialVersionUID = -2566361095660800524L;

    @Getter
    protected BaseGlobalException.ExceptionType exceptionType;
    @JsonIgnore
    protected ResultEnum resultEnum;

    public AbstractFailResult(BaseGlobalException.ExceptionType exceptionType, ResultEnum resultEnum) {
        this.exceptionType = exceptionType;
        this.resultEnum = resultEnum;
    }

    @Override
    public Integer getResCode() {
        return resultEnum.getResCode();
    }

    @Override
    public String getResMsg() {
        return resultEnum.getResMsg();
    }
}

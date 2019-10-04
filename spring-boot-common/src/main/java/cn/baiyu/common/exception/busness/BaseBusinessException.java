package cn.baiyu.common.exception.busness;

import cn.baiyu.common.enumeration.ResultEnum;
import cn.baiyu.common.exception.BaseGlobalException;
import cn.baiyu.common.exception.GlobalExceptionType;

/**
 * @auther baiyu
 * @date 2019/10/4
 */
public abstract class BaseBusinessException  extends BaseGlobalException {
    private static final long serialVersionUID = -3805445579721450701L;

    protected ResultEnum resultEnum;

    public BaseBusinessException(ResultEnum resultEnum) {
        super(resultEnum.getResMsg());
        this.resultEnum = resultEnum;
    }

    public ResultEnum getResultEnum() {
        return resultEnum;
    }

    @Override
    public ExceptionType getType() {
        return GlobalExceptionType.BUSINESS_EXCEPTION;
    }
}

package cn.baiyu.common.exception.busness;

import cn.baiyu.common.enumeration.ResultEnum;

/**
 * 标准业务异常
 * <p>
 * 不需要捕获的业务异常
 *
 * @author baiyu
 * @date 2019/10/4
 */
public class StdBusinessException extends BaseBusinessException {

    private static final long serialVersionUID = 6580813616936963521L;

    public StdBusinessException(ResultEnum resultEnum) {
        super(resultEnum);
    }
}
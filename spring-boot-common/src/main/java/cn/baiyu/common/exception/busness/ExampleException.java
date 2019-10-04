package cn.baiyu.common.exception.busness;

import cn.baiyu.common.enumeration.ErrorEnum;

/**
 * 示例业务异常
 * @auther baiyu
 * @date 2019/10/4
 */
public class ExampleException extends BaseBusinessException {

    private static final long serialVersionUID = -2429331595237618011L;

    public ExampleException() {
        super(ErrorEnum.ERROR_NOUSERS);
    }
}


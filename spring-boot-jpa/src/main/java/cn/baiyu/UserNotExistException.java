package cn.baiyu;

import cn.baiyu.common.enumeration.ErrorEnum;
import cn.baiyu.common.enumeration.ResultEnum;
import cn.baiyu.common.exception.busness.BaseBusinessException;

/**
 * @auther baiyu
 * @date 2019/10/4
 */
public class UserNotExistException extends BaseBusinessException {
    private static final long serialVersionUID = -6664262832023053603L;

    public UserNotExistException() {
        super(ErrorEnum.ERROR_NOUSERS);
    }
}

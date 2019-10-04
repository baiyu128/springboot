package cn.baiyu.common.result.fail;

import cn.baiyu.common.exception.busness.BaseBusinessException;

/**
 * 业务异常结果
 * @auther baiyu
 * @date 2019/10/4
 */
public class BusinessFailResult extends AbstractFailResult {


    private static final long serialVersionUID = 753110881998012730L;

    public BusinessFailResult(BaseBusinessException e) {
        super(e.getType(), e.getResultEnum());
    }

}

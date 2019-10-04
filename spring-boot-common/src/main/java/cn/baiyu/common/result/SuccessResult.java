package cn.baiyu.common.result;

/**
 * 请求处理成功结果
 * @auther baiyu
 * @date 2019/10/4
 */
public interface SuccessResult extends Result {

    /**
     * 请求处理成功
     *
     * @return
     */
    @Override
    default Boolean isSuccess() {
        return true;
    }
}

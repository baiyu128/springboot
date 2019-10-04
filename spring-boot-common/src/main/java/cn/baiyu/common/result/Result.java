package cn.baiyu.common.result;

import java.io.Serializable;

/**
 * 请求处理结果
 * @auther baiyu
 * @date 2019/10/4
 */
public interface Result extends Serializable {

    /**
     * 请求处理是否成功
     *
     * @return
     */
    Boolean isSuccess();

    /**
     * 结果码
     *
     * @return
     */
    Integer getResCode();

    /**
     * 结果信息
     *
     * @return
     */
    String getResMsg();
}

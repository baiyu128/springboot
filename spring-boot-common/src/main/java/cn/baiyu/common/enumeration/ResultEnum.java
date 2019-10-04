package cn.baiyu.common.enumeration;

/**
 * @auther baiyu
 * @date 2019/10/4
 */
public interface ResultEnum {
    /**
     * 请求处理结果码
     *
     * @return
     */
    Integer getResCode();

    /**
     * 请求处理结果信息
     *
     * @return
     */
    String getResMsg();
}

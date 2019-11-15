package cn.baiyu.client.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @auther baiyu
 * @date 2019/10/6
 */
@Getter
@Setter
@ToString
public class City implements Serializable {
    private static final long serialVersionUID = -4134839008258179494L;

    /**
     * 城市编号
     */
    private Long id;

    /**
     * 省份编号
     */
    private Long provinceId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */
    private String description;
}

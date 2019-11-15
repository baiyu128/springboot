package cn.baiyu.server.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 城市实体类
 *
 * @auther baiyu
 * @date 2019/10/6
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City implements Serializable {


    private static final long serialVersionUID = 7736481526176299256L;
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

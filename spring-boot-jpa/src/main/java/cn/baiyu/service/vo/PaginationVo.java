package cn.baiyu.service.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 分页用封装类
 * @auther baiyu
 * @date 2019/10/4
 */
@ApiModel
@Accessors(chain = true)
@Getter
@Setter
public class PaginationVo<T> implements Serializable {
    private static final long serialVersionUID = -1631597763903550215L;

    @ApiModelProperty(value = "总条数")
    private Long pageSize;

    @ApiModelProperty(value = "分页展示用数据")
    private List<T> rows;

    @ApiModelProperty(value = "当前页")
    private Integer current;

}

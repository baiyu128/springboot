package cn.baiyu.shrio.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Date;

import static cn.baiyu.shrio.constant.TimePattern.DATA_TIME;
import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * @auther baiyu
 * @date 2019/10/2
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class BaseModel<T extends BaseModel> implements Serializable {

    @Transient
    protected Class childClass =
            (Class<T>) ((ParameterizedType)
                    getClass()
                            .getGenericSuperclass())
                    .getActualTypeArguments()[0];

    @Column
    @CreatedDate
    @Temporal(TIMESTAMP)
    @JsonFormat(pattern = DATA_TIME)
    @ApiModelProperty(hidden = true)
    protected Date createdAt;
    @Column
    @LastModifiedDate
    @Temporal(TIMESTAMP)
    @JsonFormat(pattern = DATA_TIME)
    @ApiModelProperty(hidden = true)
    protected Date updatedAt;
    @Column
    @Temporal(TIMESTAMP)
    @JsonFormat(pattern = DATA_TIME)
    @ApiModelProperty(hidden = true)
    protected Date deletedAt;
    @Column
    @ApiModelProperty(hidden = true)
    protected boolean isDeleted;
}

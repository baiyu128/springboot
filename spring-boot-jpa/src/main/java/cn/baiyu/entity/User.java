package cn.baiyu.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * 用户实体
 * @author baiyu
 *
 */
@Entity
@Builder
@Getter
@Setter
@Table(name="jpa_user")//自定义表名
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -3752294262021766827L;
	/**
     * 唯一标示
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long id;
    /**
     * 编码
     */
    @ApiModelProperty(value = "编码")
    private String code;
    /**
     * 名称
     */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 创建时间
     */
    @CreatedDate //自动创建
    @ApiModelProperty(value = "创建时间",hidden = true)
    @Temporal(TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;
    /**
     * 修改时间
     */
    @Temporal(TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间",hidden = true)
    @LastModifiedDate //有修改时 会自动时间
    private Date gmtModified;

    @ApiModelProperty(value = "昵称")
    private String name;

    @Column
    @ApiModelProperty(hidden = true)
    protected boolean isDeleted;
}
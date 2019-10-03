package cn.baiyu.shrio.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @auther baiyu
 * @date 2019/10/2
 */
@Entity
@Builder
@Getter
@Setter
@Table(name = "shiro_user")
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseModel<User> {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ApiModelProperty(value = "中文名称")
    @Column(name = "cnname")
    private String cnname;
    @ApiModelProperty(value = "用户名")
    @NotNull
    @Column(name = "username")
    private String username;
    @ApiModelProperty(value = "密码")
    @NotNull
    @Column(name = "password")
    @JsonIgnore
    private String password;
    @ApiModelProperty(value = "邮箱")
    @Column(name = "email")
    private String email;
    @ApiModelProperty(value = "电话")
    @Column(name = "telephone")
    private String telephone;
    @ApiModelProperty(value = "手机号码")
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @ApiModelProperty(value = "微信号")
    @Column(name = "wechat_id")
    private String wechatId;
    @ApiModelProperty(value = "技能")
    @Column(name = "skill")
    private String skill;
    @ApiModelProperty(value = "部门id")
    @Column(name = "department_id")
    private Integer departmentId;
    @ApiModelProperty(value = "登陆次数")
    @Column(name = "login_count")
    private Integer loginCount;
}

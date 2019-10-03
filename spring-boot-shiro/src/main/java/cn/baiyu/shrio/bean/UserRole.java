package cn.baiyu.shrio.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

/**
 * @auther baiyu
 * @date 2019/10/2
 */
@Entity
@Builder
@Getter
@Setter
@Table(name = "shiro_user_role")
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "role_id")
    private Integer roleId;
}

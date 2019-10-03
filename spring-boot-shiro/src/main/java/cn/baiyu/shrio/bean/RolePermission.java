package cn.baiyu.shrio.bean;

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
@Table(name = "shiro_role_permission")
@AllArgsConstructor
@NoArgsConstructor
public class RolePermission {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "permission_id")
    private Integer permissionId;
}

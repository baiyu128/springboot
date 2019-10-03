package cn.baiyu.shrio.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

/**
 * @auther baiyu
 * @date 2019/10/2
 */
@Entity
@Getter
@Setter
@Builder
@Table(name = "shiro_permission")
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "permission_url")
    private String permissionUrl;
    @Column(name = "method")
    private String method;
    @Column(name = "description")
    private String description;
}

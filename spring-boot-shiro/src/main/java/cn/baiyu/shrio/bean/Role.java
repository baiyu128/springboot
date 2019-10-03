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
@Table(name = "shiro_role")
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "role_level")
    private Integer roleLevel;
    @Column(name = "description")
    private String description;
}

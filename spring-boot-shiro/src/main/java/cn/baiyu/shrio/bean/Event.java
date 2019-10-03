package cn.baiyu.shrio.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * @auther baiyu
 * @date 2019/10/2
 */
@Entity
@Getter
@Setter
@Builder
@Table(name = "shiro_event")
@AllArgsConstructor
@NoArgsConstructor
public class Event extends BaseModel<Event> {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Integer id;
    private Integer rawEventId;
    private String host;
    private String ip;
    private String source;
    private String type;
    private Date startTime;
    private Date endTime;
    private String content;
    private String dataType;
    private String suggest;
    private Integer businessSystemId;
    private Integer departmentId;
    private String status;
    private Integer occurCount;
    private String owner;
    private Date responsedTime;
    private String responsedBy;
    private Date resolvedTime;
    private String resolvedBy;
    private Date closedTime;
    private String closedBy;
}

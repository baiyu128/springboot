package cn.baiyu.websocket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.websocket.Session;
import java.io.Serializable;

/**
 * @auther baiyu
 * @date 2019/10/5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {

    private static final long serialVersionUID = 8957107006902627635L;

    private String userName;

    private Session session;

}

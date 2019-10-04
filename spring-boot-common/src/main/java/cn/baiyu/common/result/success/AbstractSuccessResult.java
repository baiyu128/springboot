package cn.baiyu.common.result.success;

import cn.baiyu.common.enumeration.ResultEnum;
import cn.baiyu.common.result.SuccessResult;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonSerializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import static cn.baiyu.common.enumeration.ErrorEnum.SUCCESS;

/**
 * @auther baiyu
 * @date 2019/10/4
 */
@Getter
@Setter
@NoArgsConstructor
public class AbstractSuccessResult implements SuccessResult {
    private static final long serialVersionUID = 1544391448163011544L;

    /**
     * Serializable || JsonSerializable
     *
     * @see Serializable
     * @see JsonSerializable
     */
    protected Object data;
    @JsonIgnore
    protected ResultEnum resultEnum = SUCCESS;

    public AbstractSuccessResult(Object data) {
        if (!isSerializable(data)) {
            throw new RuntimeException("不可序列化");
        }
        this.data = data;
    }

    private boolean isSerializable(Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof Serializable || object instanceof JsonSerializable) {
            return true;
        }
        return false;
    }

    @Override
    public Integer getResCode() {
        return resultEnum.getResCode();
    }

    @Override
    public String getResMsg() {
        return resultEnum.getResMsg();
    }
}

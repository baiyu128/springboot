package cn.baiyu.common.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.FieldError;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @auther baiyu
 * @date 2019/10/4
 */
@Getter
@AllArgsConstructor
public class FieldErrorVO implements Serializable {

    private static final long serialVersionUID = 7902364702283406419L;

    /**
     * 对象名
     */
    private final String objectName;
    /**
     * 字段名
     */
    private final String fieldName;
    /**
     * 打破的的规则
     */
    private final String brokenRule;
    /**
     * 具体信息, 说明不合法的原因 (中文)
     */
    private final String message;

    public static List<FieldErrorVO> from(List<FieldError> fieldErrors) {
        return fieldErrors.stream()
                .map(f -> new FieldErrorVO(
                        f.getObjectName(),
                        f.getField(),
                        f.getCode(),
                        f.getDefaultMessage()))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


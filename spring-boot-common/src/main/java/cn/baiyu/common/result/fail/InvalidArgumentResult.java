package cn.baiyu.common.result.fail;

import cn.baiyu.common.vo.FieldErrorVO;
import lombok.Getter;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

import static cn.baiyu.common.enumeration.ErrorEnum.ERROR_PARAMS;
import static cn.baiyu.common.exception.GlobalExceptionType.INVALID_ARGUMENT_EXCEPTION;

/**
 * @auther baiyu
 * @date 2019/10/4
 */
public class InvalidArgumentResult extends AbstractFailResult {

    private static final long serialVersionUID = -7582644419338092466L;

    @Getter
    private List<FieldErrorVO> fieldErrors;

    public InvalidArgumentResult(MethodArgumentNotValidException e) {
        super(INVALID_ARGUMENT_EXCEPTION, ERROR_PARAMS);
        List<FieldError> fieldErrors = e.getBindingResult()
                .getFieldErrors();
        this.fieldErrors = FieldErrorVO.from(fieldErrors);
    }
}

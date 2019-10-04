package cn.baiyu.common.exception;

import cn.baiyu.common.exception.busness.BaseBusinessException;
import cn.baiyu.common.exception.database.BaseDatabaseException;
import cn.baiyu.common.result.FailResult;
import cn.baiyu.common.result.Result;
import cn.baiyu.common.result.fail.BusinessFailResult;
import cn.baiyu.common.result.fail.DatabaseFailResult;
import cn.baiyu.common.result.fail.InvalidArgumentResult;
import cn.baiyu.common.result.success.StdSuccessResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @auther baiyu
 * @date 2019/10/4
 */
@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    /**
     * 请求成功, 返回对象封装成 AbstractSuccessResult
     *
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof Result) {
            throw new RuntimeException("请勿手动封装请求处理结果!");
        }

        StdSuccessResult stdSuccessResult = new StdSuccessResult(body);

        return stdSuccessResult;
    }

    /**
     * 处理业务异常
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(BaseBusinessException.class)
    public FailResult handleBusinessException(BaseBusinessException e) {
        return new BusinessFailResult(e);
    }

    /**
     * 处理参数不合法
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public FailResult handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        return new InvalidArgumentResult(e);
    }

    /**
     * 处理数据库异常
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(BaseDatabaseException.class)
    public FailResult handleDatabaseException(BaseDatabaseException e) {
        return new DatabaseFailResult(e);
    }
}

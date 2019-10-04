package cn.baiyu.common.exception.database;

import cn.baiyu.common.enumeration.ResultEnum;
import cn.baiyu.common.exception.BaseGlobalException;
import cn.baiyu.common.exception.GlobalExceptionType;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

import static cn.baiyu.common.enumeration.ErrorEnum.USER_DATABASE_ERROR;

/**
 * @auther baiyu
 * @date 2019/10/4
 */
@Slf4j
public abstract class BaseDatabaseException extends BaseGlobalException {
    private static final long serialVersionUID = -3119862015277158650L;

    @Getter
    protected Exception raw;
    @Getter
    private ResultEnum resultEnum = USER_DATABASE_ERROR;

    public BaseDatabaseException(String message, Exception raw) {
        super(message);
        this.initCause(raw);
        this.raw = raw;
    }

    @Deprecated
    public BaseDatabaseException(String message, SQLException raw) {
        super(message);
        this.initCause(raw);
        this.raw = raw;
    }

    @Override
    public ExceptionType getType() {
        return GlobalExceptionType.DATABASE_EXCEPTION;
    }
}

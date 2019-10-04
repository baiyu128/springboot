package cn.baiyu.common.result.fail;

import cn.baiyu.common.exception.database.BaseDatabaseException;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @auther baiyu
 * @date 2019/10/4
 */
public class DatabaseFailResult extends AbstractFailResult {

    private static final long serialVersionUID = -5914240512507887782L;

    private Exception exception;

    public DatabaseFailResult(BaseDatabaseException e) {
        super(e.getType(), e.getResultEnum());
        this.exception = e.getRaw();
    }

    /**
     * 数据库错误信息
     *
     * @return
     */
    public String getDbErrorMsg() {
        return this.exception.getMessage();
    }

    /**
     * 数据库错误信息列表
     *
     * @return
     */
    public List<String> getDbErrorMsgs() {
        Throwable throwable = this.exception;
        List<String> dbErrorMsgs = Lists.newArrayList();
        dbErrorMsgs.add(throwable.getMessage());
        while (null != throwable.getCause()
        ) {
            throwable = throwable.getCause();
            dbErrorMsgs.add(throwable.getMessage());
        }
        return dbErrorMsgs;
    }
}

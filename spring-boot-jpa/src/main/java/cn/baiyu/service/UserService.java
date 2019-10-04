package cn.baiyu.service;

import cn.baiyu.dao.UserDao;
import cn.baiyu.entity.User;
import cn.baiyu.service.vo.PaginationVo;
import cn.baiyu.utils.DateUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

/**
 * @auther baiyu
 * @date 2019/10/4
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public PaginationVo<User> queryBySelf(String username,String name, String code,String gmtCreate,
                                  String gmtModified, Integer pageSize, Integer current){

        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //增加筛选条件
                Predicate predicate = cb.conjunction();


                if (null != username && !StringUtils.isEmpty(username)) {
                    predicate.getExpressions().add(cb.equal(root.get("username").as(String.class), username));
                }

                if (null != name && !StringUtils.isEmpty(name)) {
                    predicate.getExpressions().add(cb.like(root.get("name").as(String.class), "%" + name + "%"));
                }
                if (null != code && !StringUtils.isEmpty(code)) {
                    predicate.getExpressions().add(cb.equal(root.get("code").as(String.class), code));
                }
                if (null != gmtCreate && !StringUtils.isEmpty(gmtCreate)) {
                    predicate.getExpressions().add(cb.greaterThanOrEqualTo(root.get("gmtCreate").as(Date.class), DateUtil.str2Date(gmtCreate)));
                }
                if (null != gmtModified && !StringUtils.isEmpty(gmtModified)) {
                    predicate.getExpressions().add(cb.lessThanOrEqualTo(root.get("gmtModified").as(Date.class), DateUtil.str2Date(gmtModified)));
                }
                return predicate;
            }
        };
        Sort sort = new Sort(Sort.Direction.DESC, "id"); //创建时间降序排序
        PageRequest request = PageRequest.of(current-1,pageSize, sort);

        Page<User> users = userDao.findAll(specification, request);
        PaginationVo<User> userPaginationVo = new PaginationVo<>();
        userPaginationVo.setCurrent(users.getSize());
        userPaginationVo.setPageSize(users.getTotalElements());
        userPaginationVo.setRows(users.getContent());

        return userPaginationVo;
    }
}

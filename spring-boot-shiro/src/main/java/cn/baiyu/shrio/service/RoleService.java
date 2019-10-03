package cn.baiyu.shrio.service;


import cn.baiyu.shrio.bean.Role;
import cn.baiyu.shrio.bean.UserRole;
import cn.baiyu.shrio.dao.RoleDao;
import cn.baiyu.shrio.dao.User2RoleDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Resource
	private RoleDao roleDao;

    @Resource
	private User2RoleDao user2RoleDao;

	public Role getById(Integer id) {
		Optional<Role> r = roleDao.findById(id);
		return r.get();
	}

	public List<Role> getByUserId(Integer userId){
		List<UserRole> userRole = user2RoleDao.findByUserId(userId);
		List<Role> list = new ArrayList<>();
		for (UserRole ur : userRole) {
			list.add(getById(ur.getRoleId()));
		}
		return list;
	}
    
}
package cn.baiyu.shrio.service;

import cn.baiyu.shrio.bean.Permission;
import cn.baiyu.shrio.dao.PermissionDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionService {
    @Resource
	private PermissionDao permissionDao;

	public List<Permission> getByUserId(Integer id){
		List<Permission> lists = permissionDao.getByUserId(id);
		return lists;
	}
    
}
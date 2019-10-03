package cn.baiyu.shrio.service;

import cn.baiyu.shrio.bean.User;
import cn.baiyu.shrio.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Resource
	private UserDao userDao;

	public List<User> getAll() {
	    return userDao.getAll();
	}
	
	public User getById(Integer id) {
		Optional<User> u = userDao.findById(id);
		return u.get();
	}
	
	public User create(User user) {
		userDao.save(user);
		return user;
	}

	public User update(User user) {
		userDao.save(user);
		return user;
	}

	public int delete(Integer id) {
		userDao.deleteUser(id);
		return id;
	}

	public User getByUserName(String userName) {
		return userDao.findByUsername(userName);
	}


}
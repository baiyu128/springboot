package cn.baiyu.shrio.service;

import cn.baiyu.shrio.bean.Event;
import cn.baiyu.shrio.dao.EventDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Resource
	private EventDao eventDao;
	
	public List<Event> getAll() {
	    return eventDao.getAll();
	}
	
	public Event getById(Integer id) {
		return eventDao.getById(id);
	}
	
	public Event create(Event event) {
		eventDao.save(event);
		return event;
	}
	public Event update(Event event) {
		Event save = eventDao.save(event);
		return save;
	}
	public int delete(Integer id) {
		eventDao.delEvent(id);
		return id;
	}
    
}
package cn.baiyu.shrio.controller;

import cn.baiyu.shrio.bean.Event;
import cn.baiyu.shrio.service.EventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @auther baiyu
 * @date 2019/10/2
 */
@RequestMapping(value = "/events")
@RestController
@Api(tags = "SHIRO 事件相关接口")
public class EventController {

    @Autowired
    private EventService eventService;

    @ApiOperation(value = "获取所有事件",notes = "获取所有事件")
    @RequestMapping(method = RequestMethod.GET)
    public List<Event> list(HttpServletRequest request) {
        return eventService.getAll();
    }

    @ApiOperation(value = "通过id查找")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Event detail(@PathVariable Integer id) {
        return eventService.getById(id);
    }

    @ApiOperation("创建事件")
    @RequestMapping(method = RequestMethod.POST)
    public Event create(@RequestBody Event event) {
        return eventService.create(event);
    }

    @ApiOperation("更新事件")
    @RequestMapping(method = RequestMethod.PUT)
    public Event update(@RequestBody Event event) {
        return eventService.update(event);
    }

    @ApiOperation("删除事件")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Integer id) {
        return eventService.delete(id);
    }

}

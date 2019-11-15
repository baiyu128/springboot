package cn.baiyu.server.service.impl;

import cn.baiyu.server.bean.City;
import cn.baiyu.server.service.CityDubboService;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * 城市业务 Dubbo 服务层实现层
 *
 * @auther baiyu
 * @date 2019/10/6
 */
// 注册为 Dubbo 服务
@Service(version = "1.0.0")
public class CityDubboServiceImpl implements CityDubboService {

    public City findCityByName(String cityName) {
        return new City(1L,2L,"温岭","是我的故乡");
    }
}

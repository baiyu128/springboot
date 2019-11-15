package cn.baiyu.server.service;

import cn.baiyu.server.bean.City;

/**
 * 城市业务 Dubbo 服务层
 *
 * @auther baiyu
 * @date 2019/10/6
 */
public interface CityDubboService {
    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findCityByName(String cityName);
}

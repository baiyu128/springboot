package cn.baiyu.client.service;

import cn.baiyu.client.bean.City;

/**
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

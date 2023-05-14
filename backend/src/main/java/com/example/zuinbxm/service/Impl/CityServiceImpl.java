package com.example.zuinbxm.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zuinbxm.entity.City;
import com.example.zuinbxm.mapper.CityMapper;
import com.example.zuinbxm.service.CityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {
}

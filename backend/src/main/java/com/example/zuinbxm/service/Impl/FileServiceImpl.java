package com.example.zuinbxm.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zuinbxm.entity.File;
import com.example.zuinbxm.mapper.FileMapper;
import com.example.zuinbxm.service.FileService;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {
}

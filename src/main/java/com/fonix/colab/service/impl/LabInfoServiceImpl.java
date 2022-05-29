package com.fonix.colab.service.impl;

import com.fonix.colab.entity.LabInfo;
import com.fonix.colab.mapper.LabInfoMapper;
import com.fonix.colab.service.LabInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 实验室信息表 服务实现类
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
@Service
public class LabInfoServiceImpl extends ServiceImpl<LabInfoMapper, LabInfo> implements LabInfoService {

    @Autowired
    LabInfoMapper labInfoMapper;
    @Override
    public Integer create(LabInfo labInfo) {
        return labInfoMapper.create(labInfo);
    }

    @Override
    public LabInfo selectByName(String labName) {
        return labInfoMapper.selectByName(labName);
    }

    @Override
    public List<LabInfo> searchByIdorName(String value) {
        return labInfoMapper.searchByIdorName(value);
    }
}

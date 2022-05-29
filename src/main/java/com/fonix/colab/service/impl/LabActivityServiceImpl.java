package com.fonix.colab.service.impl;

import com.fonix.colab.entity.LabActivity;
import com.fonix.colab.mapper.LabActivityMapper;
import com.fonix.colab.service.LabActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 实验室活动表 服务实现类
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
@Service
public class LabActivityServiceImpl extends ServiceImpl<LabActivityMapper, LabActivity> implements LabActivityService {
    @Autowired
    LabActivityMapper labActivityMapper;
    @Override
    public List<LabActivity> selectByLabId(int labID) {
        return labActivityMapper.selectByLabId(labID);
    }

    @Override
    public void create(LabActivity labActivity) {
        labActivityMapper.create(labActivity);
    }

    @Override
    public void deleteById(int id) {
        labActivityMapper.deleteById(id);
    }

    @Override
    public boolean updateActivityById(LabActivity labActivity) {
        return labActivityMapper.updateActivityById(labActivity);
    }
}

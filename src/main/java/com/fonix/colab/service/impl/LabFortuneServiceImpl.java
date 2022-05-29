package com.fonix.colab.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fonix.colab.entity.LabFortune;
import com.fonix.colab.mapper.LabFortuneMapper;
import com.fonix.colab.service.LabFortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  实验室财产表 服务实现类
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
@Service
public class LabFortuneServiceImpl extends ServiceImpl<LabFortuneMapper, LabFortune> implements LabFortuneService {
    @Autowired
    LabFortuneMapper labFortuneMapper;

    @Override
    public List<LabFortune> getFortuneByLabId(int labId) {
        return labFortuneMapper.getFortuneByLabId(labId);
    }

    @Override
    public Integer deleteById(LabFortune labFortune) {
        return labFortuneMapper.deleteById(labFortune);
    }

    @Override
    public LabFortune getFortuneById(int id) {
        return labFortuneMapper.getFortuneById(id);
    }

    @Override
    public boolean updateFortuneById(LabFortune labFortune) {
        return labFortuneMapper.updateFortuneById(labFortune);
    }

    @Override
    public Integer create(LabFortune labFortune) {
        return labFortuneMapper.create(labFortune);
    }
}

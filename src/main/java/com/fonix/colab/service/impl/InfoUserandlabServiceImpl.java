package com.fonix.colab.service.impl;

import com.fonix.colab.entity.InfoUserandlab;
import com.fonix.colab.mapper.InfoUserandlabMapper;
import com.fonix.colab.service.InfoUserandlabService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 个人与实验室信息 服务实现类
 * </p>
 *
 * @author Fonix
 * @since 2022-05-23
 */
@Service
public class InfoUserandlabServiceImpl extends ServiceImpl<InfoUserandlabMapper, InfoUserandlab> implements InfoUserandlabService {

    @Autowired
    InfoUserandlabMapper infoUserandlabMapper;

    @Override
    public List<InfoUserandlab> selectLabsByUserName(String userName) {
        return infoUserandlabMapper.selectLabsByUserName(userName);
    }

    @Override
    public void create(InfoUserandlab infoUserandlab) {
        infoUserandlabMapper.create(infoUserandlab);
    }
}

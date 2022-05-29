package com.fonix.colab.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fonix.colab.entity.LabActivityBlog;
import com.fonix.colab.mapper.LabActivityBlogMapper;
import com.fonix.colab.service.LabActivityBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  活动日志表 服务实现类
 * </p>
 *
 * @author Fonix
 * @since 2022-05-27
 */
@Service
public class LabActivityBlogServiceImpl extends ServiceImpl<LabActivityBlogMapper, LabActivityBlog> implements LabActivityBlogService {
    @Autowired
    LabActivityBlogMapper labActivityBlogMapper;
    @Override
    public boolean publishArticle(LabActivityBlog labActivityBlog) {
        return labActivityBlogMapper.publishArticle(labActivityBlog);
    }

    @Override
    public void updateBlogById(LabActivityBlog labActivityBlog) {
        labActivityBlogMapper.updateBlogById( labActivityBlog);
    }

    @Override
    public LabActivityBlog getByActivityId(int id) {
        return labActivityBlogMapper.getByActivityId(id);
    }
}

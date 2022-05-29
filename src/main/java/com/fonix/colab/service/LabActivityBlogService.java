package com.fonix.colab.service;

import com.fonix.colab.entity.LabActivityBlog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  活动日志表 服务类
 * </p>
 *
 * @author Fonix
 * @since 2022-05-27
 */
public interface LabActivityBlogService extends IService<LabActivityBlog> {
    boolean publishArticle(LabActivityBlog labActivityBlog);
    LabActivityBlog getByActivityId(int id);

    void updateBlogById(LabActivityBlog labActivityBlog);
}

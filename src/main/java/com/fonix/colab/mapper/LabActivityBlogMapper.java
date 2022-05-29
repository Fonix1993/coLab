package com.fonix.colab.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fonix.colab.entity.LabActivityBlog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  活动日志表 Mapper 接口
 * </p>
 *
 * @author Fonix
 * @since 2022-05-27
 */

@Repository
@Mapper
public interface LabActivityBlogMapper extends BaseMapper<LabActivityBlog> {
    boolean publishArticle(LabActivityBlog labActivityBlog);
    LabActivityBlog getByActivityId(int id);

    void updateBlogById(LabActivityBlog labActivityBlog);
}

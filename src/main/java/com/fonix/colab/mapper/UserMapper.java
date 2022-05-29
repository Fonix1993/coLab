package com.fonix.colab.mapper;

import com.fonix.colab.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Fonix
 * @since 2022-05-15
 */

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User>{
    User queryUserByName(String name);
    Integer create(User user);
    User getById(Long valueOf);
}

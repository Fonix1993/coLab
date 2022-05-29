package com.fonix.colab.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fonix.colab.entity.UserCenter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  个人中心表 Mapper 接口
 * </p>
 *
 * @author Fonix
 * @since 2022-05-23
 */
@Repository
@Mapper
public interface UserCenterMapper extends BaseMapper<UserCenter> {

}

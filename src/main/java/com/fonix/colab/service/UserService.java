package com.fonix.colab.service;

import com.fonix.colab.entity.User;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Fonix
 * @since 2022-05-15
 */
@Service
public interface UserService {
    public User queryUserByName(String name);
    public Integer create(User user);

    User getById(Long valueOf);
}

package com.fonix.colab.entity;

import lombok.Data;

import java.io.Serializable;

/*
 *登录成功后返回一个用户信息的载体
 */

@Data
public class AccountProfile implements Serializable {

    private Long id;
    private String username;
    private String avatar;
    private String email;

}

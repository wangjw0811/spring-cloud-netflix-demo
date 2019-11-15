package com.example.api.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVO implements Serializable {


    private static final long serialVersionUID = -2884028962517849128L;
    private Integer id;

    // 用户名
    private String name;

    // 邮箱
    private String email;

    // 手机号
    private String phoneNo;

}

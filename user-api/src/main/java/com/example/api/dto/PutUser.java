package com.example.api.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
public class PutUser implements Serializable {

    private static final long serialVersionUID = -7417112122203899247L;

    @NotNull(message = "用户id不能为空")
    private Integer id;

    @NotNull(message = "用户名不能为空")
    private String name;

    @NotNull(message = "用户密码不能为空")
    private String password;

    @Email(message = "邮箱格式错误")
    private String email;

    @Pattern(message = "手机号码格式不对", regexp="^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$")
    private String phoneNo;

}

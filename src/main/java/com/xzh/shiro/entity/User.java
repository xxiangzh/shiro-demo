package com.xzh.shiro.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @ApiModelProperty(value = "ID", hidden = true)
    private Long id;

    @ApiModelProperty(value = "用户名", required = true, example = "xzh")
    private String userName;

    @ApiModelProperty(value = "密码", required = true, example = "123456")
    private String password;
}

package com.oliver.experiment.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author 21051487 sunchengyu
 * @version 1.0
 * @date 22/3/9
 * @description 用户实体类
 */
@Data
@ApiModel (description = "用户实体")
public class User {

    @ApiModelProperty (value = "用户编号", position = 1)
    private Long id;

    @NotNull
    @Size (min = 2, max = 5)
    @ApiModelProperty (value = "用户姓名", position = 2)
    private String name;

    @NotNull
    @Max (150)
    @Min (0)
    @ApiModelProperty (value = "用户年龄", position = 3)
    private Integer age;

    @NotNull
    @Email (message = "请输入正确的邮箱")
    @ApiModelProperty (value = "用户邮箱", position = 4)
    private String email;
}

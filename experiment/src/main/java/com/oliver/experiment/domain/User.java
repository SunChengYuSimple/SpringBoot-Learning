package com.oliver.experiment.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 21051487 sunchengyu
 * @version 1.0
 * @date 22/3/9
 * @description 用户实体类
 */
@Data
@ApiModel (description = "用户实体")
public class User {
    
    @ApiModelProperty ("用户编号")
    private Long id;
    
    @ApiModelProperty ("用户姓名")
    private String name;
    
    @ApiModelProperty ("用户年龄")
    private Integer age;
}

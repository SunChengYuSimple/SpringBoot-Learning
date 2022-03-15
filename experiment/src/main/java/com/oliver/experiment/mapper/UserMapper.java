package com.oliver.experiment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oliver.experiment.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户实体持久化接口
 * @author Oliver
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

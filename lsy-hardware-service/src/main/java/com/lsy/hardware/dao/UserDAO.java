package com.lsy.hardware.dao;

import com.lsy.hardware.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author lishenyue Created on 2021/3/3 0003 16:39
 * @version 1.0
 */
@Repository
public interface UserDAO {

    /**
     * 测试接口
     * @param username
     * @return
     */
    User getByUsername(@Param("username")String username);
}

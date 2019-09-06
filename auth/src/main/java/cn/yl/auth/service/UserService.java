package cn.yl.auth.service;

import cn.yl.auth.entity.UserEntity;

import java.util.List;

/**
 * @author 杨列
 */
public interface UserService {
    List findAll();

    UserEntity findByStaffCode(String staffCode);
}

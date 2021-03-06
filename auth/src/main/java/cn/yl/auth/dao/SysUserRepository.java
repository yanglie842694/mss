package cn.yl.auth.dao;

import cn.yl.auth.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser,Integer>, JpaSpecificationExecutor<SysUser> {
    SysUser findByUsername(String username);
}

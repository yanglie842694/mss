package cn.yl.auth.dao;

import cn.yl.auth.entity.SysPrivilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component("sysPrivilegeRepository")
public interface SysPrivilegeRepository extends JpaRepository<SysPrivilege,Integer>, JpaSpecificationExecutor<SysPrivilege> {
    @Query(value = "select sp.* from sys_user su,sys_privilege sp,sys_user_privilege sup where su.id = sup.user_id and sup.privi_id = sp.privi_id and su.id = ?1",nativeQuery = true)
    List<SysPrivilege> findAllPrivilegeByUserId(Integer userId);
}

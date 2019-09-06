package cn.yl.auth.dao;

import cn.yl.auth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author 杨列
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer>, JpaSpecificationExecutor<UserEntity> {
    /**
     * @param staffCode
     * @return
     */
    UserEntity findByStaffCode(String staffCode);

    void deleteByStaffId(Integer staffId);
}

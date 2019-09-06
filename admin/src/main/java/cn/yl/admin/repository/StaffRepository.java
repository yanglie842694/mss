package cn.yl.admin.repository;

import cn.yl.admin.domain.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>, JpaSpecificationExecutor<Staff> {

    Staff findByUsername(String username);
}

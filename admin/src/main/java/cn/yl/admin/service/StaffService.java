package cn.yl.admin.service;

import cn.yl.common.vo.StaffVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StaffService {
    Page<StaffVO> page(Pageable pageable);

    StaffVO getStaff(String username);
}

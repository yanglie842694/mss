package cn.yl.admin.controller;

import cn.yl.admin.domain.entity.Staff;
import cn.yl.admin.repository.StaffRepository;
import cn.yl.common.vo.PlatResult;
import cn.yl.common.vo.StaffVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StaffController {
    @Autowired
    private StaffRepository staffRepository;

    @RequestMapping(value = "/current/{username}",method = RequestMethod.GET)
    public @ResponseBody PlatResult<StaffVO> getStaff(@PathVariable("username") String username){
        Staff staff = staffRepository.findByUsername(username);
        System.out.println(staff.toString());
        StaffVO staffVO = new StaffVO();
        staffVO.setId(staff.getId());
        staffVO.setUsername(staff.getUsername());
        return PlatResult.success(staffVO);
    }
}
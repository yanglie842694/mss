package cn.yl.admin.controller;

import cn.yl.admin.service.StaffService;
import cn.yl.common.vo.PageableParam;
import cn.yl.common.vo.PlatResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@Api("用户接口")
@RestController
public class StaffController {

    @Resource
    private StaffService staffService;

    @ApiOperation(value = "根据用户名获取用户的信息",notes = "查询数据库中的记录",httpMethod = "GET")
    @ApiImplicitParam(name = "username",value = "用户名",required = true,dataType = "String",paramType = "query")
    @RequestMapping(value = "/current/{username}",method = RequestMethod.GET)
    public PlatResult getStaff(@PathVariable("username") String username){
        return PlatResult.success(staffService.getStaff(username));
    }

    @GetMapping("/test")
    public PlatResult<?> test(){
        return PlatResult.success("chhenggongle");
    }

    @GetMapping("/test2")
    @PreAuthorize("hasAnyAuthority('query_intf')")
    public PlatResult<?> test2(){
        return PlatResult.success("权限校验成功");
    }

    @ApiOperation(value = "获取用户列表（分页）",notes = "分页查询用户",httpMethod = "GET")
    @GetMapping("/user/list")
    public PlatResult getUserList(PageableParam pageableParam){
        Pageable pageable = PageRequest.of(pageableParam.getPage(), pageableParam.getSize());
        return PlatResult.success(staffService.page(pageable));
    }
}

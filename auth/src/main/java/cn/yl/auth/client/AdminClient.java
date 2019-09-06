package cn.yl.auth.client;

import cn.yl.common.vo.PlatResult;
import cn.yl.common.vo.StaffVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mss-admin")
public interface AdminClient {
    @GetMapping("/current/{username}")
    PlatResult<StaffVO> findByUsername(@PathVariable("username") String username);
}

package cn.yl.auth.service;

import cn.yl.auth.dao.SysUserRepository;
import cn.yl.auth.dao.UserRepository;
import cn.yl.auth.entity.SysUser;
import cn.yl.auth.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Result<UserVo> userResult = userService.findByUsername(username);
////        System.out.println("user:"+userResult.getData().getUsername()+",password:"+userResult.getData().getPassword());
//        if (userResult.getCode() != StatusCode.SUCCESS_CODE) {
//            throw new UsernameNotFoundException("用户:" + username + ",不存在!");
//        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        boolean enabled = true; // 可用性 :true:可用 false:不可用
        boolean accountNonExpired = true; // 过期性 :true:没过期 false:过期
        boolean credentialsNonExpired = true; // 有效性 :true:凭证有效 false:凭证无效
        boolean accountNonLocked = true; // 锁定性 :true:未锁定 false:已锁定
//        UserVo userVo = new UserVo();
//        BeanUtils.copyProperties(userResult.getData(),userVo);
//        Result<List<RoleVo>> roleResult = roleService.getRoleByUserId(userVo.getId());
//        if (roleResult.getCode() != StatusCode.SUCCESS_CODE){
//            List<RoleVo> roleVoList = roleResult.getData();
////            System.out.println("role:"+roleVoList.get(0).toString());
//            for (RoleVo role:roleVoList){
//                //角色必须是ROLE_开头，可以在数据库中设置
//                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getValue());
//                grantedAuthorities.add(grantedAuthority);
//                //获取权限
//                Result<List<MenuVo>> perResult  = permissionService.getRolePermission(role.getId());
//                if (perResult.getCode() != StatusCode.SUCCESS_CODE){
//                    List<MenuVo> permissionList = perResult.getData();
//                    for (MenuVo menu:permissionList
//                            ) {
//                        GrantedAuthority authority = new SimpleGrantedAuthority(menu.getCode());
//                        grantedAuthorities.add(authority);
//                    }
//                }
//            }
//        }
        SysUser sysUser = sysUserRepository.findByUsername(username);
        User user = new User(sysUser.getUsername(), sysUser.getPassword(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
        return user;
    }
}

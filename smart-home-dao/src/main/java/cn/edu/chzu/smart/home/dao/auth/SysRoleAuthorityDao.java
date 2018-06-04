package cn.edu.chzu.smart.home.dao.auth;

import cn.edu.chzu.smart.home.SuperMapper;
import cn.edu.chzu.smart.home.domain.user.SysRoleAuthority;
import org.springframework.stereotype.Repository;

/**
 * 角色权限dao
 *
 * @author: EarthChen
 * @date: 2018/06/04
 */
@Repository
public interface SysRoleAuthorityDao extends SuperMapper<SysRoleAuthority> {
}

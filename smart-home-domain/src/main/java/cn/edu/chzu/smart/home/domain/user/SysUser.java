package cn.edu.chzu.smart.home.domain.user;

import com.baomidou.mybatisplus.annotations.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户
 *
 * @author: EarthChen
 * @date: 2018/06/02
 */
@Data
public class SysUser extends SuperEntity<SysUser> implements UserDetails {

    private static final long serialVersionUID = -2640006241935295774L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     * <p>
     * 不显示给前端
     */
    @JsonIgnore
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String imageUrl;


    /**
     * 角色 数据库表不存在
     */
//    @JsonIgnore
    @TableField(exist = false)
    private Set<SysRole> roles;


    @Override
    public Set<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (SysRole role : this.roles) {
            for (SysAuthority authority : role.getAuthorities()) {
                authorities.add(new SimpleGrantedAuthority(authority.getValue()));
            }
        }

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

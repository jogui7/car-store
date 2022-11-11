package br.pucpr.car_store.auth.entities;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class AuthUser extends User {

    private static final long serialVersionUID = 1L;

    private Integer guidUser;

    public AuthUser(
        String username, String password,
        boolean enabled, boolean accountNonExpired,
        boolean credentialsNonExpired,
        boolean accountNonLocked,
        Collection<? extends GrantedAuthority> authorities,
        Integer guidUser
    ) {
        super(username == null ? "email is required" : username, password == null ? "not required" : password,
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.guidUser = guidUser;
    }

    public Integer getGuidUser() {
        return guidUser;
    }

    public void setguidUser(Integer guidUser) {
        this.guidUser = guidUser;
    }
    
}

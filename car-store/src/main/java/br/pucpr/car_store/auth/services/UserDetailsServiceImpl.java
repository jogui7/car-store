package br.pucpr.car_store.auth.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.pucpr.car_store.auth.entities.AuthUser;
import br.pucpr.car_store.users.entities.User;
import br.pucpr.car_store.users.services.UsersService;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {

            User user = usersService.findByEmail(username);

            return new AuthUser(
                user.getEmail(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                new ArrayList<>(),
                null
            );

        } catch (Exception ex) {
            throw new UsernameNotFoundException(username);
        }
    }

}

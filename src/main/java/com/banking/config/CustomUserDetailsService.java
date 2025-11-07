/*
package com.banking.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            return org.springframework.security.core.userdetails.User
                    .withUsername("admin")
                    .password("$2a$10$eK1bP2Lx8Qw7Vf6t8/2wYe8gYd2NfFJz6Xw5K6aTn7Yx4DqPq/1W2") // paste new hash
                    .roles("ADMIN")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }

}
*/

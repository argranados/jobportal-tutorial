package com.ciberaccion.jobportal.services;

import com.ciberaccion.jobportal.entity.Users;
import com.ciberaccion.jobportal.repository.UsersRepository;
import com.ciberaccion.jobportal.utils.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Autowired
    public CustomUserDetailService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Could nt found user"));
        return new CustomUserDetails(users);
    }
}

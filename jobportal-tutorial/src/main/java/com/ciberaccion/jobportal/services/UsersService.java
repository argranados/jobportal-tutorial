package com.ciberaccion.jobportal.services;

import com.ciberaccion.jobportal.entity.Users;
import com.ciberaccion.jobportal.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users addNew(Users users) {
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        return  usersRepository.save(users);
    }
}

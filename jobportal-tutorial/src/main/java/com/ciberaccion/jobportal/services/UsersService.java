package com.ciberaccion.jobportal.services;

import com.ciberaccion.jobportal.entity.JobSeekerProfile;
import com.ciberaccion.jobportal.entity.RecruiterProfile;
import com.ciberaccion.jobportal.entity.Users;
import com.ciberaccion.jobportal.repository.JobSeekerProfileRepository;
import com.ciberaccion.jobportal.repository.RecruiterProfileRepository;
import com.ciberaccion.jobportal.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;

    public UsersService(UsersRepository usersRepository,
                        JobSeekerProfileRepository jobSeekerProfileRepository,
                        RecruiterProfileRepository recruiterProfileRepository) {
        this.usersRepository = usersRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
    }

    public Users addNew(Users users) {
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        Users savedUser = usersRepository.save(users);
        int userTypeId = users.getUserTypeId().getUserTypeId();
        if (userTypeId == 1) {
            recruiterProfileRepository.save(new RecruiterProfile((savedUser)));
        } else {
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
        }
        return  usersRepository.save(users);
    }

    public Optional<Users> getUserByEmail(Users users) {
        return usersRepository.findByEmail(users.getEmail());
    }
}

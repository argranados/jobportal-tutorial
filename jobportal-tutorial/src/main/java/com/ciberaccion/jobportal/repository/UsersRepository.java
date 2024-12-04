package com.ciberaccion.jobportal.repository;

import com.ciberaccion.jobportal.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}

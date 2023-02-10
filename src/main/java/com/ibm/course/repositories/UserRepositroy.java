package com.ibm.course.repositories;

import com.ibm.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositroy extends JpaRepository<User,Long> {
}

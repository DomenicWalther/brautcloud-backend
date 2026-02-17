package com.domenicwalther.brautcloud.repository;

import com.domenicwalther.brautcloud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

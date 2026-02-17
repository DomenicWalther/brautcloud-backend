package com.domenicwalther.brautcloud.repository;

import com.domenicwalther.brautcloud.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}

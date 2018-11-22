package com.jirina.p2pchat.repositories;

import com.jirina.p2pchat.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long> {

}

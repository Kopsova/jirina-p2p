package com.jirina.p2pchat.repositories;

import com.jirina.p2pchat.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MesssageRepository extends CrudRepository<Message, Long> {
}

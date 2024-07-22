package org.websocket.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author prabhakar, @Date 19-07-2024
 */
public interface UserRepository extends MongoRepository<Users,String> {


    List<Users> findAllByStatus(Status status);
}

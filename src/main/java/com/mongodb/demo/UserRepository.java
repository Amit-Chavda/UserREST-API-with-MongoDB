package com.mongodb.demo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    boolean existsByEmail(String email);

    @Query(value = "{firstName:?1,lastName:?2}")
    List<User> findAllByFirstNameAndLastNameContains(String firstName, String lastName);

    @Query(value = "{'firstName':{ $regex: ?0 },'lastName':{ $regex: ?0 },'email'{ $regex: ?0 }}")
    List<User> search(String key);

}

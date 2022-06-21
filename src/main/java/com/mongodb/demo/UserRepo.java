package com.mongodb.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo {

    @Autowired
    private MongoTemplate mongoTemplate;


    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    public User save(User user) {
        return mongoTemplate.save(user);
    }

    public List<User> search(String keyword) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").regex(keyword).orOperator(Criteria.where("firstName").regex(keyword)));
        return mongoTemplate.find(query, User.class);
    }

    public void saveAll(List<User> users) {
        mongoTemplate.insertAll(users);
    }

    public boolean existsByEmail(String email) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        return mongoTemplate.exists(query, User.class);
    }
}

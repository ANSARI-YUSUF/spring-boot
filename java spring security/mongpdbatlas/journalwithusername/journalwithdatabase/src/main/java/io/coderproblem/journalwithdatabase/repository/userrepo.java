package io.coderproblem.journalwithdatabase.repository;

import io.coderproblem.journalwithdatabase.entity.journalentry;
import io.coderproblem.journalwithdatabase.entity.user;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface userrepo extends MongoRepository<user, ObjectId> {

    public  user findByusername(String uname);

}

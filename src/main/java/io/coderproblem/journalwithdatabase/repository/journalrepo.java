package io.coderproblem.journalwithdatabase.repository;

import io.coderproblem.journalwithdatabase.entity.journalentry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface journalrepo extends MongoRepository<journalentry, ObjectId> {

}

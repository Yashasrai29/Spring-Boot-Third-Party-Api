package com.example.api.repository;

import com.example.api.model.Objects;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryLayer extends MongoRepository<Objects,Integer> {
    @Query("{'id':?0}")
    Objects findByNewId(ObjectId id);
}

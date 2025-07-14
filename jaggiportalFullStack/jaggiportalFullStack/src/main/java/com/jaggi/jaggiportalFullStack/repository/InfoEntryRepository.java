package com.jaggi.jaggiportalFullStack.repository;

import com.jaggi.jaggiportalFullStack.entity.InfoEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InfoEntryRepository extends MongoRepository<InfoEntry, ObjectId>
{}
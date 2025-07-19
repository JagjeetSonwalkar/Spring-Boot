package com.jaggi.jaggiportalwithlombak.repository;

import com.jaggi.jaggiportalwithlombak.entity.InfoEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InfoEntryRepository extends MongoRepository<InfoEntry, ObjectId>
{
    List<InfoEntry> findByName(String myname);
}

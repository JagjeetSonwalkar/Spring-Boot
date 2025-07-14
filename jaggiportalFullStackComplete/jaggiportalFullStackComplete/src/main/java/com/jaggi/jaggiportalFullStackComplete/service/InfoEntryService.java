package com.jaggi.jaggiportalFullStackComplete.service;

import com.jaggi.jaggiportalFullStackComplete.entity.InfoEntry;
import com.jaggi.jaggiportalFullStackComplete.repository.InfoEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InfoEntryService
{
    @Autowired
    private InfoEntryRepository infoEntryRepository;

    public void saveMyEntry(InfoEntry newEntry)
    {
            infoEntryRepository.save(newEntry);
    }

    public List<InfoEntry> getAll()
    {
        return infoEntryRepository.findAll();
    }

    public Optional<InfoEntry> findById(ObjectId myid)
    {
        return infoEntryRepository.findById(myid);
    }

    public List<InfoEntry> findByName(String myname)
    {
        return infoEntryRepository.findByName(myname);
    }

    public void deleteEntity(ObjectId myid)
    {
        infoEntryRepository.deleteById(myid);
    }

    public void updateByid(ObjectId id, InfoEntry newEntry)
    {
        InfoEntry oldEntry = infoEntryRepository.findById(id).orElse(null);
        if(oldEntry != null)
        {
            oldEntry.setName(newEntry.getName());
            oldEntry.setAge(newEntry.getAge());
            oldEntry.setAddress(newEntry.getAddress());
        }
    }
}

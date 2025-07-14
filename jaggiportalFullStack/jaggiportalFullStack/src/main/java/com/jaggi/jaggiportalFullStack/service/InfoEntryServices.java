package com.jaggi.jaggiportalFullStack.service;

import com.jaggi.jaggiportalFullStack.entity.InfoEntry;
import com.jaggi.jaggiportalFullStack.repository.InfoEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InfoEntryServices
{
    @Autowired
    private InfoEntryRepository infoEntryRepository;

    public void saveEntry(InfoEntry infoEntry)
    {
        infoEntryRepository.save(infoEntry);
    }

    public List<InfoEntry> getAll()
    {
        return infoEntryRepository.findAll();
    }

    public Optional<InfoEntry> findById(ObjectId id)
    {
        return  infoEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id)
    {
        infoEntryRepository.deleteById(id);
    }
}
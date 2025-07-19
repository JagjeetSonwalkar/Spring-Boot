package com.jaggi.jaggiportalwithlombak.controller;

import com.jaggi.jaggiportalwithlombak.entity.InfoEntry;
import com.jaggi.jaggiportalwithlombak.services.InfoEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/information")
public class InfoEntryController
{
    @Autowired
    private InfoEntryService infoEntryService ;

    @PostMapping
    public ResponseEntity<InfoEntry> createEntry(@RequestBody InfoEntry myEntry)
    {
        infoEntryService.saveMyEntry(myEntry);
        if((infoEntryService.findById(myEntry.getId()) != null))
        {
            return new ResponseEntity<InfoEntry>(HttpStatus.CREATED);
        }
        else
        {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping()
    public ResponseEntity<?> getAll()
    {
        List<InfoEntry> allData = infoEntryService.getAll();

        if((allData != null) && !allData.isEmpty())
        {
            return new ResponseEntity<>(allData, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id/{myid}")
    public ResponseEntity<InfoEntry> findById(@PathVariable ObjectId myid)
    {
        Optional<InfoEntry> dataById = infoEntryService.findById(myid);

        if(dataById.isPresent())
        {
            return new ResponseEntity<InfoEntry>(dataById.get(), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<InfoEntry>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{myname}")
    public ResponseEntity<InfoEntry> findByName(@PathVariable String myname)
    {
        List<InfoEntry> dataByName = infoEntryService.findByName(myname);

        if(!dataByName.isEmpty())
        {
            return new ResponseEntity<InfoEntry>(dataByName.getFirst(), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<InfoEntry>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/id/{myid}")
    public ResponseEntity<InfoEntry> deleteByObjectId(@PathVariable ObjectId myid)
    {
        Optional<InfoEntry> deleteById = infoEntryService.findById(myid);
        infoEntryService.deleteEntity(myid);

        if(deleteById.isPresent())
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("id/{myid}")
    public ResponseEntity<InfoEntry> updateById(@PathVariable ObjectId myid, @RequestBody InfoEntry myEntry)
    {
        InfoEntry oldEntry = infoEntryService.findById(myid).orElse(null);
        if(oldEntry != null)
        {
            oldEntry.setName(myEntry.getName());
            oldEntry.setAge(myEntry.getAge());
            oldEntry.setAddress(myEntry.getAddress());
            oldEntry.setPhno(myEntry.getPhno());

            infoEntryService.saveMyEntry(oldEntry);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

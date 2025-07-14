package com.jaggi.jaggiportalFullStackComplete.controller;

import com.jaggi.jaggiportalFullStackComplete.entity.InfoEntry;
import com.jaggi.jaggiportalFullStackComplete.service.InfoEntryService;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/informations")
public class InfoEntryController
{
    @Autowired
    private InfoEntryService infoEntryService ;

    @PostMapping
    public String createEntry(@RequestBody InfoEntry myEntry)
    {
        infoEntryService.saveMyEntry(myEntry);
        return "data inserted";
    }

    @GetMapping()
    public List<InfoEntry> getAll()
    {
        return infoEntryService.getAll();
    }

    @GetMapping("/id/{myid}")
    public Optional<InfoEntry> findById(@PathVariable  ObjectId myid)
    {
        return infoEntryService.findById(myid);
    }

    @GetMapping("/name/{myname}")
    public List<InfoEntry> findByName(@PathVariable String myname)
    {
        return infoEntryService.findByName(myname);
    }

    @DeleteMapping("/id/{myid}")
    public String deleteByObjectId(@PathVariable ObjectId myid)
    {
        infoEntryService.deleteEntity(myid);
        return "Data deleted successfully !";
    }

    @PutMapping("id/{myid}")
    public void updateById(@PathVariable ObjectId myid, @RequestBody InfoEntry myEntry)
    {
        InfoEntry oldEntry = infoEntryService.findById(myid).orElse(null);
        if(oldEntry != null)
        {
            oldEntry.setName(myEntry.getName());
            oldEntry.setAge(myEntry.getAge());
            oldEntry.setAddress(myEntry.getAddress());
            oldEntry.setPhno(myEntry.getPhno());

            infoEntryService.saveMyEntry(oldEntry);
        }
    }
}
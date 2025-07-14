package com.jaggi.jaggiportalFullStack.controller;

import com.jaggi.jaggiportalFullStack.entity.InfoEntry;
import com.jaggi.jaggiportalFullStack.service.InfoEntryServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/infos")
public class InfoController
{
    @Autowired
    private InfoEntryServices infoEntryServices;

    @GetMapping
    public List<InfoEntry> getAll()
    {
        return infoEntryServices.getAll();
    }

    @PostMapping
    public String createEntry(@RequestBody InfoEntry myentry)
    {
        infoEntryServices.saveEntry(myentry);
        return  "Insert data successfully";
    }

    @GetMapping("/id/{myid}")
    public InfoEntry getInfoById(@PathVariable ObjectId myid)
    {
        return infoEntryServices.findById(myid).orElse(null);
    }

    @DeleteMapping("id/{myid}")
    public Boolean deleteById(@PathVariable ObjectId myid)
    {
        infoEntryServices.deleteById(myid);
        return true;
    }

    @PutMapping("id/{myid}")
    public void updateInfoById(@PathVariable ObjectId myId, @RequestBody InfoEntry myentry)
    {
        InfoEntry old =  infoEntryServices.findById(myId).orElse(null);
        if(old != null)
        {
            old.setName(myentry.getName());
            old.setAge(myentry.getAge());

            infoEntryServices.saveEntry(old);
        }
    }
}
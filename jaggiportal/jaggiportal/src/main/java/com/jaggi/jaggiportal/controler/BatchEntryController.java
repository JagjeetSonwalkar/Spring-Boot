package com.jaggi.jaggiportal.controler;

import com.jaggi.jaggiportal.entity.BatchEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/batches")
public class BatchEntryController
{
    private Map<Long, BatchEntry> batchentries = new HashMap<>();

    @GetMapping
    public List<BatchEntry> getAll()
    {
        return  new ArrayList<>(batchentries.values());
    }

    @PostMapping
    public String creteEntry(@RequestBody BatchEntry myentry)
    {
        batchentries.put(myentry.getId(), myentry);
        return "Record inserted successfully";
    }

    @GetMapping("/id/{myid}")
    public BatchEntry getBatchEntryById(@PathVariable Long myid)
    {
        return batchentries.get(myid);
    }

    @DeleteMapping("/id/{myid}")
    public BatchEntry deleteEntryById(@PathVariable Long myid)
    {
        return batchentries.remove(myid);
    }

    @PutMapping("/id/{myid}")
    public BatchEntry updateEntryById(@PathVariable Long myid, BatchEntry myentry)
    {
        batchentries.put(myentry.getId(), myentry);
        return batchentries.put(myid,myentry);
    }
}

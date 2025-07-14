package com.jaggi.jaggiportal.entity;

public class BatchEntry
{
    private long id;
    private String name;
    private int fees;

    public void setId(long id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setFees(int fees)
    {
        this.fees = fees;
    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getFees()
    {
        return fees;
    }
}

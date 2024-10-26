package com.uzzielvz.tasktracker;

import java.util.Date;

public class Task
{
    private static int idCounter = 0;
    private int id = 0;
    private String description;
    private String status;
    private Date createdAt;
    private Date updatedAt;
   

    public Task(String description, Date createdAt, Date updatedAt)
    {
        this.id = ++idCounter;
        this.description = description;
        this.createdAt = createdAt != null ? createdAt: new Date();
        this.updatedAt = updatedAt != null ? updatedAt: new Date();
        this.status = Status.TODO.getDescripcion();
        
    }
    
    public Task(String description)
    {
        this.id = ++idCounter;
        this.description = description;
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.status = Status.TODO.getDescripcion();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }
    
    public void markAsDone()
    {
        this.setStatus(Status.DONE.getDescripcion());
        this.updatedAt = new Date();
    }
    
    public void markAsInProgress()
    {
        this.setStatus(Status.IN_PROGRESS.getDescripcion());
    }
    
    @Override
    public String toString()
    {
        return description + "- " + id + "\n" +
                "Last update: " + updatedAt + "\n" +
                "Created at: " + createdAt +"\n";
    }
}

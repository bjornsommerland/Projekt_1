package Utility;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
    private boolean Completed = false;
    private String Description;
    private String Name;
    private String DueDate;

    public Task(String Name, String DueDate, String Description) {
        this.setDueDate(DueDate);
        this.setName(Name);
        this.setDescription(Description);
    }

    public boolean isCompleted() {
        return Completed;
    }

    public void setCompleted(boolean completed) {
        Completed = completed;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String dueDate) {
        DueDate = dueDate;
    }
}

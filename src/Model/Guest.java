package Model;

import Utility.Task;

import java.io.Serializable;
import java.util.ArrayList;

public class Guest extends User implements Serializable {
    private ArrayList <Task> Tasks;
    public Guest(String password, String name, String username) {
        super(password, name, username,1);
    }

    public ArrayList<Task> GetTasks() {
        return this.Tasks;
    }
    public void RegisterTask(Task task) {
        Tasks.add(task);
    }
    public void FinishTask(Task task) {
        task.setCompleted(true);
    }
    public void DeleteTask(Task task) {
        Tasks.remove(task);
    }
    public void DisplayTasks() {
        Tasks.forEach((Task task) -> {
            String Description = task.getDescription();
            String Name = task.getName();
            boolean IsCompleted = task.isCompleted();
        });
    }
}

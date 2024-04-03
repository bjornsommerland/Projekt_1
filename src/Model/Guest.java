package Model;

import Database._DATA;
import Utility.Task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Guest extends User implements Serializable {
    private ArrayList <Task> Tasks;
    public Guest(String password, String name, String username) {
        super(password, name, username,1);

    }

    public ArrayList<Task> getTasks() {
        return this.Tasks;
    }
    public Task getTask(String task_name) {
        for (Task t : this.getTasks()) {
            if (t.getName().equals(task_name)) {
                return t;
            }
        }
        return null;
    }
    private void loadtaskfromData() {
        //this.Tasks = _DATA.getTaskData().get();
    }
    public void RegisterTask(Task task) {
        if (this.Tasks == null) {
            this.Tasks = new ArrayList<Task>();
        }
        this.Tasks.add(task);
        System.out.println("Registered new task!");
    }

    public void FinishTask(Task task) {
        task.setCompleted(true);
    }
    public void DeleteTask(Task task) {
        Tasks.remove(task);
    }
    public String DisplayTasks() {
        StringBuilder build = new StringBuilder();
        build.append("<html><body>");
        this.Tasks.forEach((Task task) -> {
            String Description = task.getDescription();
            String Name = task.getName();
            boolean IsCompleted = task.isCompleted();
            build.append("<h1>" + Name + "</h1>" + "<h1>" + Description + "</h1>" + "<h1>" + IsCompleted + "</h1>");
            build.append("<br>");
        });
        build.append("</body></html>");
        return build.toString();
    }


    @Override
    public boolean LoopAction(Scanner myObj) {
        System.out.println("/viewtasks");
        System.out.println("/toogletaskcompletion task_name true/false");
        System.out.println("/logout");

        String input = myObj.nextLine();
        String[] splited_input = input.split(" ");
        String command_name = splited_input[0];
        if (command_name.equals("/viewtasks")) {
            this.DisplayTasks();
        } else if (command_name.equals("/toogletaskcompletion")) {
            String task_name = splited_input[1];
            String verdict_str = splited_input[2];
            boolean verdict = false;
            if (verdict_str.equals("true")) {
                verdict = true;
            }
            Task t = this.getTask(task_name);
            if (t != null) {
                t.setCompleted(verdict);
            }
        } else if (command_name.equals("/logout")) {
            return false;
        }

        return true;
    }
}

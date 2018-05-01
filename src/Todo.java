import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
public class Todo{
    public static ArrayList <Task> data= new ArrayList<Task>();
    public static void main (String[] args) {

        while(true) {
            System.out.println("=================================");
            System.out.println("1. Add a new item (\"add\")");
            System.out.println("2. Delete an existing item (\"del\")");
            System.out.println("3. Update an item (\"edit\")");
            System.out.println("4. List all items (\"ls\")");
            System.out.println("5. Exit (Or press escape key to exit)");
            System.out.println("Please choose your option :");
            String input;
            Scanner get  = new Scanner(System.in);
            input = get.nextLine();
            String add = "add";
            String edit = "edit";
            String ls = "ls";
            String del = "del";
            String ascAccordingToName = "ls name asc";
            String descAccordingToName = "ls name desc";
            boolean loop = true;
            switch (input.toLowerCase()) {
                case "add": {
                    add();
                    break;
                }
                case "del": {
                    del();
                    break;
                }
                case "edit": {
                    edit();
                    break;
                }
                case "ls":{
                    read(data);
                    break;
                }
                case "ls name asc": {
                    ascaccordingname();
                    break;
                }
                case "ls name desc": {
                    descaccordingname();
                    break;
                }
                case "ls date_created asc": {
                    dateasc();
                    break;
                }
                case "ls date_created desc": {
                    datedesc();
                    break;
                }
                case "exit":{
                    loop = false;
                    break;
                }
                default:{
                    System.out.println("Wrong Input");
                }

            }
            if(!loop) {
                break;
            }
        }
    }
    public static void add() {
        Scanner get = new Scanner(System.in);
        System.out.println("=====================================\n1) Add mode:");
        System.out.println("Enter Title : ");
        String taskTitle = get.nextLine();
        if(data.isEmpty()) {
            System.out.print("Enter Discription : ");
            String taskDescription = get.nextLine();
            Task task = new Task();
            task.setTitle(taskTitle);
            task.setDescription(taskDescription);
            Date date = new Date();
            task.setDate(date);
            data.add(task);
            System.out.println("data is " + data.size());
        }else {
            boolean flag;
            flag = repeat(taskTitle);
            if(flag){
                System.out.println("Error : Duplicate Enteries");
            }
            if(!flag) {
                System.out.println("Enter Discription : ");
                String taskDescription = get.nextLine();
                Task task = new Task();
                task.setTitle(taskTitle);
                task.setDescription(taskDescription);
                Date date = new Date();
                task.setDate(date);
                data.add(task);
            }
        }
    }
    public static void edit() {
        Scanner get = new Scanner(System.in);
        System.out.println("Please enter TODO title:");
        String taskTitle = get.nextLine();
        System.out.println("Please enter updated title:");
        String updatedTaskTitle = get.nextLine();
        System.out.println("Please enter description");
        String updatedTaskDescription = get.nextLine();
        boolean flag, check;
        flag = repeat(updatedTaskTitle);
        check = repeat(taskTitle);
        if(!check) {
            System.out.println("No Such Task Found");
            flag = true;
        }
        if(!flag) {
            for(int i =0; i < data.size();i++) {
                Task t = data.get(i);
                if(t.getTitle().equals(taskTitle)) {
                    t.setTitle(updatedTaskTitle);
                    t.setDescription(updatedTaskDescription);
                }
            }
        }

    }
    public static boolean repeat(String title) {
        for(int i = 0;i < data.size();i++) {
            Task t = data.get(i);
            if(title.equals(t.getTitle())) {
                //System.out.println("Error : Duplicate Enteries");
                return true;
            }
        }
        return false;
    }
    public static void read(ArrayList<Task> tasks) {
        for(int i=0; i < tasks.size();i++) {
            Task t = tasks.get(i);
            System.out.println("title is :: " + t.getTitle());
            System.out.println("Description is ::" + t.getDescription());
        }
    }
    public static void del() {
        Scanner get = new Scanner(System.in);
        System.out.println("====================================  2) Delete mode:");
        System.out.print("Please enter TODO title: ");
        String taskTitle = get.nextLine();
        System.out.println("Are you sure you want to delete (y/n):");
        String option = get.nextLine();
        String yes = "y";
        if(option.equals(yes)) {
            System.out.println("in deltes yes");
            for(int i = 0; i < data.size();i++) {
                Task t = data.get(i);
                if(t.getTitle().equals(taskTitle)) {
                    data.remove(i);
                    break;
                }
            }
        }
    }
    public static void ascaccordingname() {
        ArrayList<Task> tasks = new ArrayList<>(data);
        Collections.sort(tasks, new TaskComparator(SortDirection.ASC, "name"));
        read(tasks);
    }
    public static void descaccordingname() {
        ArrayList<Task> tasks = new ArrayList<>(data);
        Collections.sort(tasks, new TaskComparator(SortDirection.DESC, "name"));
        read(tasks);
    }
    public static void dateasc() {
        ArrayList<Task> tasks = new ArrayList<>(data);
        Collections.sort(tasks, new TaskComparator(SortDirection.ASC, "date_created"));
        read(tasks);
    }
    public static void datedesc() {
        ArrayList<Task> tasks = new ArrayList<>(data);
        Collections.sort(tasks, new TaskComparator(SortDirection.DESC, "date_created"));
        read(tasks);
    }

}

package ToDoList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TarefaServices {

    public static User login_user;
    public static ArrayList<User> users = new ArrayList();

    public static User getLogin_User() {
        return login_user;
    }

    public static void setLogin_User(User user_x) {
        login_user = user_x;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static User findUser(String email) {
        for(User user : users){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public static Task findTask(String name) {
        ArrayList<Task> list_ = login_user.getTasks();
        for (Task task : list_) {
            if (task.getName().equals(name)) {
                return task;
            }
        }
        return null;
    }

    public static void newaccount(String email, String password) {

        //Instantiating the user
        User aux_user = new User();
        aux_user.setEmail(email);
        aux_user.setPassword(password);

        //Instantiating the Task Array
        ArrayList<Task> tasks = new ArrayList();
        aux_user.setTasks(tasks);

        users.add(aux_user);
        System.out.println("Now, log in to get started...");

    }

    public static boolean login(String email, String password) {

        boolean login_ = false;

        for (User aux : users) {

            String aux_email = aux.getEmail();
            String aux_password = aux.getPassword();

            boolean correct_email = false;
            boolean correct_password = false;

            if (email.equals(aux_email)) {
                correct_email = true;
            }

            if (password.equals(aux_password)) {
                correct_password = true;
            }

            if (correct_email && correct_password){
                login_ = true;
                login_user = aux;
                break;
            }
        }

        if (login_ == false){
            return false;
        }

        else{
            return true;
        }
    }

    public static void viewTasks() {

        ArrayList<Task> list_ = login_user.getTasks();

        if (list_.isEmpty()) {
            System.out.println("You have completed all your tasks");
            System.out.println("Congratulations!!!");
        }

        //Updating Priority Level Elements
        Collections.sort(list_);

        for (int l = 0; l < list_.size(); l++){

            Task aux = list_.get(l);
            System.out.println("Task " + l);
            System.out.println("Name: " + aux.getName());
            System.out.println("Finish: " + aux.isFinished());
            System.out.println("Description: " + aux.getDescription());
            System.out.println("End data: " + aux.getEnd_data());
            System.out.println("Priority Level: " + aux.getPriority_level());
            System.out.println("Category: " + aux.getCategory());

        }
    }

    public static void viewfinishedTasks() {

        ArrayList<Task> list_ = login_user.getTasks();
        ArrayList<Task> finished_ = new ArrayList();

        for (Task aux : list_){
            if (aux.isFinished()) {
                finished_.add(aux);
            }
        }

        if (finished_.isEmpty()) {
            System.out.println("You have not yet completed any of your tasks.");
            System.out.println("Keep swimming");
            System.out.println();
        }

        for (int l = 0; l < finished_.size(); l++) {
            Task aux = finished_.get(l);
            System.out.println("Your completed tasks are: ");
            System.out.println();
            System.out.println("Task " + l);
            System.out.println("Name: " + aux.getName());
            System.out.println("Finished: " + aux.isFinished());
            System.out.println("Description: " + aux.getDescription());
            System.out.println("End data: " + aux.getEnd_data());
            System.out.println("Priority Level: " + aux.getPriority_level());
            System.out.println("Category: " + aux.getCategory());
        }
    }

    public static void viewUnFinishedTasks() {

        ArrayList<Task> list_ = login_user.getTasks();
        ArrayList<Task> not_finished = new ArrayList();

        for (Task aux : list_) {
            if (aux.isFinished() == false) {
                not_finished.add(aux);
            }
        }

        if (not_finished.isEmpty()) {
            System.out.println("You have completed all your tasks.");
            System.out.println("Congratulations");
        }

        for (int l =0; l < not_finished.size(); l++) {
            Task aux = not_finished.get(l);

            System.out.println("Task " + l);
            System.out.println("Name: " + aux.getName());
            System.out.println("Finished: " + aux.isFinished());
            System.out.println("Description: " + aux.getDescription());
            System.out.println("End data: " + aux.getEnd_data());
            System.out.println("Priority Level: " + aux.getPriority_level());
            System.out.println("Category: " + aux.getCategory());
        }
    }

    public static void addNewTask(String title, String description, String end_date, int number, String category) {
        ArrayList<Task> list_ = login_user.getTasks();

        Task aux_task = new Task();
        aux_task.setName(title);
        aux_task.setFinished(false);
        aux_task.setDescription(description);
        aux_task.setEnd_data(end_date);
        aux_task.setPriority_level(number);
        aux_task.setCategory(category);

        list_.add(aux_task);
        Collections.sort(list_);
        System.out.println("You added a new task to your board");
    }

    public static void end_a_Task() {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Task> list_ = login_user.getTasks();
        ArrayList<Task> not_finished = new ArrayList();

        for (Task aux : list_) {
            if (aux.isFinished() == false) {
                not_finished.add(aux);
            }
        }

        if (not_finished.isEmpty()) {
            System.out.println("You have completed all your tasks.");
            System.out.println("Congratulations");
        }
        else {
            for (int l = 0; l < not_finished.size(); l ++) {
                Task aux_task = not_finished.get(l);
                System.out.println(" " + l + " " + aux_task.getName());
            }

            System.out.println("Which task do you want to finish? (Enter the corresponding number)");
            int position = scanner.nextInt();
            // Clean Buffer
            scanner.nextLine();

            // Marking the task as finished
            login_user.getTasks().get(position).setFinished(true);
        }
    }

    public static void delete_a_Task() {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> list_ = login_user.getTasks();

        for (int l = 0; l < list_.size(); l++) {
            Task aux_task = list_.get(l);
            System.out.println(" " + l + " " + aux_task.getName());
        }

        System.out.println("Enter the task you want to remove");
        //Clean Buffer
        //scanner.nextLine();

        int position = scanner.nextInt();

        if (position >= list_.size()) {
            System.out.println("erro");
            return;
        }

        list_.remove(position);

    }

}

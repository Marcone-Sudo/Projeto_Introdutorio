package ToDoList;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDo {

    private static Scanner scanner = new Scanner(System.in);
    public static User login_user = null;

    public static void main(String[] args) {

        boolean action = true;

        while(action) {

            System.out.println("Welcome");
            System.out.println("Shall we organize your day?");
            System.out.println();
            System.out.println("Enter the desired operation");
            System.out.println();
            System.out.println("[1] Register a new account");
            System.out.println("[2] Log in");
            System.out.println("[3] Log out");
            System.out.println();
            String option = scanner.nextLine();

            switch (option) {

                case "1": {

                    System.out.println("Enter your email address to register...");
                    String email = scanner.nextLine();
                    System.out.println("Enter a new password...");
                    String password = scanner.nextLine();
                    TarefaServices.newaccount(email, password);

                    break;

                }

                case "2": {

                    System.out.println("Inform your user email: ");
                    String email = scanner.nextLine();
                    System.out.println("Enter our user password: ");
                    String password = scanner.nextLine();

                    if(TarefaServices.login(email, password)){
                        Tasks();
                    }
                    else{
                        System.out.println("IAJSIJAS");
                    }

                    break;

                }

                case "3": {
                    action = false;
                    System.out.println("Processing...");
                    System.out.println("Going out...");
                    System.out.println("Check back often");
                    break;
                }

                default: {
                    break;
                }
            }
        }

        System.out.println("Check back often");
    }

    public static void Tasks() {

        boolean action = true;
        Scanner scanner = new Scanner(System.in);

        while(action) {

            System.out.println("Enter the desired operation");
            System.out.println();
            System.out.println(" 1 - View Tasks");
            System.out.println(" 2 - View Finished Tasks");
            System.out.println(" 3 - View Unfinished Tasks");
            System.out.println(" 4 - Add a New Task");
            System.out.println(" 5 - End a Task");
            System.out.println(" 6 - Delete a Task");
            System.out.println(" 7 - Log out");
            System.out.println();
            String option = scanner.nextLine();

            switch (option) {

                case "1": {

                    TarefaServices.viewTasks();
                    break;

                }

                case "2": {

                    TarefaServices.viewfinishedTasks();
                    break;

                }

                case "3": {

                    TarefaServices.viewUnFinishedTasks();
                    break;

                }

                case "4": {

                    System.out.println("Enter the Task Title: ");
                    String title = scanner.nextLine();
                    System.out.println("Provide a description of your task: ");
                    String description = scanner.nextLine();
                    System.out.println("Enter the final delivery date for your activity: ");
                    String end_date = scanner.nextLine();
                    System.out.println("Enter the priority of your task (1 - 5). 1 being high priority and 5 being low priority: ");
                    int number = scanner.nextInt();
                    System.out.println("Enter the task category:");
                    String category = scanner.next();

                    TarefaServices.addNewTask(title, description, end_date, number, category);
                    break;
                }

                case "5": {


                    TarefaServices.end_a_Task();
                    break;

                }

                case "6": {

                    TarefaServices.delete_a_Task();
                    break;

                }

                case "7": {

                    action = false;
                    login_user = null;
                    break;

                }

                default: {
                    break;
                }
            }
        }
    }

    private static void clearBuffer() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

}

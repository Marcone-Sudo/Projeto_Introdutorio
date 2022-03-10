package ToDoListTest;

import ToDoList.*;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class ToDoListTests {

    TarefaServices service = new TarefaServices();

    @Test
    public void newAccountTest() {

        String email_Expected = "mmsap1998@zgmail.com";

        service.newaccount(email_Expected, "PizzadeChocolate123");

        assertNotNull(service.findUser(email_Expected));

        System.out.println("Test NewAccount >> OK");
    }

    @Test
    public void loginTest() {

        String email_test = "mmsap1998@zgmail.com";
        String password_test = "PizzadeChocolate123";

        service.newaccount(email_test, password_test);
        service.login(email_test, password_test);

        assertEquals(email_test, service.getLogin_User().getEmail());
        assertEquals(password_test, service.getLogin_User().getPassword());

        System.out.println("Test NewAccount >> OK");
    }

    @Test
    public void viewTaskTest() {

        User new_user = new User();
        new_user.setEmail("mmsap1998@gmail.com");
        new_user.setPassword("PizzadeChocolate123");

        service.setLogin_User(new_user);

        service.addNewTask("Estudar Física",
                "Estudar para a Prova II",
                "13/04/23",
                2,
                "Importante");

        assertNotNull(service.findTask("Estudar Física"));

        System.out.println("Test View Task Test >> OK");
    }

    @Test
    public void addNewTaskTest() {

        User new_user = new User();
        new_user.setEmail("mmsap1998@gmail.com");
        new_user.setPassword("PizzadeChocolate123");

        service.setLogin_User(new_user);

        service.addNewTask("Estudar Física",
                "Estudar para a Prova II",
                "13/04/23",
                2,
                "Importante");

        assertNotNull(service.findTask("Estudar Física"));

        System.out.println("Test Add New Task Test >> OK");
    }

    @Test
    public void deleteTaskTest() {

        User new_user = new User();
        new_user.setEmail("mmsap1998@gmail.com");
        new_user.setPassword("PizzadeChocolate123");

        service.setLogin_User(new_user);


        service.addNewTask("Estudar Física",
                "Estudar para a Prova II",
                "13/04/23",
                2,
                "Importante");

        //service.delete_a_Task();

        ArrayList<Task> lista = service.getLogin_User().getTasks();
        lista.remove(0);

        assertNull(service.findTask("Estudar Física"));

        System.out.println("Test Delete Task Test >> OK");
    }
}
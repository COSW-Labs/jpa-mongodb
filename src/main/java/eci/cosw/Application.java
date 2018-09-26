package eci.cosw;

import eci.cosw.data.CustomerRepository;
import eci.cosw.data.model.Customer;
import eci.cosw.data.TodoRepository;
import eci.cosw.data.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import java.util.List;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TodoRepository todoRepository;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");

        customerRepository.deleteAll();

        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Marley"));
        customerRepository.save(new Customer("Jimmy", "Page"));
        customerRepository.save(new Customer("Freddy", "Mercury"));
        customerRepository.save(new Customer("Michael", "Jackson"));

        //Creacion de ToDo's de prueba
        todoRepository.deleteAll();

        todoRepository.save(new Todo("Tarea 23", 3,new Date(2017+1900,9,26,12,0,0), "Fabian", "Hecho"));
        todoRepository.save(new Todo("Tarea 13", 7,new Date(2017+1900,9,26,12,0,0), "Daniel", "Hecho"));
        todoRepository.save(new Todo("Tarea 6", 5,new Date(2017+1900,9,26,12,0,0), "Santiago", "Hecho"));
        todoRepository.save(new Todo("Tarea 78", 9,new Date(2017+1900,9,26,12,0,0), "Carolina", "Pendiente"));
        todoRepository.save(new Todo("Tarea 2", 2,new Date(2018+1900,10,21,12,0,0), "Pedro", "Pendiente"));
        todoRepository.save(new Todo("Tarea 45", 6,new Date(2018+1900,10,15,12,0,0), "Juan", "Pendiente"));
        todoRepository.save(new Todo("Tarea 6", 4,new Date(2018+1900,10,11,12,0,0), "Mario", "Pendiente"));
        todoRepository.save(new Todo("Tarea 4", 10,new Date(2018+1900,10,23,12,0,0), "Carlos", "Proceso"));
        todoRepository.save(new Todo("Tarea 8", 3,new Date(2018+1900,10,4,12,0,0), "David", "Pendiente"));
        todoRepository.save(new Todo("Tarea 10", 6,new Date(2018+1900,9,26,12,0,0), "Felipe", "Pendiente"));
        todoRepository.save(new Todo("Tarea 17", 4,new Date(2018+1900,9,26,12,0,0), "David", "Pendiente"));
        todoRepository.save(new Todo("Tarea 14", 9,new Date(2018+1900,9,26,12,0,0), "Juan", "Proceso"));
        todoRepository.save(new Todo("Tarea 24", 4,new Date(2018+1900,9,26,12,0,0), "Fabian", "Hecho"));
        todoRepository.save(new Todo("Tarea de mas de 30 caracteres!!", 7,new Date(2018+1900,9,26,12,0,0), "Carolina", "Pendiente"));
        todoRepository.save(new Todo("Tarea 34", 2,new Date(2018+1900,9,26,12,0,0), "Daniel", "Proceso"));
        todoRepository.save(new Todo("Tarea 154", 10,new Date(2018+1900,9,26,12,0,0), "Fabian", "Hecho"));
        todoRepository.save(new Todo("Tarea 21", 1,new Date(2018+1900,9,26,12,0,0), "Fabian", "Pendiente"));
        todoRepository.save(new Todo("Tarea 1", 9,new Date(2018+1900,9,26,12,0,0), "David", "Pendiente"));
        todoRepository.save(new Todo("Tarea 70", 3,new Date(2018+1900,9,26,12,0,0), "Daniel", "Hecho"));
        todoRepository.save(new Todo("Tarea 47", 0,new Date(2018+1900,9,26,12,0,0), "Mario", "Proceso"));
        todoRepository.save(new Todo("Tarea 186", 3,new Date(2018+1900,9,26,12,0,0), "Santiago", "Hecho"));
        todoRepository.save(new Todo("Tarea 43", 4,new Date(2018+1900,9,26,12,0,0), "Fabian", "Proceso"));
        todoRepository.save(new Todo("Tarea 164", 6,new Date(2018+1900,9,26,12,0,0), "Juan", "Hecho"));
        todoRepository.save(new Todo("Tarea 176", 5,new Date(2018+1900,9,26,12,0,0), "Daniel", "Pendiente"));
        todoRepository.save(new Todo("Tarea 29", 1,new Date(2018+1900,9,26,12,0,0), "Carolina", "Proceso"));

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : customerRepository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        System.out.println("ToDo's Queries");
        System.out.println("-------------------------------");
        System.out.println("Todos that are assigned to given user and have priority greater equal to 5");

        Query query = new Query();
        query.addCriteria(Criteria.where("priority").gt(4));

        List<Todo> todos = mongoOperation.find(query, Todo.class);

    }

}

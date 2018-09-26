package eci.cosw.data;

import eci.cosw.data.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.time.Date;

public interface TodoRepository extends MongoRepository<Todo, String> {

    List<Todo> findByPriority(int priority);

    List<Todo> findByDueDate(Date dueDate);

    List<Todo> findByResponsible(String responsible);

    List<Todo> findByStatus(String status);
}

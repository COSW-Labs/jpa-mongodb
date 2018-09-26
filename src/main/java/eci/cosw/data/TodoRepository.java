package eci.cosw.data;

import eci.cosw.data.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TodoRepository extends MongoRepository<Todo, String> {

    List<Todo> findByPriority(String priority);

    List<Todo> findByDueDate(String dueDate);

    List<Todo> findByResponsible(String responsible);

    List<Todo> findByStatus(String status);
}

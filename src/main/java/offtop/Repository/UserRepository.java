package offtop.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import offtop.Models.User;
@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
    List<User> findByEmail(String email);
}
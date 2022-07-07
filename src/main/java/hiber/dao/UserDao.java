package hiber.dao;

import org.springframework.stereotype.Repository;
import hiber.model.User;

import java.util.List;
@Repository
public interface UserDao {
    List<User> getAll();

    User getOne(Long id);

    void add(User user);
    void updateUser(User user);
    void removeUser(Long id);
}

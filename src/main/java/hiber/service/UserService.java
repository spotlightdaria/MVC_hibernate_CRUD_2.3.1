package hiber.service;

import org.springframework.stereotype.Service;
import hiber.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getUserById(Long id);

    void addUser(User user);
    void updateUser(User user);
    void removeUser(Long id);
}

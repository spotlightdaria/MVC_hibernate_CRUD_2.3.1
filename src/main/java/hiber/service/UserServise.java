package hiber.service;

import org.springframework.stereotype.Service;
import hiber.model.User;

import java.util.List;
@Service
public interface UserServise {
    List<User> getAll();

    User getOne(Long id);

    void add(User user);
    void updateUser(User user);
    void removeUser(Long id);
}

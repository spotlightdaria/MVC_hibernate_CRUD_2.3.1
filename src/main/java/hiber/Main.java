package hiber;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import hiber.config.PersistenceJPAConfig;
import hiber.model.User;
import hiber.service.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.addUser(new User("Jan", "White", (byte) 25));
        userService.addUser(new User("Lina", "Black", (byte) 43));
        userService.addUser(new User("Sam", "Red", (byte) 30));
        userService.addUser(new User("Bob", "Green", (byte) 18));

        for (User user : userService.getAll()) {
            System.out.println(user);
        }


    }
}

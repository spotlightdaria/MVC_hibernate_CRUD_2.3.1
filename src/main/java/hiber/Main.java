package hiber;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import hiber.config.PersistenceJPAConfig;
import hiber.model.User;
import hiber.service.UserServise;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
        UserServise userService = context.getBean(UserServise.class);

        userService.add(new User("Jan", "White", (byte) 25));
        userService.add(new User("Lina", "Black", (byte) 43));
        userService.add(new User("Sam", "Red", (byte) 30));
        userService.add(new User("Bob", "Green", (byte) 18));

        for (User user : userService.getAll()) {
            System.out.println(user);
        }


    }
}

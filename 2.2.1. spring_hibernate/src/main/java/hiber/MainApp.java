package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car Toyota = new Car("Toyota", 70);
        Car Audi = new Car("Audi", 3);
        Car Porsche = new Car("Porsche", 911);
        Car Nissan = new Car("Nissan", 13);

        User Alexey = new User("Alexey", "Baryshev", "alex@mail.ru");
        User Vitaliy = new User("Vitaliy", "Baryshev", "vit@mail.ru");
        User Maxim = new User("Maxim", "Baryshev", "max@ mail.ru");
        User Anastasia = new User("Anastasia", "Barysheva", "nast@mail.ru");

        Alexey.setCar(Toyota);
        Vitaliy.setCar(Audi);
        Maxim.setCar(Porsche);
        Anastasia.setCar(Nissan);

        userService.add(Alexey);
        userService.add(Vitaliy);
        userService.add(Maxim);
        userService.add(Anastasia);


        System.out.println(userService.getByCar("Toyota", 70));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }

        context.close();
    }
}

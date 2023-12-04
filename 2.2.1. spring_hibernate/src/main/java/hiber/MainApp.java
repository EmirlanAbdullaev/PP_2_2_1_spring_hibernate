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

      Car car1 = new Car("TATRA-ЗиЛ 815",21);
      Car car2 = new Car("Lexus LX",600);
      Car car3 = new Car("ВАЗ (LADA) ",2106);
      User user1 = new User("Emir1","Абдуллаев","emkaab@gmail.com");
      User user2 = new User("Emir2","Абдуллаев","emkaab@gmail.com");
      User user3 = new User("Emir3","Абдуллаев","emkaab@gmail.com");
      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      System.out.println("-------------------");
      System.out.println(userService.getByCar("TATRA-ЗиЛ 815",21));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }

      context.close();
   }
}

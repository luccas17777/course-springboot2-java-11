package com.ibm.course.config;

import com.ibm.course.entities.Category;
import com.ibm.course.entities.Order;
import com.ibm.course.entities.User;
import com.ibm.course.entities.enums.OrderStatus;
import com.ibm.course.repositories.CategoryRepository;
import com.ibm.course.repositories.OrderRepository;
import com.ibm.course.repositories.UserRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration //Para dizer para o spring que essa é uma classe de configuração
@Profile("test") // esse "teste" é o mesmo que esta no application properties
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepositroy userRepositroy;
    @Autowired
    private OrderRepository orderRep;

    @Autowired
    private CategoryRepository categoryRep;

    @Override
    public void run(String... args) throws Exception {
        // Category
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRep.saveAll(Arrays.asList(cat1, cat2, cat3));

        // Bloco spearado de User e Order. Porque eles tem associação entre si.
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1 ); // A letra "z" nos diz que este horario esta no padrão UTC.
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT,u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,u1);

        userRepositroy.saveAll(Arrays.asList(u1, u2));
        orderRep.saveAll(Arrays.asList(o1, o2, o3));

    }
}

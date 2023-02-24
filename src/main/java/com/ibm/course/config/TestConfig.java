package com.ibm.course.config;

import com.ibm.course.entities.Category;
import com.ibm.course.entities.Order;
import com.ibm.course.entities.Product;
import com.ibm.course.entities.User;
import com.ibm.course.entities.enums.OrderStatus;
import com.ibm.course.repositories.CategoryRepository;
import com.ibm.course.repositories.OrderRepository;
import com.ibm.course.repositories.ProductRepository;
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

    @Autowired
    private ProductRepository productRep;
    @Override
    public void run(String... args) throws Exception {
        // Category e Product
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");


        categoryRep.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRep.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

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

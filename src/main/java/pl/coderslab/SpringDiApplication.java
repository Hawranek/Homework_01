package pl.coderslab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.beans.Customer;
import pl.coderslab.beans.MemoryCustomerRepository;
import pl.coderslab.beans.SimpleCustomerLogger;

public class SpringDiApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MemoryCustomerRepository repository = ctx.getBean("memoryCustomerRepository", MemoryCustomerRepository.class);
        repository.add(new Customer(1,"Adam","Mickiewicz"));
        System.out.println(repository.list());
        ctx.close();
    }
}

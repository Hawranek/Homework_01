package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SimpleCustomerLogger implements CustomerLogger{
    @Autowired
    public SimpleCustomerLogger() {
    }

    @Override
    public void log() {
        System.out.println(LocalDateTime.now() + ":\tCustomer operation");
    }
}

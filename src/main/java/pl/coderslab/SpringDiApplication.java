package pl.coderslab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.beans.SimpleCustomerLogger;

public class SpringDiApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SimpleCustomerLogger simpleCustomerLogger = ctx.getBean("simpleCustomerLogger", SimpleCustomerLogger.class);
        simpleCustomerLogger.log();
        ctx.close();
    }
}

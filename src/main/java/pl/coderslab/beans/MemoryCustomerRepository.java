package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryCustomerRepository implements CustomerRepository {
    private List<Customer> customerList;
    private CustomerLogger customerLogger;
    private FileCustomerLogger fileCustomerLogger;

    @Autowired
    public MemoryCustomerRepository(FileCustomerLogger fileCustomerLogger){
        this.fileCustomerLogger=fileCustomerLogger;
        this.customerList = new ArrayList<>();
    }

    public MemoryCustomerRepository(CustomerLogger customerLogger) {
        this.customerLogger = customerLogger;
        this.customerList = new ArrayList<>();
    }


    @Override
    public void add(Customer customer) {
        this.customerList.add(customer);
        this.fileCustomerLogger.log();
    }

    @Override
    public void delete(Customer customer) {
        this.customerList.remove(customer);
        this.customerLogger.log();
    }

    @Override
    public List<Customer> list() {
        return this.customerList;
    }
}

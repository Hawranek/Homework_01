package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryCustomerRepository implements CustomerRepository {
    private List<Customer> customerList;
    private CustomerLogger customerLogger;

    @Autowired
    public MemoryCustomerRepository(CustomerLogger customerLogger) {
        this.customerLogger = customerLogger;
        this.customerList = new ArrayList<>();
    }


    @Override
    public void add(Customer customer) {
        this.customerList.add(customer);
        this.customerLogger.log();
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

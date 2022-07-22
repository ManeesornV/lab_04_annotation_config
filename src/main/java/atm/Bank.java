package atm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;


@Component
public class Bank {
   @Value("${bankname}")
   private String name;
   private Map<Integer,Customer> customers;

   @Autowired
   private DataSource dataSource;
   @PostConstruct
   void initCustomerData() {
      this.customers = dataSource.readCustomers();
   }
   public void registerCustomer(Customer customer) {
      customers.put(customer.getId(), customer);
   }

   public Customer findCustomer(int id) {
      return customers.get(id);
   }
}


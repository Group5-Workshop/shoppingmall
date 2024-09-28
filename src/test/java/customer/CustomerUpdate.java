package customer;

import edu.sm.dto.Customer;
import edu.sm.service.CustomerService;

import java.sql.Date;

public class CustomerUpdate {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        int id = 14;
        Customer cust = Customer.builder()
                .cid(id)
                .cname("홍길동")
                .phone_num("01012341234")
                .email("test@naver.com")
                .nick_name("낄똥")
                .build();

        try {
            customerService.modify(cust);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

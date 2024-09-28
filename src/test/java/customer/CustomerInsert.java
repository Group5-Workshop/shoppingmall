package customer;

import edu.sm.dto.Customer;
import edu.sm.service.CustomerService;

import java.sql.Date;
import java.time.LocalDate;

public class CustomerInsert {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();

        // 생년월일을 올바르게 변환 (LocalDate 사용 후 Date로 변환)
        LocalDate birthDate = LocalDate.of(2001, 4, 8); // 2001년 4월 8일
        Date sqlBirthDate = Date.valueOf(birthDate);  // java.sql.Date로 변환

        Customer customer = Customer.builder()
                .pwd("1234")
                .cname("서효석")
                .email("ascc@naver.com")
                .phone("01079794192")
                .birth_date(sqlBirthDate)  // 변환된 생년월일 사용
                .nick_name("집보내줘")
                .build();

        try {
            customerService.add(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

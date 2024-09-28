package customer;

import edu.sm.dto.Customer;
import edu.sm.service.CustomerService;

public class CustomerLogin {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        String email = "chulsoo@example.com"; // 테스트용 이메일
        String pwd = "password123"; // 테스트용 비밀번호

        try {
            Customer customer = customerService.login(email, pwd);
            if (customer != null) {
                System.out.println("로그인 성공! 사용자 정보: " + customer);
            } else {
                System.out.println("로그인 실패!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

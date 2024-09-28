package order;

import edu.sm.dto.Order;
import edu.sm.service.OrderService;

public class OrderInsert {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        try {
            Order order = Order.builder()
                    .cid(2)
                    .oname("김철수")
                    .address("서울시 강남구")
                    .addressDetail("아파트 101호")
                    .zipCode("123456")
                    .phone("01012345678")
                    .msg("문 앞에 두고 가주세요")
                    .build();

            orderService.add(order);
            System.out.println(order);
            System.out.println("주문 추가 성공");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

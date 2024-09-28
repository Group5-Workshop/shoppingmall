package order;

import edu.sm.dto.Order;
import edu.sm.service.OrderService;

import java.util.List;

public class OrderSelectByCid {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        int customerId = 20;

        try {
            // 고객의 주문 목록을 조회
            List<Order> orders = orderService.getByCustomerId(customerId);

            // 조회 결과 출력
            if (orders != null && !orders.isEmpty()) {
                System.out.println("고객 ID: " + customerId + "의 주문 목록:");
                for (Order order : orders) {
                    System.out.println("====================================");
                    System.out.println("주문 ID: " + order.getOid());
                    System.out.println("주문 상태: " + order.getOstatus());
                    System.out.println("주문자 이름: " + order.getOname());
                    System.out.println("주소: " + order.getAddress());
                    System.out.println("세부 주소: " + order.getAddressDetail());
                    System.out.println("우편번호: " + order.getZipCode());
                    System.out.println("전화번호: " + order.getPhone());
                    System.out.println("요청 사항: " + order.getMsg());
                    System.out.println("주문 날짜: " + order.getOdate());
                    System.out.println("====================================\n");
                }
            } else {
                System.out.println("해당 고객의 주문 목록이 없습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

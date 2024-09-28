package order;

import edu.sm.dto.Order;
import edu.sm.service.OrderService;

import java.util.List;

public class OrderStatus {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        String status = "입금대기"; // 입금대기 상태로 주문 조회

        try {
            List<Order> orders = orderService.getOrdersByStatus(status);
            for (Order order : orders) {
                System.out.println("주문번호: " + order.getOid());
                System.out.println("주문자 이름: " + order.getOname());
                System.out.println("주문 날짜: " + order.getOdate());
                System.out.println("----------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

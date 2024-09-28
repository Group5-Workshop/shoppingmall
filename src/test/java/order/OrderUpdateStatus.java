package order;

import edu.sm.service.OrderService;

public class OrderUpdateStatus {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        int orderId = 1; // 업데이트할 주문 번호
        String newStatus = "배송 중"; // 변경할 상태

        try {
            orderService.changeOrderStatus(orderId, newStatus);
            System.out.println("주문 상태가 '" + newStatus + "'로 성공적으로 변경되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

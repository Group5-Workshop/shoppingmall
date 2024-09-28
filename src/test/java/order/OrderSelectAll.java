package order;

import edu.sm.dto.Order;
import edu.sm.service.OrderService;

import java.util.List;

public class OrderSelectAll {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        try {
            // 모든 주문 조회
            List<Order> orders = orderService.get();

            // 예쁘게 출력
            for (Order order : orders) {
                System.out.print("주문 ID: " + order.getOid() + ", ");
                System.out.print("고객 ID: " + order.getCid() + ", ");
                System.out.print("주문 상태: " + order.getOstatus() + ", ");
                System.out.print("수령인 이름: " + order.getOname() + ", ");
                System.out.print("주소: " + order.getAddress() + ", ");
                System.out.print("상세 주소: " + order.getAddressDetail() + ", ");
                System.out.print("우편번호: " + order.getZipCode() + ", ");
                System.out.print("전화번호: " + order.getPhone() + ", ");
                System.out.print("메시지: " + order.getMsg() + ", ");
                System.out.println("주문 날짜: " + order.getOdate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

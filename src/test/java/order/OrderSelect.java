package order;

import edu.sm.dto.Order;
import edu.sm.service.OrderService;

public class OrderSelect {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        int id = 1;

        try {
            Order order = orderService.get(1);
            System.out.println(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

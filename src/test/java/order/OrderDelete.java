package order;

import edu.sm.service.OrderService;

public class OrderDelete {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        int id = 1;
        try {
            boolean isDeleted = orderService.remove(id);
            System.out.println("삭제 여부: " + isDeleted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

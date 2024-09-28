package orderdetail;

import edu.sm.dto.OrderDetail;
import edu.sm.service.OrderDetailService;

import java.util.List;

public class OrderDetailSelectAll {
    public static void main(String[] args) {
        OrderDetailService orderDetailService = new OrderDetailService();
        try {
            List<OrderDetail> orderDetails = orderDetailService.get();
            for (OrderDetail detail : orderDetails) {
                System.out.println(detail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

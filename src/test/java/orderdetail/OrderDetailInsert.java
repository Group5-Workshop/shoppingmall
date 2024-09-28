package orderdetail;

import edu.sm.dto.OrderDetail;
import edu.sm.service.OrderDetailService;

public class OrderDetailInsert {
    public static void main(String[] args) {
        OrderDetailService orderDetailService = new OrderDetailService();

        OrderDetail newOrderDetail = OrderDetail.builder()
                .pid(5)
                .oid(1)
                .itemCnt(2)
                .build();

        try {
            orderDetailService.add(newOrderDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

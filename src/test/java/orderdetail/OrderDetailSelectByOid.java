package orderdetail;

import edu.sm.dto.OrderDetail;
import edu.sm.service.OrderDetailService;

import java.util.List;

public class OrderDetailSelectByOid {
    public static void main(String[] args) {
        OrderDetailService orderDetailService = new OrderDetailService();
        int oid = 1; // 테스트할 주문 ID (예: 1번 주문)

        try {
            // 특정 주문 번호로 주문 상세 목록을 가져옴
            List<OrderDetail> orderDetails = orderDetailService.getByOid(oid);

            // 결과 출력
            System.out.println("Order ID: " + oid + "에 대한 주문 상세 정보");
            for (OrderDetail detail : orderDetails) {
                System.out.println("------------------------------------");
                System.out.println("주문번호 : " + detail.getOrderDetailId());
                System.out.println("상품번호 : " + detail.getPid());
                System.out.println("개수 : " + detail.getItemCnt());
                System.out.println("가격 : " + detail.getOdPrice());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

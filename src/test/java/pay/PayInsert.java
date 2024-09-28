package pay;

import edu.sm.dto.Pay;
import edu.sm.service.PayService;

public class PayInsert {
    public static void main(String[] args) {
        PayService payService = new PayService();

        Pay pay = Pay.builder()
                .oid(21) // 주문 ID
                .payPrice(100000)
                .payMethod("신용카드")
                .card(1234567890123456L)
                .build();

        try {
            payService.add(pay);
            System.out.println("Pay Insert Success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

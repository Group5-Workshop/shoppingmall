package pay;

import edu.sm.dto.Pay;
import edu.sm.service.PayService;

public class PaySelectByOid {
    public static void main(String[] args) {
        PayService payService = new PayService();
        int orderId = 1;

        try {
            Pay pay = payService.getByOrderId(orderId);
            if (pay != null) {
                System.out.println(pay);
            } else {
                System.out.println("No pay record found for order ID: " + orderId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

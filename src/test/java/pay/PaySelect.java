package pay;

import edu.sm.dto.Pay;
import edu.sm.service.PayService;

public class PaySelect {
    public static void main(String[] args) {
        PayService payService = new PayService();
        int payId = 1;

        try {
            Pay pay = payService.get(payId);
            if (pay != null) {
                System.out.println(pay);
            } else {
                System.out.println("No pay record found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

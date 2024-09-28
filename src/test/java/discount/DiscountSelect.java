package discount;

import edu.sm.dto.Discount;
import edu.sm.service.DiscountService;

public class DiscountSelect {
    public static void main(String[] args) {
        DiscountService discountService = new DiscountService();

        try {
            Discount discount = discountService.get(2);  // 조회할 할인 ID
            System.out.println("할인 정보: " + discount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

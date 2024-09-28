package discount;

import edu.sm.dto.Discount;
import edu.sm.service.DiscountService;

import java.util.List;

public class DiscountSelectAll {
    public static void main(String[] args) {
        DiscountService discountService = new DiscountService();

        try {
            List<Discount> discounts = discountService.get();  // 모든 할인 조회
            for (Discount discount : discounts) {
                System.out.println("할인 정보: " + discount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

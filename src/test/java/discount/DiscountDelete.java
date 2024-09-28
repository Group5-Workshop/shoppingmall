package discount;

import edu.sm.service.DiscountService;

public class DiscountDelete {
    public static void main(String[] args) {
        DiscountService discountService = new DiscountService();

        try {
            boolean result = discountService.remove(1);  // 삭제할 할인 ID
            if (result) {
                System.out.println("할인 삭제 성공");
            } else {
                System.out.println("할인 삭제 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

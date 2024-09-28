package discount;

import edu.sm.dto.Discount;
import edu.sm.service.DiscountService;

import java.sql.Date;

public class DiscountInsert {
    public static void main(String[] args) {
        DiscountService discountService = new DiscountService();

        // 새로운 할인 정보를 생성
        Discount discount = Discount.builder()
                .disName("새해 특가")
                .disRate(20.0f)
                .disStart(Date.valueOf("2024-01-01"))
                .disEnd(Date.valueOf("2024-01-31"))
                .build();

        try {
            discountService.add(discount);  // 할인 추가
            System.out.println("할인 추가 성공");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

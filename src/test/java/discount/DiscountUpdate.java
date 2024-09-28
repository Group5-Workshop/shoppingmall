package discount;

import edu.sm.dto.Discount;
import edu.sm.service.DiscountService;

import java.sql.Date;

public class DiscountUpdate {
    public static void main(String[] args) {
        DiscountService discountService = new DiscountService();

        // 기존 할인 정보를 수정
        Discount discount = Discount.builder()
                .disId(1)  // 수정할 할인 ID (기존 ID로 수정)
                .disName("새해 특가 수정")
                .disRate(15.0f)
                .disStart(Date.valueOf("2024-01-01"))
                .disEnd(Date.valueOf("2024-02-01"))
                .build();

        try {
            discountService.modify(discount);  // 할인 수정
            System.out.println("할인 수정 성공");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package cart;

import edu.sm.dto.Cart;
import edu.sm.service.CartService;

public class CartUpdate {
    public static void main(String[] args) {
        CartService cartService = new CartService();
        int cartId = 1;  // 실제로 수정할 장바구니 항목 ID로 수정

        try {
            Cart cart = new Cart(cartId, 1, 1, 5); // 수정할 정보를 담아 Cart 객체 생성
            cartService.modify(cart);
            System.out.println("장바구니 항목 수정 성공: " + cart);
        } catch (Exception e) {
            System.out.println("장바구니 항목 수정 중 오류 발생:");
            e.printStackTrace();
        }
    }
}

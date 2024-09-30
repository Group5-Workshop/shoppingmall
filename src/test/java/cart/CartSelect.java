package cart;

import edu.sm.dto.Cart;
import edu.sm.service.CartService;

public class CartSelect {
    public static void main(String[] args) {
        CartService cartService = new CartService();
        int cartId = 1;  // 실제로 조회할 장바구니 항목 ID로 수정

        try {
            Cart cart = cartService.get(cartId);
            System.out.println("장바구니 항목 조회 성공: " + cart);
        } catch (Exception e) {
            System.out.println("장바구니 항목 조회 중 오류 발생:");
            e.printStackTrace();
        }
    }
}

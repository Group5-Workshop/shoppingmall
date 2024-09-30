package cart;

import edu.sm.dto.Cart;
import edu.sm.service.CartService;

public class CartInsert {
    public static void main(String[] args) {
        CartService cartService = new CartService();

        // 장바구니 항목을 추가할 데이터를 생성
        Cart cart = new Cart(0, 1, 1, 2); // cartKey = 0 대신 0 설정, cid, pid, cnt 추가

        try {
            Cart addedCart = cartService.add(cart);
            System.out.println("장바구니 항목 추가 성공: " + addedCart);
        } catch (Exception e) {
            System.out.println("장바구니 항목 추가 중 오류 발생:");
            e.printStackTrace();
        }
    }
}

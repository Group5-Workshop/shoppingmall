package cart;

import edu.sm.service.CartService;

public class CartDelete {
    public static void main(String[] args) {
        CartService cartService = new CartService();
        int cid = 1;  // 삭제하려는 장바구니 항목의 고객 ID
        int pid = 1;  // 삭제하려는 장바구니 항목의 상품 ID
        try {
            boolean result = cartService.remove(cid);  // cartKey에 해당하는 항목을 삭제
            if (result) {
                System.out.println("장바구니 항목 삭제 성공: " + cid + ", " + pid);
            } else {
                System.out.println("장바구니 항목 삭제 실패: " + cid + ", " + pid);
            }
        } catch (Exception e) {
            System.out.println("장바구니 항목 삭제 중 오류 발생:");
            e.printStackTrace();
        }
    }
}

package cart;

import edu.sm.service.CartService;

public class CartDeleteByCidPid {
    public static void main(String[] args) {
        CartService cartService = new CartService();

        try {
            int cid = 3; // 고객 ID
            int pid = 6; // 상품 ID

            // 카트 항목 삭제 시도
            boolean isRemoved = cartService.removeByCidPid(cid, pid);
            if (isRemoved) {
                System.out.println("=====================================");
                System.out.println("   [ 고객 ID: " + cid + ", 상품 ID: " + pid + "의 카트 항목 삭제 성공 ]");
                System.out.println("=====================================");
            } else {
                System.out.println("=====================================");
                System.out.println("   [ 카트 항목 삭제 실패: 고객 ID: " + cid + ", 상품 ID: " + pid + " ]");
                System.out.println("=====================================");
            }
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("   [ 카트 항목 삭제 중 오류 발생 ]");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}

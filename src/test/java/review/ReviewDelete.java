package review;

import edu.sm.service.ReviewService;

public class ReviewDelete {
    public static void main(String[] args) {
        ReviewService reviewService = new ReviewService();
        int rid = 1;  // 삭제할 리뷰 ID

        try {
            boolean result = reviewService.remove(rid);
            if (result) {
                System.out.println("리뷰 삭제 성공!");
            } else {
                System.out.println("리뷰 삭제 실패!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

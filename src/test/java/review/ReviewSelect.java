package review;

import edu.sm.dto.Review;
import edu.sm.service.ReviewService;

public class ReviewSelect {
    public static void main(String[] args) {
        ReviewService reviewService = new ReviewService();
        int rid = 1;  // 조회할 리뷰 ID

        try {
            Review review = reviewService.get(rid);
            if (review != null) {
                System.out.println("리뷰 조회 성공: " + review);
            } else {
                System.out.println("리뷰를 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

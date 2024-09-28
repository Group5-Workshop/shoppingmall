package review;

import edu.sm.dto.Review;
import edu.sm.service.ReviewService;

import java.sql.Timestamp;

public class ReviewUpdate {
    public static void main(String[] args) {
        ReviewService reviewService = new ReviewService();

        // 리뷰 수정 테스트
        Review review = Review.builder()
                .rid(1)  // 기존 리뷰 ID
                .pid(1)
                .cid(1)
                .rate(3)  // 평점을 4점으로 변경
                .title("조금 아쉬웠어요.")
                .content("상품이 괜찮긴 한데, 생각보다 배송이 늦었습니다.")
                .img("review1_updated.jpg")
                .build();

        try {
            reviewService.modify(review);
            System.out.println("리뷰 수정 성공!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package review;

import edu.sm.dto.Review;
import edu.sm.service.ReviewService;

public class ReviewInsert {
    public static void main(String[] args) {
        ReviewService reviewService = new ReviewService();

        // 리뷰 추가 테스트
        Review review = Review.builder()
                .pid(1)
                .cid(1)
                .rate(5)
                .title("정말 만족합니다!")
                .content("상품이 너무 좋아요. 강추합니다.")
                .img("review1.jpg")
                .build();

        try {
            reviewService.add(review);
            System.out.println("리뷰 추가 성공!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

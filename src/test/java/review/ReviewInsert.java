package review;

import edu.sm.dto.Review;
import edu.sm.service.ReviewService;
import edu.sm.dao.ReviewDao;
import edu.sm.frame.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;

public class ReviewInsert {
    public static void main(String[] args) throws Exception { // 예외를 상위로 던짐
        // ConnectionPool에서 Connection을 가져옴
        ConnectionPool pool = ConnectionPool.create();  // ConnectionPool을 사용하여 연결 생성
        Connection conn = pool.getConnection();

        try {
            ReviewService reviewService = new ReviewService(new ReviewDao(conn));

            // 리뷰 추가
            Review newReview = Review.builder()
                    .pid(2)  // 상품 ID
                    .cid(3)  // 고객 ID
                    .rate(4)
                    .title("편안한 티셔츠")
                    .content("이 티셔츠는 정말 편하고 잘 맞아요.")
                    .img("tshirt_review.jpg")
                    .rdate(new Timestamp(System.currentTimeMillis()))
                    .build();

            // 중복 검사 및 삽입
            reviewService.addReview(newReview);
            System.out.println("리뷰가 성공적으로 삽입되었습니다.");
        } finally {
            // 작업이 끝난 후 Connection을 반납 (예외 발생해도 반납되도록 finally 사용)
            pool.releaseConnection(conn);
        }
    }
}

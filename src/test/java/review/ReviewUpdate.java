package review;

import edu.sm.dto.Review;
import edu.sm.service.ReviewService;
import edu.sm.dao.ReviewDao;
import edu.sm.frame.ConnectionPool;

import java.sql.Connection;
import java.sql.Timestamp;

public class ReviewUpdate {
    public static void main(String[] args) {
        try {
            // ConnectionPool에서 Connection을 가져옴
            ConnectionPool pool = ConnectionPool.create();
            Connection conn = pool.getConnection();

            ReviewService reviewService = new ReviewService(new ReviewDao(conn));

            // 리뷰 조회 후 수정 (리뷰 ID 1 수정)
            Review fetchedReview = reviewService.getReview(1); // 수정할 리뷰 ID 설정
            if (fetchedReview != null) {
                fetchedReview.setTitle("업데이트된 티셔츠 리뷰 제목");
                fetchedReview.setContent("이 티셔츠는 정말 멋지고 편안합니다.");
                fetchedReview.setRdate(new Timestamp(System.currentTimeMillis()));
                reviewService.modifyReview(fetchedReview);
                System.out.println("리뷰가 성공적으로 업데이트되었습니다.");
            } else {
                System.out.println("리뷰를 찾을 수 없습니다.");
            }

            // Connection 반납
            pool.releaseConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

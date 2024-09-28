package review;

import edu.sm.dto.Review;
import edu.sm.service.ReviewService;

import java.util.List;

public class ReviewSelectByPid {
    public static void main(String[] args) {
        ReviewService reviewService = new ReviewService();
        int pid = 1;  // 조회할 상품 ID

        try {
            List<Review> reviews = reviewService.getByProductId(pid);
            for (Review review : reviews) {
                System.out.println("리뷰 ID: " + review.getRid());
                System.out.println("상품 ID: " + review.getPid());
                System.out.println("회원 ID: " + review.getCid());
                System.out.println("평점: " + review.getRate());
                System.out.println("제목: " + review.getTitle());
                System.out.println("내용: " + review.getContent());
                System.out.println("이미지: " + review.getImg());
                System.out.println("작성일: " + review.getRdate());
                System.out.println("====================================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

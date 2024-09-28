package review;

import edu.sm.dto.Review;
import edu.sm.service.ReviewService;

import java.util.List;

public class ReviewSelectAll {
    public static void main(String[] args) {
        ReviewService reviewService = new ReviewService();

        try {
            List<Review> reviews = reviewService.get();
            for (Review review : reviews) {
                System.out.println(review);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

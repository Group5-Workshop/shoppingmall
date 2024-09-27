package edu.sm.frame;

public class Sql {
    // 1. 상품 조회 및 상세 정보 (spr1, spr2)
    public static String insertCustomer = "INSERT INTO Customer VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    // 카테고리별 상품 조회
    public static final String selectProductByCategory =
            "SELECT p.pid, p.pname, p.price, p.img1 FROM product p WHERE p.categoryKey = (SELECT categoryKey FROM category WHERE categoryName = ?) ORDER BY p.pname";

    // 인기순 상품 조회 (구매 횟수 기준)
    public static final String selectProductByPopularity =
            "SELECT p.pid, p.pname, p.price, COUNT(od.pid) AS purchase_count FROM product p LEFT JOIN orderDetail od ON p.pid = od.pid GROUP BY p.pid ORDER BY purchase_count DESC";

    // 최신순 상품 조회
    public static final String selectProductByDate =
            "SELECT p.pid, p.pname, p.price, p.img1, p.pdate FROM product p ORDER BY p.pdate DESC";

    // 상품 상세 정보 조회
    public static final String selectProductDetails =
            "SELECT p.pid, p.pname, p.price, p.content, p.img1, p.img2, p.img3, p.img4, (SELECT AVG(r.rate) FROM review r WHERE r.pid = p.pid) AS avg_rating FROM product p WHERE p.pid = ?";


    // 2. 장바구니 (cart1, cart2)

    // 장바구니에 담긴 상품 정보 조회
    public static final String selectCartItems =
            "SELECT p.pname, cart.cnt, p.price, (cart.cnt * p.price) AS total_price FROM cart cart JOIN product p ON cart.pid = p.pid WHERE cart.cid = ?";

    // 배송지 정보 조회
    public static final String selectDeliveryInfo =
            "SELECT a.addr, a.add_zip_code, a.phone_num, a.Delivery_address FROM address a WHERE a.cid = ?";


    // 3. 결제 (pay)

    // 결제 수단 및 결제 정보 조회
    public static final String selectPaymentInfo =
            "SELECT p.oid, p.pay_price, p.pay_method, p.card, p.pay_date FROM pay p JOIN orders o ON p.oid = o.oid WHERE o.cid = ?";


    // 4. 리뷰 작성 내역 조회 (rv1)

    // 사용자가 작성한 리뷰 조회
    public static final String selectUserReviews =
            "SELECT r.rebiewKey, r.pid, r.rate, r.title, r.content, r.rdate FROM review r WHERE r.cid = ?";


    // 5. 마이페이지 (mp1, mp2, mp3)

    // 회원 정보 조회
    public static final String selectUserInfo =
            "SELECT c.cid, c.cname, c.email, c.phone_num, c.birth_date, c.nick_name, c.grade FROM customer c WHERE c.cid = ?";

    // 주문 내역 조회
    public static final String selectUserOrders =
            "SELECT o.oid, o.odate, o.ostatus, p.pay_price FROM orders o JOIN pay p ON o.oid = p.oid WHERE o.cid = ?";

    // 취소/반품/교환 내역 조회
    public static final String selectOrderReturns =
            "SELECT o.oid, o.ostatus, r.return_id, r.return_reason, r.return_status, r.request_date, r.return_type FROM orders o JOIN order_returns r ON r.oid = o.oid WHERE o.cid = ?";


    // 6. 카테고리 조회 (ct1, ct2)

    // 카테고리 분류별 상품 수 조회
    public static final String selectCategoryProductCount =
            "SELECT c.categoryKey, c.categoryName, COUNT(p.pid) AS product_count FROM category c LEFT JOIN product p ON c.categoryKey = p.categoryKey GROUP BY c.categoryKey";

    // 특정 카테고리의 상품 목록 조회
    public static final String selectCategoryProducts =
            "SELECT p.pid, p.pname, p.price, p.img1 FROM product p WHERE p.categoryKey = (SELECT categoryKey FROM category WHERE categoryName = ?)";


    // 7. 주문 내역 (od1, od2, od3, od4)

    // 주문한 상품의 상세 정보 조회
    public static final String selectOrderDetails =
            "SELECT p.pname, od.item_cnt, od.od_price FROM orderDetail od JOIN product p ON od.pid = p.pid JOIN orders o ON od.oid = o.oid WHERE o.cid = ?";

    // 배송 정보 조회
    public static final String selectOrderShippingInfo =
            "SELECT o.ostatus, o.addr, o.zip_code, o.phone_num FROM orders o WHERE o.cid = ?";

    // 취소/반품/교환 신청 내역 조회
    public static final String selectReturnRequests =
            "SELECT od.oid, p.pname, od.item_cnt, od.od_price, r.return_reason, r.return_status, r.return_type FROM orderDetail od JOIN product p ON od.pid = p.pid JOIN orders o ON od.oid = o.oid JOIN order_returns r ON r.oid = o.oid WHERE o.cid = ?";

    // 리뷰 작성 가능한 주문 상품 조회
    public static final String selectReviewableOrders =
            "SELECT p.pid, p.pname FROM product p JOIN orderDetail od ON p.pid = od.pid JOIN orders o ON od.oid = o.oid WHERE o.cid = ?";


    public static final String insertReview = "INSERT INTO review (reviewKey, pid, cid, rate, title, content, img, rdate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String updateReview = "UPDATE review SET pid=?, cid=?, rate=?, title=?, content=?, img=?, rdate=? WHERE reviewKey=?";
    public static final String deleteReview = "DELETE FROM review WHERE reviewKey=?";
    public static final String selectOneReview = "SELECT * FROM review WHERE reviewKey=?";
    public static final String selectReview = "SELECT * FROM review";

    // 상품관리
    public static final String mg_selectAllProducts = "SELECT pid, pname, price, cnt, pdate FROM product WHERE pname LIKE ? OR categoryKey = ? OR price BETWEEN ? AND ? ORDER BY pdate DESC LIMIT 10 OFFSET 0";
    public static final String mg_updateProduct = "UPDATE product SET pname=?, price=?, content=?, cnt=?, categoryKey=?, img1=?, img2=?, img3=?, img4=?, dis_id=? WHERE pid=?";
    public static final String mg_insertProduct = "INSERT INTO product (pid, categoryKey, dis_id, pname, price, cnt, img1, img2, img3, img4, content, pdate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURDATE())";
    public static final String mg_selectAllProductStocks = "SELECT pid, pname, cnt FROM product ORDER BY pname";
    public static final String mg_updateProductStock = "UPDATE product SET cnt = cnt + ? WHERE pid = ?";

    // 주문관리
    public static final String mg_selectAllOrders = "SELECT o.oid, c.cname, o.item_name, o.odate, o.ostatus FROM orders o JOIN customer c ON o.cid = c.cid";
    public static final String mg_selectPendingOrders = "SELECT oid, oname, item_name, odate FROM orders WHERE ostatus = '입금대기'";
    public static final String mg_updateOrderStatusToPaid = "UPDATE orders SET ostatus = '입금완료' WHERE oid = ?";
    public static final String mg_selectPaidOrders = "SELECT oid, oname, item_name, odate FROM orders WHERE ostatus = '입금완료'";
    public static final String mg_updateOrderStatusToShipping = "UPDATE orders SET ostatus = '배송 중' WHERE oid = ?";
    public static final String mg_selectShippingOrders = "SELECT oid, oname, item_name, odate FROM orders WHERE ostatus = '배송 중'";
    public static final String mg_updateOrderStatusToDelivered = "UPDATE orders SET ostatus = '배송 완료' WHERE oid = ?";
    public static final String mg_selectDeliveredOrders = "SELECT oid, oname, item_name, odate FROM orders WHERE ostatus = '배송 완료'";

    // 회원관리
    public static final String mg_selectAllCustomers = "SELECT c.cid, c.cname, c.email, c.birth_date, COUNT(o.oid) AS 주문수 FROM customer c LEFT JOIN orders o ON c.cid = o.cid GROUP BY c.cid";
    public static final String mg_updateCustomer = "UPDATE customer SET cname=?, email=?, phone_num=?, nick_name=? WHERE cid=?";
    public static final String mg_deleteCustomer = "DELETE FROM customer WHERE cid=?";

    // 접속통계
    public static final String mg_selectHourlyAccessStats = "SELECT HOUR(access_time) AS 접속시간, COUNT(*) AS 접속자수 FROM access_log GROUP BY HOUR(access_time) ORDER BY 접속시간";
    public static final String mg_selectDailyAccessStats = "SELECT DATE(access_time) AS 접속일자, COUNT(*) AS 접속자수 FROM access_log GROUP BY DATE(access_time)";
    public static final String mg_selectWeeklyAccessStats = "SELECT CASE DAYNAME(access_time) WHEN 'Sunday' THEN '일요일' WHEN 'Monday' THEN '월요일' WHEN 'Tuesday' THEN '화요일' WHEN 'Wednesday' THEN '수요일' WHEN 'Thursday' THEN '목요일' WHEN 'Friday' THEN '금요일' WHEN 'Saturday' THEN '토요일' END AS 요일, COUNT(*) AS 접속자수 FROM access_log GROUP BY 요일 ORDER BY FIELD(요일, '월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일')";
    public static final String mg_selectMonthlyAccessStats = "SELECT MONTH(access_time) AS 월, COUNT(*) AS 접속자수 FROM access_log GROUP BY MONTH(access_time) ORDER BY 월";
    public static final String mg_selectYearlyAccessStats = "SELECT YEAR(access_time) AS 연도, COUNT(*) AS 접속자수 FROM access_log GROUP BY YEAR(access_time)";

    // 일별통계
    public static final String mg_selectDailyOrderStats = "SELECT DATE(odate) AS 주문일, COUNT(*) AS 주문수, SUM(pay_price) AS 총매출 FROM orders o JOIN pay p ON o.oid = p.oid GROUP BY DATE(odate)";
    public static final String mg_selectMonthlyOrderStats = "SELECT MONTH(odate) AS 월, COUNT(*) AS 주문수, SUM(pay_price) AS 총매출 FROM orders o JOIN pay p ON o.oid = p.oid GROUP BY MONTH(odate)";

    // 리뷰관리
    public static final String mg_insertReview = "INSERT INTO review (reviewKey, pid, cid, rate, title, content, img, rdate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String mg_updateReview = "UPDATE review SET pid=?, cid=?, rate=?, title=?, content=?, img=?, rdate=? WHERE reviewKey=?";
    public static final String mg_deleteReview = "DELETE FROM review WHERE reviewKey=?";
    public static final String mg_selectOneReview = "SELECT * FROM review WHERE reviewKey=?";
    public static final String mg_selectReview = "SELECT * FROM review";

    // 카테고리관리
    public static final String mg_selectAllCategories = "SELECT categoryKey, categoryName, categorydetails FROM category";
    public static final String mg_insertCategory = "INSERT INTO category (categoryKey, categoryName, categorydetails) VALUES (?, ?, ?)";
    public static final String mg_updateCategory = "UPDATE category SET categoryName=?, categorydetails=? WHERE categoryKey=?";
    public static final String mg_deleteCategory = "DELETE FROM category WHERE categoryKey=?";



}

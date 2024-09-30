package edu.sm.frame;

public class Sql {

        // 1. 주문 관련 CRUD

        public static final String insertOrder =
                "INSERT INTO orders (cid, odate, card, ostatus, oname, zip_code, addr, phone_num, item_name, item_img, cartKey) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        public static final String updateOrder =
                "UPDATE orders SET cid = ?, odate = ?, card = ?, ostatus = ?, oname = ?, zip_code = ?, addr = ?, phone_num = ?, item_name = ?, item_img = ? WHERE oid = ?";

        public static final String deleteOrder =
                "DELETE FROM orders WHERE oid = ?";

        public static final String selectOrderById =
                "SELECT * FROM orders WHERE oid = ?";

        public static final String selectAllOrders =
                "SELECT * FROM orders";


        // 2. 상품 조회 관련 (조회만 가능)

        public static final String selectProductByCategory =
                "SELECT p.pid, p.pname, p.price, p.img1 FROM product p WHERE p.categoryKey = (SELECT categoryKey FROM category WHERE categoryName = ?) ORDER BY p.pname";

        public static final String selectProductByPopularity =
                "SELECT p.pid, p.pname, p.price, COUNT(od.pid) AS purchase_count FROM product p LEFT JOIN orderDetail od ON p.pid = od.pid GROUP BY p.pid ORDER BY purchase_count DESC";

        public static final String selectProductByDate =
                "SELECT p.pid, p.pname, p.price, p.img1, p.pdate FROM product p ORDER BY p.pdate DESC";

        public static final String selectProductDetails =
                "SELECT p.pid, p.pname, p.price, p.content, p.img1, p.img2, p.img3, p.img4, (SELECT AVG(r.rate) FROM review r WHERE r.pid = p.pid) AS avg_rating FROM product p WHERE p.pid = ?";


        // 3. 장바구니 관련 CRUD
// 수정된 Cart 관련 CRUD SQL
        public static final String insertCartItem =
                "INSERT INTO cart (cid, pid, cnt) VALUES (?, ?, ?)";

    public static final String updateCartItemCount =
            "UPDATE cart SET cnt = ? WHERE cid = ? AND pid = ?";

    public static final String deleteCartItem =
            "DELETE FROM cart WHERE cid = ?";

    public static final String deleteAllCartItemsByCustomer =
            "DELETE FROM cart WHERE cid = ?";

    public static final String selectCartItems =
            "SELECT p.pname, cart.cnt, p.price, (cart.cnt * p.price) AS total_price FROM cart JOIN product p ON cart.pid = p.pid WHERE cart.cid = ?";

    public static final String selectCartItemById =
            "SELECT * FROM cart WHERE cart_id = ?";

    public static final String selectAllCartItems =
            "SELECT * FROM cart";

    public static final String selectCartItemsByCustomerId =
            "SELECT * FROM cart WHERE cid = ?";


    // 4. 결제 관련 (조회만 가능)

        public static final String selectPaymentInfo =
                "SELECT p.oid, p.pay_price, p.pay_method, p.card, p.pay_date FROM pay p JOIN orders o ON p.oid = o.oid WHERE o.cid = ?";


        // 5. 리뷰 관련 CRUD (사용자 및 관리자 구분하여 이름 변경)

        // 사용자 리뷰 관련
        public static final String insertUserReview =
                "INSERT INTO review (reviewKey, pid, cid, rate, title, content, img, rdate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        public static final String updateUserReview =
                "UPDATE review SET pid=?, cid=?, rate=?, title=?, content=?, img=?, rdate=? WHERE reviewKey=?";

        public static final String deleteUserReview =
                "DELETE FROM review WHERE reviewKey=?";

        public static final String selectOneUserReview =
                "SELECT * FROM review WHERE reviewKey=?";

        public static final String selectUserReviews =
                "SELECT * FROM review WHERE cid=?";

        // 6. 마이페이지 관련 조회 (Read)

        public static final String selectUserInfo =
                "SELECT c.cid, c.cname, c.email, c.phone_num, c.birth_date, c.nick_name, c.grade FROM customer c WHERE c.cid = ?";

        public static final String selectUserOrders =
                "SELECT o.oid, o.odate, o.ostatus, p.pay_price FROM orders o JOIN pay p ON o.oid = p.oid WHERE o.cid = ?";

        public static final String selectOrderReturns =
                "SELECT o.oid, o.ostatus, r.return_id, r.return_reason, r.return_status, r.request_date, r.return_type FROM orders o JOIN order_returns r ON r.oid = o.oid WHERE o.cid = ?";


        // 7. 취소/반품/교환 관련 CRUD

        public static final String insertReturnRequest =
                "INSERT INTO order_returns (oid, return_reason, return_status, request_date, return_type) VALUES (?, ?, ?, ?, ?)";

        public static final String updateReturnRequest =
                "UPDATE order_returns SET return_reason = ?, return_status = ?, return_type = ? WHERE return_id = ? AND oid = ?";

        public static final String deleteReturnRequest =
                "DELETE FROM order_returns WHERE return_id = ? AND oid = ?";

        public static final String selectReturnRequests =
                "SELECT od.oid, p.pname, od.item_cnt, od.od_price, r.return_reason, r.return_status, r.return_type FROM orderDetail od " +
                        "JOIN product p ON od.pid = p.pid " +
                        "JOIN orders o ON od.oid = o.oid " +
                        "JOIN order_returns r ON r.oid = o.oid " +
                        "WHERE o.cid = ?";


        // 8. 주문 내역 관련 조회 (Read)

        public static final String selectOrderDetails =
                "SELECT p.pname, od.item_cnt, od.od_price FROM orderDetail od JOIN product p ON od.pid = p.pid JOIN orders o ON od.oid = o.oid WHERE o.cid = ?";

        public static final String selectOrderShippingInfo =
                "SELECT o.ostatus, o.addr, o.zip_code, o.phone_num FROM orders o WHERE o.cid = ?";

        public static final String selectReviewableOrders =
                "SELECT p.pid, p.pname FROM product p JOIN orderDetail od ON p.pid = od.pid JOIN orders o ON od.oid = o.oid WHERE o.cid = ?";



        // 리뷰 관리
    public static final String INSERT_REVIEW =
            "INSERT INTO review (pid, cid, rate, title, content, img) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_REVIEW =
            "UPDATE review SET pid=?, cid=?, rate=?, title=?, content=?, img=? WHERE rid=?";
    public static final String DELETE_REVIEW =
            "DELETE FROM review WHERE rid=?";
    public static final String SELECT_ONE_REVIEW =
            "SELECT * FROM review WHERE rid=?";
    public static final String SELECT_ALL_REVIEWS =
            "SELECT * FROM review";
    public static final String SELECT_REVIEWS_BY_PRODUCT_ID =
            "SELECT * FROM review WHERE pid = ?";
    public static final String CHECK_DUPLICATE_REVIEW =
            "SELECT COUNT(*) FROM review WHERE cid = ? AND pid = ?";


    // 상품
    public static final String INSERT_PRODUCT =
            "INSERT INTO product (category_id, dis_id, pname, price, cnt, img1, img2, img3, img4, content, is_public) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_PRODUCT =
            "UPDATE product SET category_id=?, dis_id=?, pname=?, price=?, cnt=?, img1=?, img2=?, img3=?, img4=?, content=?, is_public=? " +
                    "WHERE pid=?";
    public static final String DELETE_PRODUCT =
            "DELETE FROM product WHERE pid=?";
    public static final String SELECT_PRODUCT_BY_ID =
            "SELECT * FROM product WHERE pid=?";
    public static final String SELECT_ALL_PRODUCTS =
            "SELECT * FROM product";
    public static final String SELECT_PUBLIC_PRODUCTS =
            "SELECT * FROM product WHERE is_public = true";
    public static final String SELECT_PRODUCTS_BY_CATEGORY =
            "SELECT * FROM product WHERE category_id = ?";
    public static final String SELECT_PRODUCT_BY_NAME =
            "SELECT * FROM product WHERE pname LIKE ?";
    // 정렬 sql
    public static final String SELECT_PRODUCT_ORDER_BY_PRICE_ASC =
            "SELECT * FROM product WHERE (category_id = ? OR ? IS NULL) ORDER BY price ASC";

    public static final String SELECT_PRODUCT_ORDER_BY_PRICE_DESC =
            "SELECT * FROM product WHERE (category_id = ? OR ? IS NULL) ORDER BY price DESC";

    public static final String SELECT_PRODUCT_ORDER_BY_REVIEW_COUNT =
            "SELECT p.*, COUNT(r.rid) AS review_count " +
                    "FROM product p LEFT JOIN review r ON p.pid = r.pid " +
                    "WHERE (p.category_id = ? OR ? IS NULL) " +
                    "GROUP BY p.pid ORDER BY review_count DESC";
    public static final String SELECT_PRODUCT_ORDER_BY_SALES_COUNT =
            "SELECT p.*, COUNT(od.pid) AS sales_count " +
                    "FROM product p " +
                    "LEFT JOIN order_detail od ON p.pid = od.pid " +
                    "WHERE (p.category_id = ? OR ? IS NULL) " +
                    "GROUP BY p.pid " +
                    "ORDER BY sales_count DESC";
    // 공개된 상품을 카테고리별로 조회하는 SQL
    public static final String SELECT_PUBLIC_PRODUCTS_BY_CATEGORY =
            "SELECT * FROM product WHERE category_id = ? AND is_public = true";

    // 공개된 상품을 상품명으로 조회하는 SQL
    public static final String SELECT_PUBLIC_PRODUCT_BY_NAME =
            "SELECT * FROM product WHERE pname LIKE ? AND is_public = true";

    // 주문
    // 주문 추가
    // 모든 주문 조회
    public static final String SELECT_ALL_ORDERS =
            "SELECT * FROM orders";
    public static final String INSERT_ORDERS =
            "INSERT INTO orders (cid, oname, address, address_detail, zip_code, phone, msg, price) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    // 특정 주문 조회
    public static final String SELECT_ORDER_BY_ID =
            "SELECT * FROM orders WHERE oid = ?";
    // 특정 고객의 주문 조회
    public static final String SELECT_ORDERS_BY_CID =
            "SELECT * FROM orders WHERE cid = ?";
    // ostatus 상태에 따른 주문조회
    public static final String SELECT_ORDERS_BY_STATUS=
            "SELECT oid, cid, ostatus, oname, address, address_detail, zip_code, phone, msg, odate, price FROM orders WHERE ostatus = ?";
    // ostatus만 바꾸기 (관리자)
    public static final String UPDATE_ORDERS_OSTATUS=
            "UPDATE orders SET ostatus = ? WHERE oid = ?";
    // 일별 주문 통계 (주문 개수와 총 매출)
    public static final String SELECT_DAILY_ORDER_STATS =
            "SELECT DATE(odate) AS order_date, COUNT(*) AS total_orders, SUM(price) AS total_sales " +
                    "FROM orders GROUP BY order_date";
   //월별 주문 통계 (주문 개수와 총 매출)
    public static final String SELECT_MONTHLY_ORDER_STATS =
            "SELECT YEAR(odate) AS order_year, MONTH(odate) AS order_month, COUNT(*) AS total_orders, SUM(price) AS total_sales " +
                    "FROM orders GROUP BY order_year, order_month";


    // 회원
    public static final String INSERT_CUSTOMER =
            "INSERT INTO customer (pwd, cname, email, phone, birth_date, nick_name, join_date) VALUES (?, ?, ?, ?, ?,  ?, CURRENT_TIMESTAMP)";
    public static final String UPDATE_CUSTOMER =
            "UPDATE customer SET cname=?, email=?, phone=?, nick_name=? WHERE cid=?";
    public static final String DELETE_CUSTOMER =
            "DELETE FROM customer WHERE cid=?";
    public static final String SELECT_CUSTOMER_BY_NAME =
            "SELECT cid, cname, email, phone, birth_date, nick_name, grade, join_date FROM customer WHERE cname LIKE ?";
    public static final String SELECT_CUSTOMER_BY_ID =
            "SELECT cid, cname, email, phone, birth_date, nick_name, grade, join_date FROM customer WHERE cid = ?";
    public static final String SELECT_CUSTOMER_ALL=
            "SELECT cid, cname, email, phone, birth_date, nick_name, grade, join_date FROM customer";
    public static final String SELECT_CUSTOMER_EMAIL=
            "SELECT * FROM customer WHERE email = ?";

    // 접속 통계
    public static final String INSERT_ACCESS_LOG =
            "INSERT INTO access_log (cid) VALUES (?)";
    public static final String SELECT_ACCESS_LOG_BY_ID =
            "SELECT * FROM access_log WHERE log_id = ?";
    public static final String SELECT_ALL_ACCESS_LOGS =
            "SELECT * FROM access_log";
    public static final String SELECT_HOURLY_ACCESS_STATS =
            "SELECT HOUR(access_time) AS 접속시간, COUNT(*) AS 접속자수 FROM access_log GROUP BY HOUR(access_time) ORDER BY 접속시간";
    public static final String SELECT_DAILY_ACCESS_STATS =
            "SELECT DATE(access_time) AS 접속일자, COUNT(*) AS 접속자수 FROM access_log GROUP BY DATE(access_time)";
    public static final String SELECT_WEEKLY_ACCESS_STATS =
            "SELECT CASE DAYNAME(access_time) " +
                    "WHEN 'Sunday' THEN '일요일' WHEN 'Monday' THEN '월요일' WHEN 'Tuesday' THEN '화요일' " +
                    "WHEN 'Wednesday' THEN '수요일' WHEN 'Thursday' THEN '목요일' WHEN 'Friday' THEN '금요일' " +
                    "WHEN 'Saturday' THEN '토요일' END AS 요일, COUNT(*) AS 접속자수 " +
                    "FROM access_log GROUP BY 요일";
    public static final String SELECT_MONTHLY_ACCESS_STATS =
            "SELECT MONTH(access_time) AS 월, COUNT(*) AS 접속자수 FROM access_log GROUP BY MONTH(access_time)";
    public static final String SELECT_YEARLY_ACCESS_STATS =
            "SELECT YEAR(access_time) AS 연도, COUNT(*) AS 접속자수 FROM access_log GROUP BY YEAR(access_time)";


    // 카테고리
    public static final String INSERT_CATEGORY =
            "INSERT INTO category (category_name, category_detail) VALUES (?, ?)";
    public static final String UPDATE_CATEGORY =
            "UPDATE category SET category_name = ?, category_detail = ? WHERE category_id = ?";
    public static final String DELETE_CATEGORY =
            "DELETE FROM category WHERE category_id = ?";
    public static final String SELECT_CATEGORY_BY_ID =
            "SELECT * FROM category WHERE category_id = ?";
    public static final String SELECT_ALL_CATEGORIES =
            "SELECT * FROM category";

    // 결제 관련
    public static final String INSERT_PAY =
            "INSERT INTO pay (oid, pay_price, pay_method, card) VALUES (?, ?, ?, ?)";
    public static final String SELECT_PAY_BY_ID =
            "SELECT * FROM pay WHERE pay_id = ?";
    public static final String SELECT_ALL_PAY =
            "SELECT * FROM pay";
    public static final String SELECT_PAY_BY_ORDER_ID =
            "SELECT * FROM pay WHERE oid = ?";

    // OrderDetiall 관련
    public static final String INSERT_ORDER_DETAIL =
            "INSERT INTO order_detail (pid, oid, item_cnt, od_price) VALUES (?, ?, ?, ?)";
    public static final String SELECT_ORDER_DETAIL_BY_ID =
            "SELECT * FROM order_detail WHERE order_detail_id = ?";
    public static final String SELECT_ALL_ORDER_DETAILS =
            "SELECT * FROM order_detail";
    // 특정 주문에 대한 주문 상세 목록을 조회하는 SQL (상품 이름 포함)
    public static final String SELECT_ORDER_DETAILS_BY_OID =
            "SELECT od.order_detail_id, od.oid, od.pid, od.item_cnt, od.od_price, p.pname " +
                    "FROM order_detail od " +
                    "JOIN product p ON od.pid = p.pid WHERE od.oid = ?";

    // 주소
    public static final String INSERT_ADDRESS =
            "INSERT INTO address (cid, aname, address, address_detail, zip_code, phone) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
    public static final String SELECT_ALL_ADDRESSES =
            "SELECT * FROM address";
    public static final String SELECT_ADDRESSES_BY_CID =
            "SELECT * FROM address WHERE cid = ?";
    public static final String SELECT_ADDRESS_BY_ID =
            "SELECT * FROM address WHERE aid = ?";
    public static final String UPDATE_ADDRESS =
            "UPDATE address SET aname = ?, address = ?, address_detail = ?, zip_code = ?, phone = ? WHERE aid = ?";
    public static final String DELETE_ADDRESS =
            "DELETE FROM address WHERE aid = ?";

    // 할인
    public static final String INSERT_DISCOUNT =
            "INSERT INTO discount (dis_name, dis_rate, dis_start, dis_end) VALUES (?, ?, ?, ?)";
    public static final String UPDATE_DISCOUNT =
            "UPDATE discount SET dis_name = ?, dis_rate = ?, dis_start = ?, dis_end = ? WHERE dis_id = ?";
    public static final String DELETE_DISCOUNT =
            "DELETE FROM discount WHERE dis_id = ?";
    public static final String SELECT_DISCOUNT_BY_ID =
            "SELECT * FROM discount WHERE dis_id = ?";
    public static final String SELECT_ALL_DISCOUNTS =
            "SELECT * FROM discount";


}

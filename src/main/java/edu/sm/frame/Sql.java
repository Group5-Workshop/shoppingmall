package edu.sm.frame;

public class Sql {

    // 리뷰 관리
    public static final String INSERT_REVIEW =
            "INSERT INTO review (pid, cid, rate, title, content, img, rdate) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_REVIEW =
            "UPDATE review SET pid=?, cid=?, rate=?, title=?, content=?, img=?, rdate=? WHERE rid=?";
    public static final String DELETE_REVIEW =
            "DELETE FROM review WHERE rid=?";
    public static final String SELECT_ONE_REVIEW =
            "SELECT * FROM review WHERE rid=?";
    public static final String SELECT_ALL_REVIEWS =
            "SELECT * FROM review";

    // 상품 관리
    public static final String SELECT_ALL_PRODUCTS =
            "SELECT pid, pname, price, cnt, pdate FROM product WHERE pname LIKE ? OR category_id = ? ORDER BY pdate DESC LIMIT ? OFFSET ?";
    public static final String UPDATE_PRODUCT =
            "UPDATE product SET pname = ?, price = ?, content = ?, cnt = ?, category_id = ?, img1 = ?, img2 = ?, img3 = ?, img4 = ?, dis_id = ?, is_public = ? WHERE pid = ?";
    public static final String INSERT_PRODUCT =
            "INSERT INTO product (category_id, dis_id, pname, price, cnt, img1, img2, img3, img4, content, pdate, is_public) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?)";
    public static final String SELECT_ALL_PRODUCT_STOCKS =
            "SELECT pid, pname, cnt FROM product ORDER BY pname";
    public static final String UPDATE_PRODUCT_STOCK =
            "UPDATE product SET cnt = cnt + ? WHERE pid = ?";
    public static final String DEACTIVATE_PRODUCT =
            "UPDATE product SET is_public = 0 WHERE pid = ?";
    public static final String SELECT_ONE_PRODUCT =
            "SELECT * FROM product WHERE pid = ? AND is_public = 1";

    // 주문 관리
    public static final String SELECT_ALL_ORDERS =
            "SELECT o.oid, c.cname, o.item_name, o.odate, o.ostatus FROM orders o JOIN customer c ON o.cid = c.cid";
    public static final String SELECT_PENDING_ORDERS =
            "SELECT oid, oname, item_name, odate FROM orders WHERE ostatus = '입금대기'";
    public static final String UPDATE_ORDER_STATUS_TO_PAID =
            "UPDATE orders SET ostatus = '입금완료' WHERE oid = ?";
    public static final String SELECT_PAID_ORDERS =
            "SELECT oid, oname, item_name, odate FROM orders WHERE ostatus = '입금완료'";
    public static final String UPDATE_ORDER_STATUS_TO_SHIPPING =
            "UPDATE orders SET ostatus = '배송 중' WHERE oid = ?";
    public static final String SELECT_SHIPPING_ORDERS =
            "SELECT oid, oname, item_name, odate FROM orders WHERE ostatus = '배송 중'";
    public static final String UPDATE_ORDER_STATUS_TO_DELIVERED =
            "UPDATE orders SET ostatus = '배송 완료' WHERE oid = ?";
    public static final String SELECT_DELIVERED_ORDERS =
            "SELECT oid, oname, item_name, odate FROM orders WHERE ostatus = '배송 완료'";

    // 회원
    public static final String INSERT_CUSTOMER =
            "INSERT INTO customer (pwd, cname, email, phone, birth_date, nick_name, join_date) VALUES (?, ?, ?, ?, ?,  ?, CURRENT_TIMESTAMP)";
    public static final String SELECT_ALL_CUSTOMERS =
            "SELECT c.cid, c.cname, c.email, c.birth_date, COUNT(o.oid) AS 주문수, c.grade FROM customer c LEFT JOIN orders o ON c.cid = o.cid GROUP BY c.cid";
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

    // 일별/월별 주문 통계
    public static final String SELECT_DAILY_ORDER_STATS =
            "SELECT DATE(odate) AS 주문일, COUNT(*) AS 주문수, SUM(pay_price) AS 총매출 FROM orders o JOIN pay p ON o.oid = p.oid GROUP BY DATE(odate)";
    public static final String SELECT_MONTHLY_ORDER_STATS =
            "SELECT MONTH(odate) AS 월, COUNT(*) AS 주문수, SUM(pay_price) AS 총매출 FROM orders o JOIN pay p ON o.oid = p.oid GROUP BY MONTH(odate)";

    // 카테고리 관리
    public static final String SELECT_ALL_CATEGORIES =
            "SELECT category_id, category_name, category_detail FROM category";
    public static final String INSERT_CATEGORY =
            "INSERT INTO category (category_name, category_detail) VALUES (?, ?)";
    public static final String UPDATE_CATEGORY =
            "UPDATE category SET category_name=?, category_detail=? WHERE category_id=?";
    public static final String DELETE_CATEGORY =
            "DELETE FROM category WHERE category_id=?";

    // 결제 관련
    public static final String SELECT_ALL_PAYMENTS =
            "SELECT * FROM pay";
    public static final String SELECT_PAYMENT_INFO =
            "SELECT p.oid, p.pay_price, p.pay_method, p.card, p.pay_date FROM pay p JOIN orders o ON p.oid = o.oid WHERE o.cid = ?";

}

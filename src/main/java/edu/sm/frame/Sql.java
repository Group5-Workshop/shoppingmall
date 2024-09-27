package edu.sm.frame;

public class Sql {
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
    public static final String mg_updateCustomer = "UPDATE customer SET cname=?, email=?, phone_num=? WHERE cid=?";
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

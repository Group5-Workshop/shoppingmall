package edu.sm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private int oid;             // 주문 아이디
    private int cid;             // 회원 아이디
    private Date odate;          // 주문 날짜
    private String card;         // 결제 카드 회사
    private String ostatus;      // 주문 현황
    private String oname;        // 수령인
    private String zip_code;     // 우편번호
    private String addr;         // 주소
    private String phone_num;    // 전화번호
    private String msg;          // 배송 요청사항
    private String item_name;    // 대표 상품명
    private String item_img;     // 대표 상품 이미지
    private int cartKey;         // 장바구니 번호
    private int id4;             // 결제 번호
}

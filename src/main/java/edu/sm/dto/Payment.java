package edu.sm.dto;


public class Payment {
    private int pay_price;      // 결제 금액
    private String pay_method;  // 결제 방법
    private long card;          // 카드 번호
    private int pay_date;       // 결제일 (int 형식)
    private int oid;            // 주문 아이디
    private int id4;            // 결제 번호
}

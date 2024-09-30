package edu.sm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderAddress {
    private int oid;            // 주문 아이디
    private int id4;            // 결제번호
    private String name;        // 수령인 이름
    private String phone_num;   // 전화번호
    private String order_add;   // 배송주소
}

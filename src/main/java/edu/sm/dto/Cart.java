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
public class Cart {
    private int cartKey;
    private int cid; // 사용자 Id
    private int pid; // 상품 id
    private int cnt;
}


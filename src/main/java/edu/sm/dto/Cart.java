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
    private int cid;
    private int pid;
    private int cnt;
    private Date cdate;

    // 필요한 생성자 추가
    public Cart(int cid, int pid, int cnt) {
        this.cid = cid;
        this.pid = pid;
        this.cnt = cnt;
    }

    public Cart(int cartKey, int cid, int pid, int cnt) {
        this.cartKey = cartKey;
        this.cid = cid;
        this.pid = pid;
        this.cnt = cnt;
    }
}

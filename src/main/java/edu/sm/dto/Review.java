package edu.sm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {
    private int rid;
    private int pid;
    private int cid;
    private int rate;
    private String title;
    private String content;
    private String img;
    private Timestamp rdate; // rdate는 Timestamp로 변경
}

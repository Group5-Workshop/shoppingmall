package edu.sm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    private int category_id;      // 카테고리 ID
    private String category_name; // 카테고리 이름
    private String category_detail; // 카테고리 세부사항
}

package edu.sm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderAdd {
    private int oid;
    private int id4;
    private int phone_number;
    private String oname;
    private String orderadd;
}


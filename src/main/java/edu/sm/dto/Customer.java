package edu.sm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    private int cid; // PK
    private String custpwd;
    private String cname;
    private String email;
    private String phone_num;
    private int birth_day;
    private String nick_name;
    private int grade;
}

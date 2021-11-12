package com.zwj.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProvinceInfo {
    private String Province;
    private Long PolicyNum;
    private Integer Vitality;
}

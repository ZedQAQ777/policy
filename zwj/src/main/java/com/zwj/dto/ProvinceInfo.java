package com.zwj.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProvinceInfo {
    private String Province;
    private Long PolicyNum;
    private Long Vitality;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProvinceInfo that = (ProvinceInfo) o;
        return Province.equals(that.Province);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Province);
    }
}

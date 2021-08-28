package com.my.xxb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class account {
    private int account_id;
    private String account_name;
    private String account_sex;
    private String account_phone;

    @Override
    public String toString() {
        return "account{" +
                "account_id=" + account_id +
                ", account_name='" + account_name + '\'' +
                ", account_sex='" + account_sex + '\'' +
                ", account_phone='" + account_phone + '\'' +
                '}';
    }
}

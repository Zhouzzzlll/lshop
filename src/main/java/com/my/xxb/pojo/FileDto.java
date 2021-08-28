package com.my.xxb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @authot: GSZ
 * @time: 2021/5/29 18:18
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {
    private String filename;
    private String msg;
}

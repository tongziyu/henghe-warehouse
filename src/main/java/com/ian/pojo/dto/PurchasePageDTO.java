package com.ian.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/18 22:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchasePageDTO {
    private Integer storeId;

    private String startTime;

    private String endTime;

    private String productName;

    private String buyUser;

    private Integer isIn;

    private Integer pageSize;

    private Integer pageNum;

    private Integer totalNum;
}

package com.ian.pojo.vo;

import com.ian.pojo.entity.InStore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/19 01:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InStorePageVo {
    private Long totalNum;

    private List<InStore> resultList;
}

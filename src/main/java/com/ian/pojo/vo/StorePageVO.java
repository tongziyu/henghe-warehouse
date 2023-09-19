package com.ian.pojo.vo;

import com.ian.pojo.entity.InStore;
import com.ian.pojo.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/19 15:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorePageVO {
    private Long totalNum;

    private List<Store> resultList;
}

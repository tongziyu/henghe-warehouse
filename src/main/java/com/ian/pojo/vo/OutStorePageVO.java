package com.ian.pojo.vo;

import com.ian.pojo.entity.OutStore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/19 12:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutStorePageVO {
    private Long totalNum;

    private List<OutStore> resultList;
}

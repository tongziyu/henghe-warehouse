package com.ian.mapper;

import com.ian.pojo.dto.PurchasePageDTO;
import com.ian.pojo.entity.BuyList;
import com.ian.pojo.vo.PurchasePageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BuyListMapper {
    /**
     * 添加采购单
     * @param buyList
     */
    void addPurchase(BuyList buyList);

    /**
     * 分页查询所有的订单,动态条件判断
     * @param purchasePageDTO
     * @return
     */
    List<BuyList> selectPurchasePage(PurchasePageDTO purchasePageDTO);

    /**
     * 修改入库单
     * @param buyList
     */
    @Update("update buy_list set buy_num = #{buyNum}, fact_buy_num = #{factBuyNum} where buy_id = #{buyId}")
    void updatePurchaseBuyNumAndFactNum(BuyList buyList);
}
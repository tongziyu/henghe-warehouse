package com.ian.controller;

import com.ian.pojo.Result;
import com.ian.pojo.dto.Page;
import com.ian.pojo.dto.ProductPageDTO;
import com.ian.pojo.entity.Place;
import com.ian.pojo.entity.Product;
import com.ian.pojo.entity.Supply;
import com.ian.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.web.ProjectedPayload;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/17 13:02
 */
@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private StoreService storeService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private SupplyService supplyService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private UnitService unitService;


    @Value("${file.upload.path}")
    private String uploadPath;


    /**
     * 查询所有仓库
     * @return
     */
    @GetMapping("/store-list")
    public Result storeList(){
        return Result.ok(storeService.selectStoreList());
    }


    /**
     * 分页查询商品的url接口/product/product-page-list
     *
     * 参数Page对象用于接收请求参数页码pageNum、每页行数pageSize;
     * 参数Product对象用于接收请求参数仓库id storeId、商品名称productName、
     * 品牌名称brandName、分类名称typeName、供应商名称supplyName、产地名称
     * placeName、上下架状态upDownState、是否过期isOverDate;
     *
     * 返回值Result对象向客户端响应组装了所有分页信息的Page对象;
     */
    @RequestMapping("/product-page-list")
    public Result productPageList(Page page, Product product){
        //执行业务
        page = productService.queryProductPage(page, product);
        //响应
        return Result.ok(page);
    }


    /**
     * 查询所有的品牌
     */
    @GetMapping("/brand-list")
    public Result brandList(){
        return Result.ok(brandService.selectBrandList());
    }


    /**
     * 查询所有供应商
     * @return
     */
    @GetMapping("/supply-list")
    public Result supplyList(){
        List<Supply> supplies = supplyService.selectSupplyList();



        return Result.ok(supplies);
    }

    /**
     * 返回所有种类树
     * @return
     */
    @GetMapping("/category-tree")
    public Result categoryTree(){
        return Result.ok(productTypeService.allProductTypeTree());
    }


    /**
     * 返回所有的产地信息
     * @return
     */
    @GetMapping("/place-list")
    public Result placeList(){
        List<Place> placeList = placeService.selectPlaceList();
        return Result.ok(placeList);
    }


    /**
     * 返回所有的单位
     * @return
     */
    @GetMapping("/unit-list")
    public Result unitList(){
        return Result.ok(unitService.selectUnitList());
    }

    /**
     * 文件上传
     */
    @CrossOrigin
    @PostMapping("/img-upload")
    public Result uploadImage(MultipartFile file){
        log.info("文件的名字:{}",file.getOriginalFilename());

        // 拼接文件后缀
        try {
            // 拼接文件后缀
            // String originalFilename = file.getOriginalFilename();

            // int i = originalFilename.lastIndexOf(".");

            // String substring = originalFilename.substring(i);

            // UUID uuid = UUID.randomUUID();

            // String fileName = uuid.toString() + substring;
            /*
                如果需要将图片保存到类路径下,那么只能只使用这个方式获取file对象:
                 - 拿到图片上传的目录路径 [类路径 classpath:static/img/upload]
                 - 使用Spring的ResourceUtils工具,将 static/img/upload放进去,
                   返回的对象就是 classpath:static/img/upload
             */
            String fileName = file.getOriginalFilename();

            File uploadFile = ResourceUtils.getFile(uploadPath);

            // 拿到绝对路径:磁盘路径
            String absoluteFile = uploadFile.getAbsolutePath();


            // 拿到上传的文件要保存的磁盘文件路径 mac使用/, windows使用 \\
            String filePath = absoluteFile + "/" + fileName;

            log.info("拿到绝对路径:{}",absoluteFile);
            log.info("文件要保存的磁盘文件路径:{}",filePath);

            file.transferTo(new File(filePath));



            // 成功响应
            return Result.ok("上传成功");

        } catch (IOException e) {

            throw new RuntimeException("文件上传失败");
        }
    }

    /**
     * 添加商品
     *
     *
     * @return
     */
    @PostMapping("/product-add")
    public Result addProduct(@RequestBody Product product){
        log.info("要插入的数据:{}",product);
        productService.addProduct(product);

        return Result.ok();
    }

    /**
     * 商品起售停售
     * @return
     */
    @PutMapping("/state-change")
    public Result changeState(@RequestBody Product product){
        productService.changeState(product);

        return Result.ok();
    }


    /**
     * 批量删除
     * @return
     */
    @DeleteMapping("/product-list-delete")
    public Result deleteProduct(@RequestBody List<Integer> productIdList){
        log.info("批量删除的ID:{}",productIdList);
        productService.deleteBatch(productIdList);
        return Result.ok();
    }

    /**
     * 商品修改
     * todo:商品修改未完成
     * @return
     */
    @PutMapping("/product-update")
    public Result updateProduct(@RequestBody Product product){

        log.info("product:{}",product);


        return Result.ok();
    }
}

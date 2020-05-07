package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseSaleAttr;
import com.atguigu.gmall.bean.PmsProductImage;
import com.atguigu.gmall.bean.PmsProductInfo;
import com.atguigu.gmall.bean.PmsProductSaleAttr;
import com.atguigu.gmall.manage.util.PmsUploadUtil;
import com.atguigu.gmall.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * ClassName :SpuController
 * Package :com.atguigu.gmall.manage.controller
 * Description :
 *
 * @author :张哈哈
 * @date :2020/4/18 16:27
 */
@RestController
@CrossOrigin//跨域注解
public class SpuController {

    @Reference
    ProductService productService;


    @RequestMapping("fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){
        //将图片或音视频上传到分布式文件系统
        String imgUrl = PmsUploadUtil.uploadImg(multipartFile);
        //将图片的地址返回给页面
        System.out.println(imgUrl);
        return imgUrl;
    }


    @RequestMapping("saveSpuInfo")
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){

        productService.saveSpuInfo(pmsProductInfo);

        return "success";
    }
    @RequestMapping("spuList")
    public List<PmsProductInfo> spuList(String catalog3Id){
        List<PmsProductInfo> pmsProductInfoList = productService.spuList(catalog3Id);
        return pmsProductInfoList;
    }

    @RequestMapping("baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList(){
        List<PmsBaseSaleAttr> pmsBaseSaleAttrList = productService.baseSaleAttrList();
        return pmsBaseSaleAttrList;
    }

    @RequestMapping("spuSaleAttrList")
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId){
        List<PmsProductSaleAttr> pmsProductSaleAttrList = productService.spuSaleAttrList(spuId);
        return pmsProductSaleAttrList;
    }

    @RequestMapping("spuImageList")
    public List<PmsProductImage> spuImageList(String spuId){
        List<PmsProductImage> pmsProductImageList = productService.spuImageList(spuId);
        return pmsProductImageList;
    }



}

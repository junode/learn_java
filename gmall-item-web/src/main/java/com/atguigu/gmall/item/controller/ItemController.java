package com.atguigu.gmall.item.controller;

import com.atguigu.gmall.bean.SkuInfo;
import com.atguigu.gmall.service.ManageService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {

    @Reference
    private ManageService manageService;

    //    @RequestMapping("{skuId}.html")
//    public String skuInfoPage(@PathVariable(value = "skuId") String skuId){
//        return "item";
//    }
    @RequestMapping("{skuId}.html")
    public String skuInfoPage(@PathVariable(value = "skuId") String skuId, Model model) {
        SkuInfo skuInfo = manageService.getSkuInfo(skuId);
        model.addAttribute("skuInfo", skuInfo);
        return "item";
    }
}

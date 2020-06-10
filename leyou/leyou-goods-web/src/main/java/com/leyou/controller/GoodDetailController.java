package com.leyou.controller;

import com.leyou.client.*;
import com.leyou.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GoodDetailController {

    @Autowired
    SpuClient spuClient;
    @Autowired
    BrandClient brandClient;

    @Autowired
    CategoryClient categoryClient;

    @Autowired
    SkuClient skuClient;

    @Autowired
    SpecClient specClient;
    @Autowired
    SpecParamClient specParamClient;

    /**
     * 1、spu
     * 2、品牌
     * 3、当前spu的三级分类
     * 4、skus
     * 5、spuDetail
     * 6、属性组以及组内的属性集合
     * @param model
     * @param spuId
     * @return
     */
    @RequestMapping("/item/{spuId}.html")
    public String helloworld(Model model, @PathVariable("spuId") Long spuId){
        //1、spu
        Spu spu = spuClient.baseInfo(spuId);

        //2、品牌
        Brand brand = brandClient.getBrandById(spu.getBrandId());

        //3、三级分类
        List<Category> categoryList  = categoryClient.findByIds(Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3()));

        //4、skus
        List<Sku> skuList  = skuClient.findSkuBySpuid(spuId);

        //5、skuDetail
        SpuDetail spuDetail = spuClient.detail(spuId);

        //6、属性组
        List<Specgroup> groups  = specClient.findSpecByCid(spu.getCid3());

        //7、特殊属性的集合
        List<SpecParam> params = specParamClient.findParamsByCidandSearchings(spu.getCid3(), false);
        Map<Long,String> paramMap = new HashMap<>();
        params.forEach(param->{
            paramMap.put(param.getId(),param.getName());
        });


        model.addAttribute("spu",spu);
        model.addAttribute("spuDetail",spuDetail);
        model.addAttribute("skuList",skuList);
        model.addAttribute("brand",brand);
        model.addAttribute("groups",groups);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("paramMap",paramMap);
        return "item";
    }













}

package com.leyou.controller;

import com.leyou.common.PageResult;
import com.leyou.pojo.Goods;
import com.leyou.pojo.Search;
import com.leyou.repository.GoodsRepository;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    GoodsRepository goodsRepository;

    @RequestMapping("page")
    public Object findGoods(@RequestBody Search search1){

        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withQuery(QueryBuilders.matchQuery("all",search1.getKey()).operator(Operator.AND));//关键字
        queryBuilder.withPageable(PageRequest.of(search1.getPage()-1,search1.getSize()));//分页


        Page<Goods> search = goodsRepository.search(queryBuilder.build());
        PageResult<Goods> pageResult = new PageResult<Goods>(search.getTotalElements(),search.getContent(),search.getTotalPages());

        return pageResult;
    }

}

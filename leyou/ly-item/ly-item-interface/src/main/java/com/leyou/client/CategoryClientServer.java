package com.leyou.client;

import com.leyou.pojo.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("category")
public interface CategoryClientServer {
    @RequestMapping("getCategoryById")
    public Category getCategoryById(@RequestParam("id") Long id);
    @RequestMapping("findByIds")
    public List<Category> findByIds(@RequestParam("ids") List<Long> ids);
}
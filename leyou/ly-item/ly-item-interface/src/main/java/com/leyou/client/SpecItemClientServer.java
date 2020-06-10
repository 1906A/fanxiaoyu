package com.leyou.client;

import com.leyou.pojo.Specgroup;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("spec")
public interface SpecItemClientServer {
    @RequestMapping("findSpecByCid")
    public List<Specgroup> findSpecByCid(@RequestParam("cid") Long cid);
}

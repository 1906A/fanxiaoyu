package com.leyou.client;

import com.leyou.pojo.SpecParam;
import com.leyou.pojo.Specgroup;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("specParam")
public interface SpecParamItemClientServer {
    @RequestMapping("paramsByCid")
    public List<SpecParam> findParamsByCidandSearching(@RequestParam("cid") Long cid);
    @RequestMapping("paramsByCids")
    public List<SpecParam> findParamsByCidandSearchings(@RequestParam("cid") Long cid, @RequestParam("generic") Boolean generic);
    @RequestMapping("groups/{cid}")
    public List<Specgroup> groups(@PathVariable("cid") Long cid);
}

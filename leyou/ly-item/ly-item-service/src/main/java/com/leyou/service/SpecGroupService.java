package com.leyou.service;

import com.leyou.dao.SpecGroupMapper;
import com.leyou.dao.SpecParamMapper;
import com.leyou.pojo.SpecParam;
import com.leyou.pojo.Specgroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecGroupService {

    @Autowired
    private SpecGroupMapper specGroupMapper;
    @Autowired
    private SpecParamMapper specParamMapper;

    public void saveSpecGroup(Specgroup specgroup) {
        specGroupMapper.insert(specgroup);
    }

    /**
     * 根据分类id查询商品规格组列表
     * @param cid
     * @return
     */
    public List<Specgroup> findSpecGroup(Long cid) {
        Specgroup specgroup = new Specgroup();
        specgroup.setCid(cid);
        List<Specgroup> select = specGroupMapper.select(specgroup);
        List<SpecParam> params = new ArrayList<>();
        select.forEach(group->{
            group.setParams(findSpecParamByGid(group.getId(),null,null));
        });
        return select;
    }

    public List<SpecParam> findSpecParamByGid(Long gid,Long cid,Boolean searching){
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(gid);
        specParam.setCid(cid);
        specParam.setSearching(searching);
        return specParamMapper.select(specParam);
    }

    /**
     * 根据商品规格组id删除
     * @param id
     */
    public void deleteBySpecGroupId(Long id) {
        specGroupMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改商品规格组
     * @param specgroup
     */
    public void updateSpevGroup(Specgroup specgroup) {
        specGroupMapper.updateByPrimaryKey(specgroup);
    }
}

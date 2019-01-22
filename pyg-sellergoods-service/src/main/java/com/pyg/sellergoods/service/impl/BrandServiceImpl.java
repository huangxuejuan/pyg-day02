package com.pyg.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pyg.mapper.TbBrandMapper;

import com.pyg.pojo.TbBrand;
import com.pyg.pojo.TbBrandExample;
import com.pyg.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper brandMapper;
    @Override
    public List<TbBrand> findAll() {
      return brandMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<TbBrand> page= (Page<TbBrand>) brandMapper.selectByExample(null);
        return new PageResult(page.getTotal(),page.getResult());
    }


    @Override
    public void add(TbBrand brand) {
        //根据品牌名字进行查询,如果存在不允许新增;
      /*  TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(brand.getName());
        List<TbBrand> brands = brandMapper.selectByExample(example);
        if (brands.size()>0){

        }*/
        brandMapper.insert(brand);
    }

    @Override
    public TbBrand findOne(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbBrand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            brandMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if (brand!=null){
            if (brand.getName()!=null&&brand.getName().length()>0){
                criteria.andNameLike("%"+brand.getName()+"%");
            }
            if (brand.getFirstChar()!=null&&brand.getFirstChar().length()>0){
                criteria.andFirstCharLike("%"+brand.getFirstChar()+"%");
            }
        }
        Page page= (Page) brandMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }

}

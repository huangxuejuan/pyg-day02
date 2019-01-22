package com.pyg.sellergoods.service;



import com.pyg.pojo.TbBrand;
import entity.PageResult;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有
     * @return
     */
    public List<TbBrand> findAll();

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(int pageNum,int pageSize);

    /**
     * 新增
     * @param brand
     */
    public void add(TbBrand brand);

    /**
     *根据id查询
     * @param id
     * @return
     */
    public TbBrand findOne(Long id);

    /**
     *修改
     * @param brand
     */
    public void update(TbBrand brand);

    /**
     * 删除
     * @param ids
     */
    public void delete(Long[] ids);

    /**
     * m模糊查询
     * @param brand
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(TbBrand brand,int pageNum,int pageSize);
}

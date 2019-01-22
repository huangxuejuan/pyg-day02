package com.pyg.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pyg.pojo.TbBrand;
import com.pyg.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
//通过接口的全类名去远程的服务找对应的接口实现并调用方法,
// 而这里得到的几口实现是一个本地的代理对象,有代理对象的方法去完成远程方法调用(通过socket)
    @Reference
    private BrandService brandService;
    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
            return brandService.findAll();
    }

    @RequestMapping("/findPage")
    public PageResult findPage(int page,int size){
      return  brandService.findPage(page, size);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand){
        try {
            brandService.add(brand);
            return new Result(true,"新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"新增失败");
        }
    }
    @RequestMapping("/findOne")
    public TbBrand findOne(Long id){
       return brandService.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand brand){
        try {
            brandService.update(brand);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }

    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        try {
            brandService.delete(ids);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand brand,int page,int size){
       return brandService.findPage(brand,page,size);
    }

}

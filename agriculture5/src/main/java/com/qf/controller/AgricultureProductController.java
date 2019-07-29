package com.qf.controller;
import com.qf.domain.AgricultureProduct;
import com.qf.domain.CommonProduct;
import com.qf.service.IAgricultureProductSevice;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("agricultureProduct")
public class AgricultureProductController {
    @Autowired
    private IAgricultureProductSevice agricultureProductSevice;
//    @Autowired
//    private ProductResponsitory productResponsitory;
    @GetMapping(value = "/findByCategoriesId")
    @ApiOperation("根据总类ID查询所有商品")
    public List<AgricultureProduct> findByCategoriesId(@RequestParam Integer categoriesId) {
        return agricultureProductSevice.findByCategoriesId(categoriesId);
    }

    @GetMapping(value = "/findBySubclassId")
    @ApiOperation("根据子分类ID查询所有商品")
    public List<AgricultureProduct> findBySubclassId(@RequestParam Integer subclassId) {
        return agricultureProductSevice.findBySubclassId(subclassId);
    }

    //根据商品id查询商品

    @ApiOperation(value = "根据商品id查询商品详细信息")
    @ApiImplicitParam(paramType = "Query",name="id",value = "商品id",required = true)
    @RequestMapping(value = "/one",method = RequestMethod.GET)
    public Object getonee(@RequestParam Integer id){
        System.out.println(agricultureProductSevice.selectone(id));

        return agricultureProductSevice.selectone(id);
    }


    //根据商品id查看所有评论
    @ApiOperation(value = "根据商品id查询商品评论")
    @ApiImplicitParam(paramType = "Query",name="pid",value = "商品id",required = true)
    @RequestMapping(value = "/common",method = RequestMethod.GET)
    public List<CommonProduct> getById(@RequestParam Integer pid){
        System.out.println(agricultureProductSevice.selectCommen(pid));
        return agricultureProductSevice.selectCommen(pid);

    }

       @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ApiOperation("查询所有产品")
    public List<AgricultureProduct> findAll() {
        return agricultureProductSevice.findAll();
    }

    @RequestMapping(value = "/findLike",method = RequestMethod.GET)
    @ApiOperation("输入条件模糊查询")//名字，品牌，产地，多条件查询
    public List<AgricultureProduct> findLike(String productName) {
        System.out.println(productName);
        System.out.println(agricultureProductSevice.findLike(productName));
        return agricultureProductSevice.findLike(productName);
    }

//    @GetMapping(value = "/findByNameLike")
//    @ApiOperation("模糊查询所有产品")
//    public Set<AgricultureProduct> findByNameLike(String name) {
//        AgricultureProduct agr = new AgricultureProduct();
//        AgricultureProduct agr1 = new AgricultureProduct();
//        AgricultureProduct agr2 = new AgricultureProduct();
//        agr.setProductName(name);
//        agr1.setProductPlace(name);
//        agr2.setProductBrand(name);
//        List<AgricultureProduct> list = agricultureProductSevice.example(agr);
//        List<AgricultureProduct> list1 = agricultureProductSevice.example(agr1);
//        List<AgricultureProduct> list2 = agricultureProductSevice.example(agr2);
//        Set<AgricultureProduct> agrlist = new HashSet<>();
//        agrlist.addAll(list);
//        agrlist.addAll(list1);
//        agrlist.addAll(list2);
//        return agrlist;
//    }


    @RequestMapping(value = "/findAllById",method = RequestMethod.GET)
    @ApiOperation("通过ID查询产品")
    public AgricultureProduct findAll(@RequestParam Integer productId) {
        return agricultureProductSevice.findAllById(productId);
    }

    @RequestMapping(value = "/findBySortId",method = RequestMethod.GET)
    @ApiOperation("根据种类 id 显示对应商品")
    public List<AgricultureProduct> findBySortId(Integer sortId){
        return agricultureProductSevice.findBySortId(sortId);
    }



//    @RequestMapping("/findByaid")
//    public List<AgricultureProduct> findByaid(int aid) {
//        return productResponsitory.findByaid(aid);
//    }


}

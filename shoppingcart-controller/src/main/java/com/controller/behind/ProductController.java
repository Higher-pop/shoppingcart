package com.controller.behind;

import com.controller.ParentController;
import com.entity.CategoryEntity;
import com.entity.ProductAndPImageEntity;
import com.entity.ProductEntity;
import com.page.*;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;
import com.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * @author SherWin
 * @date 2019/12/6 10:35
 */


@Controller
@RequestMapping("/admin/product")
public class ProductController extends ParentController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    public static final String FILE_DIRECTORY = "/images";

    @RequestMapping("/add")
    public String  add(HttpServletRequest req){
        req.setAttribute("categories",categoryService.getAll());
        return "forward:addjsp";
    }

    @RequestMapping("/addjsp")
    public String addJsp(){
        return "be/product/add";
    }

    @RequestMapping("/delete")
    public String  delete(Integer pid){
        productService.deleteById(pid);
        return "redirect:listjsp";
    }
    @RequestMapping("/edit")
    public String edit(HttpServletRequest req,Integer pid){
        req.setAttribute("product",productService.getById(pid));
        List<CategoryEntity> categoryEntities= categoryService.getAll();
        req.setAttribute("categories",categoryEntities);
        return "redirect:editjsp";

    }
    @RequestMapping("/editjsp")
    public String editJsp(){
        return "be/product/edit";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest req){
        int recordCount  = productService.getRecordCount();
        PageInfoes pageInfo = new PageInfoes(getParamInteger(req,"pageno",1),recordCount,PAGE_SIZE);
        List<ProductEntity> productList = productService.getPagedRecords(pageInfo.getOffset(), pageInfo.getPageCount());// TODO: 2019/12/24

        ProductVO productVO = new ProductVO(pageInfo,productList);
        req.setAttribute("pvo", productVO);
        return "forward:listjsp";
    }
    @RequestMapping("/listjsp")
    public String listJsp(){
        return "be/product/list";
    }

    @PostMapping("/insert")
    public String insert(ProductAndPImageEntity productAndPImageEntity, HttpServletRequest req){
        String filename = productAndPImageEntity.getMultipartFile().getOriginalFilename();
        String path = FILE_DIRECTORY + File.separator + filename;
        File file = new File(path);
        ProductEntity productEntity=new ProductEntity();
        productEntity.setCid(productAndPImageEntity.getCid());
        productEntity.setPdesc(productAndPImageEntity.getPdesc());
        productEntity.setPid(productAndPImageEntity.getPid());
        productEntity.setPimage(path);
        productEntity.setPname(productAndPImageEntity.getPname());
        productEntity.setUnitprice(productAndPImageEntity.getUnitprice());
        try {
            productAndPImageEntity.getMultipartFile().transferTo(file);
            productService.insert(productEntity);
            return "redirect:index";
        } catch (IOException e) {
            e.printStackTrace();
            req.setAttribute("Product",productEntity);
            req.setAttribute("categories",categoryService.getAll());
            //一般不会把这种异常的消息暴露给界面.
            //req.setAttribute("msg", re.getMessage());
            req.setAttribute("msg", "出错了");
            return "forward:addJsp";
        }
    }
    @PostMapping("/update")
    public String update(ProductAndPImageEntity productAndPImageEntity,String oldimage,HttpServletRequest req){
        String filename = productAndPImageEntity.getMultipartFile().getOriginalFilename();
        if(filename.isEmpty()){
            filename = oldimage;
        }
        String path = FILE_DIRECTORY + File.separator + filename;
        File file = new File(path);
        ProductEntity productEntity=new ProductEntity();
        productEntity.setCid(productAndPImageEntity.getCid());
        productEntity.setPdesc(productAndPImageEntity.getPdesc());
        productEntity.setPid(productAndPImageEntity.getPid());
        productEntity.setPimage(path);
        productEntity.setPname(productAndPImageEntity.getPname());
        productEntity.setUnitprice(productAndPImageEntity.getUnitprice());
        try {
            // TODO: 2019/12/11 或许还有些问题
            productAndPImageEntity.getMultipartFile().transferTo(file);
            productService.update(productEntity);
            return "redirect:index";
        } catch (IOException e) {
            e.printStackTrace();
            req.setAttribute("Product",productEntity);
            return "forward:editJsp";
        }

    }






}

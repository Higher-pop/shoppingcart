
package com.controller.behind;

import com.entity.CategoryEntity;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author SherWin
 * @date 2019/12/5 12:04
 */

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping("/delete")
    public void delete(Integer cid){
        categoryService.deleteById(cid);
    }

    @RequestMapping("/index")
    public String index(){
        return "be/category/list";
    }

    @ResponseBody
    @RequestMapping("/insert")
    public void insert(CategoryEntity categoryEntity){
        categoryService.insert(categoryEntity);
    }
    @RequestMapping("/list")
    @ResponseBody
    public List<CategoryEntity> list(){
        return categoryService.getAll();
    }
    @ResponseBody
    @RequestMapping("/update")
    public void update(CategoryEntity categoryEntity){
        categoryService.update(categoryEntity);
    }
}



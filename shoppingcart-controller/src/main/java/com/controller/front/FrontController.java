package com.controller.front;

import com.controller.ParentController;
import com.entity.CartEntity;
import com.entity.CategoryEntity;
import com.entity.ProductEntity;
import com.entity.SUserEntity;
import com.page.PageInfoes;
import com.service.CartService;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;
import com.vo.CartItemVO;
import com.vo.CartVO;
import com.vo.ProductCategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SherWin
 * @date 2019/12/12 8:38
 */


@Controller
public class FrontController extends ParentController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CartService cartService;

    @RequestMapping("/addtocart")
    public String addToCart(Integer pid, HttpServletRequest req){
        ProductEntity productEntity=productService.getById(pid);
        String referer=req.getHeader("referer");
        CartItemVO cartItem=new CartItemVO(productEntity);
        addProductToCart(req,cartItem);
        return "redirect:"+referer;
    }

    private void addProductToCart(HttpServletRequest request, CartItemVO cartItem) {
        HttpSession session = request.getSession();
        CartVO cart = (CartVO)session.getAttribute("cart");
        if(cart!=null) {
            cart.addCartItem(cartItem);
            // TODO: 2019/12/12  这里要加入数据库
        }else {
            cart = new CartVO();//这里new 了cart
            cart.addCartItem(cartItem);
            session.setAttribute("cart", cart);
        }
    }
    @RequestMapping("/indexjsp")
    public String indexJsp(){
        return "fe/index";
    }
    @RequestMapping("/")
    public String index(Integer cid,HttpServletRequest req){
        List<CategoryEntity> categoryEntities=categoryService.getAll();
        Map<String,Object> conditions=generateSearchCondition(req);

        int reordCount=productService.getProductsCountByCondition(conditions);

        PageInfoes pageInfoes = new PageInfoes(getParamInteger(req, "pageno", 1), reordCount, PAGE_SIZE);
        List<ProductEntity> productEntities=productService.getProductsByCondition(conditions,pageInfoes.getOffset(),pageInfoes.getPageCount());
        ProductCategoryVO productCategoryVO = new ProductCategoryVO(productEntities,
                categoryEntities,pageInfoes,cid);
        req.setAttribute("pvo", productCategoryVO);
        return "forward:indexjsp";
    }
    private  Map<String,Object> generateSearchCondition(HttpServletRequest req) {
        Integer cid = getParamInteger(req,"cid",0);
        String pname = req.getParameter("pname");
        Map<String,Object> conditions = new HashMap<>(16);
        if(cid!=null) {
            conditions.put("cid", cid);
        }
        if(pname!=null) {
            conditions.put("pname", "%" + pname + "%");
        }


        return  conditions;
    }

    @RequestMapping("/removefromcart")
    public String removeFromCart(String qty,HttpServletRequest req){
        String[] pids = req.getParameterValues("pid");
        CartVO cart= (CartVO) req.getSession().getAttribute("cart");
        if (cart==null){
            return "redirect:/";
        }
        if (qty==null || qty.isEmpty()){
            removeProduct(pids,cart);
        }else{
            cart.removeItems(Integer.valueOf(pids[0]),Integer.valueOf(qty));
        }
        return "redirect:viewcart";
    }
    private void removeProduct(String[] pids, CartVO cart) {
        if(pids !=null && pids.length> 0) {
            for (String id : pids) {
                cart.removeItems(Integer.valueOf(id));
            }
        }
    }

    @RequestMapping("/viewcartjsp")
    public String viewCartJsp(){
        return "fe/viewcart";
    }
    @RequestMapping("/viewcart")
    public String viewCart(HttpServletRequest req){
        CartVO cart = (CartVO) req.getSession().getAttribute("cart");
        if(cart!=null){
            return "forward:viewcartjsp";
        }
        SUserEntity sUserEntity= (SUserEntity) req.getSession().getAttribute("users");
        String username = sUserEntity.getUsername();
        List<CartEntity> cartEntities=cartService.getCartByName(username);
        cart =new CartVO();
        for (CartEntity c:cartEntities){
            ProductEntity productEntity = new ProductEntity();
            productEntity.setPid(c.getPid());
            productEntity.setPname(c.getPname());
            productEntity.setUnitprice(c.getUnitprice());
            CartItemVO cartItemVO=new CartItemVO(productEntity,c.getQuantity());
            cart.addCartItem(cartItemVO);
        }
        req.getSession().setAttribute("cart",cart);
        return "forward:viewcartjsp";
    }
}

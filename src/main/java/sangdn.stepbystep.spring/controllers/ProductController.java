package sangdn.stepbystep.spring.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sangdn.stepbystep.spring.domain.Product;
import sangdn.stepbystep.spring.services.ProductService;
import sangdn.stepbystep.spring.services.ProductServiceImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sangdn on 9/22/15.
 */
@Controller
public class ProductController {
    public static final Logger logger = Logger.getLogger(ProductController.class);
    ProductService productService;

    public ProductService getProductService() {
        return productService;
    }
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/product")
    public String listProduct(Model model){
        model.addAttribute("products",productService.getAll());
        return "product";
    }
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveProduct(Product product,HttpServletRequest request){
        logger.info("saveProduct: " +product.getId());
        productService.update(product);
        logger.info("saveProduct: " + product.getId());

        return "redirect:/product/" + product.getId();
    }
    @RequestMapping("/product/{id}")
    public String productDetail(@PathVariable int id,Model model){
        model.addAttribute("product", productService.get(id));
        return "product-detail";
    }
    @RequestMapping("/product/new")
    public String createProduct(Model model){
        model.addAttribute("product",new Product());
        return "product-new";
    }
    @RequestMapping("/product/edit/{id}")
    public String editProduct(@PathVariable int id,Model model){
        model.addAttribute("product",productService.get(id));
        return "product-new";
    }
    @RequestMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable int id,HttpServletRequest request){
        productService.delete(id);

        return "redirect:/product";
    }
//    @RequestMapping("/product")
//    public String listProduct(Model model){
//        model.addAttribute("products",productService.getAll());
//        Section home = new Section();
//        for(product : Products){
//            Section product=home.addSection("product");
//            product.setVariable("id",product.getId);
//            product.setVariable("id",product.getId);
//            product.setVariable("id",product.getId);
//            product.setVariable("id",product.getId);
//            product.setVariable("id",product.getId);
//        }
//        return "product";
//    }
}

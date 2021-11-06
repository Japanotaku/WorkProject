package com.example.SpringWebWork.controllers;


import com.example.SpringWebWork.Entity.Product;
import com.example.SpringWebWork.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showProductsList(Model model,@RequestParam(value="word",required = false)String word) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProductsWithFilter(word));
        model.addAttribute("product", product);
        model.addAttribute("word",word);
        return "products";
    }


    @PostMapping("/edit")
    public String addProduct(@ModelAttribute(value = "product")Product product) {
        productService.add(product);
        return "redirect:/products";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(value = "id") Long id) {
        Product productRem = productService.getById(id);
        productService.delete(productRem);
        return "redirect:/products";
    }
    @GetMapping("/show/{id}")
    public String showOneProduct(Model model, @PathVariable(value = "id") Long id) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "product-page";
    }
    @GetMapping("/edit{id}")
    public String showAddProductForm(Model model,@PathVariable(value= "id")Long id){
        Product product = productService.getById(id);
        model.addAttribute("product",product);
        return "product-change";
    }
    @GetMapping("/add")
    public String showAddProductForm(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "product-change";
    }
}

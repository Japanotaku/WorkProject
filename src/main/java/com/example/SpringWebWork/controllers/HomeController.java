package com.example.SpringWebWork.controllers;


import com.example.SpringWebWork.Entity.Cat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/view")
public class HomeController {
    @Value("${spring.application.name}")
    String appName;


    @GetMapping("/main")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }
    @GetMapping("/index/{name}")
    public String homeRequest(Model model, @PathVariable(value = "name") String name) {
        model.addAttribute("name", name);
        return "index";
    }
    @GetMapping("/form")
    public String showForm(){
        return "form-information";
    }
    @PostMapping("/form")
    public String saveForm(@RequestParam(value ="name") String name,@RequestParam(value="email") String email){
        System.out.println(name);
        System.out.println(email);
        return "redirect:/";
    }
    @GetMapping("/addcat")
    public String showAddCatForm(Model model){
        Cat cat = new Cat(1L,null,null);
        model.addAttribute("cat",cat);
        return "cat-form";
    }
    @PostMapping("/addcat")
    public String showAddCatRequest(@ModelAttribute(value="cat") Cat cat){
        System.out.println(cat.getId()+" "+cat.getName());
        return "redirect:/";
    }
}

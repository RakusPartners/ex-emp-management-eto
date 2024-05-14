package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Administrator;
import com.example.form.InsertAdministratorForm;
import com.example.form.LoginForm;
import com.example.service.AdministratorService;

@Controller
@RequestMapping("/")
public class AdministratorController {

@Autowired
private AdministratorService administratorService;

@GetMapping("/toInsert")
public String toInsert(InsertAdministratorForm form, Model model){
    model.addAttribute("form", form);
    return "administrator/insert.html";
}    


@PostMapping("/insert")
public String insert(InsertAdministratorForm form){
    Administrator administrator = new Administrator();
    
    administrator.setName(form.getName());
    administrator.setMailAddress(form.getMailAddress());
    administrator.setPassword(form.getPassword());

    administratorService.insert(administrator);

    // 「/」(ログイン画面)にリダイレクトする
    return "redirect:/login";

}
@GetMapping("/")
public String toLogin(LoginForm form, Model model){
    return "administrator/login";

}

}

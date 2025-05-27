package com.unicuritiba.boleto.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PageRedirectController {

    @GetMapping("/verificar")
    public String redirectToHtml(){
        return "redirect:/verificar.html";
    }
}

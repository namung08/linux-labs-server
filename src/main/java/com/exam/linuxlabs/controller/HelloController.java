package com.exam.linuxlabs.controller;

import com.exam.linuxlabs.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HelloController {
  private final GreetingService service;

  @GetMapping("/hello")
  public String getString(Model model) {
    model.addAttribute("message", "안녕하세요, Thymeleaf!");
    return "hello";
  }

  @GetMapping("/greeting")
  public String get(Model model, @RequestParam String lang) {
    service.greeting(model, lang);
    return "greeting";
  }
}

package com.exam.linuxlabs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
  @GetMapping("/hello")
  public String getString(Model model) {
    model.addAttribute("message", "안녕하세요, Thymeleaf!");
    return "hello";
  }
}

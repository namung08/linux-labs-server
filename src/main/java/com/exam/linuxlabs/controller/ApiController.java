package com.exam.linuxlabs.controller;

import com.exam.linuxlabs.dto.GreetingResponse;
import com.exam.linuxlabs.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ApiController {
  private final GreetingService service;

  @GetMapping("/greeting")
  public ResponseEntity<GreetingResponse> getGreetingResponse(@RequestParam String lang) {
    return ResponseEntity.ok(service.greeting(lang));
  }
}

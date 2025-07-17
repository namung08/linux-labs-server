package com.exam.linuxlabs.service;

import com.exam.linuxlabs.model.Greeting;
import com.exam.linuxlabs.model.Lang;
import com.exam.linuxlabs.repository.GreetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class GreetingService {
  private final GreetingRepository repository;

  public void greeting(Model model, String lang) {
    lang = lang.toUpperCase();
    Lang langEnum;
    switch (lang) {
      case "EN" -> langEnum = Lang.EN;
      case "JP" -> langEnum = Lang.JP;
      default -> langEnum = Lang.KR;
    }
    Greeting byLangCode = repository.findByLangCode(langEnum);
    model.addAttribute("message", byLangCode.getMessage());
  }
}

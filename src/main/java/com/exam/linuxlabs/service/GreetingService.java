package com.exam.linuxlabs.service;

import com.exam.linuxlabs.dto.GreetingResponse;
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
    Greeting byLangCode = getGreeting(lang);
    model.addAttribute("message", byLangCode.getMessage());
  }

  public GreetingResponse greeting(String lang) {
    Greeting byLangCode = getGreeting(lang);
    return GreetingResponse.builder()
        .lang(byLangCode.getLangCode())
        .message(byLangCode.getMessage())
        .build();
  }

  private Greeting getGreeting(String lang) {
    lang = lang.toUpperCase();
    Lang langEnum;
    switch (lang) {
      case "EN" -> langEnum = Lang.EN;
      case "JP" -> langEnum = Lang.JP;
      default -> langEnum = Lang.KR;
    }
    return repository.findByLangCode(langEnum);
  }
}

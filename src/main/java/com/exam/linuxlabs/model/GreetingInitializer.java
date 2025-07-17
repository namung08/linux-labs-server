package com.exam.linuxlabs.model;

import com.exam.linuxlabs.repository.GreetingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingInitializer {

  @Bean
  CommandLineRunner initData(GreetingRepository repository) {
    return args -> {
      if (repository.count() == 0) {
        repository.save(new Greeting(null, Lang.KR, "안녕하세요!"));
        repository.save(new Greeting(null, Lang.EN, "Hello!"));
        repository.save(new Greeting(null, Lang.JP, "こんにちは!"));
      }
    };
  }
}

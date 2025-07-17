package com.exam.linuxlabs.repository;

import com.exam.linuxlabs.model.Greeting;
import com.exam.linuxlabs.model.Lang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
  Greeting findByLangCode(Lang langCode);
}

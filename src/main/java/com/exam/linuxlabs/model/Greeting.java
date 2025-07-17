package com.exam.linuxlabs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "greetings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Greeting {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, unique = true, length = 10)
  private Lang langCode;
  @Column(nullable = false)
  private String message;
}

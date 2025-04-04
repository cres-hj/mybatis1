package com.example.mybatis1.todo;

import lombok.*;

import java.time.*;

@Getter
@Setter  // 세터로 값 받아와
@AllArgsConstructor
@NoArgsConstructor  // 기본생성자로 객체 만들고 modelattribute쓸거면이거있어야
public class Todo {
  private int tno;
  private String title;
  private LocalDate regDate = LocalDate.now();
  private boolean finish = false;
}

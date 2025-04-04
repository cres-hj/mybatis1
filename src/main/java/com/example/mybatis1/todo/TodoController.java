package com.example.mybatis1.todo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class TodoController {
  // 컨트롤러는 서비스를 주입받아서 움직여
  // 컨트롤러는 dao를 주입받아 사용. dao에서 db작업 했어
  @Autowired
  private TodoDao todoDao;

  @GetMapping("/todo/list")
  public ModelAndView findAll() {
    return new ModelAndView("todo/list").addObject("todos", todoDao.findAll());

  }

  @PostMapping("/todo/write")
  public ModelAndView save(@ModelAttribute Todo todo) {
    todoDao.save(todo);
    return new ModelAndView("redirect:/todo/list");

  }

  @PostMapping("/todo/finish")
  public ModelAndView finish(@RequestParam int tno) {
    todoDao.finish(tno);
    return new ModelAndView("redirect:/todo/list");

  }

  @PostMapping("/todo/delete")
  public ModelAndView delete(int tno) {
    todoDao.delete(tno);
    return new ModelAndView("redirect:/todo/list");
  }

}

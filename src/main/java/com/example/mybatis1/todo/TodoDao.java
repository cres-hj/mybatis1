package com.example.mybatis1.todo;

import org.apache.ibatis.annotations.*;

import java.util.*;

// 빈 생성을 mybatis가 하기 때문에 mybatis annotation인 @Mapper 사용
// 스프링의 DAO 어노테이션은 @Repository
@Mapper
public interface TodoDao {
  // 이건 몇 개 나갈지 모르지 있으면 다 나가고 없으면 아예 안나가고
  // 정확한 개수를 모르면 List를 리턴 -> 결과가 0개면 비어있는 리스트를 리턴 -> null이 발생하지 않아~
  @Select("select * from todo")
  // select * from todo 뒤에 order by tno desc 붙이면 번호 기준으로 내림차순 정렬
  public List<Todo> findAll();

  // 이건 하나 출력! 왜? 기본키를 줬으니까! 기본키는 겹치지 않아
  // 기본키로 검색했기 때문에 결과의 개수는 0 또는 1 (0이면 null 리턴, 1이면 todo가 리턴)
  @Select("select * from todo where tno=#{tno}")
  public Todo findByTno(int tno);

  @Select("select * from todo where title=#{title}")
  public List<Todo> findByTitle(String title);

  @Insert("insert into todo values(todo_seq.nextval, #{title}, #{regDate}, #{finish})")
  // ㅈ #들은 데이터베이스에 있는 투두의 타이틀, 데이트, 피니시르 ㄹ의미해서 #{} 쓰는거야
  public int save(Todo todo);

  @Update("update todo set finish=1 where tno=#{tno}")
  public int finish(int tno);

  @Delete("delete from todo where tno=#{tno}")
  public int delete(int tno);

  // update나 delete는 항상 기본키를 받아
}

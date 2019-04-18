package com.qikegu.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qikegu.demo.User;

public interface UserMapper {
    
   final String getAll = "SELECT * FROM User"; 
   final String getById = "SELECT * FROM User WHERE id = #{id}";
   final String deleteById = "DELETE from User WHERE id = #{id}";
   final String insert = "INSERT INTO User (name) VALUES (#{name})";
   final String update = "UPDATE User SET name = #{name} WHERE id = #{id}";
   
   @Select(getAll)
   @Results(value = {
      @Result(property = "id", column = "id"),
      @Result(property = "name", column = "name")
   })
   List<User> getAll();
  
   @Select(getById)
   @Results(value = {
      @Result(property = "id", column = "ID"),
      @Result(property = "name", column = "NAME")
   })
   User getById(long id);

   @Update(update)
   void update(User user);

   @Delete(deleteById)
   void delete(long id);
  
   @Insert(insert)
   @Options(useGeneratedKeys = true, keyProperty = "id")
   void insert(User user);
}

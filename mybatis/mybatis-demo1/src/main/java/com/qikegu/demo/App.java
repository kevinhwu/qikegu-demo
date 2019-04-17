package com.qikegu.demo;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class App {

    public static void main(String args[]) throws IOException {

        Reader reader = Resources.getResourceAsReader("MybatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        System.out.println("------------ 数据插入 -----------");
        // 创建用户对象
        User user = new User("newUser100");

        // 插入新用户到数据库
        session.insert("User.insert", user);
        session.commit();
        System.out.println("数据插入成功");

        System.out.println("------------ 读取用户列表 -----------");
        // select contact all contacts
        List<User> userList = session.selectList("User.getAll");

        for (User u : userList) {
            System.out.println(u.getId());
            System.out.println(u.getName());
        }

        System.out.println("读取用户列表成功");

        System.out.println("------------ 读取用户详情 -----------");
        User user1 = (User) session.selectOne("User.getById", user.getId());

        System.out.println(user1.getId());
        System.out.println(user1.getName());

        System.out.println("读取用户详情成功");

        System.out.println("------------ 修改用户 -----------");
        user1.setName("userNameUpdated");
        session.update("User.update", user1);
        session.commit();

        // 查询修改后的用户详情
        User user2 = (User) session.selectOne("User.getById", user.getId());
        System.out.println(user2.getId());
        System.out.println(user2.getName());
        System.out.println("修改用户成功");

        System.out.println("------------ 删除用户 -----------");
        session.delete("User.deleteById", user.getId());
        System.out.println("删除用户成功");

        session.commit();
        session.close();
    }

}
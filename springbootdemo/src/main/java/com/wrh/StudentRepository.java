package com.wrh;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wuranghao on 2017/4/12.
 */
public interface StudentRepository extends JpaRepository<Student,Integer> {

    public List<Student> findByName(String name);


}

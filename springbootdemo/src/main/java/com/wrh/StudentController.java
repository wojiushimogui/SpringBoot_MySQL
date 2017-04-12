package com.wrh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wuranghao on 2017/4/7.
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    /**
    * 获取所有学生列表
    * */
    @GetMapping(value = "/allstudent")
    public List<Student> getAllStudentInfo(){

//        Iterable iterable = studentRepository.findAll();
//        Iterator iterator = iterable.iterator();
//        List<Student> students = new ArrayList<Student>();
//        while(iterator.hasNext()){
//            students.add((Student) iterator.next());
//        }
//
//        return students;
        return studentRepository.findAll();

    }
    /**
     * 存储一个学生的信息到数据库
     *
     * */
    @PostMapping(value="/save")
    public Student saveOne(@RequestParam("id") Integer age,
                           @RequestParam("name") String name){
        Student student = new Student();
        student.setAge(age);
        student.setName(name);

        return studentRepository.save(student);
    }
    /**
     * 通过Id来获取一个学生的信息
     * */
    @GetMapping(value="/findById/{id}")
    public Student findById(@PathVariable(value = "id") Integer id){
        return studentRepository.findOne(id);
    }
    /**
     * 通过Name来获取学生的信息
     * */
    @GetMapping(value="/findByName/{name}")
    public List<Student> findByName(@PathVariable("name") String name){
        return studentRepository.findByName(name);
    }
    /**
     * 更新一个学生的信息
     * */
    @PutMapping(value="/update")
    public Student update(@RequestParam("id") Integer id,
                       @RequestParam("age") Integer age,
                       @RequestParam("name") String name){
        Student s = new Student();
        s.setId(id);
        s.setAge(age);
        s.setName(name);

        return studentRepository.save(s);
    }
    /**
     * 通过Id来删除一个学生的信息
     * */
    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        studentRepository.delete(id);
    }

}







package com.springORMpractice;

import com.springORMpractice.dao.PersonDao;
import com.springORMpractice.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springORMConfig.xml");
        PersonDao personDao = context.getBean("personDao", PersonDao.class);

        Person person = new Person(01,"Gotham City","Bruce Wayne");
        int result = personDao.insert(person);

        System.out.println("Inserted :-- "+result);
    }
}

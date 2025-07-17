package com.springORMpractice.dao;

import com.springORMpractice.entity.Person;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class PersonDao {

    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int insert(Person person){
        Integer res = (Integer) this.hibernateTemplate.save(person);
        return res;
    }

    public Person getPerson(int id){
        return this.hibernateTemplate.get(Person.class, id);
    }

    public List<Person> getAllPerson(){
       return this.hibernateTemplate.loadAll(Person.class);
    }

    @Transactional
    public void deletePerson(int id){
        Person person = this.hibernateTemplate.get(Person.class,id);
        this.hibernateTemplate.delete(person);
    }

    @Transactional
    public void updatePerson(Person person){
        this.hibernateTemplate.update(person);
    }

    public PersonDao() {
    }

    public PersonDao(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}

package com.springORMpractice;

import com.springORMpractice.dao.PersonDao;
import com.springORMpractice.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springORMConfig.xml");
        PersonDao personDao = context.getBean("personDao", PersonDao.class);

//        personDao.deletePerson(02);
////        Person person = new Person(01,"Gotham City","Bruce Wayne");
//        Person person = new Person(02,"New York City","Peter Parker");
//        int result = personDao.insert(person);
//
//        System.out.println("Inserted :-- "+result);
//
//
//        Person p1 = personDao.getPerson(02);
//        System.out.println(p1.getCity());
//        System.out.println(p1.getId());
//        System.out.println(p1.getName());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean continueGame = true;
        while(continueGame){

            System.out.println("PRESS 1 to add new person");
            System.out.println("PRESS 2 to display all persons");
            System.out.println("PRESS 3 to get data of a person");
            System.out.println("PRESS 4 to delete a person");
            System.out.println("PRESS 5 to update a person");
            System.out.println("PRESS 6 to exit");


            try{
                int input = Integer.parseInt(br.readLine());

                switch (input){
                    case 1:
                        //add a new person
                        System.out.println("Enter the person details-- ");
                        System.out.println("Enter the person id:-- ");
                        int uId = Integer.parseInt(br.readLine());
                        System.out.println("Enter the person name:-- ");
                        String personName = br.readLine();
                        System.out.println("Enter the person city:-- ");
                        String personCity = br.readLine();

                        Person pers1 = new Person();
                        pers1.setCity(personCity);
                        pers1.setName(personName);
                        pers1.setId(uId);

                        int res = personDao.insert(pers1);

                        System.out.println(res+ " person added");
                        System.out.println("***********************************************");
                        System.out.println();
                        break;
                    case 2:
                        //Display all person
                        List<Person> allPersons = personDao.getAllPerson();
                        System.out.println("***********************************************");
                        for(Person person1: allPersons){
                            System.out.println("Id: "+person1.getId());
                            System.out.println("Name: "+person1.getName());
                            System.out.println("City: "+person1.getCity());
                            System.out.println("_______________________________________________");

                        }
                        System.out.println("***********************************************");

                        break;
                    case 3:
                        //Display one person
                        System.out.println("***********************************************");
                        System.out.println("Enter the Id for person that you want the details for:-- ");
                        int uId1 = Integer.parseInt(br.readLine());
                        Person person2 = personDao.getPerson(uId1);
                        if(person2==null){
                            System.out.println("Person not found!!");
                        }
                        else {
                            System.out.println("Id: "+person2.getId());
                            System.out.println("Name: "+person2.getName());
                            System.out.println("City: "+person2.getCity());
                            System.out.println("_______________________________________________");
                        }
                        break;
                    case 4:
                        //delete a person

                        System.out.println("***********************************************");
                        System.out.println("Enter the Id for person that you want to delete :-- ");
                        int uId3 = Integer.parseInt(br.readLine());
                        personDao.deletePerson(uId3);
                        System.out.println("Deleted successfully!!!- ");
                        break;
                    case 5:
                        //update a person

                        System.out.println("Enter the person details that you want to update-- ");
                        System.out.println("Enter the person id:-- ");
                        int uId4 = Integer.parseInt(br.readLine());
                        System.out.println("Enter the person name:-- ");
                        String personName1 = br.readLine();
                        System.out.println("Enter the person city:-- ");
                        String personCit1 = br.readLine();

                        Person pers4 = new Person();
                        pers4.setCity(personCit1);
                        pers4.setName(personName1);
                        pers4.setId(uId4);
                        personDao.updatePerson(pers4);

                        System.out.println("Person updated successfully!!!");
                        System.out.println("***********************************************");
                        System.out.println();
                        break;
                    case 6:
                        //exit
                        continueGame = false;
                        break;
                    default:
                        System.out.println("Invalid input,enter correct one!!!");

                }
            }catch (Exception e){
                System.out.println("Invalid input, try another one!!!");
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Thanks for playing the game!!!");
        System.out.println("Hope to see you soon!!!");

    }
}

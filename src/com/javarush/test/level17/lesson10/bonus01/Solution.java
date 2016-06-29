package com.javarush.test.level17.lesson10.bonus01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]){
            //-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
            case "-i" : {
                Person person = allPeople.get(Integer.parseInt(args[1]));
                String sex;
                if (person.getSex().equals(Sex.MALE)) sex = "м";
                else sex = "ж";
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                String date = dateFormat.format(person.getBirthDay());
                System.out.println(person.getName() + " " + sex + " " + date);
                break;
            }
            //-d  - производит логическое удаление человека с id
            case "-d" : {
                allPeople.set(Integer.parseInt(args[1]), null);
                break;
            }
            //-u  - обновляет данные человека с данным id
            case "-u" : {
                Person newPerson;
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date birthday = new Date(args[4]);
                birthday = new Date(Date.parse(dateFormat.format(birthday)));
                if (args[3].equals("м")) newPerson = Person.createMale(args[2], birthday );
                else newPerson = Person.createFemale(args[2], birthday);
                allPeople.set(Integer.parseInt(args[1]), newPerson);
                break;
            }
            //-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
            case "-c" : {
                Person newPerson;
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                String tmpDate = dateFormat.format(Date.parse(args[3]));
                Date birthday = new Date(tmpDate);
//                birthday = new Date(Date.parse(dateFormat.format(birthday)));
                if (args[2].equals("м")) newPerson = Person.createMale(args[1], birthday );
                else newPerson = Person.createFemale(args[1], birthday);
                allPeople.add(newPerson);
                System.out.println(tmpDate);
                System.out.println(allPeople.indexOf(newPerson));
                break;
            }
        }
    }
}

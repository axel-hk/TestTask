package com.company;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        DataBaseHandler db = new DataBaseHandler();
        System.out.println("Введите 1 для добавления студента в таблицу");
        System.out.println("Введите 2 для добавления удаления студента из таблицы");
        System.out.println("Введите 3 для добавления студента вывода списка студентов");
        System.out.println("Введите 0 для завершения программы: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while (num!=0) {
            switch (num) {
                case (1):
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Введите Имя студента: ");
                    String name = sc.nextLine();
                    System.out.println("Введите Фамилию студента: ");
                    String sername = sc.nextLine();
                    System.out.println("Введите Отчество студента: ");
                    String secondName = sc.nextLine();
                    System.out.println("Введите Дату рождения студента: ");
                    String birth = sc.nextLine();
                    System.out.println("Введите Группу студента: ");
                    String group = sc.nextLine();
                    System.out.println("Введите Номер студента: ");
                    String unique = sc.nextLine();
                    Students student = new Students(name,sername, secondName, birth, group, unique);
                    db.insertInfo(student);

                    break;
                case (2):
                    System.out.println("Введите Номер студента: ");
                    String uniqueNum = scanner.nextLine();
                    db.delStudent(uniqueNum);
                    break;
                case (3):
                    try{
                        StringBuffer str = db.getStudentsList();
                        System.out.println("Список студентов: ");
                        System.out.println(str.toString());

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;

            }
            num = scanner.nextInt();
        }

    }
}

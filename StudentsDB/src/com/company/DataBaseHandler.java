package com.company;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Collection;

public class DataBaseHandler extends Configs{
    Connection dbConnection ;
    //Соединение с базой данных
    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        }catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        dbConnection =  DriverManager.getConnection(connectionString, dbUser, dbPass);
        return  dbConnection;
    }
    //Помещение информации в базу данных
    public void insertInfo(Students student)
    {

        String insert = "INSERT INTO "+Constants.STUDENT_TABLE+"("+Constants.STUDENT_NAME+","+Constants.STUDENT_SER+","
                +Constants.STUDENT_SEC+"," + Constants.STUDENT_DATE+","+Constants.STUDENT_GROUP+","+Constants.STUDENT_UNIQUE+")"+"VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,student.getFirstName());
            prSt.setString(2,student.getSerName());
            prSt.setString(3,student.getSecondName());
            prSt.setString(4,student.getBirth());
            prSt.setString(5,student.getGroup());
            prSt.setString(6,student.getUnique());
            prSt.executeUpdate();
            System.out.println(prSt);
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    //Получение спсика студентов
    public StringBuffer getStudentsList() throws SQLException {
        ResultSet resultSet = null;
        StringBuffer data = new StringBuffer();
        int i = 1;
        String select = "SELECT * FROM "+Constants.STUDENT_TABLE;
        try {

            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resultSet = prSt.executeQuery();
            while (resultSet.next()) {
                data.append("Имя: " + resultSet.getString("name")+"\n");
                data.append("Фамилия: " + resultSet.getString("sername")+"\n");
                data.append("Отчество: " + resultSet.getString("second_name")+"\n");
                data.append("Дата рождения: " + resultSet.getString("date_of_birth")+"\n");
                data.append("Группа: " + resultSet.getString("group_id")+"\n");
                data.append("Номер студента: " + resultSet.getString("unique_id")+"\n");

                // or p.name=rs.getString("firstname"); by name of column
            }
            return data;
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;

    }
    //удаление студентов
    public void delStudent(String unique) {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
        dbConnection =  DriverManager.getConnection(connectionString, dbUser, dbPass);
        String delete = "DELETE FROM "+dbName+"."+Constants.STUDENT_TABLE+" WHERE unique_id = "+'"'+unique+'"';

        System.out.println(delete);


            Statement statement =dbConnection.createStatement();
            statement.executeUpdate(delete);


        } catch (SQLException e){
            e.printStackTrace();

        }
    }
}

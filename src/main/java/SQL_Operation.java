import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

public class SQL_Operation {
    private static String url = "jdbc:mysql://localhost/new_student_info_8?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private  static String password = "qwerty123";

    public static ArrayList<Student> select(){
        ArrayList<Student> studentList = new ArrayList<Student>();
        try{
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            try{
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM db_objects");

                while(result.next()){
                    int obj_id = Integer.parseInt(result.getString(1));
                    String obj_name = result.getString(2);
                    int obj_group_number = Integer.parseInt(result.getString(3));
                    Student student = new Student(obj_id, obj_name, obj_group_number);
                    studentList.add(student);
                }

            }catch (Exception e){
                //Как правильно вывести логи на серверную консоль(помимо .printStackTrace()) ?
            }
        }catch (Exception e){

        }
        return studentList;
    }

    public static Student selectOne(int id){
        Student student = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            try{
                Connection connection = DriverManager.getConnection(url, username, password);

                try{
                    PreparedStatement ps = connection.prepareStatement("SELECT * FROM db_objects WHERE obj_id = ?");
                    ps.setInt(1, id);
                    ResultSet result = ps.executeQuery();
                    if(result.next()){
                        int idt = Integer.parseInt(result.getString(1));
                        String name = result.getString(2);
                        int group_number = Integer.parseInt(result.getString(3));
                        student = new Student(idt, name, group_number);
                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return student;
    }

    public static int insert(Student student){
        try{
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                try{
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO db_objects VALUES (?, ?, ?)");
                    try{
                        ps.setInt(1, student.getId());
                        ps.setString(2, student.getName());
                        ps.setInt(3, student.getGroup_number());
                        return ps.executeUpdate();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }

    public static int update(Student student){
        try{
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            try{
                Connection connection = DriverManager.getConnection(url, username, password);
                try{
                    PreparedStatement ps = connection.prepareStatement("UPDATE db_objects SET obj_name = ?, obj_ref_group_id = ? WHERE obj_id = ?");
                    ps.setString(1, student.getName());
                    ps.setInt(2, student.getGroup_number());
                    ps.setInt(3, student.getId());
                    return ps.executeUpdate();

                }catch (Exception e){
                    System.out.println(e);
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }

    public static int delete(int id){
        try{
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            try{
                Connection connection = DriverManager.getConnection(url, username, password);
                try{
                    PreparedStatement ps = connection.prepareStatement("DELETE FROM db_objects WHERE obj_id = ?");
                    ps.setInt(1, id);

                    return ps.executeUpdate();
                }catch (Exception e){
                    System.out.println(e);
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }

}

package student.model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class Student {
    private String user;
    private String pass;
    private Connection connection;
    private Statement statement;
    private int checkTable = 0;

    public Student(String databasename) {

        Dotenv dotenv = Dotenv.configure()
                .directory("./src/.env")
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();
        String url = "jdbc:sqlserver://localhost:1433;databaseName=" + databasename
                + ";encrypt=true;trustServerCertificate=true;";

        user = dotenv.get("USER");
        pass = dotenv.get("PASSWORD");

        try {
            this.connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connect to database");
            statement = connection.createStatement();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet rs = databaseMetaData.getTables(null, null, "Student", new String[] { "TABLE" });
            while (rs.next()) {
                if (rs.getString(3).equals("Student")) {
                    checkTable = 1;
                }
            }

            if (checkTable == 0) {
                createTable(databasename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        try {
            statement = (Statement) connection.createStatement();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return statement;
    }

    public Connection getConnection() {
        return connection;
    }

    public void createTable(String database) {
        String table = "create table Student (" +
                "id nvarchar(50)," +
                "first_name nvarchar(50)," +
                "last_name nvarchar(50)," +
                "dateofbirth date," +
                "address nvarchar(50)," +
                "constraint PK_student primary key (id),)";
        try {
            statement.executeUpdate(table);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

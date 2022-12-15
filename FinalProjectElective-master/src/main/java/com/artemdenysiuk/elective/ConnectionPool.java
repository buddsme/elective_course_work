package com.artemdenysiuk.elective;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionPool {

    public static final Logger log = (Logger) LogManager.getLogger(ConnectionPool.class);

    private DataSource dataSource;
    private static ConnectionPool instance;

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    private ConnectionPool() {
        try{
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/elective_db");
        } catch (NamingException e) {
            log.error("Cannot obtain a data source", e);
            throw new IllegalStateException("Cannot obtain a data source", e);
        }
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            log.error("Cannot obtain a data source", e);
            throw new IllegalStateException("Cannot obtain a data source", e);
        }
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        final String user = "root";
        final String password = "Panda75096523";
        final String url = "jdbc:mysql://localhost:3306/elective_db";

        String REGISTER_USER_SQL = "INSERT INTO profile(login, password, email, telephone, name, surname, role, block_status) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        //Connection connect = new PoolConnectionBuilder().getConnection();
        final Connection connect = DriverManager.getConnection(url, user, password);

        try (connect;
             PreparedStatement st = connect.prepareStatement(REGISTER_USER_SQL)){
            st.setString(1, "hello");
            st.setString(2, "1234");
            st.setString(3, "art55em@gmail.com");
            st.setString(4, "380680354399");
            st.setString(5, "Artem");
            st.setString(6, "Denysiuk");
            st.setString(7, "STUDENT");
            st.setInt(8, 0);
            st.executeUpdate();
//            statement.setInt(1, 1);
//            final ResultSet resultSet = statement.executeQuery();
//
//            if(resultSet.next()){
//                String byName = "username is : "  + resultSet.getString("username");
//                System.out.println(byName);
//            }
        } finally {
            connect.close();
        }
    }
}

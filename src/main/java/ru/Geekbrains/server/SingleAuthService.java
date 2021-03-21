package ru.Geekbrains.server;

import java.sql.*;

public final class SingleAuthService implements AuthService {

    private static Connection connection;
    private static PreparedStatement psGetNick;
    private static final String urlConnectionDatabase = "jdbc:sqlite:auth_users.db";

    //Блок паттерна Singleton-Sync
    private static volatile SingleAuthService instance;

    public static SingleAuthService getInstance() {
        SingleAuthService result = instance;
        if (result != null) {
            return result;
        }
        synchronized (SingleAuthService.class) {
            if (instance == null) {
                instance = new SingleAuthService();
            }
            return instance;
        }
    }

    public static boolean connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(urlConnectionDatabase);
            psGetNick = connection.prepareStatement("SELECT nick FROM users WHERE login = ? AND password = ?");
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

        @Override
        public String getNicknameByLoginAndPassword (String login, String password){
            String nick = null;
            try {

                psGetNick.setString(1, login);
                psGetNick.setString(2, password);
                ResultSet rs = psGetNick.executeQuery();
                if (rs.next()) {
                    nick = rs.getString("nick");
                }
                rs.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
            return nick;
        }

    public static void disconnect() {
        try {
            psGetNick.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


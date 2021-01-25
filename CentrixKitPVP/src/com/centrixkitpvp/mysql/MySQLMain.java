package com.centrixkitpvp.mysql;

import com.centrixkitpvp.config.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLMain {

    private static MySQLMain instance = new MySQLMain();
    private Connection connection;
    private String host, database, username, password;
    private int port;

    public static MySQLMain getInstance() {
        return instance;
    }

    public void connect() {
        host = ConfigManager.getConfigManager().getPath("host");

        port = ConfigManager.getConfigManager().getInt("port");

        database = ConfigManager.getConfigManager().getPath("database");

        username = ConfigManager.getConfigManager().getPath("username");

        password = ConfigManager.getConfigManager().getPath("password");
        try {
            synchronized (this) {

                if (getConnection() != null && !getConnection().isClosed()) {

                    return;

                }
                Class.forName("com.mysql.jdbc.Driver");

                setConnection(DriverManager.getConnection("jdbc:mysql://" + this.host + ":"

                        + this.port + "/" + this.database + "?autoReconnect=true", this.username, this.password));


                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "MYSQL CONNECTED");
                createPlayerDataTable();
                createKeyTable();
            }

        } catch (SQLException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }
    }

    public Connection getConnection() {

        return connection;
    }

    public void setConnection(Connection connection) {

        this.connection = connection;

    }

    private void createPlayerDataTable() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + "PLAYERDATA"
                    + "(UUID VARCHAR(255) NOT NULL, NAME VARCHAR(255) NOT NULL, KILLS INT(16), DEATHS INT(16), LEVELS INT(16), PRIMARY KEY (UUID))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createKeyTable() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + "KEYDATA" +
                    "(UUID VARCHAR(255) NOT NULL, LEVELKEY INT(16), KILLKEY INT(16), PRIMARY KEY (UUID))");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

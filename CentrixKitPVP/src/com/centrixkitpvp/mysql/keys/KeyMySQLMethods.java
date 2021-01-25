package com.centrixkitpvp.mysql.keys;

import com.centrixkitpvp.mysql.MySQLMain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class KeyMySQLMethods {


    private static KeyMySQLMethods instance = new KeyMySQLMethods();

    public static KeyMySQLMethods getInstance() {
        return instance;
    }

    //Level Key

    public int getLevelKey(String uuid) {
        try {
            PreparedStatement ps = MySQLMain.getInstance().getConnection().prepareStatement(
                    "SELECT * FROM KEYDATA WHERE UUID = ?");
            ps.setString(1, uuid);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getInt("LEVELKEY");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public void setLevelKey(UUID uuid, int amount) {
        if (getLevelKey(uuid.toString()) == -1) {
            try {
                PreparedStatement ps = MySQLMain.getInstance().getConnection().prepareStatement(
                        "INSERT INTO KEYDATA (UUID, LEVELKEY) VALUES (?,?)");
                ps.setString(1, uuid.toString());
                ps.setInt(2, amount);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            try {
                PreparedStatement statement = MySQLMain.getInstance().getConnection().prepareStatement(
                        "UPDATE KEYDATA SET LEVELKEY=? WHERE UUID=?");
                statement.setInt(1, amount);
                statement.setString(2, uuid.toString());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void giveLevelKey(UUID uuid, int amount){
        int current = getLevelKey(uuid.toString());
        setLevelKey(uuid, current + amount);
    }

    public void takeLevelKey(UUID uuid, int amount){
        int current = getLevelKey(uuid.toString());
        setLevelKey(uuid, current - amount);
    }

    //Kill Key
    public int getKillKey(String uuid) {
        try {
            PreparedStatement ps = MySQLMain.getInstance().getConnection().prepareStatement(
                    "SELECT * FROM KEYDATA WHERE UUID = ?");
            ps.setString(1, uuid);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getInt("KILLKEY");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public void setKillKey(UUID uuid, int amount) {
        if (getLevelKey(uuid.toString()) == -1) {
            try {
                PreparedStatement ps = MySQLMain.getInstance().getConnection().prepareStatement(
                        "INSERT INTO KEYDATA (UUID, KILLKEY) VALUES (?,?)");
                ps.setString(1, uuid.toString());
                ps.setInt(2, amount);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            try {
                PreparedStatement statement = MySQLMain.getInstance().getConnection().prepareStatement(
                        "UPDATE KEYDATA SET KILLKEY=? WHERE UUID=?");
                statement.setInt(1, amount);
                statement.setString(2, uuid.toString());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void giveKillKey(UUID uuid, int amount){
        int current = getKillKey(uuid.toString());
        setKillKey(uuid, current + amount);
    }

    public void takeKillKey(UUID uuid, int amount){
        int current = getKillKey(uuid.toString());
        setKillKey(uuid, current - amount);
    }
}
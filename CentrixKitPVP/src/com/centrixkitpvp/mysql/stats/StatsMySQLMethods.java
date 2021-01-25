package com.centrixkitpvp.mysql.stats;

import com.centrixkitpvp.mysql.MySQLMain;

import com.centrixkitpvp.string.MessageUtils;
import com.centrixkitpvp.string.StringUtils;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StatsMySQLMethods {

    private static StatsMySQLMethods instance = new StatsMySQLMethods();

    public static StatsMySQLMethods getInstance() {
        return instance;
    }

    //Kills

    public int getKills(String name) {
        try {
            PreparedStatement ps = MySQLMain.getInstance().getConnection().prepareStatement(
                    "SELECT * FROM PLAYERDATA WHERE NAME = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("KILLS");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public void setKills(String name, int amount) {
        if (getKills(name) == -1) {
            try {
                PreparedStatement ps = MySQLMain.getInstance().getConnection().prepareStatement(
                        "INSERT INTO PLAYERDATA (NAME, KILLS) VALUES (?,?)");
                ps.setString(1, name);
                ps.setInt(2, amount);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PreparedStatement statement = MySQLMain.getInstance().getConnection().prepareStatement(
                        "UPDATE PLAYERDATA SET KILLS=? WHERE NAME=?");
                statement.setInt(1, amount);
                statement.setString(2, name);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void addKills(String name) {
        int current = getKills(name);
        setKills(name, current + 1);
    }

    public List<String> getTopKills() {
        List<String> result = new ArrayList<>();
        try {
            Statement s = MySQLMain.getInstance().getConnection().createStatement();
            if (s != null) {
                ResultSet rs = s.executeQuery("SELECT NAME FROM PLAYERDATA ORDER BY KILLS");
                rs.findColumn("NAME");
                if (rs.last()) {
                    result.add(rs.getString("NAME"));
                }

                if (rs.previous()) {
                    result.add(rs.getString("NAME"));
                }

                if (rs.previous()) {
                    result.add(rs.getString("NAME"));
                }

                if(rs.previous()){
                    result.add(rs.getString("NAME"));
                }

                if(rs.previous()){
                    result.add(rs.getString("NAME"));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

    //Deaths
    public int getDeaths(String uuid) {
        try {
            PreparedStatement ps = MySQLMain.getInstance().getConnection().prepareStatement(
                    "SELECT * FROM PLAYERDATA WHERE UUID = ?");
            ps.setString(1, uuid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("DEATHS");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public void setDeaths(UUID uuid, int amount) {
        if (getDeaths(uuid.toString()) == -1) {
            try {
                PreparedStatement ps = MySQLMain.getInstance().getConnection().prepareStatement(
                        "INSERT INTO PLAYERDATA (UUID, DEATHS) VALUES (?,?)");
                ps.setString(1, uuid.toString());
                ps.setInt(2, amount);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PreparedStatement statement = MySQLMain.getInstance().getConnection().prepareStatement(
                        "UPDATE PLAYERDATA SET DEATHS=? WHERE UUID=?");
                statement.setInt(1, amount);
                statement.setString(2, uuid.toString());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void addDeaths(UUID uuid) {
        int current = getDeaths(uuid.toString());
        setDeaths(uuid, current + 1);
    }

    //Levels
    public int getLevels(String uuid) {
        try {
            PreparedStatement ps = MySQLMain.getInstance().getConnection().prepareStatement(
                    "SELECT * FROM PLAYERDATA WHERE UUID = ?");
            ps.setString(1, uuid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("LEVELS");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public void setLevels(UUID uuid, int amount) {
        if (getLevels(uuid.toString()) == -1) {
            try {
                PreparedStatement ps = MySQLMain.getInstance().getConnection().prepareStatement(
                        "INSERT INTO PLAYERDATA (UUID, LEVELS) VALUES (?,?)");
                ps.setString(1, uuid.toString());
                ps.setInt(2, amount);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PreparedStatement statement = MySQLMain.getInstance().getConnection().prepareStatement(
                        "UPDATE PLAYERDATA SET LEVELS=? WHERE UUID=?");
                statement.setInt(1, amount);
                statement.setString(2, uuid.toString());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void addLevels(UUID uuid) {
        int current = getLevels(uuid.toString());
        setLevels(uuid, current + 1);
    }
}
package com.centrixkitpvp.mysql.player;

import com.centrixkitpvp.mysql.MySQLMain;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PlayerMySQLMethods {

    private static PlayerMySQLMethods instance = new PlayerMySQLMethods();

    public static PlayerMySQLMethods getInstance() {
        return instance;
    }

    public boolean playerExists(UUID uuid, String name) {
        try {
            PreparedStatement ps = MySQLMain.getInstance().getConnection().prepareStatement(
                    "SELECT * FROM " + name + " WHERE UUID=?");
            ps.setString(1, uuid.toString());

            ResultSet r = ps.executeQuery();
            if (r.next()) {
                System.out.print("Player Found!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void setPlayer(final UUID uuid, Player player) {
        try {
            PreparedStatement ps = MySQLMain.getInstance().getConnection().prepareStatement(
                    "SELECT * FROM PLAYERDATA WHERE UUID=?");
            ps.setString(1, uuid.toString());
            if (!playerExists(uuid, "PLAYERDATA")) {
                PreparedStatement insert = MySQLMain.getInstance().getConnection().prepareStatement(
                        "INSERT INTO PLAYERDATA (UUID, NAME, KILLS, DEATHS, LEVELS) VALUES (?,?,?,?,?)");
                insert.setString(1, uuid.toString());
                insert.setString(2, player.getName());
                insert.setInt(3, 0);
                insert.setInt(4, 0);
                insert.setInt(5, 1);
                insert.executeUpdate();
                System.out.print("Player InfoMenu Has Been Inserted!");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

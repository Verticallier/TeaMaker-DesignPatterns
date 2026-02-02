/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TeaLogRepository {

    public void insert(int cups, LocalDateTime time) {
        String sql = "INSERT INTO tea (cups, made_at) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cups);
            ps.setTimestamp(2, Timestamp.valueOf(time));
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getDailyTotal(LocalDate date) {
        String sql = "SELECT COALESCE(SUM(cups), 0) FROM tea WHERE DATE(made_at) = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setDate(1, Date.valueOf(date));
        try (ResultSet rs = ps.executeQuery()) {
            rs.next();
            return rs.getInt(1);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return 0;
    }

    public int getMonthlyTotal(int year, int month) {
    String sql = "SELECT COALESCE(SUM(cups), 0) FROM tea WHERE YEAR(made_at)=? AND MONTH(made_at)=?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, year);
        ps.setInt(2, month);
        try (ResultSet rs = ps.executeQuery()) {
            rs.next();
            return rs.getInt(1);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return 0;
}

}

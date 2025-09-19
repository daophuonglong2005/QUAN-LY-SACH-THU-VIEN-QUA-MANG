package server.dao;

import server.config.DBConnection;
import server.model.BorrowRecord;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowRecordDAO {
    public boolean add(BorrowRecord br) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO borrow_records(user_id,book_id,borrow_date,due_date,status) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, br.getUserId());
            ps.setInt(2, br.getBookId());
            ps.setTimestamp(3, new Timestamp(br.getBorrowDate().getTime()));
            ps.setDate(4, new java.sql.Date(br.getDueDate().getTime()));
            ps.setString(5, br.getStatus());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<BorrowRecord> getAll() {
        List<BorrowRecord> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM borrow_records";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                BorrowRecord br = new BorrowRecord();
                br.setId(rs.getInt("id"));
                br.setUserId(rs.getInt("user_id"));
                br.setBookId(rs.getInt("book_id"));
                br.setBorrowDate(rs.getTimestamp("borrow_date"));
                br.setDueDate(rs.getDate("due_date"));
                br.setReturnDate(rs.getDate("return_date"));
                br.setStatus(rs.getString("status"));
                list.add(br);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean updateReturn(int recordId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE borrow_records SET return_date=NOW(), status='RETURNED' WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, recordId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}

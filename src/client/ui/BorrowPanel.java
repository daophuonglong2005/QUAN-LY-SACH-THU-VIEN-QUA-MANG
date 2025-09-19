package client.ui;

import client.network.ClientConnector;
import common.dto.BorrowRecordDTO;
import common.protocol.Request;
import common.protocol.Response;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BorrowPanel extends JPanel {
    private JTable table;
    private JTextField tfUserId, tfBookId, tfDueDate, tfRecordId;

    public BorrowPanel() {
        setLayout(new BorderLayout());

        // --- Form nhập ---
        JPanel form = new JPanel(new GridLayout(2, 4, 10, 10));
        form.setBorder(BorderFactory.createTitledBorder("Thông tin mượn/trả"));

        tfUserId = new JTextField();
        tfBookId = new JTextField();
        tfDueDate = new JTextField("2025-09-30"); // gợi ý định dạng
        tfRecordId = new JTextField(); // dùng khi trả sách

        form.add(new JLabel("User ID:"));
        form.add(tfUserId);
        form.add(new JLabel("Book ID:"));
        form.add(tfBookId);

        form.add(new JLabel("Ngày hẹn trả (yyyy-MM-dd):"));
        form.add(tfDueDate);
        form.add(new JLabel("Record ID (trả):"));
        form.add(tfRecordId);

        add(form, BorderLayout.NORTH);

        // --- Buttons ---
        JPanel buttons = new JPanel();

        JButton btnBorrow = new JButton("📖 Mượn sách");
        btnBorrow.setBackground(new Color(33, 150, 243));
        btnBorrow.setForeground(Color.WHITE);

        JButton btnReturn = new JButton("✅ Trả sách");
        btnReturn.setBackground(new Color(76, 175, 80));
        btnReturn.setForeground(Color.WHITE);

        JButton btnLoad = new JButton("🔄 Tải danh sách");
        btnLoad.setBackground(new Color(255, 152, 0));
        btnLoad.setForeground(Color.WHITE);

        buttons.add(btnBorrow);
        buttons.add(btnReturn);
        buttons.add(btnLoad);
        add(buttons, BorderLayout.SOUTH);

        // --- Table ---
        table = new JTable();
        add(new JScrollPane(table), BorderLayout.CENTER);

        // --- Sự kiện ---
        btnBorrow.addActionListener(e -> doBorrow());
        btnReturn.addActionListener(e -> doReturn());
        btnLoad.addActionListener(e -> loadRecords());
    }

    private void doBorrow() {
        try {
            int userId = Integer.parseInt(tfUserId.getText());
            int bookId = Integer.parseInt(tfBookId.getText());
            Date dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(tfDueDate.getText());

            BorrowRecordDTO dto = new BorrowRecordDTO(0, userId, bookId,
                    new Date(), dueDate, null, "BORROWED");

            Request req = new Request("BORROW_BOOK", dto);
            Response res = ClientConnector.sendRequest(req);

            JOptionPane.showMessageDialog(this, res.getMessage());
            loadRecords();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi nhập dữ liệu: " + ex.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void doReturn() {
        try {
            int recordId = Integer.parseInt(tfRecordId.getText());

            Request req = new Request("RETURN_BOOK", recordId);
            Response res = ClientConnector.sendRequest(req);

            JOptionPane.showMessageDialog(this, res.getMessage());
            loadRecords();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi nhập dữ liệu: " + ex.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadRecords() {
        Request req = new Request("GET_BORROW_RECORDS", null);
        Response res = ClientConnector.sendRequest(req);

        if (res.isSuccess()) {
            List<BorrowRecordDTO> list = (List<BorrowRecordDTO>) res.getData();
            DefaultTableModel model = new DefaultTableModel(
                    new Object[]{"ID", "User ID", "Book ID", "Ngày mượn", "Hẹn trả", "Ngày trả", "Trạng thái"}, 0
            );
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (BorrowRecordDTO br : list) {
                model.addRow(new Object[]{
                        br.getId(), br.getUserId(), br.getBookId(),
                        sdf.format(br.getBorrowDate()),
                        br.getDueDate() != null ? sdf.format(br.getDueDate()) : "",
                        br.getReturnDate() != null ? sdf.format(br.getReturnDate()) : "",
                        br.getStatus()
                });
            }
            table.setModel(model);
        } else {
            JOptionPane.showMessageDialog(this, res.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}

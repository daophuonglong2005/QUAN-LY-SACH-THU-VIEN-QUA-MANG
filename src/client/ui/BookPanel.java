package client.ui;

import client.network.ClientConnector;
import common.dto.BookDTO;
import common.protocol.Request;
import common.protocol.Response;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class BookPanel extends JPanel {
    private JTable table;

    public BookPanel() {
        setLayout(new BorderLayout());

        JButton btnLoad = new JButton("Tải danh sách sách");
        btnLoad.setBackground(new Color(33, 150, 243));
        btnLoad.setForeground(Color.WHITE);

        add(btnLoad, BorderLayout.NORTH);

        table = new JTable();
        add(new JScrollPane(table), BorderLayout.CENTER);

        btnLoad.addActionListener(e -> loadBooks());
    }

    private void loadBooks() {
        Request req = new Request("GET_BOOKS", null);
        Response res = ClientConnector.sendRequest(req);

        if (res.isSuccess()) {
            List<BookDTO> list = (List<BookDTO>) res.getData();
            DefaultTableModel model = new DefaultTableModel(
                    new Object[]{"ID", "Tên sách", "Tác giả", "Thể loại", "NXB", "Năm", "Số lượng"}, 0
            );
            for (BookDTO b : list) {
                model.addRow(new Object[]{
                        b.getId(), b.getTitle(), b.getAuthor(),
                        b.getCategory(), b.getPublisher(),
                        b.getYear(), b.getQuantity()
                });
            }
            table.setModel(model);
        } else {
            JOptionPane.showMessageDialog(this, res.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}

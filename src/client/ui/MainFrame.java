package client.ui;

import common.dto.UserDTO;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private UserDTO currentUser;

    public MainFrame(UserDTO user) {
        this.currentUser = user;

        setTitle("Hệ thống thư viện - Xin chào " + user.getName());
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("📚 Sách", new BookPanel());
        tabs.addTab("📖 Mượn sách", new BorrowPanel());

        add(tabs, BorderLayout.CENTER);

        JButton btnLogout = new JButton("Đăng xuất");
        btnLogout.setBackground(new Color(244, 67, 54));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.addActionListener(e -> {
            new LoginFrame().setVisible(true);
            dispose();
        });

        add(btnLogout, BorderLayout.SOUTH);
    }
}

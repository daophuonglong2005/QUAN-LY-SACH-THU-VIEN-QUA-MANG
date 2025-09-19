package client.ui;

import client.network.ClientConnector;
import common.dto.UserDTO;
import common.protocol.Request;
import common.protocol.Response;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {
    private JTextField tfUsername, tfName, tfEmail, tfPhone;
    private JPasswordField tfPassword;
    private JButton btnRegister, btnBack;

    public RegisterFrame() {
        setTitle("Đăng ký tài khoản");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("📝 Đăng ký tài khoản mới", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setForeground(new Color(76, 175, 80));
        add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(5, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        form.add(new JLabel("Tên đăng nhập:"));
        tfUsername = new JTextField();
        form.add(tfUsername);

        form.add(new JLabel("Mật khẩu:"));
        tfPassword = new JPasswordField();
        form.add(tfPassword);

        form.add(new JLabel("Họ tên:"));
        tfName = new JTextField();
        form.add(tfName);

        form.add(new JLabel("Email:"));
        tfEmail = new JTextField();
        form.add(tfEmail);

        form.add(new JLabel("Số điện thoại:"));
        tfPhone = new JTextField();
        form.add(tfPhone);

        add(form, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        btnRegister = new JButton("Đăng ký");
        btnRegister.setBackground(new Color(76, 175, 80));
        btnRegister.setForeground(Color.WHITE);

        btnBack = new JButton("Quay lại");
        btnBack.setBackground(new Color(158, 158, 158));
        btnBack.setForeground(Color.WHITE);

        buttons.add(btnRegister);
        buttons.add(btnBack);
        add(buttons, BorderLayout.SOUTH);

        // Sự kiện
        btnRegister.addActionListener(e -> doRegister());
        btnBack.addActionListener(e -> {
            new LoginFrame().setVisible(true);
            dispose();
        });
    }

    private void doRegister() {
        UserDTO dto = new UserDTO(0,
                tfUsername.getText(),
                new String(tfPassword.getPassword()),
                tfName.getText(),
                tfEmail.getText(),
                tfPhone.getText(),
                "USER"
        );

        Request req = new Request("REGISTER", dto);
        Response res = ClientConnector.sendRequest(req);

        JOptionPane.showMessageDialog(this, res.getMessage());
        if (res.isSuccess()) {
            new LoginFrame().setVisible(true);
            dispose();
        }
    }
}

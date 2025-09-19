package client.ui;

import client.network.ClientConnector;
import common.dto.UserDTO;
import common.protocol.Request;
import common.protocol.Response;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private JTextField tfUsername;
    private JPasswordField tfPassword;
    private JButton btnLogin, btnRegister;

    public LoginFrame() {
        setTitle("Đăng nhập hệ thống thư viện");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("📚 Đăng nhập thư viện", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(new Color(33, 150, 243));
        add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(2, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        form.add(new JLabel("Tên đăng nhập:"));
        tfUsername = new JTextField();
        form.add(tfUsername);

        form.add(new JLabel("Mật khẩu:"));
        tfPassword = new JPasswordField();
        form.add(tfPassword);

        add(form, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        btnLogin = new JButton("Đăng nhập");
        btnLogin.setBackground(new Color(33, 150, 243));
        btnLogin.setForeground(Color.WHITE);

        btnRegister = new JButton("Đăng ký");
        btnRegister.setBackground(new Color(76, 175, 80));
        btnRegister.setForeground(Color.WHITE);

        buttons.add(btnLogin);
        buttons.add(btnRegister);
        add(buttons, BorderLayout.SOUTH);

        // Sự kiện
        btnLogin.addActionListener(e -> doLogin());
        btnRegister.addActionListener(e -> {
            new RegisterFrame().setVisible(true);
            dispose();
        });
    }

    private void doLogin() {
        String user = tfUsername.getText().trim();
        String pass = new String(tfPassword.getPassword());

        UserDTO dto = new UserDTO(0, user, pass, null, null, null, null);
        Request req = new Request("LOGIN", dto);
        Response res = ClientConnector.sendRequest(req);

        if (res.isSuccess()) {
            JOptionPane.showMessageDialog(this, res.getMessage());
            new MainFrame((UserDTO) res.getData()).setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, res.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}

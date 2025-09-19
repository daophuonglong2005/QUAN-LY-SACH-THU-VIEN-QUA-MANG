package server.service;

import server.dao.UserDAO;
import server.model.User;

import java.util.List;

public class UserService {
    private UserDAO dao = new UserDAO();

    public User login(String username, String password) {
        return dao.login(username, password);
    }

    public boolean register(User user) {
        return dao.register(user);
    }

    public List<User> getAll() {
        return dao.getAll();
    }
}

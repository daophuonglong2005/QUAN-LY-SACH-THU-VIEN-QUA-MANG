package common.protocol;

import java.io.Serializable;

public class Request implements Serializable {
    private String action;   // Ví dụ: "LOGIN", "REGISTER", "ADD_BOOK"
    private Object data;     // Chứa DTO

    public Request() {}

    public Request(String action, Object data) {
        this.action = action;
        this.data = data;
    }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public Object getData() { return data; }
    public void setData(Object data) { this.data = data; }
}

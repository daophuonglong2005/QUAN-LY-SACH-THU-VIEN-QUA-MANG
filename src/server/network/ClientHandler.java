package server.network;

import common.protocol.Request;
import common.protocol.Response;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

            while (true) {
                Object obj = in.readObject();
                if (obj instanceof Request) {
                    Request req = (Request) obj;
                    Response res = RequestProcessor.process(req);
                    out.writeObject(res);
                    out.flush();
                }
            }

        } catch (Exception e) {
            System.out.println("❌ Client ngắt kết nối: " + socket);
        }
    }
}

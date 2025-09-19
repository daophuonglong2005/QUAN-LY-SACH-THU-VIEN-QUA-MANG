package client.network;

import common.protocol.Request;
import common.protocol.Response;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientConnector {
    private static final String HOST = "localhost";
    private static final int PORT = 9999;

    public static Response sendRequest(Request req) {
        try (Socket socket = new Socket(HOST, PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            out.writeObject(req);
            out.flush();
            return (Response) in.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, "Không kết nối được server", null);
        }
    }
}

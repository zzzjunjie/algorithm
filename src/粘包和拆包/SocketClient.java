package 粘包和拆包;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketClient {
    public static void main(String[] args) throws Exception {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 55533;
        // 与服务端建立连接
        Socket socket = new Socket(host, port);
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        String message = "这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!这是一个整包!!!";
        byte[] contentBytes = message.getBytes(StandardCharsets.UTF_8);
        System.out.println("contentBytes.length = " + contentBytes.length);
        int length = contentBytes.length;
        byte[] lengthBytes = Utils.int2Bytes(length);
        byte[] resultBytes = new byte[4 + length];
        System.arraycopy(lengthBytes, 0, resultBytes, 0, lengthBytes.length);
        System.arraycopy(contentBytes, 0, resultBytes, 4, contentBytes.length);

        for (int i = 0; i < 10; i++) {
            outputStream.write(resultBytes);
        }
        Thread.sleep(20000);
        outputStream.close();
        socket.close();
    }
}


import java.io.*;
import java.net.*;

public class SocketClient {
    public static void main(String[] args) {
        String serverIP = "10.130.129.103";  // IP do servidor fornecido
        int serverPort = 12345;  // Porta do servidor fornecida
        String messageToSend = "Mensagem específica";  // Substitua pela mensagem fornecida pelo professor

        try (Socket socket = new Socket(serverIP, serverPort)) {
            // Enviar mensagem ao servidor como bytes
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(messageToSend.getBytes());
            outputStream.flush();

            // Receber resposta do servidor como bytes
            InputStream inputStream = socket.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
            String response = byteArrayOutputStream.toString("UTF-8");
            System.out.println("Resposta do servidor: " + response);

            // Salvar a resposta em um arquivo
            try (FileWriter fileWriter = new FileWriter("resposta_do_servidor.txt")) {
                fileWriter.write("Resposta do servidor: " + response);
            } catch (IOException e) {
                System.err.println("Erro ao salvar a resposta no arquivo: " + e.getMessage());
            }

        } catch (UnknownHostException e) {
            System.err.println("Host desconhecido: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro de I/O: " + e.getMessage());
        }
    }
}

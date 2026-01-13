/*

*/
public static class Server implements Runnable {
    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(8089)) {
            Socket clientSocket = serverSocket.accept(); // Wait client connection

            // Receive
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = bufferedReader.readLine(); // Wait message
            IO.println("Received message from client: " + message);

            // Send
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            PrintWriter printWriter = new PrintWriter(bufferedWriter, true);
            printWriter.println("Hello from Server!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

/*

*/
public static class Client implements Runnable {
    @Override
    public void run() {
        try (Socket clientSocket = new Socket("localhost", 8089)) {
            // Send
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            PrintWriter printWriter = new PrintWriter(bufferedWriter, true);
            printWriter.println("Hello from Client!");

            // Receive
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = bufferedReader.readLine(); // Wait message
            IO.println("Received message from server: " + message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

/*

*/
void main() throws Exception {
    new Thread(new Server()).start();
    new Thread(new Client()).start();
}
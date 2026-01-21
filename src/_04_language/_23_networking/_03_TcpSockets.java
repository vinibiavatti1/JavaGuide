/*
 * TCP/IP (Transmission Control Protocol/Internet Protocol) Sockets
 * - This file demonstrates the basic usage of TCP sockets in Java, providing a foundation for network communication
 *   between a server and one or more clients.
 *
 * Overview
 * - A socket represents an endpoint for communication between two machines or processes over a network.
 * - TCP Sockets are ideal for applications that require reliability, ordered delivery, and a persistent connection,
 *   such as web servers, email, file transfers, and databases.
 * - Java provides two primary classes for TCP communication:
 *   - ServerSocket: Listens for incoming client connections on a specific port.
 *   - Socket: Represents a client connection or a socket returned by ServerSocket.accept().
 * - Sockets provide InputStream and OutputStream for sending and receiving raw bytes.
 * - For text-based communication, InputStreamReader/BufferedReader and OutputStreamWriter/PrintWriter can be layered on
 *   top of the streams for convenient character I/O.
 *
 * Key Characteristics
 * - TCP sockets are connection-oriented and reliable: data is delivered in order without loss.
 * - Streams are the standard abstraction for reading and writing data; text or binary protocols can be implemented
 *   using these streams.
 * - Closing a socket automatically closes its associated streams.
 *
 * Usage
 * - ServerSocket is typically used in a dedicated server thread or process to accept connections.
 * - Socket is used by clients to initiate connections or by servers to communicate with accepted clients.
 * - Both server and client usually use buffering for efficiency and convenience (BufferedReader/Writer).
 *
 * Notes
 * - This example demonstrates the basic concept of socket communication in a single machine using localhost for
 *   simplicity.
 * - Real-world network programs require careful handling of concurrency, timeouts, and error conditions.
 */

/*
 * Server
 * - Demonstrates a minimal TCP server that listens on port 8089, accepts a client connection, and exchanges text
 *   messages using buffered I/O streams.
 */
public static class Server implements Runnable {
    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(8089)) {
            Socket clientSocket = serverSocket.accept(); // Block and wait client connection

            // Receive
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = bufferedReader.readLine(); // Block and wait message
            IO.println("Received message from client: " + message);

            // Send
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            PrintWriter printWriter = new PrintWriter(bufferedWriter, true);
            printWriter.println("Hi Client!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

/*
 * Client
 * - Demonstrates a minimal TCP client that connects to the server on localhost:8089, sends a text message, and reads
 *   the server's response.
 */
public static class Client implements Runnable {
    @Override
    public void run() {
        try (Socket clientSocket = new Socket("localhost", 8089)) {
            // Send
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            PrintWriter printWriter = new PrintWriter(bufferedWriter, true);
            printWriter.println("Hi Server!");

            // Receive
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = bufferedReader.readLine(); // Block and wait message
            IO.println("Received message from server: " + message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

/*
 * Main / Example Execution
 * - Starts both the server and client in separate threads to illustrate socket communication.
 * - This setup shows how ServerSocket and Socket interact using blocking I/O streams for
 *   text-based message exchange.
 * - Intended purely for demonstration of basic socket concepts in Java.
 * - Output: Received message from client: Hi Server! | Received message from server: Hi Client!
 */
void main() throws InterruptedException {
    new Thread(new Server()).start();
    Thread.sleep(500); // Small delay to ensure server is ready
    new Thread(new Client()).start();
}
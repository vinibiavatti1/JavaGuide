/*
Datagrams (UDP)
- This file demonstrates the basic usage of UDP sockets in Java, providing a foundation for connectionless network
  communication between a server and a client.

Overview
- UDP (User Datagram Protocol) is a connectionless, packet-oriented protocol.
- UDP Datagrams are suitable for applications that prioritize low latency and high performance, where occasional packet
  loss is acceptable, such as online games, video/audio streaming, VoIP, and broadcast/multicast protocols.
- Java provides the DatagramSocket and DatagramPacket classes for sending and receiving datagrams.
- Unlike TCP, UDP does not guarantee delivery, ordering, or protection against duplicates.
- Each message is sent as a discrete packet; the application is responsible for handling lost or out-of-order packets.
- DatagramSocket provides InputStream/OutputStream-like send/receive operations via DatagramPacket objects.

Key Characteristics
- DatagramSocket can send and receive DatagramPackets over the network.
- UDP is lightweight and low-latency, suitable for real-time applications or broadcasting.
- Each packet has a limited maximum size (~64 KB, practical limit lower).
- read/receive operations block the calling thread until a packet arrives.
- There is no persistent connection: client and server do not maintain a session.

Usage
- The server binds a DatagramSocket to a specific port and waits for incoming packets.
- The client sends a packet to the server and may wait for a response.
- Packet addressing is explicit: each packet carries the destination IP address and port.
- No handshake or connection setup is needed, unlike TCP sockets.

Notes
- This example demonstrates basic UDP communication on localhost.
- Real-world UDP programs need to handle lost, duplicated, or reordered packets.
- UDP is not suitable for applications that require guaranteed delivery or stream-oriented protocols.

Server
- Demonstrates a minimal UDP server that binds to port 8089, receives a datagram from a client, and sends a response
  back to the sender.
- Each message is handled independently; there is no persistent connection.
*/
public static class Server implements Runnable {
    @Override
    public void run() {
        try(DatagramSocket socket = new DatagramSocket(8089)) {
            // Receive
            byte[] buffer = new byte[32];
            DatagramPacket packet = new DatagramPacket(
                    buffer,
                    buffer.length
            );
            socket.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength());
            IO.println("Received message from client: " + message);

            // Send
            buffer = "Hi Client!".getBytes();
            packet = new DatagramPacket(
                    buffer,
                    buffer.length,
                    packet.getAddress(),
                    packet.getPort()
            );
            socket.send(packet);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

/*
Client
- Demonstrates a minimal UDP client that sends a single datagram to the server on localhost:8089, and waits for a
  response.
- The client uses DatagramPacket to specify the server address and port for sending.
- Communication is connectionless and each send/receive is independent.
*/
public static class Client implements  Runnable {
    @Override
    public void run() {
        try(DatagramSocket socket = new DatagramSocket()) {
            // Send
            byte[] buffer = "Hi Client!".getBytes();
            DatagramPacket packet = new DatagramPacket(
                    buffer,
                    buffer.length,
                    InetAddress.getByName("localhost"),
                    8089
            );
            socket.send(packet);

            // Receive
            buffer = new byte[32];
            packet = new DatagramPacket(
                    buffer,
                    buffer.length
            );
            socket.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength());
            IO.println("Received message from server: " + message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

/*
Main / Example Execution
- Starts both the UDP server and client in separate threads to illustrate UDP communication.
- Demonstrates sending and receiving discrete packets without establishing a connection.
- Highlights key UDP characteristics:
  - No guarantee of delivery or order.
  - Each packet is self-contained.
  - Blocking behavior on receive() calls.
- Intended purely for demonstration of basic datagram concepts in Java.
- Output example: Received message from client: Hi Client! | Received message from server: Hi Client!
*/
void main() throws InterruptedException {
    new Thread(new Server()).start();
    Thread.sleep(500); // Small delay to ensure server is ready
    new Thread(new Client()).start();
}
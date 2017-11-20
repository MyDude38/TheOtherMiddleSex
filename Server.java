package serverclient;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server {


  private static ServerSocket serverSocket = null;
  private static Socket clientSocket = null;
  ArrayList<Shapes> MyList = new ArrayList<Shapes>();
  
  private static final int MaxClients = 5;
  private static final clientThread[] threads = new clientThread[MaxClients];

  public static void main(String args[]) {

    int portNumber = 2222;
    if (args.length < 1) {
      System.out.println("Using port number=" + portNumber);
    } else {
      portNumber = Integer.valueOf(args[0]).intValue();
    }

 
    try {
      serverSocket = new ServerSocket(portNumber);
    } catch (IOException e) {
      System.out.println(e);
    }

  
    while (true) {
      try {
        clientSocket = serverSocket.accept();
        int i = 0;
        for (i = 0; i < MaxClients; i++) {
          if (threads[i] == null) {
            (threads[i] = new clientThread(clientSocket, threads)).start();
            break;
          }
        }
        if (i == MaxClients) {
          PrintStream os = new PrintStream(clientSocket.getOutputStream());
          os.println("Server is under too much stress. Please try again shortly.");
          os.close();
          clientSocket.close();
        }
      } catch (IOException e) {
        System.out.println(e);
      }
    }
  }
}


class clientThread extends Thread {

  private String clientName = null;
  private DataInputStream is = null;
  private PrintStream os = null;
  private Socket clientSocket = null;
  private final clientThread[] threads;
  private int MaxClients;

  public clientThread(Socket clientSocket, clientThread[] threads) {
    this.clientSocket = clientSocket;
    this.threads = threads;
    MaxClients = threads.length;
  }

  public void run() {
    int MaxClients = this.MaxClients;
    clientThread[] threads = this.threads;
    
  
  try {
      is = new DataInputStream(clientSocket.getInputStream());
      os = new PrintStream(clientSocket.getOutputStream());
      String name;
      while (true) {
        os.println("Please, enter your name.");
        name = is.readLine().trim();
        if (name.indexOf('@') == -1) {
          break;
        } else {
          os.println("Please don't use '@' in your name");
        }
      }
     
      
      synchronized (this) {
        for (int i = 0; i < MaxClients; i++) {
          if (threads[i] != null && threads[i] == this) {
            clientName = "@" + name;
            break;
          }
        }
        for (int i = 0; i < MaxClients; i++) {
          if (threads[i] != null && threads[i] != this) {
            threads[i].os.println(" A new user " + name
                + " started using the Shapes Maker!!");
          }
        }
      }
      while (true) {
        String line = is.readLine();
        if (line.startsWith("/quit")) {
          break;
        }
      }
      synchronized (this) {
        for (int i = 0; i < MaxClients; i++) {
          if (threads[i] != null && threads[i] != this
              && threads[i].clientName != null) {
            threads[i].os.println(name + " is leaving the Shapes Maker!! ");
          }
        }
      }

    
      synchronized (this) {
        for (int i = 0; i < MaxClients; i++) {
          if (threads[i] == this) {
            threads[i] = null;
          }
        }
      }
      
      is.close();
      os.close();
      clientSocket.close();
    } catch (IOException e) {
    }
  }
}  

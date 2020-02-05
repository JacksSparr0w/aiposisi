package com.aposisi.lab1;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Date;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) {
        int port = 8082;

        try {
            ServerSocket serverConnect = new ServerSocket(port);
            logger.log(Level.INFO, "Server started. Listening for connections on port : " + port);

            while (true) {
                JavaHTTPServer myServer = new JavaHTTPServer(serverConnect.accept());

                System.out.println("Connecton opened. (" + new Date() + ")");

                Thread thread = new Thread(myServer);
                thread.start();
            }

        } catch (IOException e) {
            System.err.println("Server Connection error : " + e.getMessage());
        }
    }
}

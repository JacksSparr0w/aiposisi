package com.aposisi.lab1;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Optional;
import java.util.StringTokenizer;

public class JavaHTTPServer implements Runnable {
    private static final Logger logger = LogManager.getLogger(JavaHTTPServer.class);

    private static final String ROOT = "/sharedFiles";
    private static final String DEFAULT_FILE = "/index.html";
    private static final String FILE_NOT_FOUND = "/404.html";
    private static final String METHOD_NOT_SUPPORTED = "/501.html";

    private Socket connect;

    private BufferedReader in;
    private PrintWriter out;
    private BufferedOutputStream dataOut;

    JavaHTTPServer(Socket connect) {
        this.connect = connect;
    }

    @Override
    public void run() {
        String fileRequested = null;
        try {
            in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            out = new PrintWriter(connect.getOutputStream());
            dataOut = new BufferedOutputStream(connect.getOutputStream());

            String input = in.readLine();
            StringTokenizer parse = new StringTokenizer(input);

            String method = parse.nextToken().toUpperCase();
            fileRequested = parse.nextToken().toLowerCase();

            Optional<RequestType> requestType = RequestType.of(method);
            if (requestType.isPresent()) {
                logger.log(Level.INFO, "Request method: " + requestType.get().name());
                switch (requestType.get()) {
                    case GET:
                        processGet(fileRequested);
                        break;
                    case POST:
                        processPost();
                    case OPTIONS:
                        processOptions();
                        break;
                    default:
                        methodNotSupported(requestType.get());
                }
            }
            logger.log(Level.INFO, "File " + fileRequested + " returned");
        } catch (FileNotFoundException fnfe) {
            try {
                logger.log(Level.WARN, "File:" + fileRequested + " not found, load " + FILE_NOT_FOUND);
                fileNotFound(fileRequested);
            } catch (IOException ioe) {
                logger.log(Level.WARN, "Error with file not found exception : " + ioe.getMessage());
            }
        } catch (IOException ioe) {
            logger.log(Level.ERROR, "Server error : " + ioe);
        } finally {
            try {
                in.close();
                out.close();
                dataOut.close();
                connect.close();
            } catch (Exception e) {
                logger.log(Level.ERROR, "Error closing stream : " + e.getMessage());
            }
            logger.log(Level.INFO, "Connection closed");
        }
    }

    private void processGet(String fileRequested) throws IOException {
        if (fileRequested.endsWith("/")) {
            fileRequested += DEFAULT_FILE;
        }
        InputStream inputStream = findFile(fileRequested, true);
        ContentType content = getContentType(fileRequested);
        createResponse(HTTPCodes.OK, content, inputStream.available(), readFileData(inputStream));
        logger.log(Level.INFO, "File " + fileRequested + " of type " + content + " returned");
    }

    private void processPost() throws IOException {
        createResponse(HTTPCodes.CREATED, ContentType.PLAIN, 0, new byte[]{});
        logger.log(Level.INFO, "POST request was accepted");
    }

    private void processOptions() throws IOException {
        InputStream inputStream = findFile("options.txt", false);
        createResponse(HTTPCodes.OK, ContentType.PLAIN, inputStream.available(), readFileData(inputStream));
    }

    private void methodNotSupported(RequestType type) throws IOException {
        InputStream inputStream = findFile(METHOD_NOT_SUPPORTED, false);
        createResponse(HTTPCodes.NOT_IMPLEMENTED, ContentType.HTML, inputStream.available(), readFileData(inputStream));
        logger.log(Level.WARN, "Unknown method: " + type);
    }

    private byte[] readFileData(InputStream inputStream) throws IOException {
        FileInputStream fileIn = null;
        byte[] fileData = new byte[inputStream.available()];
        try {
            inputStream.read(fileData);
        } finally {
            if (fileIn != null)
                fileIn.close();
        }
        logger.log(Level.INFO, "Read data from request file");
        return fileData;
    }

    private ContentType getContentType(String fileRequested) {
        if (fileRequested.endsWith(".htm") || fileRequested.endsWith(".html"))
            return ContentType.HTML;
        else
            return ContentType.PLAIN;
    }

    private void fileNotFound(String fileRequested) throws IOException {
        InputStream inputStream = findFile(FILE_NOT_FOUND, false);
        createResponse(HTTPCodes.NOT_FOUND, ContentType.HTML, inputStream.available(), readFileData(inputStream));
        logger.log(Level.WARN, "File " + fileRequested + " not found");

    }

    private InputStream findFile(String fileName, boolean clientFile) throws FileNotFoundException {
        if (clientFile){
            fileName = ROOT + fileName;
        }
        InputStream inputStream = this.getClass().getResourceAsStream(fileName);
        if (inputStream == null){
            throw new FileNotFoundException();
        }
        return inputStream;
    }

    private void createResponse(HTTPCodes code, ContentType content, int fileLength, byte[] fileData) throws IOException {
        out.println("HTTP/1.1 " + code.getCode() + " " + code.getDescription());
        out.println("Server: Java HTTP Server");
        out.println("Date: " + new Date());
        out.println("Content-type: " + content.getText());
        out.println("Content-length: " + fileLength);
        out.println();
        out.flush();
        dataOut.write(fileData, 0, fileLength);
        dataOut.flush();
        logger.log(Level.INFO, "Creating header of response");
    }
}
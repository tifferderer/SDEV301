package sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

//The server has to be started first
public class MathServer {

    public static final int MATH_PORT = 0200;

    public static void main(String[] args) {
        //create a ServerSocket object use a
        //try with clause to create the socket
        try (ServerSocket server = new ServerSocket(MATH_PORT)) {
            System.out.println("Math Server starting...");

            //wait for client to connect
            Socket client = server.accept();
            System.out.println("Found client...");

            //set up pipeline or streams(input and output)
            OutputStream outStream = client.getOutputStream();
            //instream get data from client
            InputStream inStream = client.getInputStream();

            //create text objects PrintWriter for outStream(text sent to client)
            PrintWriter out = new PrintWriter(outStream);

            //create scanner pto handle instream(text from client)
            Scanner in = new Scanner(inStream);

            //trying to read in 2 numbers from client
            try {
                int num1 = in.nextInt();
                int num2 = in.nextInt();

                calculate(num1, num2, out);

            } catch (InputMismatchException e) {
                //send a message to client Math protocol was not followed
                //Math protocol expects <num1> <num2>
                out.println("Math protocol expects <num1> <num2>");
                out.flush(); //force MathServer to send string now
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Math Server exiting");
    }

    public static void calculate(int num1, int num2, PrintWriter out) {
        out.println(num1 + " + " + num2 + " = " + (num1 + num2));
        out.println(num1 + " - " + num2 + " = " + (num1 - num2));
        out.println(num1 + " * " + num2 + " = " + (num1 * num2));
        if(num2 != 0) {
            out.println(num1 + " / " + num2 + " = " + (num1 / num2));
        } else {
            out.println("Cannot divide by zero.");
        }
        out.println(num1 + " % " + num2 + " = " + (num1 % num2));
        out.flush(); //make sure all is sent to client
    }
}

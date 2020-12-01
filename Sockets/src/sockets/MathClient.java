package sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MathClient {

    public static void main(String[] args) {
        //creat a socket for the client with a try with
        try(Socket s = new Socket("localhost", MathServer.MATH_PORT);
            Scanner kb = new Scanner(System.in)) {

                //prompt for two numbers
                System.out.println("Enter 2 integers separated by a space");

                //read in a string
                String nums = kb.nextLine();

                //setup out text transfer objects PrintWriter and another Scanner
                 PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                Scanner in = new Scanner(s.getInputStream());

                //send the nums to the mathserver
                out.println(nums);

                //receive calculations from MathServer
                while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }



        }catch (UnknownHostException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Client exiting.");
    }
}

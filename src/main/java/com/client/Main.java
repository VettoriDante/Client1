package com.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) throws UnknownHostException, IOException{
        System.out.println("client partito");
        Socket s = new Socket("localhost", 3000);
        System.out.println("il client si è collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        String inputString;

        do{
            System.out.print("Inserisci la stringa da modificare: ");
            inputString = scanner.nextLine();
            if(inputString.equals("exit")) inputString = "!";
            out.writeBytes(inputString + "\n");

            String ans = in.readLine();
            if(inputString.equals("!"))break;
            System.out.println(ans);
        }while(true);
        scanner.close();
        s.close();
    }
}
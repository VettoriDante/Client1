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
        System.out.print("Inserisci la stringa da modificare: ");
        String inpuString = scanner.nextLine();
        
        out.writeBytes(inpuString + "\n");
        String ans = in.readLine();
        System.out.println(ans);
        scanner.close();

    }
}
package com.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException{
        System.out.println("client partito");
        Socket s = new Socket("localhost", 3000);
        System.out.println("il client si è collegato");
        boolean error = false;

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        String inputString;

        do{
            System.out.print("Inserisci la stringa da modificare: ");
            inputString = scanner.nextLine();
            if(inputString.equals("exit")) inputString = "!";
            out.writeBytes(inputString + "\n");
            do{
                //chiedo l'operazione da eseguire
                System.out.println("Decidi l'operazione da eseguire: \n M = maiuscolo \n m = minuscolo \n r = ribalta stringa \n c = conta caratteri \n ex = chiudi programma" );
                inputString = scanner.nextLine();
                switch (inputString) {
                    case "M":
                    case "m":
                    case "r":
                    case "c":
                    case "ex":
                        out.writeBytes(inputString + "\n");
                        error = false;
                    break;
                    default:
                        System.out.println("Valore errato");
                        error = true;
                    break;
                }
            }while(error);
            
            
            String ans = in.readLine();
            if(inputString.equals("ex"))break;
            if(ans.equals("!!!"))
                System.out.println("Qualcosa è andato storto");
            else            
                System.out.println(ans);
        }while(true);
        scanner.close();
    }
}
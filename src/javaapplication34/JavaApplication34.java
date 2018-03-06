/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication34;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author adamlass
 */
public class JavaApplication34 {
    
    static List<Character> found = new ArrayList<>();
    static List<Character> unique = new ArrayList<>();
    static List<Character> failed = new ArrayList<>();
     static       int fails = 0;

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("HANGMAN: Enter a word for the (soon to be hanged) to guess:");
        String answer = sc.next().toLowerCase();
        
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
        
        JavaApplication34 jp = new JavaApplication34();
        
        jp.generateUnique(answer);
        
        do{
        System.out.print("Guess:");
        jp.find(sc.next().toLowerCase(), answer);
            System.out.println("____");
        jp.printString(answer);
            System.out.println("You have "+fails+"/6 fails"  );
            System.out.println("");
            System.out.println(failed);
        
        //todo
        } while(unique.size() != found.size() ^ fails==6);
        
        if(fails < 6){
                    System.out.println("You have won the game");

        } else {
            System.out.println("You have lost the game");
        }
        
        
    }

    public void find(String next, String answer) {
        char input = next.charAt(0);
        
        for (int i = 0; i < answer.length(); i++) {
            if(answer.charAt(i) == input){
                if(!found.contains(input)){
                    found.add(input);
                    return;
                }
            }
        }
        failed.add(input);
        fails++;
    }
    
    

    private void printString(String answer) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length(); i++) {
            char current = answer.charAt(i);
            if(found.contains(current)){
                sb.append(current);
            } else {
                sb.append("*");
            }
        }
        System.out.println(sb.toString());
    }

    private void generateUnique(String answer) {
        for (int i = 0; i < answer.length(); i++) {
            char current = answer.charAt(i);
            if(!unique.contains(current)){
                unique.add(current);
            }
            
        }
    }
    
}

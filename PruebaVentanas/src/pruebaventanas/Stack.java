/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaventanas;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Fernando Armira
 */
public class Stack {
	private int maxSize;
	private String[] stackElements;
	private int topOfStack;

	public Stack(int maxSize) {
		this.maxSize = maxSize;
		stackElements = new String[maxSize];
		topOfStack = -1;
	}

	public void push(String element) {
		if (isFull()) {
			System.out.println("Stack is Full");
			return;
		}
		stackElements[++topOfStack] = element;
	}

	public String pop() {
		if (isFull()) {
			new RuntimeException("Empty Stack");
		}
		return stackElements[topOfStack--];
	}

	public String peek() {
		return stackElements[topOfStack];
	}

	public boolean isEmpty() {
		return (topOfStack == -1);
	}

	public boolean isFull() {
		return (topOfStack == maxSize - 1);
	}
       

        public void getCodigoInterno(){
            
            while(isEmpty() == false){
                String dato = pop();

                System.out.println(dato);

                
            }
            
        }
        
        public void dot()
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("stack.dot");
            pw = new PrintWriter(fichero);
            pw.println("digraph firsGraph{");
            pw.println("node [shape=record];");
            pw.println("rankdir=LR;");
            pw.print("nodoe_A [shape=record    label=\"");
            
            while(isEmpty() == false){
                String dato = pop();
                
                pw.print("|" + dato);

                //System.out.println(dato);

                
            }
            pw.println("\"];");
            pw.println("}");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           Runtime rt = Runtime.getRuntime();
           rt.exec( "dot stack.dot -Tjpg -o stack.jpg");
           
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
           

	/*public static void main(String[] args) {
		Stack stack = new Stack(20);
                
                String c= "464";
                

		stack.push(c);
		stack.push("afs");
		stack.push("dasff");
		stack.push("re");
		stack.push("p");
		//stack.push(60);//Stack is Full Message
                

                //String dato = Long.toString(stack.pop());
                
                //while(stack.isEmpty() == false){
                  //  System.out.println(stack.pop());          
                //}
                //stack.getCodigoInterno();
                stack.dot();


	}*/
}
           

	/*public static void main(String[] args) {
		Stack stack = new Stack(5);

		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		//stack.push(60);//Stack is Full Message
                

                //String dato = Long.toString(stack.pop());
                
                /*while(stack.isEmpty() == false){
                    System.out.println(stack.pop());          
                }
                //stack.getCodigoInterno();
                stack.dot();


	}*/



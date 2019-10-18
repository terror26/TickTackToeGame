package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    TickTackToe tickTackToe = new TickTackToe();
        Scanner scan = new Scanner(System.in);
	    while (true) {

	        System.out.println((tickTackToe.player == 1?"X":"Y")+" chance");
	        while(true) {
				int x = scan.nextInt(),y = scan.nextInt();
	            boolean valid = tickTackToe.putPosition(x,y);
	            if(valid ) break;
            }
			System.out.println(tickTackToe.toString());
	        if(!tickTackToe.isEmpty) break;
            if(tickTackToe.isWin(1) ||tickTackToe.isWin(-1)) {
            	tickTackToe.winner();
            	break;
			}
        }
	    System.out.println("END---------------");
    }
}

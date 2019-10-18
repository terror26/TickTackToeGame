package com.company;

public class TickTackToe {
    private static final int X = 1,O  = -1;
    private static final int EMTPY = 0;
    public int player = X;
    public static int noMorePositions = 0;
    public boolean isEmpty = false;
    public TickTackToe() {
        noMorePositions = 0;
    }

    int[][] board = new int[3][3];
    boolean putPosition(int x,int y) {
        boolean done = true;
        if(x<0|| x>2 || y < 0 || y>2) {
            printAns("Wrong Input");
            return false;
        }
        if(board[x][y] == EMTPY) {
            board[x][y] = player;
            player = player == X ? O:X;
            noMorePositions++;
        } else done = false;
        return done;
    }

    boolean isWin(int player) {
        return board[0][0] +board[0][1]  + board[0][2] == 3*player ||
                board[1][0] +board[1][1]  + board[1][2] ==3*player ||
                board[2][0] +board[2][1]  + board[2][2] ==3*player ||
                board[0][0] + board[1][0] + board[2][0] ==3*player||
                board[0][1] + board[1][1] + board[2][1] ==3*player||
                board[0][2] + board[1][2] + board[2][2] ==3*player||
                board[0][0] + board[1][1] + board[2][2] ==3*player ||
                board[0][2] + board[1][1] + board[2][0] ==3*player ;
    }

    private void printAns(String ans) {
        System.out.println(ans);
    }
    boolean winner() {
        if(isWin(X)) {
            printAns("X won");
            return true;
        } else if(isWin(O)) {
            printAns("O won");
            return true;
        }

        if(noMorePositions == 9) {
            printAns("No One Won");
            return true;
        }
        return false;
    }
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        isEmpty = false;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                switch(board[i][j])
                {
                    case X:
                        s.append(" X ");
                        break;
                    case O:
                        s.append(" O ");
                        break;
                    case EMTPY:
                        s.append("   ");
                        isEmpty=true;
                        break;
                }
                if(j<2)
                {
                    s.append("|");
                }

            }
            if(i<2)
            {
                s.append("\n-----------\n");
            }
        }
        return s.toString();
    }

}

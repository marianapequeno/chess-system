package application;

import boardgame.Board;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ChessMatch chessMatch = new ChessMatch();

        while (true){
            try{
                UI.clearScreen();//Faz sempre limpar a tela após input de dados
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            } catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();//Para aguardar o usuário apertar a tecla 'enter' (Handling exceptions and clearing screen)
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();//Para aguardar o usuário apertar a tecla 'enter' (Handling exceptions and clearing screen)
            }
        }


    }
}
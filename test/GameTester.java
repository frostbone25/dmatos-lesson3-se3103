package test;

//import from our codebase
import model.NumberGuessGame;

public class GameTester 
{
    public static void main(String[] args)
    {
        NumberGuessGame numberGuessGame = new NumberGuessGame();
        numberGuessGame.start();
        System.out.println("" + numberGuessGame);

        numberGuessGame.play(50);
        System.out.println(numberGuessGame);
        System.out.println(numberGuessGame.progressMessage);

        numberGuessGame.play(30);
        System.out.println(numberGuessGame);
        System.out.println(numberGuessGame.progressMessage);
    }
}
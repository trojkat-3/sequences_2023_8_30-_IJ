import exceptions.CantDecomposeException;
import exceptions.OutOfBoundsException;
import gui.MainFrame;
import print.Printer;
import print.PrinterFile;
import print.PrinterStdOut;
import sequence.*;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setTitle("Sequences");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);



        Printer printerStdOut = new PrinterStdOut();
        Printer printerFile = new PrinterFile("integers.txt");

        Sequence sq = new Integers();
        printerStdOut.print(sq);
        printerFile.print(sq);

        sq = new Arithmetic(3, 5);
        printerStdOut.print(sq);
        printerFile.print(sq);

        try {
            System.out.println(sq.getSum(10));

            sq = new Fibonacci(3, 5);
            printerStdOut.print(sq);
            printerFile.print(sq);

            //System.out.println(sq.getSum(30));

            sq = new Squares();
            printerStdOut.print(sq);
            printerFile.print(sq);

            System.out.println(sq.getDecomposition(1236));

            sq = new Primes();
            sq.setMax(10000);
            printerStdOut.print(sq);
            printerFile.print(sq);

            System.out.println(sq.getDecomposition(30));

            sq = new Fibonacci();
            printerStdOut.print(sq);
            printerFile.print(sq);

            System.out.println(sq.getDecomposition(666));

            sq = new Integers();
            printerStdOut.print(sq);
            printerFile.print(sq);

        } catch (OutOfBoundsException|CantDecomposeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
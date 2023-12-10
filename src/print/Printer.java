package print;

import java.util.ArrayList;
import java.util.Collections;
import sequence.Sequence;

abstract public class Printer {
    
    private final static int MAX_IN_LINE = 10;
    
    private int getNumberOfDigits(int n) {
        if (n==0){
            return 1;
        }
        int nd = 0;
        while (n > 0) {
            nd++;
            n = (n - (n % 10)) / 10;
        }
        return nd;
    }
    
    public String print(Sequence sq) {
        ArrayList<Integer> listToOutput=sq.getSequence();
        String outputStr = "-----------\n"+sq+":\n";
        for (int i = 0; i < listToOutput.size(); i++) {
            int n = listToOutput.get(i);
            outputStr += Integer.toString(n);
            if (i < listToOutput.size() - 1) {
                outputStr += ", ";
            }
            int maxNumber = Collections.max(listToOutput);
            for (int j = 0; j
                    < getNumberOfDigits(maxNumber) - getNumberOfDigits(n); j++) {
                outputStr += " ";
            }
            if ((i + 1) % MAX_IN_LINE == 0) {
                outputStr += "\n";
            }
        }
        outputStr += "\n";
        output(outputStr);
        return outputStr;
    }
    
    abstract protected void output(String str);
    
}







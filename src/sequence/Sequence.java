package sequence;

import java.util.ArrayList;
import java.util.Collections;
import exceptions.CantDecomposeException;
import exceptions.OutOfBoundsException;

abstract public class Sequence {

    protected int max = 1000;
    protected ArrayList<Integer> sequence = new ArrayList<>();
    private String name;

    public Sequence(String name) {
        this.name = name;
    }

    public void setMax(int max) {
        this.max = max;
        sequence.clear();
        initialize();
    }

    /**
     * Computes the sum of n initial elements of the sequence
     *
     * @param n
     * @return sum of n initial elements
     * @throws OutOfBoundsException
     */
    public int getSum(int n) throws OutOfBoundsException {
        if (n>sequence.size()){
            throw new OutOfBoundsException("In the sum function for "+name+
                    " sequence max="+sequence.size(),n);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sequence.get(i);
        }
        return sum;
    }
    
    public ArrayList<Integer> getDecomposition(int n) 
            throws CantDecomposeException{
        int nBackup=n;
        ArrayList<Integer> lst=new ArrayList<>(sequence); //shallow copy
        Collections.sort(lst,Collections.reverseOrder());
        ArrayList<Integer> ret=new ArrayList<>(); //output
        int i=0;
        while(n>0 && i<lst.size()){
            if (lst.get(i)<=n){
                ret.add(lst.get(i));
                n-=lst.get(i);
            } else {
                i++;
            }
        }
        if (n!=0){
            throw new CantDecomposeException(name, nBackup);
        }
        return ret;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getSequence() {
        return sequence;
    }

    @Override
    public String toString() {
        return "Sequence: " + name + " [max: " + max + "]";
    }

    abstract void initialize();

}

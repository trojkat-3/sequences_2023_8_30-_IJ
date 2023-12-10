package print;

import java.io.FileWriter;
import java.io.IOException;

public class PrinterFile extends Printer {

    private String filename;

    public PrinterFile(String filename) {
        this.filename = filename;
        try (FileWriter myWriter
                = new FileWriter("output/" + filename);) {
            myWriter.write("");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    protected void output(String str) {
        try (FileWriter myWriter
                = new FileWriter("output/" + filename, true);) {
            myWriter.write(str);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

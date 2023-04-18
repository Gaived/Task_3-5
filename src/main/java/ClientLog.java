import au.com.bytecode.opencsv.CSVWriter;

import java.io.*;
import java.util.*;

public class ClientLog {
//    private String log = "";
    private List<String[]> log = new ArrayList<>();

    public void log(int productNum, int amount) {
//        log += String.format("%d,%d%n", productNum, amount);
        log.add(new String[] {"" + productNum, "" + amount});
    }

    public void  exportAsCSV(File txtFile) {
        if (!txtFile.exists()) {
//            log = "productNum,amount\n" + log;
            log.add(0, new String[] {"productNum,amount"});
        }

//        try (FileWriter writer = new FileWriter(txtFile, true)) {
//            writer.write(log);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(txtFile, true))) {
            writer.writeAll(log);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

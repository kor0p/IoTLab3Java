package ua.lviv.iot.security.managers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import ua.lviv.iot.security.models.Security;

public class SecuritiesWriter {

  public static void writeToFile(List<Security> securities)
      throws FileNotFoundException, IOException {
    File myFile = new File("out.csv");
    try (FileOutputStream fos = new FileOutputStream(myFile);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bufWriter = new BufferedWriter(osw);) {
      for (Security security:securities) {
        bufWriter.write(
            security.getHeaders() + "\n"
            + security.toCSV() + "\n"
        );
      }
    } finally {
      System.out.println();
    }
  }
}

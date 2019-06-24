package org.angrybeard.designmode.decorator.io;

import java.io.*;

/**
 * Created by angry_beary on 2019/6/24.
 */
public class InputTest {

    public static void main(String[] args) {
        int c;
        try (InputStream in = new LowerCaseInputStream(
                new BufferedInputStream(
                        new FileInputStream("src/main/java/org/angrybeard/designmode/decorator/io/test.txt")
                ))) {
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

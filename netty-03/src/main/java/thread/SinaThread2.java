package thread;

import java.io.*;

public class SinaThread2 implements Runnable {
    BufferedReader bufferedReader;
    private Object obj = new Object();
    String line = null;
    String path = "/Users/yodo1/code-liyang/netty/netty-03/pom.xml2";
    String text = null;

    public SinaThread2(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public SinaThread2(String text) {
        this.text = text;
    }

    public void run() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path)));
            String[] sinas = text.split("\r\n");
            for (String line : sinas) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

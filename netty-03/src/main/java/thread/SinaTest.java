package thread;

import java.io.*;

public class SinaTest {

    public static void main(String args[]) {
        String path = "/Users/yodo1/code-liyang/netty/netty-03/pom.xml";
        String line = null;
        String text = null;
        try {//主线程读取
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)));
            while ((line = bufferedReader.readLine()) != null) {
                text += line + "\r\n";
            }

//            System.out.println(text);

            SinaThread1 sinaThread1 = new SinaThread1(text); //写1
            SinaThread2 sinaThread2 = new SinaThread2(text); //写2

            Thread t1 = new Thread(sinaThread1);
            Thread t2 = new Thread(sinaThread2);
            t1.start();
            t2.start();
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

}

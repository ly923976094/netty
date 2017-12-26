package thread;


class Thread1  extends Thread{


    private SubMain subMain;
    Thread1(){}
    Thread1(SubMain subMain){
        this.subMain = subMain;
    }

    public void run() {
        for (int i=0; i<50;i++){
            subMain.sub();
        }

    }
}

class Thread2  extends Thread{


    private SubMain subMain;
    Thread2(){}
    Thread2(SubMain subMain){
        this.subMain = subMain;
    }

    public void run() {
        for (int i=0; i<50;i++){
            subMain.main_sub();
        }

    }
}

/**
 * 面试题1:编写程序实现,子线程循环10次,接着主线程循环20次,接着再子线程循环10次,主线程循环20次,如此反复,循环50次.
 */
public class SubMainDemo1 {
    public static void main(String[] args) {

     SubMain subMain = new SubMain();

     Thread1 t1 = new Thread1(subMain);
     Thread2 t2 = new Thread2(subMain);
     System.out.println("start");
     t1.start();
     System.out.println("t1");
     t2.start();
     System.out.println("end");

    }
}

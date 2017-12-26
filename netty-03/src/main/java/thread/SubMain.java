package thread;


public class SubMain {


    private boolean flag = false;
    public SubMain(){}


    public synchronized void sub(){
//        Lock lock = new ReetranLock
        while (flag){

            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        for (int i=0; i<10;i++){
            System.out.println("sub-" + i);
        }

        flag = true;
        this.notify();
    }

    public synchronized void main_sub(){
        while (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i=0; i<20;i++){
            System.out.println("main-" + i);
        }

        flag = false;
        this.notify();

    }
}

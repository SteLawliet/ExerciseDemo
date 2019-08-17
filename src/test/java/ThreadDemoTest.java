import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stelawliet on 17/11/7.
 */
public class ThreadDemoTest {
    public  List<Integer> integers = new ArrayList<Integer>();
    private int count = 0;
    @Ignore
    @Test
    public void fun1(){
        int[] num= new int[101];
        for (int i = 0 ; i<num.length;i++){
            num[i]=i;
        }


        new Thread(new addThread(1,25)).start();
        new Thread(new addThread(26,50)).start();
        new Thread(new addThread(51,75)).start();
        new Thread(new addThread(76,100)).start();

        synchronized (integers) {
            count++;
            System.out.println(Thread.currentThread().getName()+" start  "+count);

            if (integers.size() == 4) {
                int i = integers.get(0) + integers.get(1) + integers.get(2) + integers.get(3);
                System.out.println(i);
            } else {
                try {
                    System.out.println("integers.wait() "+count);
                    integers.wait();
                    System.out.println("integers.wait.end;");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }




    }
    class addThread implements Runnable{
        private int begin;
        private int end;
        public addThread(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
        private int getSum(int begin, int end ) {
            int sum = 0;
            for (int i = begin; i <end+1 ; i++) {
                sum = sum +i;
            }
            return sum;
        }
        @Override
        public void run() {
            int i = getSum(this.begin,this.end);
            System.out.println(begin+" + "+end+ " = "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (integers) {
                integers.add(i);
                System.out.println("integers.size()= "+integers.size() );
                if (integers.size() == 4) {
                    integers.notify();
                }
            }
        }
    }





    @Test
    @Ignore
    public void fun2(){
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        System.out.println(integers.get(0));
        System.out.println("size"+integers.size());
        String s = "1";
        Integer i = 1;
        int[] ints = new int[1];
        ints[0]=1;
        changeString(ints);

        System.out.println(ints[0]);
    }


    private void changeString(int[] i) {

        i[0]=2;
    }

    @Test
    @Ignore
    public void fun3() {
        int a = 0;
    }
}

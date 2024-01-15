import java.util.concurrent.CountDownLatch;

public class Philosophear implements Runnable{
    private String name;
    private int num;
    private boolean hungry; // сытый/не сытый
    private boolean isThinking; // в статусе true, означает, что философ думает
    //private CountDownLatch cdl;
    private int meals = 3;

    @Override
    public void run() {
        while(meals > 0) {
            thinking();
            eating();
        }
    }

    public Philosophear(int num, String name) {
        this.num = num;
        this.name = name;
    }
    public String getPhilosophearName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public void thinking() {
        System.out.println(num + " думает...");
        hungry = true;
        try {
            Thread.sleep(1000);
            isThinking = false;
        }
        catch(InterruptedException e) {
            throw new RuntimeException();
        }
    }

    public void eating() {
        if(!isThinking && hungry && meals > 0) {
            System.out.print(num + " ест...");
            hungry = false;
            meals--;
            isThinking = true;
        } else {
            System.out.println(num + " объелся");
        }
    }

    public boolean getIsThinking() {
        return isThinking;
    }

    public  boolean isAte() {
        return meals < 1;
    }

}

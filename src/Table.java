import java.util.ArrayList;
import java.util.List;

public class Table extends Thread{
    private List<Philosophear> philosophears;
    private List<Fork> forks;

    @Override
    public void run() {
        while(true) {
            thinking();
            eating();
        }
    }

    public Table() {
        philosophears = new ArrayList<>(5);
        philosophears.add(new Philosophear(0," Аристотель"));
        philosophears.add(new Philosophear(1," Кант"));
        philosophears.add(new Philosophear(2," Платон"));
        philosophears.add(new Philosophear(3," Конфуций"));
        philosophears.add(new Philosophear(4," Декарт"));

        forks = new ArrayList<>(5);
        for(int i = 0; i < 5; i++) {
            forks.add(new Fork(i));
        }
    }

    private void thinking() {

        for(Philosophear p : philosophears) {
            p.thinking();
        }
    }

//    private boolean validForks() {
//        for(Philosophear p : philosophears) {
//            for(int i = 0; i < forks.size(); i++) {
//                if(p.getNum() == forks.get(i).getNumber() && p.getNum() == forks.get(i+1).getNumber()-1) {
//                    forks.get(i).valid();
//                    forks.get(i+1).valid();
//                    return true;
//                }
//                if(p.getNum() == 4 && (i == 0 || i == 4)) {
//                    forks.get(0).valid();
//                    forks.get(4).valid();
//                    return true;
//                }
//            }
//        }
//        return  false;
//    }

    public void eating() {
        for(Philosophear p : philosophears) {
            if(!p.getIsThinking()) {
                for(int i = 0; i < forks.size(); i++) {
                    if(i + 1 < forks.size()) {
                        if(p.getNum() == forks.get(i).getNumber() && p.getNum() == forks.get(i+1).getNumber() - 1) {
                            forks.get(i).setValid(true);
                            forks.get(i+1).setValid(true);
                            if(forks.get(i).isFree() && forks.get(i+1).isFree()) {
                                p.eating();
                                if(!p.isAte()) {
                                    System.out.println(" вилками " + forks.get(i).getNumber() + " и " + forks.get(i+1).getNumber());
                                    forks.get(i).setFree(false);
                                    forks.get(i+1).setFree(false);
                                    try {
                                        Thread.sleep(1000);
                                        forks.get(i).setFree(true);
                                        forks.get(i+1).setFree(true);
                                        System.out.println("Вилки " + forks.get(i).getNumber()+ " и " +
                                                forks.get(i+1).getNumber() + " свободны");
                                    }
                                    catch(InterruptedException e) {
                                        throw new RuntimeException();
                                    }
                                }
                            }
                        }
                        if(p.getNum() == 4 && (i == 0 || i == 4)) {
                            forks.get(0).setValid(true);
                            forks.get(4).setValid(true);
                            if(forks.get(0).isFree() && forks.get(4).isFree()) {
                                p.eating();
                                if(!p.isAte()) {
                                    System.out.println(" вилками " + forks.get(4).getNumber() + " и " + forks.get(0).getNumber());
                                    forks.get(i).setFree(false);
                                    forks.get(i+1).setFree(false);

                                    try {
                                        Thread.sleep(1000);
                                        forks.get(4).setFree(true);
                                        forks.get(0).setFree(true);
                                        System.out.println("Вилки " + forks.get(4).getNumber()+ " и " +
                                                forks.get(0).getNumber() + " свободны");
                                    }
                                    catch(InterruptedException e) {
                                        throw new RuntimeException();
                                    }
                                }

                            }
                        }
                    }

                }
            }

        }
    }
}

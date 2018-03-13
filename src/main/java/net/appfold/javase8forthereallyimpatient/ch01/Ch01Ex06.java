package net.appfold.javase8forthereallyimpatient.ch01;

public class Ch01Ex06 {

    @FunctionalInterface
    public interface RunnableEx {

        void run() throws Exception;
    }

    public static Runnable uncheck(RunnableEx runnableEx) {
        return runnableEx == null ? null : () -> {
            try {
                runnableEx.run();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    public static void main(String[] args) {
        new Thread(uncheck(() -> {
            System.out.println("Zzz");
            Thread.sleep(1000);
        })).start();
    }
}

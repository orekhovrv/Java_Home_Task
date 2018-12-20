package ExecutionManager;


public class ExecutionManagerTest {
    public static void main(String[] args) {

        Runnable callback = new Runnable() {
            @Override
            public void run() {
                System.out.println("callback");
            }
        };

        Runnable[] tasks = new Runnable[100];
        for (Integer i=0; i < 100; i++) {
            tasks[i] = new Runnable() {
                @Override
                public void run() {
                    //sleep(10);
                    System.out.println("task ");
//                    throw new RuntimeException();
                }
            };
        }


        ExecutionManager executionManager = new ExecutionManagerImpl();
        Context context = executionManager.execute(callback, tasks);
        sleep(500);
        context.interrupt();

        sleep(1000);
        System.out.println("context.getCompletedTaskCount() = " + context.getCompletedTaskCount());
        System.out.println("context.getFailedTaskCount() = " + context.getFailedTaskCount());
        System.out.println("context.getInterruptedTaskCount() = " + context.getInterruptedTaskCount());
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

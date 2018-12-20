package ExecutionManager;


import java.util.Collection;

public class CallbackThread extends Thread {
    private Runnable callback;
    private ContextImpl context;

    public CallbackThread(Runnable callback, ContextImpl context) {
        this.callback = callback;
        this.context = context;
    }

    @Override
    public void run() {
        // wait for all
        for(Thread taskThread : context.getThreads()) {
            try {
                taskThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        // run
        if(context.isFinished()) {
            try {
                callback.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}

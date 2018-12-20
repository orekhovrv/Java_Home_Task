package ExecutionManager;


public class TaskThread extends Thread {

    private Runnable task;
    private ContextImpl context;

    public TaskThread(Runnable task, ContextImpl context) {
        this.task = task;
        this.context = context;
    }

    @Override
    public void run() {
        if (!this.isInterrupted()) {
            try {
                task.run();
                context.incrementCompletedTaskCount();
            } catch (Exception e) {
                context.incrementFailedTaskCount();
            }
        } else {
            context.incrementInterruptedTaskCount();
        }
    }
}

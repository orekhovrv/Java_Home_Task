package ExecutionManager;


import java.util.ArrayList;
import java.util.Collection;

public class ContextImpl implements Context {

    private int completedTaskCount;
    private int failedTaskCount;
    private int interruptedTaskCount;
    private boolean finished;
    private Collection<Thread> threads;

    public ContextImpl() {
        this.completedTaskCount = 0;
        this.failedTaskCount = 0;
        this.interruptedTaskCount = 0;
        this.finished = false;
        this.threads = new ArrayList<>();
    }

    //возвращает количество тасков, которые на текущий момент успешно выполнились.
    @Override
    public int getCompletedTaskCount() { return completedTaskCount; }

    //возвращает количество тасков, при выполнении которых произошел Exception.
    @Override
    public int getFailedTaskCount() {
        return failedTaskCount;
    }

    // возвращает количество тасков, которые не были выполены из-за отмены (вызовом предыдущего метода).
    @Override
    public int getInterruptedTaskCount() {
        return interruptedTaskCount;
    }

    // отменяет выполнения тасков, которые еще не начали выполняться.
    @Override
    public void interrupt() {
        threads.forEach(Thread::interrupt);
    }

    // вернет true, если все таски были выполнены или отменены, false в противном случае.
    @Override
    public boolean isFinished() {
        return completedTaskCount + failedTaskCount + interruptedTaskCount == threads.size();
    }

    public void addThread(Thread thread) {
        threads.add(thread);
    }

    public Collection<Thread> getThreads() {
        return  threads;
    }

    public void incrementCompletedTaskCount() {
        completedTaskCount++;
    }

    public void incrementFailedTaskCount() {
        failedTaskCount++;
    }

    public void incrementInterruptedTaskCount() {
        interruptedTaskCount++;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

}

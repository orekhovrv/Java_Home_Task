package com.company.Task;

import java.util.concurrent.Callable;

public class TaskTest {
// thread.start() -> task.get() -> callable.call()

    public static void main(String[] args) {
        Callable<String> callable = new Callable<String>() {
            //callable.call()
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName() + " called");
                Thread.sleep(100);
                return "Результат";
            }
        };

        Task<String> task = new Task<>(callable);

        for (int i = 0; i < 100; i++) {
            //thread.start()
            Thread thread = new Thread(() -> {
                try {
                    System.out.println(task.get());
                } catch (CallableException e) {
                    e.printStackTrace();
                }
            });
            thread.setName(String.valueOf(i));
            thread.start();
        }
        }

}

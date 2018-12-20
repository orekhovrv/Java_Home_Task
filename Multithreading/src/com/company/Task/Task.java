package com.company.Task;

import java.util.concurrent.Callable;

public class Task<T> {

    private final Callable<? extends T> callable;
    private volatile T result;
    private volatile boolean calculated;
    CallableException exception;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
        calculated = false; // почему, если устанавливать не в конструкторе, то тогда он всегда false
    }


/*
    *Ваша задача реализовать метод get() который возвращает результат работы Callable.
    *Выполнение callable должен начинать тот поток, который первый вызвал метод get().
    *Если несколько потоков одновременно вызывают этот метод,
    то выполнение должно начаться только в одном потоке,
    а остальные должны ожидать конца выполнения (не нагружая процессор).
    *Если при вызове get() результат уже просчитан, то он должен вернуться сразу,
    (даже без задержек на вход в синхронизированную область).
    *Если при просчете результата произошел Exception, то всем потокам при вызове get(),
    * надо кидать этот Exception, обернутый в ваш RuntimeException (подходящее название своему ексепшену придумайте сами)
*/

    public T get() throws CallableException {
        if (!calculated) {
            try {
                result = tryCall();
            } catch (CallableException e) {
                exception = e;
            }
        }

        if (exception != null) {
            throw exception;
        }

        return result;
    }

    private synchronized T tryCall() throws CallableException {
        if (!calculated) {
            try {
                System.out.println("calculating...");
                T temp = callable.call();
                calculated = !calculated;
                return temp;
            } catch (Exception e) {
                throw new CallableException(e);
            }
        } else {
            return result;
        }
    }
}


package com.company.Task;


public class CallableException extends Throwable {

    Throwable throwable;

    public CallableException(Throwable e) {
        this.throwable = e;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}

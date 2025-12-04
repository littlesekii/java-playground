package com.littlesekii.playground.examples.dependencyInjection;;

public class NotificationService {

    private final INotifier notifier;

    public NotificationService(INotifier notifier) {
        this.notifier = notifier;
    }

    public void sendNotification(String msg) {
        notifier.send(msg);
    }
}

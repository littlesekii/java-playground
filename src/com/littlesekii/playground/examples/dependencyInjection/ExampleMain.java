package com.littlesekii.playground.examples.dependencyInjection;

public class ExampleMain {

    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService(new EmailNotifier());
        notificationService.sendNotification("Isso é trap!");

        NotificationService notificationService2 = new NotificationService(new SMSNotifier());
        notificationService2.sendNotification("Isso é trap!");

        NotificationService notificationService3 = new NotificationService(new PushNotifier());
        notificationService3.sendNotification("Isso é trap!");
    }

}

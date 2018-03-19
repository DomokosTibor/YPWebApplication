package com.codecool.web.service;

import com.codecool.web.model.Subscription;

public final class SubscriptionService {

    public Subscription subscribeSuccess() {
        return new Subscription("Subscribed successfully!");
    }

    public Subscription subscribeFailed() {
        return new Subscription("Subscribe Failed!");
    }

}

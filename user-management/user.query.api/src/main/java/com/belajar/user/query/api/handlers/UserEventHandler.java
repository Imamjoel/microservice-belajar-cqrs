package com.belajar.user.query.api.handlers;

import com.belajar.user.core.events.UserRegisteredEvent;
import com.belajar.user.core.events.UserRemovedEvent;
import com.belajar.user.core.events.UserUpdatedEvent;

public interface UserEventHandler {
    void on(UserRegisteredEvent event);
    void on(UserUpdatedEvent event);
    void on(UserRemovedEvent event);
}

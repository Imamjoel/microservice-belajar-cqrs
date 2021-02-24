package com.belajar.bankacc.query.api.handlers;

import com.belajar.bankacc.core.events.AccountClosedEvent;
import com.belajar.bankacc.core.events.AccountOpenedEvent;
import com.belajar.bankacc.core.events.FundWithDrawnEvent;
import com.belajar.bankacc.core.events.FundsDepositedEvent;

public interface AccountEventHandler {
    void on(AccountOpenedEvent event);
    void on(FundsDepositedEvent event);
    void on(FundWithDrawnEvent event);
    void on(AccountClosedEvent event);
}

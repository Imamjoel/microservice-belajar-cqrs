package com.belajar.bankacc.query.api.handlers;

import com.belajar.bankacc.core.events.AccountClosedEvent;
import com.belajar.bankacc.core.events.AccountOpenedEvent;
import com.belajar.bankacc.core.events.FundWithDrawnEvent;
import com.belajar.bankacc.core.events.FundsDepositedEvent;
import com.belajar.bankacc.core.models.BankAccount;
import com.belajar.bankacc.query.api.repositories.AccountRepository;
import lombok.var;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@ProcessingGroup("bankaccount-group")
public class AccountEventHandlerImpl implements AccountEventHandler {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountEventHandlerImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @EventHandler
    @Override
    public void on(AccountOpenedEvent event) {
        var bankAccount = BankAccount.builder()
                .id(event.getId())
                .accountHolderId(event.getAccountHolderId())
                .accountType(event.getAccountType())
                .createDate(event.getCreateDate())
                .balance(event.getOpeningBalance())
                .build();
        accountRepository.save(bankAccount);
    }

    @EventHandler
    @Override
    public void on(FundsDepositedEvent event) {
        var bankAccount = accountRepository.findById(event.getId());

        if (bankAccount.isPresent()) return;

        bankAccount.get().setBalance(event.getBalance());
        accountRepository.save(bankAccount.get());
    }

    @EventHandler
    @Override
    public void on(FundWithDrawnEvent event) {
        var bankAccount = accountRepository.findById(event.getId());

        if (bankAccount.isPresent()) return;

        bankAccount.get().setBalance(event.getBalance());
        accountRepository.save(bankAccount.get());
    }

    @EventHandler
    @Override
    public void on(AccountClosedEvent event) {
        accountRepository.deleteById(event.getId());
    }
}

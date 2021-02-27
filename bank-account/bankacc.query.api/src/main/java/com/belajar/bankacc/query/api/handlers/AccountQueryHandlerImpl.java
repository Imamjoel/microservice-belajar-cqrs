package com.belajar.bankacc.query.api.handlers;

import com.belajar.bankacc.core.models.BankAccount;
import com.belajar.bankacc.query.api.dto.AccountLookupResponse;
import com.belajar.bankacc.query.api.dto.EqualityType;
import com.belajar.bankacc.query.api.queries.FindAccountByIdQuery;
import com.belajar.bankacc.query.api.queries.FindAccountWithBalanceQuery;
import com.belajar.bankacc.query.api.queries.FindAcoountByHolderIdQuery;
import com.belajar.bankacc.query.api.queries.FindAllAccountQuery;
import com.belajar.bankacc.query.api.repositories.AccountRepository;
import lombok.var;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AccountQueryHandlerImpl implements AccountQueryHandle{
    private final AccountRepository accountRepository;

    @Autowired
    public AccountQueryHandlerImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @QueryHandler
    @Override
    public AccountLookupResponse findAccountById(FindAccountByIdQuery query) {
        var bankAccount = accountRepository.findById(query.getId());

        var response = bankAccount.isPresent()
                ? new AccountLookupResponse("Bank account successfully returned!", bankAccount.get())
                : new AccountLookupResponse("No bank account found for ID " + query.getId());

        return response;
    }

    @QueryHandler
    @Override
    public AccountLookupResponse findAccountByHolderId(FindAcoountByHolderIdQuery query) {
        var bankAccount = accountRepository.findById(query.getAccountHolderId());

        var response = bankAccount.isPresent()
                ? new AccountLookupResponse("Bank account successfully returned!", bankAccount.get())
                : new AccountLookupResponse("No bank account found for ID " + query.getAccountHolderId());

        return response;
    }

    @QueryHandler
    @Override
    public AccountLookupResponse findAllAccounts(FindAllAccountQuery query) {
        var bankAccountIter = accountRepository.findAll();

        if (!bankAccountIter.iterator().hasNext())
            return new AccountLookupResponse("no bank account were found");

        var bankAccounts = new ArrayList<BankAccount>();
        bankAccountIter.forEach(i -> bankAccounts.add(i));
        var count = bankAccounts.size();

        return new AccountLookupResponse("successfully returned " + count + "Bank account(s)!" + bankAccounts);
    }

    @QueryHandler
    @Override
    public AccountLookupResponse findAccountsWithBalance(FindAccountWithBalanceQuery query) {
        var bankAccounts = query.getEqualityType() == EqualityType.GREATER_THAN
                ? accountRepository.findByBalanceGreaterThan(query.getBalance())
                : accountRepository.findByBalanceLessThan(query.getBalance());

        var response = bankAccounts != null && bankAccounts.size() > 0
                ? new AccountLookupResponse("successfully returned " + bankAccounts.size() + " Bank account(s)!", bankAccounts)
                : new AccountLookupResponse("no bank account were found");

        return response;
    }
}

package com.belajar.bankacc.query.api.handlers;

import com.belajar.bankacc.query.api.dto.AccountLookupResponse;
import com.belajar.bankacc.query.api.queries.FindAccountByIdQuery;
import com.belajar.bankacc.query.api.queries.FindAccountWithBalanceQuery;
import com.belajar.bankacc.query.api.queries.FindAcoountByHolderIdQuery;
import com.belajar.bankacc.query.api.queries.FindAllAccountQuery;

public interface AccountQueryHandle {
    AccountLookupResponse findAccountById(FindAccountByIdQuery query);
    AccountLookupResponse findAccountByHolderId(FindAcoountByHolderIdQuery query);
    AccountLookupResponse findAllAccounts(FindAllAccountQuery query);
    AccountLookupResponse findAccountsWithBalance(FindAccountWithBalanceQuery query);

}

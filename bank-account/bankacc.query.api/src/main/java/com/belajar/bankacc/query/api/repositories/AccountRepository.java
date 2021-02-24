package com.belajar.bankacc.query.api.repositories;

import com.belajar.bankacc.core.models.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<BankAccount, String> {
}

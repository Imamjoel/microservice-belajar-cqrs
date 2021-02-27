package com.belajar.bankacc.query.api.queries;

import com.belajar.bankacc.query.api.dto.EqualityType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindAccountWithBalanceQuery {
    private EqualityType equalityType;
    private double balance;
}

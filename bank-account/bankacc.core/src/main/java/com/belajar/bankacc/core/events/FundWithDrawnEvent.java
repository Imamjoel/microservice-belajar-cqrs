package com.belajar.bankacc.core.events;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FundWithDrawnEvent {
    private String id;
    private double amount;
    private double balance;
}

package com.belajar.bankacc.cmd.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class WithDrawFundsCommand {
    @TargetAggregateIdentifier
    private String id;
    private double amount;
}
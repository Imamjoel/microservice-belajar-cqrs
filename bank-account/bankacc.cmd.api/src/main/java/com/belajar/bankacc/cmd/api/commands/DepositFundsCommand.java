package com.belajar.bankacc.cmd.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.Min;

@Data
@Builder
public class DepositFundsCommand {
    @TargetAggregateIdentifier
    private String id;

    @Min(value = 1, message = "the deposit account must be greather than")
    private double amount;
}

package com.belajar.bankacc.cmd.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.Min;

@Data
@Builder
public class WithDrawFundsCommand {
    @TargetAggregateIdentifier
    private String id;

    @Min(value = 1, message = "the withdrawal amount must be greater than 0.")
    private double amount;
}

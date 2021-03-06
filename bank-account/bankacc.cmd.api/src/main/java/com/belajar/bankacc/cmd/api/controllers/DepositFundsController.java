package com.belajar.bankacc.cmd.api.controllers;

import com.belajar.bankacc.cmd.api.commands.DepositFundsCommand;
import com.belajar.bankacc.core.dto.BaseResponse;
import lombok.var;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/depositFunds")
public class DepositFundsController {
    private final CommandGateway commandGateway;

    @Autowired
    public DepositFundsController(CommandGateway command) {
        this.commandGateway = command;
    }

    @PutMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    public ResponseEntity<BaseResponse> depositFunds(@PathVariable(value = "id") String id,
                                                     @Valid @RequestBody DepositFundsCommand command) {
        try {
            command.setId(id);
            commandGateway.send(command);

            return new ResponseEntity<>(new BaseResponse("funds successfully deposited"), HttpStatus.OK);
        } catch (Exception e) {
            var safeError = "error while proccessing to deposit fund into bank account for id - " + id;
            return new ResponseEntity<>(new BaseResponse(safeError), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

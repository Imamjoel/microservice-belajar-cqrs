package com.belajar.bankacc.cmd.api.controllers;

import com.belajar.bankacc.cmd.api.commands.CloseAccountCommand;
import com.belajar.bankacc.core.dto.BaseResponse;
import lombok.var;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/closeBankAccount")
public class CloseAccountController {
    private final CommandGateway commandGateway;

    @Autowired
    public CloseAccountController(CommandGateway command) {
        this.commandGateway = command;
    }

    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    public ResponseEntity<BaseResponse> closeAccount(@PathVariable("id") String id) {
        try {
            var command = CloseAccountCommand.builder()
                    .id(id)
                    .build();
            commandGateway.send(command);

            return new ResponseEntity<>(new BaseResponse("bank account successfully close"), HttpStatus.OK);
        } catch (Exception e) {
            var safeError = "error while proccessing to close bank account for id - " + id;
            return new ResponseEntity<>(new BaseResponse(safeError), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

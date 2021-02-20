package com.belajar.user.cmd.api.controllers;

import com.belajar.user.cmd.api.commands.RegisterUserCommand;
import com.belajar.user.cmd.api.commands.RemoveUserCommand;
import com.belajar.user.cmd.api.commands.UpdateUserCommand;
import com.belajar.user.cmd.api.dto.RegisterUserResponse;
import com.belajar.user.core.dto.BaseResponse;
import lombok.var;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/removeUser")
public class RemoveUserController {
    private final CommandGateway commandGateway;

    @Autowired
    public RemoveUserController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

   @DeleteMapping
    public ResponseEntity<BaseResponse> removeUser(@PathVariable(value = "id") String id) {
        try {
            commandGateway.send(new RemoveUserCommand(id));
            return new ResponseEntity<>(new BaseResponse("user success remove!"), HttpStatus.OK);
        } catch (Exception e) {
            var safeErrorMessage = "Error while proccessing remove user request for id - " + id;
            return  new ResponseEntity<>(new BaseResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
   }
}
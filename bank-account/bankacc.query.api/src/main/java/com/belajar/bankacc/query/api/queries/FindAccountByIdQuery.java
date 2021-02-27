package com.belajar.bankacc.query.api.queries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindAccountByIdQuery {
    private String id;
}

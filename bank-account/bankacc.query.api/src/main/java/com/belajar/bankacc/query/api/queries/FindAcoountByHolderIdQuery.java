package com.belajar.bankacc.query.api.queries;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FindAcoountByHolderIdQuery {
    private String accountHolderId;
}

package com.belajar.bankacc.cmd.api.dto;

import com.belajar.bankacc.core.dto.BaseResponse;

public class OpenAccountResponse extends BaseResponse {
    private String id;

    public OpenAccountResponse(String id, String meesage) {
        super(meesage);
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}

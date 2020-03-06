package com.wd.health.model.bean;

import java.io.Serializable;

public class CollectBean implements Serializable {
    private String status;
    private String Message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}

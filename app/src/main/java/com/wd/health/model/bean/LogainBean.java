package com.wd.health.model.bean;

import java.io.Serializable;

public class LogainBean implements Serializable {
    private String status;
    private String message;
    private LogainBeanResultBean result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LogainBeanResultBean getResult() {
        return result;
    }

    public void setResult(LogainBeanResultBean result) {
        this.result = result;
    }
}

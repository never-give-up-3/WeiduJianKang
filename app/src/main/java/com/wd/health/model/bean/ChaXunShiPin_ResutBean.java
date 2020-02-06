package com.wd.health.model.bean;

import java.io.Serializable;
import java.util.List;

public class ChaXunShiPin_ResutBean implements Serializable {
    private String message;
    private String status;
    private List<ChaXunShiPin_DataBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ChaXunShiPin_DataBean> getResult() {
        return result;
    }

    public void setResult(List<ChaXunShiPin_DataBean> result) {
        this.result = result;
    }
}

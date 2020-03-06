package com.wd.health.model.bean;

import java.io.Serializable;

public class VideoCommentList implements Serializable {
    private String status;
    private String message;
    private VideoCommentListResult result;

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

    public VideoCommentListResult getResult() {
        return result;
    }

    public void setResult(VideoCommentListResult result) {
        this.result = result;
    }
}

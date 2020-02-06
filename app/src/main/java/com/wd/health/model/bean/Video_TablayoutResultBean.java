package com.wd.health.model.bean;

import java.io.Serializable;
import java.util.List;

public class Video_TablayoutResultBean implements Serializable {

    /**
     * result : [{"id":1,"name":"儿科"},{"id":2,"name":"常识"},{"id":3,"name":"健身"},{"id":4,"name":"美容"},{"id":5,"name":"心理"},{"id":6,"name":"养生"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<Video_TablayoutDataBean> result;

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

    public List<Video_TablayoutDataBean> getResult() {
        return result;
    }

    public void setResult(List<Video_TablayoutDataBean> result) {
        this.result = result;
    }
}

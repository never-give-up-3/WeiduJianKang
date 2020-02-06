package com.wd.health.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: WDHealth
 * @Package: com.wd.health.model.bean
 * @ClassName: SickCircleListBean
 * @Description: java类作用描述
 * @Author: jialiang
 * @CreateDate: 2020/1/8 14:39
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/8 14:39
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SickCircleListBean implements Serializable {

    /**
     * result : [{"amount":0,"collectionNum":0,"commentNum":3,"detail":"11111","releaseTime":1576598400000,"sickCircleId":1797,"title":"1111111"},{"amount":0,"collectionNum":0,"commentNum":11,"detail":"123456","releaseTime":1576598400000,"sickCircleId":1795,"title":"♥"},{"amount":0,"collectionNum":0,"commentNum":8,"detail":"ZZZZZZZZ","releaseTime":1576512000000,"sickCircleId":1785,"title":"在ZZZZZZZZ"},{"amount":0,"collectionNum":0,"commentNum":2,"detail":"--------","releaseTime":1576512000000,"sickCircleId":1783,"title":"******------"},{"amount":0,"collectionNum":0,"commentNum":2,"detail":"····","releaseTime":1576512000000,"sickCircleId":1750,"title":"·······"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * amount : 0
         * collectionNum : 0
         * commentNum : 3
         * detail : 11111
         * releaseTime : 1576598400000
         * sickCircleId : 1797
         * title : 1111111
         */

        private int amount;
        private int collectionNum;
        private int commentNum;
        private String detail;
        private long releaseTime;
        private int sickCircleId;
        private String title;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getCollectionNum() {
            return collectionNum;
        }

        public void setCollectionNum(int collectionNum) {
            this.collectionNum = collectionNum;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public int getSickCircleId() {
            return sickCircleId;
        }

        public void setSickCircleId(int sickCircleId) {
            this.sickCircleId = sickCircleId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}

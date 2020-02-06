package com.wd.health.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: WDHealth
 * @Package: com.wd.health.model.bean
 * @ClassName: HealthlectureBean
 * @Description: java类作用描述
 * @Author: jialiang
 * @CreateDate: 2020/1/8 14:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/8 14:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HealthlectureBean implements Serializable {

    /**
     * result : [{"id":1,"name":"儿科"},{"id":2,"name":"常识"},{"id":3,"name":"健身"},{"id":4,"name":"美容"},{"id":5,"name":"心理"},{"id":6,"name":"养生"}]
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
         * id : 1
         * name : 儿科
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

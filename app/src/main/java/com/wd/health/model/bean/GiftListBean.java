package com.wd.health.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: WDHealth
 * @Package: com.wd.health.model.bean
 * @ClassName: GiftListBean
 * @Description: java类作用描述
 * @Author: jialiang
 * @CreateDate: 2020/1/8 14:32
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/8 14:32
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class GiftListBean implements Serializable {

    /**
     * result : [{"id":1001,"meaning":"鲜花是一种认可","name":"鲜花","pic":"http://172.17.8.100/images/health/gift/gift1.jpg","worth":20},{"id":1002,"meaning":"证书是一种象征","name":"证书","pic":"http://172.17.8.100/images/health/gift/gift2.jpg","worth":50},{"id":1003,"meaning":"奖杯是一种荣誉","name":"奖杯","pic":"http://172.17.8.100/images/health/gift/gift3.jpg","worth":100}]
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
         * id : 1001
         * meaning : 鲜花是一种认可
         * name : 鲜花
         * pic : http://172.17.8.100/images/health/gift/gift1.jpg
         * worth : 20
         */

        private int id;
        private String meaning;
        private String name;
        private String pic;
        private int worth;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMeaning() {
            return meaning;
        }

        public void setMeaning(String meaning) {
            this.meaning = meaning;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getWorth() {
            return worth;
        }

        public void setWorth(int worth) {
            this.worth = worth;
        }
    }
}

package com.jiyun.zhibo.model.entify;

import java.util.List;

public class MoneyDataBean {

    /**
     * msg : 操作成功
     * ext :
     * code : 200
     * data : {"totalRow":6,"pageNumber":1,"firstPage":true,"lastPage":true,"totalPage":1,"pageSize":10,"list":[{"price":1,"vcNo":1,"id":1,"vc":1,"giveVc":0},{"price":60,"vcNo":2,"id":2,"vc":60,"giveVc":6},{"price":100,"vcNo":3,"id":3,"vc":120,"giveVc":10},{"price":500,"vcNo":4,"id":4,"vc":800,"giveVc":20},{"price":1000,"vcNo":5,"id":5,"vc":1500,"giveVc":30},{"price":2000,"vcNo":6,"id":6,"vc":2000,"giveVc":200}]}
     */

    private String msg;
    private String ext;
    private String code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * totalRow : 6
         * pageNumber : 1
         * firstPage : true
         * lastPage : true
         * totalPage : 1
         * pageSize : 10
         * list : [{"price":1,"vcNo":1,"id":1,"vc":1,"giveVc":0},{"price":60,"vcNo":2,"id":2,"vc":60,"giveVc":6},{"price":100,"vcNo":3,"id":3,"vc":120,"giveVc":10},{"price":500,"vcNo":4,"id":4,"vc":800,"giveVc":20},{"price":1000,"vcNo":5,"id":5,"vc":1500,"giveVc":30},{"price":2000,"vcNo":6,"id":6,"vc":2000,"giveVc":200}]
         */

        private int totalRow;
        private int pageNumber;
        private boolean firstPage;
        private boolean lastPage;
        private int totalPage;
        private int pageSize;
        private List<ListBean> list;

        public int getTotalRow() {
            return totalRow;
        }

        public void setTotalRow(int totalRow) {
            this.totalRow = totalRow;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public boolean isFirstPage() {
            return firstPage;
        }

        public void setFirstPage(boolean firstPage) {
            this.firstPage = firstPage;
        }

        public boolean isLastPage() {
            return lastPage;
        }

        public void setLastPage(boolean lastPage) {
            this.lastPage = lastPage;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * price : 1
             * vcNo : 1
             * id : 1
             * vc : 1
             * giveVc : 0
             */

            private int price;
            private int vcNo;
            private int id;
            private int vc;
            private int giveVc;

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getVcNo() {
                return vcNo;
            }

            public void setVcNo(int vcNo) {
                this.vcNo = vcNo;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getVc() {
                return vc;
            }

            public void setVc(int vc) {
                this.vc = vc;
            }

            public int getGiveVc() {
                return giveVc;
            }

            public void setGiveVc(int giveVc) {
                this.giveVc = giveVc;
            }
        }
    }
}

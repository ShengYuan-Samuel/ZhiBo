package com.jiyun.zhibo.model.entify;

import java.util.List;

public class LunBoBeans {

    /**
     * ext :
     * msg : 操作成功
     * code : 200
     * data : {"ext":"","msg":"操作成功","code":"200","data":{"totalRow":2,"pageNumber":1,"firstPage":true,"lastPage":true,"totalPage":1,"pageSize":10,"list":[{"adName":"banner0","adPic":"http://hongdou.oss-cn-beijing.aliyuncs.com/banner1","adType":0,"adUrl":"http://www.baidu.com/a.html","id":1},{"adName":"wenminggongyue","adPic":"http://hongdou.oss-cn-beijing.aliyuncs.com/wenminggongyue","adType":0,"adUrl":"http://www.baidu.com/a.html","id":2}]}}
     */

    private String ext;
    private String msg;
    private String code;
    private DataBeanX data;

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * ext :
         * msg : 操作成功
         * code : 200
         * data : {"totalRow":2,"pageNumber":1,"firstPage":true,"lastPage":true,"totalPage":1,"pageSize":10,"list":[{"adName":"banner0","adPic":"http://hongdou.oss-cn-beijing.aliyuncs.com/banner1","adType":0,"adUrl":"http://www.baidu.com/a.html","id":1},{"adName":"wenminggongyue","adPic":"http://hongdou.oss-cn-beijing.aliyuncs.com/wenminggongyue","adType":0,"adUrl":"http://www.baidu.com/a.html","id":2}]}
         */

        private String ext;
        private String msg;
        private String code;
        private DataBean data;

        public String getExt() {
            return ext;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
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
             * totalRow : 2
             * pageNumber : 1
             * firstPage : true
             * lastPage : true
             * totalPage : 1
             * pageSize : 10
             * list : [{"adName":"banner0","adPic":"http://hongdou.oss-cn-beijing.aliyuncs.com/banner1","adType":0,"adUrl":"http://www.baidu.com/a.html","id":1},{"adName":"wenminggongyue","adPic":"http://hongdou.oss-cn-beijing.aliyuncs.com/wenminggongyue","adType":0,"adUrl":"http://www.baidu.com/a.html","id":2}]
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
                 * adName : banner0
                 * adPic : http://hongdou.oss-cn-beijing.aliyuncs.com/banner1
                 * adType : 0
                 * adUrl : http://www.baidu.com/a.html
                 * id : 1
                 */

                private String adName;
                private String adPic;
                private int adType;
                private String adUrl;
                private int id;

                public String getAdName() {
                    return adName;
                }

                public void setAdName(String adName) {
                    this.adName = adName;
                }

                public String getAdPic() {
                    return adPic;
                }

                public void setAdPic(String adPic) {
                    this.adPic = adPic;
                }

                public int getAdType() {
                    return adType;
                }

                public void setAdType(int adType) {
                    this.adType = adType;
                }

                public String getAdUrl() {
                    return adUrl;
                }

                public void setAdUrl(String adUrl) {
                    this.adUrl = adUrl;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }
            }
        }
    }
}

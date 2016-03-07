package com.yyj.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 草帽儿 on 2016/2/22.
 */
public class Jokes {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"allNum":22257,"allPages":2226,"contentlist":[{"ct":"2016-02-22 12:31:44.578","img":"http://img0.hao123.com/data/3_68c4095542c454d4596584b966f3e962_0","title":"再输可就真的要出事了","type":2},{"ct":"2016-02-22 12:31:44.532","img":"http://img0.hao123.com/data/3_8d50cad401e65d46299479ddc846c2d0_430","title":"颤抖吧，此刻的肯尼迪机场","type":2},{"ct":"2016-02-22 12:00:24.574","img":"http://img.hao123.com/data/3_41d7c62ca45d0f1202b0fe5565987d4f_430","title":"妹子这样洗电脑真的行吗","type":2},{"ct":"2016-02-22 12:00:24.551","img":"http://img4.hao123.com/data/3_72d4642492735c2e8157c3f7fc7ca819_430","title":"大爷你几个意思","type":2},{"ct":"2016-02-22 11:32:19.514","img":"http://img1.hao123.com/data/3_9f6a80751325e07f8d3643ae1cc9c75f_430","title":"出门忘带钥匙只好翻进去","type":2},{"ct":"2016-02-22 11:32:19.504","img":"http://img6.hao123.com/data/3_aa4ff665d8e7fae765b2755722868c56_0","title":"这是传说中的\u201c老婆饼\u201d吗？","type":2},{"ct":"2016-02-22 11:32:19.503","img":"http://img4.hao123.com/data/3_34fd3ac63b730ab64733f809fc1fa134_0","title":"这不是用来洗脚的吧","type":2},{"ct":"2016-02-22 11:00:23.632","img":"http://img.hao123.com/data/3_bbc9d92608dcb1216c3b6689316aeab7_0","title":"看了把持不住啊","type":2},{"ct":"2016-02-22 11:00:23.627","img":"http://img6.hao123.com/data/3_3e1dd1c85ee75bbf03731869f1bb9226_430","title":"这是什么活动，我也好想参加！","type":2},{"ct":"2016-02-21 15:30:45.803","img":"http://img5.hao123.com/data/3_cf495f5b5acc9bb493228cfb3942c56c_430","title":"挺起来吧！咪咪兔！","type":2}],"currentPage":1,"maxResult":10,"ret_code":0}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    /**
     * allNum : 22257
     * allPages : 2226
     * contentlist : [{"ct":"2016-02-22 12:31:44.578","img":"http://img0.hao123.com/data/3_68c4095542c454d4596584b966f3e962_0","title":"再输可就真的要出事了","type":2},{"ct":"2016-02-22 12:31:44.532","img":"http://img0.hao123.com/data/3_8d50cad401e65d46299479ddc846c2d0_430","title":"颤抖吧，此刻的肯尼迪机场","type":2},{"ct":"2016-02-22 12:00:24.574","img":"http://img.hao123.com/data/3_41d7c62ca45d0f1202b0fe5565987d4f_430","title":"妹子这样洗电脑真的行吗","type":2},{"ct":"2016-02-22 12:00:24.551","img":"http://img4.hao123.com/data/3_72d4642492735c2e8157c3f7fc7ca819_430","title":"大爷你几个意思","type":2},{"ct":"2016-02-22 11:32:19.514","img":"http://img1.hao123.com/data/3_9f6a80751325e07f8d3643ae1cc9c75f_430","title":"出门忘带钥匙只好翻进去","type":2},{"ct":"2016-02-22 11:32:19.504","img":"http://img6.hao123.com/data/3_aa4ff665d8e7fae765b2755722868c56_0","title":"这是传说中的\u201c老婆饼\u201d吗？","type":2},{"ct":"2016-02-22 11:32:19.503","img":"http://img4.hao123.com/data/3_34fd3ac63b730ab64733f809fc1fa134_0","title":"这不是用来洗脚的吧","type":2},{"ct":"2016-02-22 11:00:23.632","img":"http://img.hao123.com/data/3_bbc9d92608dcb1216c3b6689316aeab7_0","title":"看了把持不住啊","type":2},{"ct":"2016-02-22 11:00:23.627","img":"http://img6.hao123.com/data/3_3e1dd1c85ee75bbf03731869f1bb9226_430","title":"这是什么活动，我也好想参加！","type":2},{"ct":"2016-02-21 15:30:45.803","img":"http://img5.hao123.com/data/3_cf495f5b5acc9bb493228cfb3942c56c_430","title":"挺起来吧！咪咪兔！","type":2}]
     * currentPage : 1
     * maxResult : 10
     * ret_code : 0
     */

    private ShowapiResBodyEntity showapi_res_body;

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public void setShowapi_res_body(ShowapiResBodyEntity showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public ShowapiResBodyEntity getShowapi_res_body() {
        return showapi_res_body;
    }

    public static class ShowapiResBodyEntity {
        private int allNum;
        private int allPages;
        private int currentPage;
        private int maxResult;
        private int ret_code;
        /**
         * ct : 2016-02-22 12:31:44.578
         * img : http://img0.hao123.com/data/3_68c4095542c454d4596584b966f3e962_0
         * title : 再输可就真的要出事了
         * type : 2
         */

        private ArrayList<ContentlistEntity> contentlist;

        public void setAllNum(int allNum) {
            this.allNum = allNum;
        }

        public void setAllPages(int allPages) {
            this.allPages = allPages;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public void setMaxResult(int maxResult) {
            this.maxResult = maxResult;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public void setContentlist(ArrayList<ContentlistEntity> contentlist) {
            this.contentlist = contentlist;
        }

        public int getAllNum() {
            return allNum;
        }

        public int getAllPages() {
            return allPages;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public int getMaxResult() {
            return maxResult;
        }

        public int getRet_code() {
            return ret_code;
        }

        public ArrayList<ContentlistEntity> getContentlist() {
            return contentlist;
        }

        public static class ContentlistEntity {
            private String ct;
            private String img;
            private String title;
            private int type;

            public void setCt(String ct) {
                this.ct = ct;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getCt() {
                return ct;
            }

            public String getImg() {
                return img;
            }

            public String getTitle() {
                return title;
            }

            public int getType() {
                return type;
            }
        }
    }

    @Override
    public String toString() {
        return "Jokes{" +
                "showapi_res_code=" + showapi_res_code +
                ", showapi_res_error='" + showapi_res_error + '\'' +
                ", showapi_res_body=" + showapi_res_body +
                '}';
    }
}

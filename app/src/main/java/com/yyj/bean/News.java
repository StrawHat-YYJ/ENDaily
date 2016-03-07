package com.yyj.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 草帽儿 on 2016/2/17.
 */
public class News {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"code":200,"msg":"ok","newslist":[{"ctime":"1970-01-01 08:00","description":"孙杨吐槽深夜遭突击尿检 里约他恐经历七关药检...","picUrl":"http://d.ifengimg.com/w145_h103/y3.ifengimg.com/cmpp/2016/02/18/ac0df79bae1615a662eb16e8d613757b_size77_w580_h200.jpg","title":"孙杨吐槽深夜遭突击尿检 里约他恐经历七关药检","url":"http://sports.ifeng.com/a/20160218/47473350_0.shtml"},{"ctime":"2016-02-18 07:04","description":"青冬奥中国夺雪上首金 冬季两项接力两小将爆冷夺冠...","picUrl":"http://d.ifengimg.com/w145_h103/y0.ifengimg.com/cmpp/2016/02/18/c6fd2880e79691190c8e421186567e51_size325_w500_h350.jpg","title":"青冬奥中国夺雪上首金 冬季两项接力两小将爆冷夺冠","url":"http://sports.ifeng.com/a/20160218/47474028_0.shtml"},{"ctime":"1970-01-01 08:00","description":"丁俊晖轰单杆126分4-3险胜 进威尔士赛16强碰新星...","picUrl":"http://d.ifengimg.com/w145_h103/y2.ifengimg.com/cmpp/2016/02/18/9e0db3f5f451e37fb311e7cee7d92881_size219_w500_h350.jpg","title":"丁俊晖轰单杆126分4-3险胜 进威尔士赛16强碰新星","url":"http://sports.ifeng.com/a/20160218/47474262_0.shtml"},{"ctime":"1970-01-01 08:00","description":"梁文博出局中国3人进威尔士赛16强 于德陆将战火箭...","picUrl":"http://d.ifengimg.com/w145_h103/y0.ifengimg.com/cmpp/2016/02/18/5b41738ab50b7f8d04637a1cf2a2743f_size275_w500_h320.jpg","title":"梁文博出局中国3人进威尔士赛16强 于德陆将战火箭","url":"http://sports.ifeng.com/a/20160218/47474360_0.shtml"},{"ctime":"2016-02-18 07:11","description":"周杰伦进军电竞圈！有望成立电竞公司持千万股份...","picUrl":"http://d.ifengimg.com/w145_h103/y0.ifengimg.com/cmpp/2016/02/18/c081295a2eca6aba315fbaaa6658042c_size278_w500_h350.jpg","title":"周杰伦进军电竞圈！有望成立电竞公司持千万股份","url":"http://sports.ifeng.com/a/20160218/47474581_0.shtml"},{"ctime":"1970-01-01 08:00","description":"张继科透露已恢复九成水平 直言2016挑战与机遇并存...","picUrl":"http://d.ifengimg.com/w145_h103/y0.ifengimg.com/cmpp/2016/02/18/4ced4f0fd49cfb4b2b6b27de5536271b_size363_w370_h500.jpg","title":"张继科透露已恢复九成水平 直言2016挑战与机遇并存","url":"http://sports.ifeng.com/a/20160218/47474675_0.shtml"},{"ctime":"1970-01-01 08:00","description":"穆雷岳父澳网晕倒原因曝光：连吃十天寿司导致过敏...","picUrl":"http://d.ifengimg.com/w145_h103/y3.ifengimg.com/cmpp/2016/02/18/7835fae16a5edaa05d3a003d5246541b_size325_w500_h300.jpg","title":"穆雷岳父澳网晕倒原因曝光：连吃十天寿司导致过敏","url":"http://sports.ifeng.com/a/20160218/47474834_0.shtml"},{"ctime":"2016-02-18 07:51","description":"青冬奥会中国再添两金 速滑跨国团体赛沈晗扬夺冠...","picUrl":"http://d.ifengimg.com/w145_h103/y1.ifengimg.com/cmpp/2016/02/18/917d2d7703b0b1b8458b7b619893f59a_size254_w300_h500.jpg","title":"青冬奥会中国再添两金 速滑跨国团体赛沈晗扬夺冠","url":"http://sports.ifeng.com/a/20160218/47475183_0.shtml"},{"ctime":"1970-01-01 08:00","description":"肖国栋羡慕奥沙利文随性：他活在自己的世界里...","picUrl":"http://d.ifengimg.com/w145_h103/y1.ifengimg.com/a/2016_08/8dcf424421cb414.jpg","title":"肖国栋羡慕奥沙利文随性：他活在自己的世界里","url":"http://sports.ifeng.com/a/20160217/47461203_0.shtml"},{"ctime":"2016-02-17 10:38","description":"李世石自信人机大战能取胜 直言不会进行针对性练习...","picUrl":"http://d.ifengimg.com/w145_h103/y1.ifengimg.com/a/2016_08/58025ce1f941836.jpg","title":"李世石自信人机大战能取胜 直言不会进行针对性练习","url":"http://sports.ifeng.com/a/20160217/47461436_0.shtml"}]}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    /**
     * code : 200
     * msg : ok
     * newslist : [{"ctime":"1970-01-01 08:00","description":"孙杨吐槽深夜遭突击尿检 里约他恐经历七关药检...","picUrl":"http://d.ifengimg.com/w145_h103/y3.ifengimg.com/cmpp/2016/02/18/ac0df79bae1615a662eb16e8d613757b_size77_w580_h200.jpg","title":"孙杨吐槽深夜遭突击尿检 里约他恐经历七关药检","url":"http://sports.ifeng.com/a/20160218/47473350_0.shtml"},{"ctime":"2016-02-18 07:04","description":"青冬奥中国夺雪上首金 冬季两项接力两小将爆冷夺冠...","picUrl":"http://d.ifengimg.com/w145_h103/y0.ifengimg.com/cmpp/2016/02/18/c6fd2880e79691190c8e421186567e51_size325_w500_h350.jpg","title":"青冬奥中国夺雪上首金 冬季两项接力两小将爆冷夺冠","url":"http://sports.ifeng.com/a/20160218/47474028_0.shtml"},{"ctime":"1970-01-01 08:00","description":"丁俊晖轰单杆126分4-3险胜 进威尔士赛16强碰新星...","picUrl":"http://d.ifengimg.com/w145_h103/y2.ifengimg.com/cmpp/2016/02/18/9e0db3f5f451e37fb311e7cee7d92881_size219_w500_h350.jpg","title":"丁俊晖轰单杆126分4-3险胜 进威尔士赛16强碰新星","url":"http://sports.ifeng.com/a/20160218/47474262_0.shtml"},{"ctime":"1970-01-01 08:00","description":"梁文博出局中国3人进威尔士赛16强 于德陆将战火箭...","picUrl":"http://d.ifengimg.com/w145_h103/y0.ifengimg.com/cmpp/2016/02/18/5b41738ab50b7f8d04637a1cf2a2743f_size275_w500_h320.jpg","title":"梁文博出局中国3人进威尔士赛16强 于德陆将战火箭","url":"http://sports.ifeng.com/a/20160218/47474360_0.shtml"},{"ctime":"2016-02-18 07:11","description":"周杰伦进军电竞圈！有望成立电竞公司持千万股份...","picUrl":"http://d.ifengimg.com/w145_h103/y0.ifengimg.com/cmpp/2016/02/18/c081295a2eca6aba315fbaaa6658042c_size278_w500_h350.jpg","title":"周杰伦进军电竞圈！有望成立电竞公司持千万股份","url":"http://sports.ifeng.com/a/20160218/47474581_0.shtml"},{"ctime":"1970-01-01 08:00","description":"张继科透露已恢复九成水平 直言2016挑战与机遇并存...","picUrl":"http://d.ifengimg.com/w145_h103/y0.ifengimg.com/cmpp/2016/02/18/4ced4f0fd49cfb4b2b6b27de5536271b_size363_w370_h500.jpg","title":"张继科透露已恢复九成水平 直言2016挑战与机遇并存","url":"http://sports.ifeng.com/a/20160218/47474675_0.shtml"},{"ctime":"1970-01-01 08:00","description":"穆雷岳父澳网晕倒原因曝光：连吃十天寿司导致过敏...","picUrl":"http://d.ifengimg.com/w145_h103/y3.ifengimg.com/cmpp/2016/02/18/7835fae16a5edaa05d3a003d5246541b_size325_w500_h300.jpg","title":"穆雷岳父澳网晕倒原因曝光：连吃十天寿司导致过敏","url":"http://sports.ifeng.com/a/20160218/47474834_0.shtml"},{"ctime":"2016-02-18 07:51","description":"青冬奥会中国再添两金 速滑跨国团体赛沈晗扬夺冠...","picUrl":"http://d.ifengimg.com/w145_h103/y1.ifengimg.com/cmpp/2016/02/18/917d2d7703b0b1b8458b7b619893f59a_size254_w300_h500.jpg","title":"青冬奥会中国再添两金 速滑跨国团体赛沈晗扬夺冠","url":"http://sports.ifeng.com/a/20160218/47475183_0.shtml"},{"ctime":"1970-01-01 08:00","description":"肖国栋羡慕奥沙利文随性：他活在自己的世界里...","picUrl":"http://d.ifengimg.com/w145_h103/y1.ifengimg.com/a/2016_08/8dcf424421cb414.jpg","title":"肖国栋羡慕奥沙利文随性：他活在自己的世界里","url":"http://sports.ifeng.com/a/20160217/47461203_0.shtml"},{"ctime":"2016-02-17 10:38","description":"李世石自信人机大战能取胜 直言不会进行针对性练习...","picUrl":"http://d.ifengimg.com/w145_h103/y1.ifengimg.com/a/2016_08/58025ce1f941836.jpg","title":"李世石自信人机大战能取胜 直言不会进行针对性练习","url":"http://sports.ifeng.com/a/20160217/47461436_0.shtml"}]
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
        private int code;
        private String msg;
        /**
         * ctime : 1970-01-01 08:00
         * description : 孙杨吐槽深夜遭突击尿检 里约他恐经历七关药检...
         * picUrl : http://d.ifengimg.com/w145_h103/y3.ifengimg.com/cmpp/2016/02/18/ac0df79bae1615a662eb16e8d613757b_size77_w580_h200.jpg
         * title : 孙杨吐槽深夜遭突击尿检 里约他恐经历七关药检
         * url : http://sports.ifeng.com/a/20160218/47473350_0.shtml
         */

        private ArrayList<NewslistEntity> newslist;

        public void setCode(int code) {
            this.code = code;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public void setNewslist(ArrayList<NewslistEntity> newslist) {
            this.newslist = newslist;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }

        public ArrayList<NewslistEntity> getNewslist() {
            return newslist;
        }

        public static class NewslistEntity {
            private String ctime;
            private String description;
            private String picUrl;
            private String title;
            private String url;

            public void setCtime(String ctime) {
                this.ctime = ctime;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCtime() {
                return ctime;
            }

            public String getDescription() {
                return description;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public String getTitle() {
                return title;
            }

            public String getUrl() {
                return url;
            }
        }


    }

    @Override
    public String toString() {
        return "News{" +
                "showapi_res_code=" + showapi_res_code +
                ", showapi_res_error='" + showapi_res_error + '\'' +
                ", showapi_res_body=" + showapi_res_body +
                '}';
    }
}

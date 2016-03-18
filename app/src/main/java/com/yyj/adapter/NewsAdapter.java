package com.yyj.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.endaily.BaseApplication;
import com.example.administrator.endaily.R;
import com.yyj.ConfigConstant.NewsItemType;
import com.yyj.bean.News;
import com.yyj.utils.netUtil.HttpVolley;

import java.util.ArrayList;

/**
 * Created by 草帽儿 on 2016/2/17.
 */
public class NewsAdapter extends BaseAdapter{
    private ArrayList<News.ShowapiResBodyEntity.NewslistEntity> list;
    private Context context;
    private int itemTypeCount=2;
    private Animation animation;
    //是否为无图模式，默认为否。
    private boolean isNoImage;
    public NewsAdapter(Context context,
                       ArrayList<News.ShowapiResBodyEntity.NewslistEntity>list,
                       boolean isNoImage){
        this.context=context;
        this.list=list;
        this.isNoImage = isNoImage;
        animation=new AlphaAnimation(0.0f,1.0f);
        animation.setDuration(300);
    }

    public boolean isNoImage() {
        return isNoImage;
    }

    public void setIsNoImage(boolean isNoImage) {
        this.isNoImage = isNoImage;
    }

    @Override
    public int getCount() {

        return list!=null?list.size():0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return itemTypeCount;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0) {
            return NewsItemType.type_firstItem;
        }
        return NewsItemType.type_otherItem;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       final News.ShowapiResBodyEntity.NewslistEntity news=list.get(position);
        ViewHolder viewHolder;
        int itemType=getItemViewType(position);
        switch (itemType){
            case NewsItemType.type_otherItem:
                if (convertView==null) {
                    viewHolder= new ViewHolder();
                    convertView=View.inflate(context, R.layout.layout_news_item,null);
                    viewHolder.title= (TextView) convertView.findViewById(R.id.news_title);
                    viewHolder.description= (TextView) convertView.findViewById(R.id.news_des);
                    viewHolder.imageview= (ImageView) convertView.findViewById(R.id.news_img);
                    viewHolder.ctime= (TextView) convertView.findViewById(R.id.news_ctime);
                    convertView.setTag(viewHolder);
                }else {
                    viewHolder= (ViewHolder) convertView.getTag();
                }
            case NewsItemType.type_firstItem:
                if (convertView==null) {
                    viewHolder= new ViewHolder();
                    convertView=View.inflate(context, R.layout.layout_news_firstitem,null);
                    viewHolder.title= (TextView) convertView.findViewById(R.id.news_firstItemtitle);
                    viewHolder.description= (TextView) convertView.findViewById(R.id.news_firstItemdes);
                    viewHolder.imageview= (ImageView) convertView.findViewById(R.id.news_firstItemIv);
                    viewHolder.ctime= (TextView) convertView.findViewById(R.id.news_firstItemctime);
                    convertView.setTag(viewHolder);
                }else {
                    viewHolder= (ViewHolder) convertView.getTag();
                }
                if (news!=null) {
                    viewHolder.title.setText(news.getTitle());
                    viewHolder.ctime.setText(news.getCtime());
                    viewHolder.description.setText(news.getDescription());
//                viewHolder.imageview.setImageBitmap(null);
                    if (!isNoImage) {
                        //非无图模式下
                        if (news.getPicUrl() != null && !"".equals(news.getPicUrl())) {
                            //图片url不为空且不等于空字符串时才显示ImageView
                            viewHolder.imageview.setVisibility(View.VISIBLE);
//                        viewHolder.imageview.setImageBitmap(null);
                            HttpVolley.setBitmap(context, news.getPicUrl(), viewHolder.imageview, animation);
                        }
                    } else {
                        //无图模式
                        viewHolder.imageview.setVisibility(View.GONE);
                    }
                }
                break;
        }
        return convertView;
    }

    static class ViewHolder{
        private TextView ctime;
        private TextView description;
        private ImageView imageview;
        private TextView title;
    }
}

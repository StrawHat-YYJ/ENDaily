package com.yyj.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.endaily.R;
import com.yyj.bean.Jokes;
import com.yyj.utils.netUtil.HttpVolley;

import java.util.ArrayList;

/**
 * Created by 草帽儿 on 2016/2/22.
 */
public class JokesAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<Jokes.ShowapiResBodyEntity.ContentlistEntity> list;
    private Animation animation;
    public JokesAdapter(Context context,ArrayList<Jokes.ShowapiResBodyEntity.ContentlistEntity>
                        list){
        this.context=context;
        this.list=list;
        animation = new AlphaAnimation(0.0f,1.0f);
        animation.setDuration(300);
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
    public View getView(int position, View convertView, ViewGroup parent) {
       final Jokes.ShowapiResBodyEntity.ContentlistEntity joke=list.get(position);
        ViewHolder viewHolder;
        if (convertView==null) {
            viewHolder=new ViewHolder();
            convertView=View.inflate(context, R.layout.layout_jokes_item,null);
            viewHolder.title= (TextView) convertView.findViewById(R.id.jokes_title);
            viewHolder.img= (ImageView) convertView.findViewById(R.id.jokes_img);
            viewHolder.ct= (TextView) convertView.findViewById(R.id.jokes_ct);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        if (joke!=null) {
            viewHolder.title.setText(joke.getTitle());
            viewHolder.ct.setText(joke.getCt());
            HttpVolley.setBitmap(context, joke.getImg(), viewHolder.img, animation);
        }
        return convertView;
    }
    static class ViewHolder{
        TextView title;
        ImageView img;
        TextView ct;

    }
}

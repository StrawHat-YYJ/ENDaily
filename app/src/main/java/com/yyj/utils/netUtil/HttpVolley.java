package com.yyj.utils.netUtil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.endaily.BaseApplication;
import com.example.administrator.endaily.MainActivity;
import com.yyj.ConfigConstant.Api;
import com.yyj.ConfigConstant.Constants;
import com.yyj.utils.FileUtil.FileUtils;
import com.yyj.utils.dateutil.DateUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 草帽儿 on 2016/2/18.
 */
public class HttpVolley {
    public static BaseApplication baseApplication=BaseApplication.getApplication();
    public static final String downloadDir= FileUtils.getDiskCacheDir(baseApplication,"").getAbsolutePath()+Constants.imgDownDir;
    static RequestQueue requestQueue;
    //获取requestQueue对象的时候只创建一个requestQueue对象，否则会outofMemory。
    private static RequestQueue getRequestQueue(Context context) {
        if (requestQueue==null) {
            requestQueue=Volley.newRequestQueue(context);
        }
        return requestQueue;
    }
    public static void getData(final Context context,String url, final String num, final String page, final Handler handler){
        requestQueue =getRequestQueue(context);
        StringRequest stringRequest= new StringRequest(Request.Method.POST,
               url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response!=null) {
                   String news=response.toString();
                    Message message = new Message();
                    message.what=0;
                    message.obj = news;
                    handler.sendMessage(message);
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"网络开小差了 >.<",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String,String>();
                map.put("maxResult",num);
                map.put("num", num);
                map.put("page", page);
                map.put("showapi_appid",Api.appid);
                map.put("showapi_timestamp", DateUtils.getRequestTime());
                map.put("showapi_sign",Api.secret);
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    public static void setBitmap(Context context, final String imgUrl, final ImageView imageView, final Animation animation){
        requestQueue=getRequestQueue(context);
        //ImageRequest实现
        final File imgFile=getFile(imgUrl);
        //如果图片不存在，请求网络下载并缓存到缓存目录文件夹下
        if (!imgFile.exists()) {
            ImageRequest imageRequest = new ImageRequest(imgUrl, new Response.Listener<Bitmap>() {
                @Override
                public void onResponse(Bitmap response) {
                    if (response != null) {
                        try {
                            imageView.setImageBitmap(response);
                            FileOutputStream fileOutputStream = new FileOutputStream(imgFile);
                            response.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, 0, 0, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("TAG", "错误 = " + error.getMessage(), error);
                }
            });
            requestQueue.add(imageRequest);
        }
        //ImageLoader实现

//        ImageLoader imageLoader = new ImageLoader(requestQueue,new BitmapCache());
//        ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(imageView,0
//        ,R.mipmap.ic_launcher);
//        imageLoader.get(imgUrl,imageListener,500,500);
        Bitmap bitmap=null;
        try {
            bitmap= BitmapFactory.decodeFile(imgFile.getAbsolutePath());
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        if (bitmap!=null) {
            imageView.setImageBitmap(bitmap);
            imageView.startAnimation(animation);
        }
    }
//    public static class BitmapCache implements ImageLoader.ImageCache {
//
//        private LruCache<String, Bitmap> cache;
//
//        public BitmapCache() {
//            cache = new LruCache<String, Bitmap>(20 * 1024 * 1024) {
//                @Override
//                protected int sizeOf(String key, Bitmap bitmap) {
//                    return bitmap.getRowBytes() * bitmap.getHeight();
//                }
//            };
//        }
//
//        @Override
//        public Bitmap getBitmap(String url) {
//            return cache.get(url);
//        }
//
//        @Override
//        public void putBitmap(String url, Bitmap bitmap) {
//            cache.put(url, bitmap);
//        }
//    }
    @Nullable
    public static File getFile(String imgurl){
        imgurl=imgurl.substring(imgurl.lastIndexOf("/")+1,imgurl.length());
        File cache= new File(downloadDir);
        //创建缓存目录文件夹
        if (!cache.exists()) {
            cache.mkdirs();
        }
        File file = new File(cache,imgurl);
        return file;
    }
}

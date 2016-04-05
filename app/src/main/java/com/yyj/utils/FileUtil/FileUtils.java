package com.yyj.utils.FileUtil;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * Created by 草帽儿 on 2016/2/24.
 */
public class FileUtils {
    /**
     * @param
     * @return
     * @author yyj
     * create at 2016/2/24 13:41
     * 检查sd卡是否存在
     */

    public static boolean checkSDCard() {
        final String status = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(status)) {
            return true;
        }
        return false;
    }

    public static File getDiskCacheDir(Context context, String uniqueName) {
        final String cachePath = checkSDCard() ? getExternalCacheDir(context).getPath() : getAppCacheDir(context);

        File cacheDirFile = new File(cachePath);
        if (!cacheDirFile.exists()) {
            cacheDirFile.mkdirs();
        }
        return cacheDirFile;
    }

public static String getAppCacheDir(Context context) {
    return context.getCacheDir().getPath();
 }
    /**
     * 获取程序外部的缓存目录
     * @param context
     * @return
     */
    public static File getExternalCacheDir(Context context) {
        // 这个sd卡中文件路径下的内容会随着，程序卸载或者设置中清除缓存后一起清空
        return new File(Environment.getExternalStorageDirectory().getPath() );
    }

    /**
     * 获取文件路径空间大小
     * @param path
     * @return
     */
    public static long getUsableSpace(File path) {
        try{
            final StatFs stats = new StatFs(path.getPath());
            return (long) stats.getBlockSize() * (long) stats.getAvailableBlocks();
        }catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

}

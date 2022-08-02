package com.zhongyong.smarthome.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.util.Base64;
import android.widget.ImageView;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.zhongyong.smarthome.App;
import com.zhongyong.smarthome.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/7/7.
 */
public class ImageUtils {
    public static final String wo_shi = "https://img1.baidu.com/it/u=1854502057,103455225&fm=253&fmt=auto&app=138&f=JPEG";// 卧室 http://opor07of8.bkt.clouddn.com/woshi.jpg
    public static final String canting ="https://img0.baidu.com/it/u=1425656574,2830166878&fm=253&app=120&size=w931&n=0&f=JPEG";// 餐厅 "http://opor07of8.bkt.clouddn.com/canting.jpg"
    public static final String chufang ="https://img0.baidu.com/it/u=589572245,831270830&fm=253&app=138&size=w931&n=0&f=JPEG";// 厨房 "http://opor07of8.bkt.clouddn.com/chufang.jpg"
    public static final String zoulang ="https://img0.baidu.com/it/u=500230228,2324369670&fm=253&app=138&size=w931&n=0&f=JPEG";// 走廊 "http://opor07of8.bkt.clouddn.com/zoulang.jpg"
    public static final String mainroom ="https://img0.baidu.com/it/u=2269636698,1073969005&fm=253&app=138&size=w931&n=0&f=JPEG";// 主卧 "http://opor07of8.bkt.clouddn.com/mainroom.jpg"
    public static final String xishoujian ="https://img0.baidu.com/it/u=589572245,831270830&fm=253&app=138&size=w931&n=0&f=JPEG";// 洗手间 "http://opor07of8.bkt.clouddn.com/xishoujian.jpg"
    public static final String worhi ="https://img1.baidu.com/it/u=2023390791,3057009341&fm=253&fmt=auto&app=138&f=JPG";// A房间 "http://opor07of8.bkt.clouddn.com/worhi.jpg"
    public static final String room ="https://img1.baidu.com/it/u=4100706516,2171147058&fm=253&fmt=auto&app=138&f=JPEG";// 主卧 "http://opor07of8.bkt.clouddn.com/room.jpg"

    public static final String campus1 = "https://img1.baidu.com/it/u=3773957770,285993983&fm=253&fmt=auto&app=138&f=JPEG";// 哥哥 http://opor07of8.bkt.clouddn.com/campus1.jpg
    public static final String campus2 ="https://img1.baidu.com/it/u=529199542,495794959&fm=253&fmt=auto&app=138&f=JPEG";// 爸爸 "http://opor07of8.bkt.clouddn.com/campus2.jpg"
    public static final String campus3 ="https://img1.baidu.com/it/u=2201706329,406772638&fm=253&fmt=auto&app=138&f=JPEG";//  妈妈 "http://opor07of8.bkt.clouddn.com/campus3.jpg"

    public static final String Screenshot_2017 ="https://img2.baidu.com/it/u=3042539031,3564089312&fm=253&fmt=auto&app=138&f=JPEG";//  我的家 "http://opor07of8.bkt.clouddn.com/Screenshot_2017-05-05-10-00-29-71.png"
    //默认半径为5，需要的时候可以直接用
    public static void setCornerImage(final ImageView imageView, String path) {
        if (path != null) {
            Glide.with(App.getInstance()).asBitmap().load(path).centerCrop().error(App.getInstance().getResources().getDrawable(R.drawable.avatar_default)).into(new BitmapImageViewTarget(imageView) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(App.getInstance().getResources(), resource);
                    circularBitmapDrawable.setCornerRadius(5);
                    imageView.setImageDrawable(circularBitmapDrawable);
                }
            });
        }
    }

    //这个可以自定义半径，需要的时候可以直接用
    public static void setCornerImage(final ImageView imageView, String path, final int radius) {
        if (path != null) {
            Glide.with(App.getInstance()).asBitmap().load(path).centerCrop().error(App.getInstance().getResources().getDrawable(R.drawable.avatar_default)).into(new BitmapImageViewTarget(imageView) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(App.getInstance().getResources(), resource);
                    circularBitmapDrawable.setCornerRadius(radius);
                    imageView.setImageDrawable(circularBitmapDrawable);
                }
            });
        }
    }

    //轮播的特别设置的，半径20
    public static void setCornerImageNo(final ImageView imageView, String path) {
        if (path != null) {
            Glide.with(App.getInstance()).asBitmap().load(path).centerCrop().error(App.getInstance().getResources().getDrawable(R.drawable.avatar_default)).into(new BitmapImageViewTarget(imageView) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(App.getInstance().getResources(), resource);
                    circularBitmapDrawable.setCornerRadius(20);
                    imageView.setImageDrawable(circularBitmapDrawable);
                }
            });
        }
    }

    public static void setCircleImage(final ImageView imageView, String path) {
        if (path != null) {
            Glide.with(App.getInstance()).asBitmap().load(path).centerCrop().error(App.getInstance().getResources().getDrawable(R.drawable.login_tupian_def)).into(new BitmapImageViewTarget(imageView) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(App.getInstance().getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    imageView.setImageDrawable(circularBitmapDrawable);
                }
            });
        }
    }


    public static synchronized Drawable byteToDrawable(String icon) {

        byte[] img = Base64.decode(icon.getBytes(), Base64.DEFAULT);
        Bitmap bitmap;
        if (img != null) {


            bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
            @SuppressWarnings("deprecation")
            Drawable drawable = new BitmapDrawable(bitmap);

            return drawable;
        }
        return null;

    }

    public static synchronized String drawableToByte(Drawable drawable) {
        if (drawable != null) {
            Bitmap bitmap = Bitmap
                    .createBitmap(
                            drawable.getIntrinsicWidth(),
                            drawable.getIntrinsicHeight(),
                            drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                                    : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            int size = bitmap.getWidth() * bitmap.getHeight() * 4;

            // 创建一个字节数组输出流,流的大小为size
            ByteArrayOutputStream baos = new ByteArrayOutputStream(size);
            // 设置位图的压缩格式，质量为100%，并放入字节数组输出流中
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            // 将字节数组输出流转化为字节数组byte[]
            byte[] imagedata = baos.toByteArray();

            String icon = Base64.encodeToString(imagedata, Base64.DEFAULT);
            return icon;
        }
        return null;
    }


    public static int readPictureDegree(String path) {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

    public static Bitmap rotateImageView(int angle, Bitmap bitmap) {
        //旋转图片 动作
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        System.out.println("angle2=" + angle);
        // 创建新的图片
        Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0,
                bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return resizedBitmap;
    }

    public static void setBackgroundImage(final ImageView imageView, int drawable) {
        imageView.setBackgroundResource(drawable);
    }
}

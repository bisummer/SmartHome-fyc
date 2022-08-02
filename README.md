# Awesome Android

> 该项主要用来收集和整理开发过程中经常用到的三方库和控件，并包含一些演示代码。[可以参考下文来了解更多的内容]

## 代码清单

### 1、ButterKnife
AndroidStudio升级到了4.1版本，在使用ButterKnife时，使用BindView注解给出了这样的提示：
Resource IDs will be non-final in Android Gradle Plugin version 5.0，
所有的R.id.*都会变成变量，
ButterKnife的作者也跳出来宣称，开发已经进入尾声，将不再更新并弃用，
推荐我们使用谷歌官方推出的 View Binding：
https://blog.csdn.net/u014653815/article/details/109216216


### 2、Glide无法解析asBitmap()
4.0.0之后,必须在with()之后添加asBitmap(),它才能像以前一样工作


### 3、This project uses AndroidX dependencies,
but the 'android.useAndroidX' property is not enabled.
Set this property to true in the gradle.properties file and retry.

## 代码清单
1. [百度云语音唤醒SDK](https://cloud.baidu.com/doc/SPEECH/index.html#DEMO.E5.8E.8B.E7.BC.A9.E5.8C.85.E8.AF.B4.E6.98.8E)
VoiceRecognition-2.1.20.jar
com.baidu.tts_2.3.0.jar
libBaiduSpeechSDK.so
libbd_easr_s1_merge_normal_20151216.dat.so
libbdEASRAndroid.so

2. 友盟第三方登录、分享(QQ登录、QQ分享)
SocialSDK_QQ_Simplify.jar
SocialSDK_Sina_Simplify.jar
SocialSDK_WeChat_Simplify.jar
umeng_shareboard_widget.jar

3. 极光推送
jpush-android-3.1.3.jar
jcore-android-1.2.1.jar

4.modbus实现jar包,编写工控上位机和下位机进行交互使用的jar包
jamod-1.2-SNAPSHOT.jar
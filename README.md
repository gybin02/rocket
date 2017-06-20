# Rocket
开发过程辅助工具，QA/Debug Tool 
<img src='/images/logo.png'></img>

#### 背景
 上次给内容组一起查一个BUG: 快速点击资讯列表，进入资讯详情页可能会出现资讯的内容是列表下一项的内容。华为手机会出现但是概率低很不好重现，导致问题很难重现；排查了一番，感觉一个是请求并发的问题，但是不好定位。这时候就想如果能不修改现在代码，同时有个功能按钮，我可以点击下就同时发起多个请求，这样测试就方便了。于是就简单实现了这个功能；
#### 特色
  1. 初始化下插件，就能在当前页面出现悬浮窗，点击悬浮窗可以出来功能测试页面；
  2. 测试的页面可以使用注解来实现，无需关心布局，只关心要测试的功能；

#### 功能
Rocket是一个简单但是好用的小工具。 可以用来给开发者或者QA 一个界面配置功能和选项，或者一些额外的信息，比如LogCat输出等；
Rocket 实现以下几个配置：

- 快速配置设置
- 使用注解功能快速使用配置页面；
- 可以显示一些额外的信息，比如：安装版本，服务器环境等；
- 可以用来显示LogCat,或者比如QaTest 之类的查看Event参数；可以查看一个Event是不是被触发了。

<img src='/images/rocket0.png'></img>


<img src='/images/rocket1.png'></img>

#### 安装
```groovy
dependencies {
  compile 'com.meiyou.plugin.rocket:0.0.1-SNAPSHOT'
}
```

#### 使用
继承  BeeConfig 新增需要的类；
```java
public class AppRocketConfig extends RocketConfig {

    private static final String TAG = "AppBeeConfig";


    /**
     * 当打开设置页面的时候
     */
    @Override
    public void onClose() {
        super.onClose();
        Log.w(TAG, "onClose");
    }

    @Override
    public void onOpen() {
        super.onOpen();
        Log.w(TAG, "onOpen");
    }

    /**
     * 使用@注解方法生成 测试UI；Button
     * <p>
     * Title 用来显示Button文字
     * Method should have no parameter.
     */
    @Title("测试请求网络")
    @Button
    public void requestNetwork() {
        Log.d(TAG, " 测试请求网络 requestNetwork");
    }


    /**
     * 生成一个CheckBox
     *
     * @Title 用来 显示Label
     * @Method 返回一个参数用来处理是否点击
     */
    @Title("显示广告")
    @CheckBox
    public void onShowAdsChecked(boolean isChecked) {
        Log.d(TAG, "是否显示广告： "+isChecked);
    }

    /**
     * 生成一个 Spinner
     *
     * @Spinner 注解需要传入 一个 String[]
     * Title 是用来显示Label
     * Method 返回选中的 String;
     */
    @Title("测试环境")
    @Spinner({"测试", "预发", "正式"})
    public void onEnvironmentSelected(String selectedValue) {
        Log.d(TAG, "测试环境： "+selectedValue);
    }
```

#### Activity 配置，启动悬浮窗 

你可以初始化在 具体的 activity里面 或者在BaseActivity,这样每个页面都可以用；

```java
@Override protected void onCreate(Bundle savedInstanceState) {
    ...

    Rocket.init(this)
      .inject(AppRocketConfig.class);  //required
}
```
####  @Text 显示文字

####  @Button 添加一个Button

#### @Checkbox 可以添加一个Checkout

#### @Spinner 可以添加一个 Spinner 如    @Spinner({"测试", "预发", "正式"})


#### TODO
- 常用的一些配置，服务器环境切换,
- 新增一些常用的功能： 重启APP， Clear Data 重启APP,
- 配置内容可以通过脚本方式配置； 
- 配置内容可以通过网络方式修改

#### License 
Copyright 2017 zhengxiaobin@xiaoyouzi.com
Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.


#Rocket
开发过程辅助工具，QA/Debug Tool 

#### 功能
Rocket是一个简单但是好用的小工具。 可以用来给开发者或者QA 一个界面配置功能和选项，或者一些额外的信息，比如LogCat输出等；
Rocket 实现以下几个配置：

- 快速配置设置
- 使用注解功能快速使用配置页面；
- 可以显示一些额外的信息，比如：安装版本，服务器环境等；
- 可以用来显示LogCat,或者比如QaTest 之类的查看Event参数；可以查看一个Event是不是被触发了。

#### 安装
```groovy
dependencies {
  compile 'com.meiyou.jet.rocket:0.0.1-SNAPSHOT'
}
```

#### 使用
继承  BeeConfig 新增需要的类；
```java
public class AppBeeConfig extends BeeConfig {

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
        Log.d(TAG, "onShowAdsChecked");
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
        Log.d(TAG, "onEndPointSelected");
    }

}
```

#### Activity 配置，启动 Bee

你可以初始化在 具体的 activity里面 或者在BaseActivity,这样每个页面都可以用；

```java
@Override protected void onCreate(Bundle savedInstanceState) {
    ...

  Bee.init(this)
    .inject(AppBeeConfig.class);  //required
}
```
####  @Text 显示文字

####  @Button 添加一个Button

#### @Checkbox 可以添加一个Checkout

#### @Spinner 可以添加一个 Spinner 如    @Spinner({"测试", "预发", "正式"})


#### TODO
- 常用的一些配置，服务器环境切换,
- 新增一些常用的功能： 重启APP， Clear Data 重启APP,

#### License 
Copyright 2017 zhengxiaobin@xiaoyouzi.com
Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

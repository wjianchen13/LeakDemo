# Leakcanary 使用总结

## 接入
LeakCanary的地址是：https://square.github.io/leakcanary/getting_started/
```Java
dependencies {
  // debugImplementation because LeakCanary should only run in debug builds.
  debugImplementation 'com.squareup.leakcanary:leakcanary-android:2.8.1'
}
```
确认LeakCanary已经正常运行起来了，在logcat里面有打印：
LeakCanary is running and ready to detect memory leaks.

## 常见内存泄漏的场景
https://www.jianshu.com/p/ea24d1474299








































> # 该项目基于[BaseProject项目]("https://github.com/jianesrq0724/BaseProject")
* 基于MVP，[跳转BaseProject]("https://github.com/jianesrq0724/BaseProject")，有BaseProject详细的介绍。


## Lazy-Loading的详细介绍，请看下面这篇文章
[ViewPager+Fragment实现懒加载（lazy-loading）]("http://blog.csdn.net/jianesrq0724/article/details/72531019")

## 懒加载需要配合ViewPager一起使用，具体的实现封装在BaseFragment中，子类继承两个方法
* lazyLoad()方法：懒加载，联网等操作
* stopLoad()方法：停止耗时的操作，计时器，动画等




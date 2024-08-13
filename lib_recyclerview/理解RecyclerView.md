### 目标
> [缓存机制](https://juejin.cn/post/6844903661726859271)
* 减少onCreateViewHolder() 和 onBindViewHolder() 调用次数
     * 减少调用次数
     * 减少执行时间

##RecyclerView的多级缓存机制
### 一级缓存：mAttachedScrap 和 mChangedScrap
* mAttachedScrap：
  * LayoutManager每次layout子View之前，那些已经添加到RecyclerView中的Item以及被删除的Item的临时存放地。
  * 使用场景就是RecyclerView滚动时、还有在可见范围内删除Item后用notifyItemRemoved方法通知更新时；
* mChangedScrap：作用：存放可见范围内有更新的Item。
  * 使用场景：可见范围内的Item有更新，并且使用notifyItemChanged方法通知更新时；
  * 就是临时缓存局部更新，用于播放动画，动画播放完viewholder还是会给 recyclerpool


### 二级缓存：mCachedViews : 默认最大2个
* mCachedViews：
  * 作用：存放滚动过程中没有被重新使用且状态无变化的那些旧Item。场景：滚动，prefetch；
### 三级缓存：ViewCacheExtension
###  四级缓存：RecycledViewPool
* 作用：缓存Item的最终站，用于保存那些Removed、Changed、以及mCachedViews满了之后更旧的Item。
* 场景：Item被移除、Item有更新、滚动过程；

###  绘制过程

 #### 类职责介绍

* Recycler：缓存池

* Adapter：ViewHolder的生成器和内容绑定器。

* LayoutManager：接管RecyclerView的Measure，Layout，Draw的过程

     #### 绘制过程简介
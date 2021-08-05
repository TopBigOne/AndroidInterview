### 目标
> 缓存机制(https://juejin.cn/post/6844903661726859271)
* 减少onCreateViewHolder() 和 onBindViewHolder() 调用次数
     * 减少调用次数
     * 减少执行时间



###  绘制过程

 #### 类职责介绍

* Recycler：缓存池

* Adapter：ViewHolder的生成器和内容绑定器。

* LayoutManager：接管RecyclerView的Measure，Layout，Draw的过程

     #### 绘制过程简介
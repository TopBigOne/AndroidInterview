## 看看别人使用mmap

###  void *mmap(void *start, size_t length, int prot, int flags, int fd, off_t offset);

### 参数
* return
  * mmap() 函数在成功映射内存区域时会返回一个指向映射区域起始地址的指针，这个指针通常是 void* 类型。如果映射失败，则返回值为 MAP_FAILED，通常被定义为 (void*)-1

* start：映射区的开始地址

* length：映射区的长度

* prot：期望的内存保护标志，不能与文件的打开模式冲突。是以下的某个值，可以通过or运算合理地组合在一起
       *  1 PROT_EXEC ：页内容可以被执行
       *  2 PROT_READ ：页内容可以被读取
       *  3 PROT_WRITE ：页可以被写入
       *  4 PROT_NONE ：页不可访问
* flags：指定映射对象的类型，映射选项和映射页是否可以共享。它的值可以是一个或者多个以下位的组合体
  * 1 MAP_FIXED //使用指定的映射起始地址，如果由start和len参数指定的内存区重叠于现存的映射空间，重叠部分将会被丢弃。如果指定的起始地址不可用，操作将会失败。并且起始地址必须落在页的边界上。
  * 2 MAP_SHARED //与其它所有映射这个对象的进程共享映射空间。对共享区的写入，相当于输出到文件。直到msync()或者munmap()被调用，文件实际上不会被更新。
  * 3 MAP_PRIVATE //建立一个写入时拷贝的私有映射。内存区域的写入不会影响到原文件。这个标志和以上标志是互斥的，只能使用其中一个。
  * 4 MAP_DENYWRITE //这个标志被忽略。
  * 5 MAP_EXECUTABLE //同上
  * 6 MAP_NORESERVE //不要为这个映射保留交换空间。当交换空间被保留，对映射区修改的可能会得到保证。当交换空间不被保留，同时内存不足，对映射区的修改会引起段违例信号。
  * 7 MAP_LOCKED //锁定映射区的页面，从而防止页面被交换出内存。
  * 8 MAP_GROWSDOWN //用于堆栈，告诉内核VM系统，映射区可以向下扩展。
  * 9 MAP_ANONYMOUS //匿名映射，映射区不与任何文件关联。
  * 10 MAP_ANON //MAP_ANONYMOUS的别称，不再被使用。
  * 11 MAP_FILE //兼容标志，被忽略。
  * 12 MAP_32BIT //将映射区放在进程地址空间的低2GB，MAP_FIXED指定时会被忽略。当前这个标志只在x86-64平台上得到支持。
  * 13 MAP_POPULATE //为文件映射通过预读的方式准备好页表。随后对映射区的访问不会被页违例阻塞。
  * 14 MAP_NONBLOCK //仅和MAP_POPULATE一起使用时才有意义。不执行预读，只为已存在于内存中的页面建立页表入口。

* fd：有效的文件描述词。如果MAP_ANONYMOUS被设定，为了兼容问题，其值应为-1

### int munmap( void * addr, size_t len )
> 解除一个映射关系，addr是调用mmap()时返回的地址，len是映射区的大小； 当映射关系解除后，对原来映射地址的访问将导致段错误发生。

### int msync(void* __addr, size_t __size, int __flags);
> msync() 函数主要用于将内存映射区域的数据同步到持久存储介质（如磁盘）上。它可以确保对内存映射区域所做的修改被写回到文件系统，从而保持数据的一致性。下面详细解释一些 msync() 函数的参数和用法

* 参数：
  * addr：指向内存映射区域起始地址的指针。
  * length：要同步的内存映射区域的大小，以字节为单位。
  * flags：用于控制同步行为的标志。
    * MS_ASYNC：异步写回，即将数据异步写回磁盘。
    * MS_SYNC：同步写回，即等待数据完全写回磁盘后返回。
    * MS_INVALIDATE：标记内存映射区域无效，使下次访问时强制重新加载数据。

## 参考
* [Logdog](https://github.com/ithaibo/Logdog/tree/master)
* [Android_MMap](https://github.com/GreateLi/Android_MMap/tree/master)

##  额外
### 系统虚拟存储页的大小获取方式
* printf("%ld\n", getpagesize());
* printf("%ld\n", sysconf(_SC_PAGESIZE));


分布式百度百科爬虫
===
* 基于redis 和 rabbitMQ，采用Spring框架对爬虫进行管理
* 使用 redis 存储去重的位信息，使用Bloom Filter算法进行去重
* 使用rabbitMQ接收从各个节点获取到的URL
* 数据最终落地到mysql数据库
* 因为在一台机子上可能采取多线程爬去数据，导致数据入库发生异常，采用ThreadLocal方式对线程与jdbc连接进行了绑定
* 已经成功爬取200万条数据

出现问题
---
1. 爬取前期问题主要是多台计算机同时开爬，数据库服务器磁盘I/O被占满
2. 爬取后期问题主要是因为获取URL的问题，重复URL太多，爬取速度下降

总体架构图
---
![image](https://github.com/smallmadrabbit/bdbkspider/blob/master/frame.png)
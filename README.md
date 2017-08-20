分布式百度百科爬虫
---
* 基于redis 和 rabbitMQ
* 使用 redis 存储去重的位信息，使用Bloom Filter算法进行去重
* 使用rabbitMQ接收从各个节点获取到的URL
* 数据最终落地到mysql数据库
* 因为在一台机子上可能采取多线程爬去数据，导致数据入库发生异常，采用ThreadLocal方式对线程与jdbc连接进行了绑定
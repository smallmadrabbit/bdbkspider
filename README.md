分布式百度百科爬虫
---
* 基于redis 和 rabbitMQ
* 使用 redis 存储去重的位信息，使用Bloom Filter算法进行去重
* 使用rabbitMQ接收从各个节点获取到的URL
* 准备使用zookeeper做节点状态的监控
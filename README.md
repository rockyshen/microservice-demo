![](https://picgo-rockyshen.oss-cn-shanghai.aliyuncs.com/picgo/CleanShot%202025-12-01%20at%2011.19.23%402x.png)

启动两个inventory-service实例，一个运行在7777端口，一个运行在8888端口

nginx配置轮询7777和8888，模拟在微服务环境下gateway的轮询。

每次实验一种组件，去Github上（基于main分支）创建一个feature分支，在这个分支上开发实验！实验完，也不用合并到main！
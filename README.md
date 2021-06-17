# post-origin-server
>简单的api，目的是为了项目更新时通过Webhooks自动回调服务器接口，执行对应的脚本

### 使用

#### 1.需要修改 application.properties 配置文件
``` shell
# 服务器端口
server.port=
# 请求 secret
secret=
```
#### 2.将打好的jar推送到服务器

#### 3.后台运行运行
```shell
pid : nohup  java  -jar  test.jar &
```
#### 4.查看状态
```shell
ps -ef|grep java
```


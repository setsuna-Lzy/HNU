对test数据库中的两张表student和score进行了简单的增删改查实现

使用了spring boot开发，主要操作对象是数据库，springDao工具类JdbcTemple作为持久层，编写了service层和web层
项目结构分析:
pojo:User和Score的数据模型
service:service层，调用Dao层存储数据
controller:与浏览器的交互，调用service层

项目启动输入http://localhost:8080/index.html 可以进入一个交互界面，可以进行操作并显式结果

开发环境及工具版本
jdk:1.8
IDEA:2019.2.4
maven:3.3.9

小结: 在以前的web开发中使用servlet，没有接触过spring和spring boot，项目较为丑陋，又有300+的课要听了QwQ

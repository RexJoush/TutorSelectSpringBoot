## 修改记录

* 2021.08.08 **Rex Joush**
    * 新建项目，配置基础环境
    * 添加依赖
    * 修改端口号 8080 为 8080

* 2021.08.10 **dynamic10**
    * 修改数据库表system_time中字段time_id为int类型，自增
    * 添加数据库表system_user，存储使用该系统用户的学工号，角色名称，用户状态，院系名称，以及系统用户的创建时间

* 2021.08.13 **Rex Joush**
    * 规范后端代码的文件目录结构
    * 新建 controller 和 service 层的文件夹并附带 readme.md 说明
* 2021.08.18 **dynamic**
    * 规范学科属性代码 ：文科1 理科2 交叉学科3
    * 修改获取导师列表返回值
 * 2021.08.18 **zjz**
    * ResultCode成功统一返回20000 失败20001
    * 数据库apply表 id主键改为自增
    
 * 2021.08.19 **zjz**
    首次申请状态码res.data修改 
    查询出来的状态为0 ，老师可以进去修改 101
    没有申请过此岗位  102
    老师已提交 申请过此岗位 100
 * 2021.08.20 **dynamic**
    给公共方法TutorInspectController，getALL ,请求路径添加/admin前缀 
    给研究生管理员SystemUserController，请求路径添加/graduate前缀 

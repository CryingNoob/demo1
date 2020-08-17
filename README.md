# demo1
# async community

这是一个前后端分离的restfull 的 springboot项目,前端部分在https://github.com/sakitam21/hello-vue

大三-大四 夏季小学期 javaee 大作业
2020.8.13 完成登陆注册功能,各项配置正确.

 使用mybatis 注解方式,没有mapper.xml文件, 再application.yml 中开启驼峰转换 
 
 @PostMapping
 (@Request Map<string,Object> json)
 其中object不能直接解析为实体类,需要JSON.parseObject()来解析
  User user = JSON.parseObject(JSON.toJSONString(json.get("user")),User.class);

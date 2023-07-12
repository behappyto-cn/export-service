### 说明

当前的服务是为了解决大量数据导出，需要占用大量的服务器资源、需要在页面长时间等待的问题，只需要配置导出模板， 提供导出数据的接口即可。 目前仅支持http协议GET、POST和curl命令行的导出、后期会新增dubbo、grpc等协议的支持。

### 流程

创建MySQL数据库的schema，然后执行文件夹sql下面的语句，创建对应的表和默认的测试数据。

### 使用

export-demo 为导出提供接口的应用，默认的导出测试接口。 export-core 导出的核心代码，包括数据的创建、导出任务处理等功能。

现在只要启动 export-demo，然后启动 export-core 项目，就会根据配置的测试数据进行导出，目前测试的导出数据为100万，而且支持横向填充、 纵向填充，模板里面已经包含对应的实列。

模板格式参考： // 模板注意 用{} 来表示你要用的变量 如果本来就有"{","}" 特殊字符 用"\{","\}"代替。 // {前缀.} 前缀可以区分不同的list，前缀为 export_task_detail 的 name
字段的值。 // 所有的返回值比较是 List 的格式，目前只支持List格式。

测试的模板在目录 export-demo/src/main/resources/static/template.xlsx

使用流程：
1、启动export-service项目，可以打开当前的地址 http://127.0.0.1:8088/export-service/doc.html#/home 查看对应的接口信息。
2、使用时，
a、http://127.0.0.1:8088/export-service/doc.html#/export-service/%E6%A8%A1%E6%9D%BF%E7%AE%A1%E7%90%86/addUsingPOST_1 管理需要导出的模板
b、http://127.0.0.1:8088/export-service/doc.html#/export-service/%E4%BB%BB%E5%8A%A1%E7%AE%A1%E7%90%86/addUsingPOST 新增导出的任务

### 管理页面（待完善）
管理界面：https://github.com/behappyto-cn/export-ui
管理后台：https://github.com/behappyto-cn/export-parent

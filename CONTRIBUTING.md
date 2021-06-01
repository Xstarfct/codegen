# 前期配置

/codegen/src/main/resources/generator.xml

在上述文件中，可以修改生成的 basepackage 、默认去除前缀、数据库连接信息

</br></br>

template/java_imports.include

在上述文件中，是默认的Java文件头部信息，强烈建议修改 author 信息

</br></br>

# 如何使用?

运行 generator.GeneratorMain 方法，修改 generateByTable 参数为表名，即可生成

Warn！！！！！！！！！

Mac OS 一定要注意调整代码

g.deleteOutRootDir();

否则会删除系统根目录的文件！！！！！！！！
//package cn.behappyto.export.common.generator;
//
//import com.baomidou.mybatisplus.generator.FastAutoGenerator;
//import com.baomidou.mybatisplus.generator.config.OutputFile;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//
//import java.util.Collections;
//
///**
// * 代码生成器
// *
// * @author behappyto.cn
// */
//public class Generator {
//
//    public static void main(String[] args) {
//        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/export_service?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai"
//                        , "root", "root")
//                .globalConfig(builder -> {
//                    // 设置作者
//                    builder.author("behappyto.cn")
//                            // 开启 swagger 模式
//                            // .enableSwagger()
//                            // 指定输出目录
//                            .outputDir("D://export-service");
//                }).packageConfig(builder -> {
//                    // 设置父包名
//                    builder.parent("cn.behappyto.export.domain.dao")
//                            // 设置父包模块名
//                            .moduleName("")
//                            // 设置mapperXml生成路径
//                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D://export-service//mapper"));
//                }).strategyConfig(builder -> {
//                    // 设置需要生成的表名
//                    builder.addInclude("export_task")
//                            .addInclude("export_task_detail")
//                            .addInclude("export_app")
//                            .addInclude("export_template");
//                    // 设置过滤表前缀
//                    //.addTablePrefix("t_", "c_");
//                })
//                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
//                .templateEngine(new FreemarkerTemplateEngine())
//                .execute();
//    }
//}

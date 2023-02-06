/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 80029
Source Host           : 127.0.0.1:3306
Source Database       : export_service

Target Server Type    : MYSQL
Target Server Version : 80029
File Encoding         : 65001

Date: 2022-09-22 15:23:06
*/

SET
FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for export_app
-- ----------------------------
DROP TABLE IF EXISTS `export_app`;
CREATE TABLE `export_app`
(
    `id`          bigint                                                         NOT NULL AUTO_INCREMENT COMMENT '主鍵',
    `app_id`      varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   NOT NULL DEFAULT (uuid()) COMMENT '应用编码',
    `app_name`    varchar(128)                                                   NOT NULL COMMENT '应用名称',
    `app_secret`  varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '应用密钥',
    `remark`      varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '备注',
    `enabled`     tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效 0：无效  1：有效',
    `deleted`     tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0：正常 1：删除',
    `create_date` datetime                                                       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_date` datetime                                                                DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_app_id` (`app_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of export_app
-- ----------------------------
INSERT INTO `export_app`
VALUES ('2', 'fa08ae66-00b5-4fa7-a28c-fa6c6d117fa9', '测试应用',
        'k9s78agm8eoi6xqmnrieob4mmc6q7zdq8najjb18rj31g962h0r9iwjr2qlqfbq6qnjrf7x7ji2xsdl56n80qxyd9tycy4cqlkw3zih3anrgbl9nh5r2vxk1w5qepcojci4h5nxwb9f3o7iorc07mwc13k2y7bkt4wkia2ddrwvdad9pj9slnzv3kl5cb0e1hahodbdae3gstn28tctyz1yq8yicpsr5chd3oh2zt315s9ixwv6emb1y5lohr4xgvqy8f99j9dwyub7cjjuzdkvz1rujjf2a16c287qqd561yh06q2ffqa2rwmu5w4jqpfoztenepgely8fdwlvy7b30zf2a25gzs3itppw0j0ifmwfm34xru44pc26j2c2euxyi763j9t5l467443vi7a6uvgj1bdg5p8vxqjolchjq20po5g4967o2umq2bydg6afv6tqbx2p1m3l7urwmsb4zz4llx73ej4wx9yup3xnvf7zvwnexrs620aiayrstwqa6khfkg7t35k66nidhtyooa3h1tqjz490zl0klwwv5skqzgjfkqftev6ct77q4dee98mczhv4s9t4st99aftkwzvbtkn20nj93exk4augzqni55zxmsvarmfbstrztftbdyh5256n0dj9hamsdpefjnqopgwo019pr98aasg8bz8ae557u548es2tml4xg44mf2d2v40ury6ty29a0t8p363l0qrwlu4rvig4q2micmtu4faxqk9z39gvu0a1c4l5gvmyu6vxdkzss0ghtff2u7yt39mzi0bkwcinvjkvk0s5z1jveb8tslews29fej6f44flvmeacpllfdjq1szl3kxwm9ciu5axmb87zrq2b0mo7axgrvso8ajr6ppxlaekmzt3i74fl4jjqipa3ow3z98aij5xqt3ayp5w8tw7rpt6vxrj67yyigkwokdgrofbh24373022ec6ghfms3ocsnt7rodoaww61xyv51nazmjd2sw5qet7snvn77dyqt1uiqh0dgxq580lyn31ztu56u4vl8lxah9ofd4pvkwtal8pn0j9wxge1ixjx0z3m8deah1plk3wtzlrifgzzgxgjfjcny4yk8c0rvniqpyz5jgak0od7wm49i8r6oslvbh1dtoo2fo7zev3u3k4u8so0tj7rbnh334uamokdgeilp2lhb752nzs6eqxe62ud3z9u3zzzz7g9acioqwlxtbpgcb0ahx44agz0so84d7aj0fyqoal0d03dreuzb967y7zi5knvfabxplj1jw5zbtz6ynknxy1l45otm4ynz4l38gt177srxt7f5dbude250osyxjkj02kh7zxt58cglc4rip4awpjhkcy4p1s5ew5bc9v152qoygmqe9qtq4huyv1fy6favn75v5uokz8ouqe7u7eimmbpto1wm4bjt7s5ygxypcd8bpjjyefqik66axc74xpkwjsvzdi0o5at43o2zrvfwxxyky2ivht7zmagl6kxg88mwp7kbd995e5qgbkvti1cd7nb1hxbldht1f3wxvr4umeuvjiijeqywzqv2xqsvfhvyjaec6bf9ke97ydmlmx8o75f8yenkcg0d7fuhwdc3wkhu3yyjle67y9ybpjibgxwcgw25eqhuhmzyb1is48byzm0yrd06acpv6oqncwm8ovn9q0gabjpe94nfsodc27jofzk2d6d6ma56xrqr48sd7qd6qybfu77xzx7x0eu9h0ibw8mk31nz17ktqvj6unn0kampf53vw50lhjpun8k9leny4l7m41524nho6pwxcdzvcw6dg4lf6qqw6sdpaylc5gsyghp6mz4bujiau7g0hfaeyzp39k97pj80gufve10beaw8kwzqob8mqvfhiohm2w6gxpliprg2ezzz1qkdu4qn5hd2eaow7vk3l0eszr3oqdk1812x9c35tyva8fp98jj7n2jk6c562e7so3z282lobjkdx0le7v45zt430ash51c33cxzwxniqbi97zowtgvjhhvn170',
        '', '1', '0', '2022-09-21 23:19:01', null);

-- ----------------------------
-- Table structure for export_task
-- ----------------------------
DROP TABLE IF EXISTS `export_task`;
CREATE TABLE `export_task`
(
    `id`            bigint                                                        NOT NULL COMMENT '主键',
    `name`          varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '任务名称',
    `app_id`        varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '应用编码',
    `status`        int                                                           NOT NULL DEFAULT '0' COMMENT '处理状态（0：等待导出； 1：执行成功； -1：执行失败； 2：正在执行； 3：已经下载）',
    `template_id`   bigint                                                        NOT NULL COMMENT '模板主键',
    `template_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '模板名称',
    `user_id`       varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '用户编码',
    `user_name`     varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名称',
    `method`        varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL DEFAULT 'http' COMMENT '回调方式',
    `slice_num`     int                                                           NOT NULL DEFAULT '0' COMMENT '分片的值',
    `remark`        varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
    `enabled`       tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效 0：无效  1：有效',
    `deleted`       tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0：正常 1：删除',
    `create_date`   datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_date`   datetime                                                               DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of export_task
-- ----------------------------
INSERT INTO `export_task`
VALUES ('1', '测试任务', 'fa08ae66-00b5-4fa7-a28c-fa6c6d117fa9', '1', '1', '模板名称', '1', '佚名', 'http', '0', '', '1', '0',
        '2022-09-21 21:23:52', '2022-09-22 14:55:05');

-- ----------------------------
-- Table structure for export_task_detail
-- ----------------------------
DROP TABLE IF EXISTS `export_task_detail`;
CREATE TABLE `export_task_detail`
(
    `id`          bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '主键',
    `task_id`     bigint                                                        NOT NULL COMMENT '任务主键',
    `name`        varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_ci  NOT NULL DEFAULT 'data' COMMENT '名称（Excel填充前缀）',
    `method`      varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL DEFAULT 'GET' COMMENT '请求方法',
    `param`       json                                                          NOT NULL COMMENT '基本参数',
    `remark`      varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
    `enabled`     tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效 0：无效  1：有效',
    `deleted`     tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0：正常 1：删除',
    `create_date` datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_date` datetime                                                               DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='任务明细';

-- ----------------------------
-- Records of export_task_detail
-- ----------------------------
INSERT INTO `export_task_detail`
VALUES ('1', '1', 'data1', 'http', '{
  \"url\": \"http://localhost:8080/demo/test1?currentPage=1\", \"body\": \"\", \"name\": \"data\", \"method\": \"GET\", \"timeout\": 5000, \"pageSizeName\": \"pageSize\", \"currentPageName\": \"currentPage\"}',
        '', '1', '0', '2022-09-22 14:09:20');
INSERT INTO `export_task_detail`
VALUES ('2', '1', 'data1', 'http', '{
  \"url\": \"http://localhost:8080/demo/test1?currentPage=1\", \"body\": \"\", \"name\": \"data\", \"method\": \"GET\", \"timeout\": 5000, \"pageSizeName\": \"pageSize\", \"currentPageName\": \"currentPage\"}',
        '', '1', '0', '2022-09-22 14:09:20');
INSERT INTO `export_task_detail`
VALUES ('3', '1', 'data2', 'http', '{
  \"url\": \"http://localhost:8080/demo/test2?currentPage=1\", \"body\": \"\", \"name\": \"data\", \"method\": \"GET\", \"timeout\": 5000, \"pageSizeName\": \"pageSize\", \"currentPageName\": \"currentPage\"}',
        '', '1', '0', '2022-09-22 14:09:20');
INSERT INTO `export_task_detail`
VALUES ('4', '1', 'data2', 'http', '{
  \"url\": \"http://localhost:8080/demo/test2?currentPage=1\", \"body\": \"\", \"name\": \"data\", \"method\": \"GET\", \"timeout\": 5000, \"pageSizeName\": \"pageSize\", \"currentPageName\": \"currentPage\"}',
        '', '1', '0', '2022-09-22 14:09:20');
INSERT INTO `export_task_detail`
VALUES ('6', '1', 'data3', 'http', '{
  \"url\": \"http://localhost:8080/demo/test3?currentPage=1\", \"body\": \"\", \"name\": \"data\", \"method\": \"GET\", \"timeout\": 5000, \"fillVertical\": false, \"pageSizeName\": \"pageSize\", \"currentPageName\": \"currentPage\"}',
        '', '1', '0', '2022-09-22 14:09:20');
INSERT INTO `export_task_detail`
VALUES ('7', '1', 'data3', 'http', '{
  \"url\": \"http://localhost:8080/demo/test3?currentPage=1\", \"body\": \"\", \"name\": \"data\", \"method\": \"GET\", \"timeout\": 5000, \"fillVertical\": false, \"pageSizeName\": \"pageSize\", \"currentPageName\": \"currentPage\"}',
        '', '1', '0', '2022-09-22 14:09:20');
INSERT INTO `export_task_detail`
VALUES ('8', '1', 'data4', 'http', '{
  \"url\": \"http://localhost:8080/demo/test4?currentPage=1\", \"body\": \"\", \"name\": \"data\", \"method\": \"GET\", \"timeout\": 5000, \"fillVertical\": false, \"pageSizeName\": \"pageSize\", \"currentPageName\": \"currentPage\"}',
        '', '1', '0', '2022-09-22 14:09:20');
INSERT INTO `export_task_detail`
VALUES ('9', '1', 'data4', 'http', '{
  \"url\": \"http://localhost:8080/demo/test4?currentPage=1\", \"body\": \"\", \"name\": \"data\", \"method\": \"GET\", \"timeout\": 5000, \"fillVertical\": false, \"pageSizeName\": \"pageSize\", \"currentPageName\": \"currentPage\"}',
        '', '1', '0', '2022-09-22 14:09:20');

-- ----------------------------
-- Table structure for export_template
-- ----------------------------
DROP TABLE IF EXISTS `export_template`;
CREATE TABLE `export_template`
(
    `id`          bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '主键',
    `app_id`      varchar(64)                                                   NOT NULL COMMENT '应用编码',
    `name`        varchar(128)                                                  NOT NULL COMMENT '模板名称',
    `type`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL DEFAULT 'xlsx' COMMENT '类型',
    `url`         varchar(256)                                                  NOT NULL COMMENT '模板路径',
    `remark`      varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
    `enabled`     tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效 0：无效  1：有效',
    `deleted`     tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0：正常 1：删除',
    `create_date` datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_date` datetime                                                               DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_app_id_name` (`app_id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of export_template
-- ----------------------------
INSERT INTO `export_template`
VALUES ('1', 'fa08ae66-00b5-4fa7-a28c-fa6c6d117fa9', '测试模板', 'xlsx', 'http://localhost:8080/template.xlsx', '', '1',
        '0', '2022-09-21 21:23:19', null);

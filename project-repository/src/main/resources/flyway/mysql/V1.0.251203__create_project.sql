-- 若库不存在创建一个
CREATE DATABASE IF NOT EXISTS `project`;
USE `project`;

drop table if exists `project_instance`;
CREATE TABLE IF NOT EXISTS `project_instance`(
    `project_instance_id` bigint(19) NOT NULL COMMENT '项目ID',
    `project_name` varchar(64) DEFAULT NULL COMMENT '项目名',
    `project_code` varchar(64) DEFAULT NULL COMMENT '项目code',
    `description` varchar(64) DEFAULT NULL COMMENT '项目描述',
    `icon` varchar(64) DEFAULT NULL COMMENT '项目icon',
    `scope` integer(11) DEFAULT NULL COMMENT '可见范围(0:成员可见，1:组织可见,2...)',
    `start_time` datetime DEFAULT NULL COMMENT '项目开始时间',
    `end_time` datetime DEFAULT NULL COMMENT '项目截止时间',
    `budget` decimal DEFAULT NULL COMMENT '预算成本',
    `cost` decimal DEFAULT NULL COMMENT '实际成本',
    `bonus` decimal DEFAULT NULL COMMENT '奖金',
    `progress` integer(11) DEFAULT NULL COMMENT '项目进度',
    `revision` integer(11) DEFAULT NULL COMMENT '版本号',
    `app_id` varchar(64) DEFAULT NULL COMMENT '应用id',
    `create_time` datetime DEFAULT NULL COMMENT '时间戳',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `create_id` bigint(19) DEFAULT NULL COMMENT '创建者ID',
    `update_id` bigint(19) DEFAULT NULL COMMENT '更新者ID',
    PRIMARY KEY (`project_instance_id`)
) ENGINE=InnoDB COMMENT='';

drop table if exists `project_demand`;
CREATE TABLE IF NOT EXISTS `project_demand`(
    `project_demand_id` bigint(19) NOT NULL COMMENT '项目需求ID',
    `project_instance_id` bigint(19) DEFAULT NULL COMMENT '项目ID',
    `account_instance_id` bigint(19) DEFAULT NULL COMMENT '提出者ID',
    `nickname` varchar(64) DEFAULT NULL COMMENT '昵称',
    `doc_link` varchar(64) DEFAULT NULL COMMENT '文档链接',
    `oss_code` varchar(64) DEFAULT NULL COMMENT '对象存储码[db,local,cos,oss,qiuniu...]',
    `content` text DEFAULT NULL COMMENT '需求描述文档',
    `priority` integer(11) DEFAULT NULL COMMENT '优先级',
    `worth` integer(11) DEFAULT NULL COMMENT '价值',
    `revision` integer(11) DEFAULT NULL COMMENT '版本号',
    `app_id` varchar(64) DEFAULT NULL COMMENT '应用id',
    `create_time` datetime DEFAULT NULL COMMENT '时间戳',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `create_id` bigint(19) DEFAULT NULL COMMENT '创建者ID',
    `update_id` bigint(19) DEFAULT NULL COMMENT '更新者ID',
    PRIMARY KEY (`project_demand_id`)
) ENGINE=InnoDB COMMENT='';

drop table if exists `project_milestone`;
CREATE TABLE IF NOT EXISTS `project_milestone`(
    `project_milestone_id` bigint(19) NOT NULL COMMENT '项目里程碑ID',
    `project_instance_id` bigint(19) DEFAULT NULL COMMENT '项目ID',
    `milestone_name` varchar(64) DEFAULT NULL COMMENT '里程碑名称',
    `description` varchar(64) DEFAULT NULL COMMENT '里程碑描述',
    `phase_budget` decimal DEFAULT NULL COMMENT '阶段预算',
    `phase_cost` decimal DEFAULT NULL COMMENT '阶段成本',
    `time_unit` varchar(64) DEFAULT NULL COMMENT '时间单位 [Year，Month，Day，Hour]',
    `duration` integer(11) DEFAULT NULL COMMENT '相对时间长',
    `start_time` datetime DEFAULT NULL COMMENT '开始时间',
    `end_time` datetime DEFAULT NULL COMMENT '结束时间',
    `revision` integer(11) DEFAULT NULL COMMENT '版本号',
    `app_id` varchar(64) DEFAULT NULL COMMENT '应用id',
    `create_time` datetime DEFAULT NULL COMMENT '时间戳',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `create_id` bigint(19) DEFAULT NULL COMMENT '创建者ID',
    `update_id` bigint(19) DEFAULT NULL COMMENT '更新者ID',
    PRIMARY KEY (`project_milestone_id`)
) ENGINE=InnoDB COMMENT='';

drop table if exists `project_task`;
CREATE TABLE IF NOT EXISTS `project_task`(
    `project_task_id` bigint(19) NOT NULL COMMENT '项目任务ID',
    `project_milestone_id` bigint(19) DEFAULT NULL COMMENT '项目里程碑ID',
    `project_demand_id` bigint(19) DEFAULT NULL COMMENT '项目需求ID',
    `project_instance_id` bigint(19) DEFAULT NULL COMMENT '项目ID',
    `budget` decimal DEFAULT NULL COMMENT '预算成本',
    `task_title` varchar(64) DEFAULT NULL COMMENT '任务标题',
    `prompt` varchar(64) DEFAULT NULL COMMENT '提示',
    `progress` integer(11) DEFAULT NULL COMMENT '进度',
    `step` integer(11) DEFAULT NULL COMMENT '步骤',
    `priority` integer(11) DEFAULT NULL COMMENT '优先级',
    `factor` integer(11) DEFAULT NULL COMMENT '难度系数',
    `revision` integer(11) DEFAULT NULL COMMENT '版本号',
    `app_id` varchar(64) DEFAULT NULL COMMENT '应用id',
    `create_time` datetime DEFAULT NULL COMMENT '时间戳',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `create_id` bigint(19) DEFAULT NULL COMMENT '创建者ID',
    `update_id` bigint(19) DEFAULT NULL COMMENT '更新者ID',
    PRIMARY KEY (`project_task_id`)
) ENGINE=InnoDB COMMENT='';

drop table if exists `project_mind`;
CREATE TABLE IF NOT EXISTS `project_mind`(
    `project_mind_id` bigint(19) NOT NULL COMMENT '项目脑图ID',
    `project_instance_id` bigint(19) DEFAULT NULL COMMENT '项目ID',
    `mind_url` varchar(64) DEFAULT NULL COMMENT '脑图地址',
    `mind_version` varchar(64) DEFAULT NULL COMMENT '脑图版本号',
    `mind_json` varchar(64) DEFAULT NULL COMMENT 'json配置',
    `revision` integer(11) DEFAULT NULL COMMENT '版本号',
    `app_id` varchar(64) DEFAULT NULL COMMENT '应用id',
    `create_time` datetime DEFAULT NULL COMMENT '时间戳',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `create_id` bigint(19) DEFAULT NULL COMMENT '创建者ID',
    `update_id` bigint(19) DEFAULT NULL COMMENT '更新者ID',
    PRIMARY KEY (`project_mind_id`)
) ENGINE=InnoDB COMMENT='';

drop table if exists `project_repository`;
CREATE TABLE IF NOT EXISTS `project_repository`(
    `project_repository_id` bigint(19) NOT NULL COMMENT '项目仓库ID',
    `project_instance_id` bigint(19) DEFAULT NULL COMMENT '项目ID',
    `git_url` varchar(64) DEFAULT NULL COMMENT '仓库地址',
    `http_url` varchar(64) DEFAULT NULL COMMENT '仓库http地址',
    `token` varchar(64) DEFAULT NULL COMMENT '仓库token',
    `revision` integer(11) DEFAULT NULL COMMENT '版本号',
    `app_id` varchar(64) DEFAULT NULL COMMENT '应用id',
    `create_time` datetime DEFAULT NULL COMMENT '时间戳',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `create_id` bigint(19) DEFAULT NULL COMMENT '创建者ID',
    `update_id` bigint(19) DEFAULT NULL COMMENT '更新者ID',
    PRIMARY KEY (`project_repository_id`)
) ENGINE=InnoDB COMMENT='';

drop table if exists `project_ops`;
CREATE TABLE IF NOT EXISTS `project_ops`(
    `project_ops_id` bigint(19) NOT NULL COMMENT '项目运维ID',
    `project_instance_id` bigint(19) DEFAULT NULL COMMENT '项目ID',
    `script` varchar(64) DEFAULT NULL COMMENT '脚本',
    `script_name` varchar(64) DEFAULT NULL COMMENT '脚本名称[mvn-build,mvn-deploy,docker-build]',
    `stage` integer(11) DEFAULT NULL COMMENT '阶段',
    `revision` integer(11) DEFAULT NULL COMMENT '版本号',
    `app_id` varchar(64) DEFAULT NULL COMMENT '应用id',
    `create_time` datetime DEFAULT NULL COMMENT '时间戳',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `create_id` bigint(19) DEFAULT NULL COMMENT '创建者ID',
    `update_id` bigint(19) DEFAULT NULL COMMENT '更新者ID',
    PRIMARY KEY (`project_ops_id`)
) ENGINE=InnoDB COMMENT='';

drop table if exists `project_flow`;
CREATE TABLE IF NOT EXISTS `project_flow`(
    `project_flow_id` bigint(19) NOT NULL COMMENT '项目流程ID',
    `project_instance_id` bigint(19) DEFAULT NULL COMMENT '项目ID',
    `stage_name` varchar(64) DEFAULT NULL COMMENT '阶段名称[一周任ddf务，待测试，待修复，待验收，已完成]',
    `seq` integer(11) DEFAULT NULL COMMENT '阶段序列[0:一周任务，1:待测试，2:待修复，3:待验收，4:已完成]',
    `flow_bonus_percent` decimal DEFAULT NULL COMMENT '流程奖金百分比',
    `revision` integer(11) DEFAULT NULL COMMENT '版本号',
    `app_id` varchar(64) DEFAULT NULL COMMENT '应用id',
    `create_time` datetime DEFAULT NULL COMMENT '时间戳',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `create_id` bigint(19) DEFAULT NULL COMMENT '创建者ID',
    `update_id` bigint(19) DEFAULT NULL COMMENT '更新者ID',
    PRIMARY KEY (`project_flow_id`)
) ENGINE=InnoDB COMMENT='';

drop table if exists `project_kanban`;
CREATE TABLE IF NOT EXISTS `project_kanban`(
    `project_kanban_id` bigint(19) NOT NULL COMMENT '项目看板Id',
    `project_instance_id` bigint(19) DEFAULT NULL COMMENT '项目ID',
    `project_flow_id` bigint(19) DEFAULT NULL COMMENT '项目流程ID',
    `account_instance_id` bigint(19) DEFAULT NULL COMMENT '成员账号ID',
    `nickname` varchar(64) DEFAULT NULL COMMENT '账号昵称',
    `personal_bonus_percent` decimal DEFAULT NULL COMMENT '个人奖金百分比',
    `revision` integer(11) DEFAULT NULL COMMENT '版本号',
    `app_id` varchar(64) DEFAULT NULL COMMENT '应用id',
    `create_time` datetime DEFAULT NULL COMMENT '时间戳',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `create_id` bigint(19) DEFAULT NULL COMMENT '创建者ID',
    `update_id` bigint(19) DEFAULT NULL COMMENT '更新者ID',
    PRIMARY KEY (`project_kanban_id`)
) ENGINE=InnoDB COMMENT='';

drop table if exists `project_member`;
CREATE TABLE IF NOT EXISTS `project_member`(
    `project_member_id` bigint(19) NOT NULL COMMENT '项目成员ID',
    `project_instance_id` bigint(19) DEFAULT NULL COMMENT '项目ID',
    `account_instance_id` bigint(19) DEFAULT NULL COMMENT '成员账号ID',
    `user_instance_id` bigint(19) DEFAULT NULL COMMENT '成员用户ID',
    `nickname` varchar(64) DEFAULT NULL COMMENT '账号昵称',
    `member_role` varchar(64) DEFAULT NULL COMMENT '参与者角色[h5，java，test...]',
    `revision` integer(11) DEFAULT NULL COMMENT '版本号',
    `app_id` varchar(64) DEFAULT NULL COMMENT '应用id',
    `create_time` datetime DEFAULT NULL COMMENT '时间戳',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `create_id` bigint(19) DEFAULT NULL COMMENT '创建者ID',
    `update_id` bigint(19) DEFAULT NULL COMMENT '更新者ID',
    PRIMARY KEY (`project_member_id`)
) ENGINE=InnoDB COMMENT='';

drop table if exists `project_setting`;
CREATE TABLE IF NOT EXISTS `project_setting`(
    `project_setting_id` bigint(19) NOT NULL COMMENT '项目设置ID',
    `project_instance_id` bigint(19) DEFAULT NULL COMMENT '项目ID',
    `project_source_id` bigint(19) DEFAULT NULL COMMENT '项目源表ID',
    `project_source` varchar(64) DEFAULT NULL COMMENT '项目源表(表名)[demand,document,task...]',
    `setting_key` varchar(64) DEFAULT NULL COMMENT '设置key[如gitlab,mysl.report[0:日报，1:周报，2:月报，3：季度报，4，年报...]，cron表达式,..]',
    `setting_json` varchar(64) DEFAULT NULL COMMENT '设置json值',
    `revision` integer(11) DEFAULT NULL COMMENT '版本号',
    `app_id` varchar(64) DEFAULT NULL COMMENT '应用id',
    `create_time` datetime DEFAULT NULL COMMENT '时间戳',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `create_id` bigint(19) DEFAULT NULL COMMENT '创建者ID',
    `update_id` bigint(19) DEFAULT NULL COMMENT '更新者ID',
    PRIMARY KEY (`project_setting_id`)
) ENGINE=InnoDB COMMENT='';

drop table if exists `project_tag`;
CREATE TABLE IF NOT EXISTS `project_tag`(
    `project_tag_id` bigint(19) NOT NULL COMMENT '项目标签ID',
    `project_instance_id` bigint(19) DEFAULT NULL COMMENT '项目ID',
    `tag_name` varchar(64) DEFAULT NULL COMMENT '标签名称',
    `tag_color` varchar(64) DEFAULT NULL COMMENT '标签颜色',
    `revision` integer(11) DEFAULT NULL COMMENT '版本号',
    `app_id` varchar(64) DEFAULT NULL COMMENT '应用id',
    `create_time` datetime DEFAULT NULL COMMENT '时间戳',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `create_id` bigint(19) DEFAULT NULL COMMENT '创建者ID',
    `update_id` bigint(19) DEFAULT NULL COMMENT '更新者ID',
    PRIMARY KEY (`project_tag_id`)
) ENGINE=InnoDB COMMENT='';

drop table if exists `project_attachment`;
CREATE TABLE IF NOT EXISTS `project_attachment`(
    `project_attachment_id` bigint(19) NOT NULL COMMENT '项目附件ID',
    `project_instance_id` bigint(19) DEFAULT NULL COMMENT '项目ID',
    `account_instance_id` bigint(19) DEFAULT NULL COMMENT '账号ID',
    `project_source_id` bigint(19) DEFAULT NULL COMMENT '项目源表ID',
    `project_source` varchar(64) DEFAULT NULL COMMENT '项目源表(表名)[demand,document,task...]',
    `doc_title` varchar(64) DEFAULT NULL COMMENT '文档标题',
    `description` varchar(64) DEFAULT NULL COMMENT '文档描述',
    `oss_code` varchar(64) DEFAULT NULL COMMENT '存储器编码[db|local|cos|oss|s3..]',
    `doc_link` varchar(64) DEFAULT NULL COMMENT '文档链接地址',
    `md5` varchar(64) DEFAULT NULL COMMENT 'md5',
    `format` varchar(64) DEFAULT NULL COMMENT '格式[txt,doc,pdf]',
    `content` text DEFAULT NULL COMMENT '文档类容',
    `doc_type` integer(11) DEFAULT NULL COMMENT '文档类型[0:需求，1:汇报[日|周|月|年],2.....]',
    `revision` integer(11) DEFAULT NULL COMMENT '版本号',
    `app_id` varchar(64) DEFAULT NULL COMMENT '应用id',
    `create_time` datetime DEFAULT NULL COMMENT '时间戳',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `create_id` bigint(19) DEFAULT NULL COMMENT '创建者ID',
    `update_id` bigint(19) DEFAULT NULL COMMENT '更新者ID',
    PRIMARY KEY (`project_attachment_id`)
) ENGINE=InnoDB COMMENT='';



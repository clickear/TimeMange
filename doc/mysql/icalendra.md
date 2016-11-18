


## 表结构说明

```
CREATE TABLE `task_events` (
  `eventsid` int(11) NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  `start` datetime DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  `description` tinytext,
  `state` tinyint(4) DEFAULT '0' COMMENT '0 未完成 1 已完成',
  PRIMARY KEY (`eventsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='每日待办事项表：记录待办事项';


``` 

```
CREATE TABLE `mydb`.`sys_user` (
  `userId` BIGINT(20) NOT NULL COMMENT '用户表',
  `userName` VARCHAR(100) NULL COMMENT '用户昵称',
  `avatar` VARCHAR(100) NULL COMMENT '用户头像地址',
  PRIMARY KEY (`userId`)
  );
  ```
  
  ```
CREATE TABLE `mydb`.`sys_user_auth` (
  `auth_id` BIGINT(20) NOT NULL,
  `user_id` BIGINT(20) NULL,
  `identity_type` VARCHAR(100) NULL COMMENT '登录类型（手机号 邮箱 用户名）或第三方应用名称（微信 微博等）',
  `identifier` VARCHAR(100) NULL COMMENT '标识（手机号 邮箱 用户名或第三方应用的唯一标识）',
  `credential` VARCHAR(100) NULL COMMENT '密码凭证（站内的保存密码，站外的不保存或保存token）',
  PRIMARY KEY (`auth_id`));
```

```
DROP TABLE IF EXISTS `sys_auth`;

CREATE TABLE `sys_auth` (
  `auth_id` bigint(20) NOT NULL,
  `api_key` varchar(100) DEFAULT NULL COMMENT '客户端apiKey',
  `api_secret` varchar(100) DEFAULT NULL COMMENT '客户端apiSecret',
  `callback` varchar(100) DEFAULT NULL COMMENT '回调网址',
  `accesstoken_url` varchar(100) DEFAULT NULL COMMENT '获取token地址',
  `accesstoen_auth_url` varchar(100) DEFAULT NULL COMMENT '获取auth地址',
  `auth_code` varchar(100) DEFAULT NULL,
  `auth_type` tinyint(4) DEFAULT NULL COMMENT '类型，比如1 代表github',
  `auth_name` varchar(100) DEFAULT NULL COMMENT '名称 github',
  `auth_check_code` varchar(100) DEFAULT NULL COMMENT '用于获取唯一Id值',
  `auth_check_url` varchar(100) DEFAULT NULL COMMENT '获取用户信息',
  PRIMARY KEY (`auth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

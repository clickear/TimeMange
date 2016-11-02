


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





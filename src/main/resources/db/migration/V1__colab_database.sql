
/*
Source Host           : localhost:3306
Source Database       : colab
Target Server Type    : MYSQL
Author                : Fonix-WHUT
Date: 2022-05-25
*/


create table user
(
    id          int primary key auto_increment,
    username    varchar(50) not null unique,
    password    varchar(50) not null,
    phone       varchar(11),
    email       varchar(25),
    sex         varchar(3),
    age         int,
    address     varchar(50),
    creat_time  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)engine=InnoDB default charset=utf8 auto_increment=1 comment = "用户表";
insert into user(id, username, password, phone, email, sex, age, address)
values (1, 'admin', '12345', '183', '123456789@qq.com', '男', 18, '武汉');
insert into user(id, username, password, phone, email, sex, age, address)
values (2, 'admin2', '12345', '183', '123456789@qq.com', '男', 18, '武汉');


create table lab_info
(
    id            int primary key auto_increment,
    labNum        varchar(128) not null unique,
    name          varchar(128) not null unique,
    type          varchar(128) NULL DEFAULT NULL,
    peopleCount   int          not null default 1,
    address       varchar(128) NULL DEFAULT NULL,
    positionCount int NULL DEFAULT NULL,
    mentor        varchar(128) NULL DEFAULT NULL,
    creator       varchar(128) not null,
    manager       varchar(128) NULL DEFAULT NULL,
    creat_time    timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    update_time   timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)engine=InnoDB default charset=utf8 auto_increment=1 comment = "实验室信息表";
insert into lab_info(id, labNum, name, type, peopleCount, address, positionCount, mentor, creator, manager)
values (1, 'ABC123', '805实验室', '计算机', 30, '鉴4 805 ', 34, '多位老师', 'fonix', 'fonix');


create table lab_log
(
    id          int primary key auto_increment,
    lab_id      int not null,
    log         varchar(128),
    operater    varchar(128),
    time        datetime NULL DEFAULT NULL,
    creat_time  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)engine=InnoDB default charset=utf8 auto_increment=1 comment = "实验室日志表";

create table lab_activity
(
    id          int primary key auto_increment,
    lab_id      int          not null,
    topic       varchar(128) not null,
    hold_time   datetime     not null,
    location    varchar(128) NULL DEFAULT NULL,
    fare        varchar(128) NULL DEFAULT NULL,
    attendee    varchar(256) NULL DEFAULT NULL,
    host        varchar(128) not null,
    comeUp_time datetime     not null,
    state       varchar(128) not null,
    arrangement varchar(256) NULL DEFAULT NULL,
    creat_time  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)engine=InnoDB default charset=utf8 auto_increment=1 comment = "实验室活动表";
insert into lab_activity(id, lab_id, topic, hold_time, location, fare, attendee, host, comeUp_time, state)
values (1, 1, '聚餐活动', '2022-05-28 14:00:00', '升升', '50', 'fonix;admin', 'fonix', '2022-05-26 14:00:00', '即将开始');

create table lab_activity_blog
(
    id          int primary key auto_increment,
    activity_id int          not null,
    title       varchar(128) not null,
    content     longtext null default null,
    creat_time  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)engine=InnoDB default charset=utf8 auto_increment=1 comment = " 活动日志表";
insert into lab_activity_blog(id, activity_id, title, content)
values (1, 1, '聚餐活动', '一次愉快的聚餐活动即将开始，别忘了在结束后来记录本次活动的精彩瞬间');

create table lab_fortune
(
    id            int primary key auto_increment,
    lab_id        int          not null,
    fortune_name  varchar(128) not null,
    fortune_owner varchar(128) NULL DEFAULT NULL,
    fortune_state varchar(128) NULL DEFAULT NULL,
    fortune_value varchar(128) NULL DEFAULT NULL,
    purchase_time datetime NULL DEFAULT NULL,
    disable_time  datetime NULL DEFAULT NULL,
    creat_time    timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    update_time   timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)engine=InnoDB default charset=utf8 auto_increment=1 comment = " 实验室财产表";
insert into lab_fortune(id, lab_id, fortune_name, fortune_owner, fortune_state, fortune_value)
values (1, 1, '冰箱', '805实验室', '正常使用', '500');
insert into lab_fortune(id, lab_id, fortune_name, fortune_owner, fortune_state, fortune_value)
values (2, 1, '打印机', '805实验室', '正常使用', '1500');


create table lab_history
(
    id           int primary key auto_increment,
    lab_id       int          not null,
    event        varchar(128) not null,
    time         datetime NULL DEFAULT NULL,
    introduction varchar(256) NULL DEFAULT NULL,
    operator     varchar(128) NULL DEFAULT NULL,
    creat_time   timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    update_time  timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)engine=InnoDB default charset=utf8 auto_increment=1 comment = " 实验室历史";

create table lab_achievement
(
    id           int primary key auto_increment,
    lab_id       int          not null,
    achievement  varchar(128) not null,
    time         datetime NULL DEFAULT NULL,
    introduction varchar(256) NULL DEFAULT NULL,
    achiever     varchar(128) NULL DEFAULT NULL,
    operator     varchar(128) NULL DEFAULT NULL,
    creat_time   timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    update_time  timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)engine=InnoDB default charset=utf8 auto_increment=1 comment = " 实验室成果";

create table info_userandlab
(
    id          int primary key auto_increment,
    userName    varchar(256) not null,
    labId       int          not null,
    labName     varchar(256) not null,
    permission  varchar(256) not null default 'member',
    creat_time  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)engine=InnoDB default charset=utf8 auto_increment=1 comment = " 个人与实验室信息";
insert into info_userandlab(id, userName, labId, labName, permission)
values (1, 'admin', 1, '805实验室', 'member');
create table log_userandlab
(
    id          int primary key auto_increment,
    labId       int          not null,
    username    varchar(256) not null,
    event       varchar(256),
    time        datetime,
    creat_time  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)engine=InnoDB default charset=utf8 auto_increment=1 comment = " 个人与实验室相关日志";

create table user_center
(
    id          int primary key auto_increment,
    username    varchar(256) not null,
    labIds      varchar(256) null default null,
    labcount    int default 0,
    creat_time  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)engine=InnoDB default charset=utf8 auto_increment=1 comment = " 个人中心表";

create table user_achievement
(
    id          int primary key auto_increment,
    username    varchar(256) not null,
    achievement varchar(256) not null,
    creat_time  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)engine=InnoDB default charset=utf8 auto_increment=1 comment = " 个人成就表"
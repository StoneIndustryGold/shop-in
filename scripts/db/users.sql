 ----------------------------------------用户表
 		--id
 用户名字--username
 密码------password
 性别--sex
 年龄--age
 邮箱--GMail
 是否启用--enabled
 图像---images
 
 create table users(
        id integer primary key,
        username varchar(64) not null,
        password varchar(128) not null,
        sex varchar(64),
        age_id integer ,
        gmail varchar(128),
        enabled varchar2(1),
        images varchar(2000),
        LAST_LOGIN_TIME timestamp
 )
 
 
 create sequence users_seq
       INCREMENT BY 1  -- 每次加几个  
       START WITH 1    -- 从1开始计数  
       NOMAXVALUE      -- 不设置最大值  
       NOCYCLE   -- 一直累加，不循环  
 
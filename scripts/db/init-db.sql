

--brand --牌子
--model --型号
--os --系统（IOS、Android、Windows Phone）
--cpubrand --品牌（高通、联发科）
--ram --内存
--color --颜色
--description --描述
--price--价格
--images --图片

create table cellpones(----------------------------------------------手机表
       id integer primary key,
       brand varchar(64) not null,--牌子
       model varchar(64) not null,--型号
       os varchar(64) not null, --系统（IOS、Android、Windows Phone）
       cpubrand varchar(64),--品牌（高通、联发科）
       ram int not null,--内存
       color varchar(64) not null,--颜色
       description varchar(64) not null,--描述                         
       price int not null,--价格
       
       images varchar(500) --图片
)

create sequence cellpones_seq
       INCREMENT BY 1  -- 每次加几个  
       START WITH 1    -- 从1开始计数  
       NOMAXVALUE      -- 不设置最大值  
       NOCYCLE -- 一直累加，不循环  
       
 =------------- ----------------------------------------用户表
 		--id
 用户名字--username
 密码------password
 性别--sex
 年龄--age
 邮箱--GMail
 是否启用--enabled
 图像---images
 
 create table users(-----用户表
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
       
       
 ------------------------------------------------------ --购物车
--- 用户id
--手机id
--数量 
create table carts(
       id integer primary key,
       user_id integer not null,
       cellpone_id integer not null,
       count integer     
  ) 

 create sequence carts_seq
        INCREMENT BY 1  -- 每次加几个  
       START WITH 1    -- 从1开始计数  
       NOMAXVALUE      -- 不设置最大值  
       NOCYCLE
       
 alter table carts add foreign key (user_id) references users(id)
 alter table carts add foreign key (cellpone_id)references cellpones(id) 
       
                
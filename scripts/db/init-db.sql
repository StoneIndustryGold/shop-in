

--brand --牌子
--model --型号
--os --系统（IOS、Android、Windows Phone）
--cpubrand --品牌（高通、联发科）
--ram --内存
--color --颜色
--description --描述
--price--价格
--images --图片

create table cellpones(--手机表
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
                
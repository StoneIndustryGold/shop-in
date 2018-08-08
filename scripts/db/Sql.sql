--增加语句

--往序列了增加数据的语句
	方法一：insert into  TextName values(TextName_sesq.nextval,'张三','123','男')
	方法二：insert into  TestName(name,password,exs)value('张三','123','男')
	模糊查找： select * from TextName where name like '张%'
	多表联查： select * from TextName t 
	内联一定有数据：	inner join b表 b on b.a_id=t.id
	外联不一定有数据：	left join a表 a on a.t_id=b.id
	
--修改语句
	单个修改：update TextName set name='李四' where id=2
	多个修改：update TextName ste name='李四',password='1234' where id=2

--删除语句
	删掉表里所有信息：delete from TextName
	删掉表里id2信息:delete from TextName where id=2
	
	删掉时间过期数据：elete from Orders where 
	       		"state"='Canceled'--状态为取消
	       		 and current_timestamp - createtime >=interval '2' day; 
							--当前时间       减去      创建时间  大于=间隔 ‘2’天；
	删除序列：drop sequence  TextName_seq      	
	  删除表：drop table TextName_seq
	
	
	
       		 
drop table shop_product cascade constraint;
drop table shop_user cascade constraint;

drop sequence shop_product_seq;

create sequence shop_product_seq;

create table shop_user
( username varchar2(20) primary key,
  password varchar2(10) not null,
  name varchar2(20) not null,
  zip number(6) ,
  address varchar2(30)
);

create table shop_product
( id number(7) primary key,
  productName varchar2(20) not null,
  price number(7,2),
  picpath varchar2(40),
  discription varchar2(40)
);

insert into shop_product(id,productname,price,picpath) 
values(shop_product_seq.nextval,'Java编程思想',96,'/image/product/cover.gif');
insert into shop_product(id,productname,price,picpath) 
values(shop_product_seq.nextval,'精通Hibernate',68,'/image/product/zcover2.gif');
insert into shop_product(id,productname,price,picpath) 
values(shop_product_seq.nextval,'Java核心技术卷',87,'/image/product/zcover3.gif');
insert into shop_product(id,productname,price,picpath) 
values(shop_product_seq.nextval,'Effective Java中文版',28,'/image/product/zcover4.gif');
insert into shop_product(id,productname,price,picpath) 
values(shop_product_seq.nextval,'Java与模式',45,'/image/product/zcover5.gif');
insert into shop_product(id,productname,price,picpath) 
values(shop_product_seq.nextval,'深入浅出Hibernate',60,'/image/product/zcover6.gif');
insert into shop_product(id,productname,price,picpath) 
values(shop_product_seq.nextval,'Tomcat与JavaWeb 核心技术详解',29.3,'/image/product/zcover7.gif');
insert into shop_product(id,productname,price,picpath) 
values(shop_product_seq.nextval,'精通Spring',24.2,'/image/product/zcover8.gif');
commit;

insert into shop_user(username,password,name,zip,address)
values('luxw','1234','陆晓伟','100000','亮马桥');
insert into shop_user(username,password,name,zip,address)
values('liucy','2222','刘春阳','100000','北苑家园');
commit;

select * from shop_user;
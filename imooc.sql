CREATE TABLE `product_category` (
  `category_id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(100) NOT NULL,
  `category_type` INT NOT NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp on update current_timestamp,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `uqe_category_type` (`category_type`));

insert into product_category(category_name,category_type) values('热榜',11),('好吃的',22);

create table `product_info`(
`product_id` varchar(32) not null,
`product_name` varchar(64) not null,
`product_price` decimal(8,2) not null,
`product_stock` int not null,
`product_description` varchar(64),
`product_icon` varchar(512),
`product_status` tinyint(3) default '0',
`category_type` int not null,
`create_time` timestamp not null default current_timestamp,
`update_time` timestamp not null default current_timestamp on update current_timestamp,
primary key (`product_id`));

insert into `product_info`(product_id, product_name,product_price,product_stock,product_description,product_status,category_type) values
('111aaa','皮蛋粥',0.01,100,'taste good',0,11),
('aaabbb','蛋糕',10,23,'sweet',0,22),
('aaabba','油条',2,30,'早餐',0,22);

create table `order_master`(
`order_id` varchar(32) not null,
`buyer_name` varchar(32) not null,
`buyer_phone` varchar(32) not null,
`buyer_address` varchar(128) not null,
`buyer_openid` varchar(64) not null,
`order_amount` decimal(8,2) not null,
`order_status` tinyint(3) not null default '0',
`pay_status` tinyint(3) not null default '0',
`create_time` timestamp not null default current_timestamp,
`update_time` timestamp not null default current_timestamp on UPDATE current_timestamp,
primary key(`order_id`),
key `idx_buyer_openid` (`buyer_openid`));

create table `order_detail`(
`detail_id` varchar(32) not null,
`order_id` varchar(32) not null,
`product_id` varchar(32) not null,
`product_name` varchar(64) not null,
`product_price` decimal(8,2) not null,
`product_quantity` int not null,
`product_icon` varchar(512),
`create_time` timestamp not null default current_timestamp,
`update_time` timestamp not null default current_timestamp on UPDATE current_timestamp,
primary key(`detail_id`),
key `idx_order_id` (`order_id`),
foreign key(`order_id`) references order_master(`order_id`));
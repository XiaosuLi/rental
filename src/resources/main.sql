--数据库初始化脚本

--创建项目使用的数据库
CREATE DATABASE rental;
--UserID、userphone、username、
-- userpassword（明文）、userpasswordMD5、
-- userphoto、userturename、userIdcardnumber
--创建user表
--++注意使用中文的`这个标记mysql可以识别，且不能把注释带过去
use rental;
CREATE TABLE user(
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_phone` VARCHAR(11) NOT NULL ,
  `user_name` VARCHAR (128) NOT NULL ,
  `user_password` VARCHAR (128) NOT  NULL ,
  `user_password_md5` VARCHAR (255),
  `user_photo` VARCHAR(255),
  `user_real_name` VARCHAR (32),
  `user_ID_number` VARCHAR(32),
  --ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8
  --最后不需要，结尾
  PRIMARY KEY (user_id)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

--插入一个测试用户小苏
--++定义为varchar的字段需要引号
INSERT INTO user (user_phone,user_name,user_password)
VALUES
(13012345678,'小苏',123456);


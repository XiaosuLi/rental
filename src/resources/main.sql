--���ݿ��ʼ���ű�

--������Ŀʹ�õ����ݿ�
CREATE DATABASE rental;
--UserID��userphone��username��
-- userpassword�����ģ���userpasswordMD5��
-- userphoto��userturename��userIdcardnumber
--����user��
--++ע��ʹ�����ĵ�`������mysql����ʶ���Ҳ��ܰ�ע�ʹ���ȥ
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
  --�����Ҫ����β
  PRIMARY KEY (user_id)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

--����һ�������û�С��
--++����Ϊvarchar���ֶ���Ҫ����
INSERT INTO user (user_phone,user_name,user_password)
VALUES
(13012345678,'С��',123456);


SET NAMES utf8mb4;

SET FOREIGN_KEY_CHECKS = 0;-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE
IF
	EXISTS `admin`;
CREATE TABLE `admin` (
	`adminID` VARCHAR ( 10 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员工号',
	`account` VARCHAR ( 10 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员姓名',
	`password` VARCHAR ( 20 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
	PRIMARY KEY ( `adminID` ) USING BTREE 
) ENGINE = INNODB CHARACTER 
SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;-- ----------------------------
-- Table structure for check_customer
-- ----------------------------
DROP TABLE
IF
	EXISTS `check_customer`;
CREATE TABLE `check_customer` (
	`customerID` VARCHAR ( 18 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
	`name` VARCHAR ( 10 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
	`gender` TINYINT ( 1 ) NULL DEFAULT NULL COMMENT '性别 1 男 0 女',
	`phone` VARCHAR ( 20 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
	PRIMARY KEY ( `customerID` ) USING BTREE,
	INDEX `customerID` ( `customerID` ) USING BTREE 
) ENGINE = INNODB CHARACTER 
SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;-- ----------------------------
-- Table structure for customer_order
-- ----------------------------
DROP TABLE
IF
	EXISTS `customer_order`;
CREATE TABLE `customer_order` (
	`orderID` INT ( 4 ) NOT NULL COMMENT '订单号',
	`customerID` VARCHAR ( 18 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
	`roomID` VARCHAR ( 3 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间号',
	`checkInTime` date NULL DEFAULT NULL COMMENT '入住时间',
	`leaveTime` date NULL DEFAULT NULL COMMENT '离开时间',
	`living` TINYINT ( 1 ) NULL DEFAULT NULL COMMENT '0 表示离开 1 表示未到或已入住',
	PRIMARY KEY ( `orderID`, `customerID` ) USING BTREE,
	INDEX `orderID` ( `orderID` ) USING BTREE,
	INDEX `customerID` ( `customerID` ) USING BTREE,
	INDEX `roomID` ( `roomID` ) USING BTREE,
	CONSTRAINT `customer_order_ibfk_1` FOREIGN KEY ( `orderID` ) REFERENCES `order` ( `orderID` ) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT `customer_order_ibfk_2` FOREIGN KEY ( `customerID` ) REFERENCES `check_customer` ( `customerID` ) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT `customer_order_ibfk_3` FOREIGN KEY ( `roomID` ) REFERENCES `room` ( `roomID` ) ON DELETE RESTRICT ON UPDATE RESTRICT 
) ENGINE = INNODB CHARACTER 
SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE
IF
	EXISTS `member`;
CREATE TABLE `member` (
	`level` INT ( 1 ) NOT NULL COMMENT '会员等级',
	`discount` DOUBLE ( 4, 2 ) NULL DEFAULT NULL COMMENT '会员折扣',
	`memberDetail` VARCHAR ( 50 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细信息',
	PRIMARY KEY ( `level` ) USING BTREE,
	INDEX `level` ( `level` ) USING BTREE 
) ENGINE = INNODB CHARACTER 
SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE
IF
	EXISTS `message`;
CREATE TABLE `message` (
	`no` INT ( 3 ) NOT NULL AUTO_INCREMENT COMMENT '自增序号',
	`title` VARCHAR ( 20 ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '消息标题',
	`content` VARCHAR ( 50 ) CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '消息内容',
	`sendTime` date NULL DEFAULT NULL COMMENT '消息发送时间',
	PRIMARY KEY ( `no` ) USING BTREE 
) ENGINE = INNODB AUTO_INCREMENT = 9 CHARACTER 
SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE
IF
	EXISTS `order`;
CREATE TABLE `order` (
	`orderID` INT ( 4 ) NOT NULL AUTO_INCREMENT COMMENT '订单号',
	`phone` VARCHAR ( 20 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册会员手机号',
	`roomType` VARCHAR ( 20 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间类型',
	`orderTime` date NULL DEFAULT NULL COMMENT '预定时间',
	`checkInTime` date NULL DEFAULT NULL COMMENT '入住时间',
	`leaveTime` date NULL DEFAULT NULL COMMENT '离开时间',
	`payment` DOUBLE ( 7, 2 ) NULL DEFAULT NULL COMMENT '支付金额',
	`roomNum` INT ( 2 ) NULL DEFAULT NULL COMMENT '房间数量',
	`orderDetail` VARCHAR ( 50 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细信息',
	`orderStatus` TINYINT ( 1 ) NULL DEFAULT NULL COMMENT '订单状态\r\n0 未完成\r\n1 已完成',
	PRIMARY KEY ( `orderID` ) USING BTREE,
	INDEX `order_register_phone_foreign` ( `phone` ) USING BTREE,
	CONSTRAINT `order_register_phone_foreign` FOREIGN KEY ( `phone` ) REFERENCES `register` ( `phone` ) ON DELETE RESTRICT ON UPDATE RESTRICT 
) ENGINE = INNODB AUTO_INCREMENT = 23 CHARACTER 
SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE
IF
	EXISTS `register`;
CREATE TABLE `register` (
	`phone` VARCHAR ( 20 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码',
	`account` VARCHAR ( 10 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
	`password` VARCHAR ( 20 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
	`gender` TINYINT ( 1 ) NULL DEFAULT NULL COMMENT '性别',
	`email` VARCHAR ( 30 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
	`level` INT ( 1 ) NULL DEFAULT NULL COMMENT '会员等级',
	`score` INT ( 5 ) NULL DEFAULT NULL COMMENT '会员积分',
	PRIMARY KEY ( `phone` ) USING BTREE,
	INDEX `orderCustomer_member_level_foreign` ( `level` ) USING BTREE,
	CONSTRAINT `orderCustomer_member_level_foreign` FOREIGN KEY ( `level` ) REFERENCES `member` ( `level` ) ON DELETE RESTRICT ON UPDATE RESTRICT 
) ENGINE = INNODB CHARACTER 
SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE
IF
	EXISTS `room`;
CREATE TABLE `room` (
	`roomID` VARCHAR ( 3 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '房间号',
	`roomType` VARCHAR ( 20 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间类型',
	`roomDetail` VARCHAR ( 50 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细信息',
	`roomStatus` TINYINT ( 1 ) NULL DEFAULT NULL COMMENT '1 房间空余 0 房间不空余',
	PRIMARY KEY ( `roomID` ) USING BTREE,
	INDEX `room_roomType_type_foreign` ( `roomType` ) USING BTREE,
	CONSTRAINT `room_roomType_type_foreign` FOREIGN KEY ( `roomType` ) REFERENCES `room_type` ( `type` ) ON DELETE RESTRICT ON UPDATE RESTRICT 
) ENGINE = INNODB CHARACTER 
SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;-- ----------------------------
-- Table structure for room_type
-- ----------------------------
DROP TABLE
IF
	EXISTS `room_type`;
CREATE TABLE `room_type` (
	`type` VARCHAR ( 20 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '房间类型',
	`checkInNum` INT ( 1 ) NULL DEFAULT NULL COMMENT '房间最多入住人数',
	`roomPrice` INT ( 3 ) NULL DEFAULT NULL COMMENT '房间价格',
	PRIMARY KEY ( `type` ) USING BTREE 
) ENGINE = INNODB CHARACTER 
SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;-- ----------------------------
-- Table structure for waiter
-- ----------------------------
DROP TABLE
IF
	EXISTS `waiter`;
CREATE TABLE `waiter` (
	`waiterID` VARCHAR ( 10 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务员工号',
	`account` VARCHAR ( 10 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务员姓名',
	`password` VARCHAR ( 20 ) CHARACTER 
	SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
	PRIMARY KEY ( `waiterID` ) USING BTREE 
) ENGINE = INNODB CHARACTER 
SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;-- ----------------------------
-- Triggers structure for table register
-- ----------------------------
DROP TRIGGER
IF
	EXISTS `insert_level`;

delimiter;;
CREATE TRIGGER `insert_level` BEFORE INSERT ON `register` FOR EACH ROW
BEGIN
	IF
		new.score < 1000 THEN#UPDATE register SET `level`=1 WHERE phone=new.phone;
			
			SET new.LEVEL = 1;
		
		ELSEIF new.score < 3000 THEN#UPDATE register SET `level`=2 WHERE phone=new.phone;
		
		SET new.LEVEL = 2;
		
		ELSEIF new.score < 6000 THEN#UPDATE register SET `level`=3 WHERE phone=new.phone;
		
		SET new.LEVEL = 3;
		ELSE #UPDATE register SET `level`=4 WHERE phone=new.phone;
		
		SET new.LEVEL = 4;
		
	END IF;
	
END;;

delimiter;-- ----------------------------
-- Triggers structure for table register
-- ----------------------------
DROP TRIGGER
IF
	EXISTS `update_level`;

delimiter;;
CREATE TRIGGER `update_level` BEFORE UPDATE ON `register` FOR EACH ROW
BEGIN
	IF
		new.score < 1000 THEN#UPDATE register SET `level`=1 WHERE phone=new.phone;
			
			SET new.LEVEL = 1;
		
		ELSEIF new.score < 3000 THEN#UPDATE register SET `level`=2 WHERE phone=new.phone;
		
		SET new.LEVEL = 2;
		
		ELSEIF new.score < 6000 THEN#UPDATE register SET `level`=3 WHERE phone=new.phone;
		
		SET new.LEVEL = 3;
		ELSE #UPDATE register SET `level`=4 WHERE phone=new.phone;
		
		SET new.LEVEL = 4;
		
	END IF;
	
END;;

delimiter;

SET FOREIGN_KEY_CHECKS = 1;
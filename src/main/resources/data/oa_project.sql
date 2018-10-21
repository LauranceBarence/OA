/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : oa_project

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-10-22 05:45:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for affair
-- ----------------------------
DROP TABLE IF EXISTS `affair`;
CREATE TABLE `affair` (
  `affair_id` int(10) NOT NULL AUTO_INCREMENT,
  `affair_module_id` int(10) DEFAULT NULL,
  `affair_data` longtext,
  `proposer` int(10) DEFAULT '1',
  `affair_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`affair_id`) USING BTREE,
  KEY `fk_form_status` (`proposer`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of affair
-- ----------------------------
INSERT INTO `affair` VALUES ('1', null, null, null, '0');
INSERT INTO `affair` VALUES ('2', '1', '\'						<input type=\"text\" class=\"hidden\" id=\"content\" name=\"html\">												<input type=\"text\" class=\"hidden\" name=\"affairModuleId\" value=\"1\" disabled=\"disabled\">						  <div class=\"form-group\">						  						     <!-- 多选框 -->					    		<label for=\"\" class=\"col-sm-2 control-label\">请假事由</label>					    		<div class=\"col-sm-10\">					    			<!-- 遍历选项 -->								    <label class=\"checkbox-inline\">								        <input type=\"checkbox\" value=\"\" checked=\"checked\" disabled=\"disabled\"> 								    </label>							    </div>													    							  </div>						  <div class=\"form-group\">						  						     <!-- 日期时间 -->					    		<label for=\"\" class=\"col-sm-2 control-label\">请假开始时间</label>							    <div class=\"col-sm-10\">							      <input type=\"datetime-local\" class=\"form-control\" value=\"2018-10-22T00:00\" disabled=\"disabled\">							    </div>							    						  </div>						  <div class=\"form-group\">						  						     <!-- 日期时间 -->					    		<label for=\"\" class=\"col-sm-2 control-label\">请假结束时间</label>							    <div class=\"col-sm-10\">							      <input type=\"datetime-local\" class=\"form-control\" value=\"2018-10-23T23:59\" disabled=\"disabled\">							    </div>							    						  </div>					\'', '1', '0');

-- ----------------------------
-- Table structure for affair_chain
-- ----------------------------
DROP TABLE IF EXISTS `affair_chain`;
CREATE TABLE `affair_chain` (
  `affair_chain_id` int(11) NOT NULL,
  `affair_id` int(11) DEFAULT NULL,
  `affair_chain_order` int(11) DEFAULT NULL,
  `affair_chain_status` int(11) DEFAULT NULL,
  `affair_comment` varchar(255) DEFAULT NULL,
  `approver` int(11) DEFAULT NULL,
  PRIMARY KEY (`affair_chain_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of affair_chain
-- ----------------------------

-- ----------------------------
-- Table structure for affair_module
-- ----------------------------
DROP TABLE IF EXISTS `affair_module`;
CREATE TABLE `affair_module` (
  `module_id` int(11) NOT NULL AUTO_INCREMENT,
  `module_name` varchar(255) DEFAULT NULL,
  `designer_id` int(11) DEFAULT NULL,
  `module_status` int(11) DEFAULT '1',
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of affair_module
-- ----------------------------
INSERT INTO `affair_module` VALUES ('1', '请假申请单', '1', '1');
INSERT INTO `affair_module` VALUES ('2', '出差申请单', '1', '1');
INSERT INTO `affair_module` VALUES ('3', 'testAffair', '1', '1');
INSERT INTO `affair_module` VALUES ('4', 'admintest', '1', '1');
INSERT INTO `affair_module` VALUES ('5', 'admintest2', '1', '1');
INSERT INTO `affair_module` VALUES ('6', 'testAdmin3', '1', '1');

-- ----------------------------
-- Table structure for affair_module_chain
-- ----------------------------
DROP TABLE IF EXISTS `affair_module_chain`;
CREATE TABLE `affair_module_chain` (
  `module_chain_id` int(11) NOT NULL AUTO_INCREMENT,
  `order` int(10) DEFAULT NULL,
  `approver_id` int(11) DEFAULT NULL,
  `module_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`module_chain_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of affair_module_chain
-- ----------------------------
INSERT INTO `affair_module_chain` VALUES ('1', '1', '9', '4');
INSERT INTO `affair_module_chain` VALUES ('2', '2', '8', '4');
INSERT INTO `affair_module_chain` VALUES ('3', '3', '12', '4');
INSERT INTO `affair_module_chain` VALUES ('4', '4', '3', '4');
INSERT INTO `affair_module_chain` VALUES ('9', '1', '9', '6');
INSERT INTO `affair_module_chain` VALUES ('10', '2', '12', '6');
INSERT INTO `affair_module_chain` VALUES ('11', '3', '3', '6');
INSERT INTO `affair_module_chain` VALUES ('12', '4', '15', '6');
INSERT INTO `affair_module_chain` VALUES ('13', '5', '6', '6');
INSERT INTO `affair_module_chain` VALUES ('14', '1', '8', '5');
INSERT INTO `affair_module_chain` VALUES ('15', '2', '14', '5');

-- ----------------------------
-- Table structure for affair_module_part
-- ----------------------------
DROP TABLE IF EXISTS `affair_module_part`;
CREATE TABLE `affair_module_part` (
  `part_id` int(11) NOT NULL AUTO_INCREMENT,
  `part_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`part_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of affair_module_part
-- ----------------------------
INSERT INTO `affair_module_part` VALUES ('1', '单行文本框');
INSERT INTO `affair_module_part` VALUES ('2', '多行文本框');
INSERT INTO `affair_module_part` VALUES ('3', '多选框');
INSERT INTO `affair_module_part` VALUES ('4', '单选按钮');
INSERT INTO `affair_module_part` VALUES ('5', '下拉菜单');
INSERT INTO `affair_module_part` VALUES ('6', '日期');
INSERT INTO `affair_module_part` VALUES ('7', '时间');
INSERT INTO `affair_module_part` VALUES ('8', '日期时间');

-- ----------------------------
-- Table structure for affair_rel_module_part
-- ----------------------------
DROP TABLE IF EXISTS `affair_rel_module_part`;
CREATE TABLE `affair_rel_module_part` (
  `module_part_id` int(11) NOT NULL AUTO_INCREMENT,
  `module_id` int(11) DEFAULT NULL,
  `part_id` int(11) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `part_name` varchar(255) DEFAULT NULL,
  `part_data` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`module_part_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of affair_rel_module_part
-- ----------------------------
INSERT INTO `affair_rel_module_part` VALUES ('1', '1', '3', '1', '请假事由', null);
INSERT INTO `affair_rel_module_part` VALUES ('2', '1', '8', '2', '请假开始时间', null);
INSERT INTO `affair_rel_module_part` VALUES ('3', '1', '8', '3', '请假结束时间', null);
INSERT INTO `affair_rel_module_part` VALUES ('4', '2', '3', '1', '出差事由', '开会,业务交流,参观学习');
INSERT INTO `affair_rel_module_part` VALUES ('5', '2', '2', '2', '出差具体事由', null);
INSERT INTO `affair_rel_module_part` VALUES ('6', '2', '1', '3', '出差地点', null);
INSERT INTO `affair_rel_module_part` VALUES ('7', '2', '8', '4', '出差开始时间', null);
INSERT INTO `affair_rel_module_part` VALUES ('8', '2', '8', '5', '出差结束时间', null);
INSERT INTO `affair_rel_module_part` VALUES ('9', null, '1', '0', 'testpart1', null);
INSERT INTO `affair_rel_module_part` VALUES ('10', null, '2', '1', 'testpart2', null);
INSERT INTO `affair_rel_module_part` VALUES ('11', null, '1', '0', 'test222', null);
INSERT INTO `affair_rel_module_part` VALUES ('22', '5', '1', '0', 'test2222', '1,2,3');
INSERT INTO `affair_rel_module_part` VALUES ('23', '5', '1', '1', 'test22222', '1,5');

-- ----------------------------
-- Table structure for attendence
-- ----------------------------
DROP TABLE IF EXISTS `attendence`;
CREATE TABLE `attendence` (
  `attendence_id` int(10) NOT NULL,
  `user_id` int(10) DEFAULT NULL,
  `sign_in_time` datetime DEFAULT NULL,
  `sign_out_time` datetime DEFAULT NULL,
  PRIMARY KEY (`attendence_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of attendence
-- ----------------------------

-- ----------------------------
-- Table structure for attendence_standard
-- ----------------------------
DROP TABLE IF EXISTS `attendence_standard`;
CREATE TABLE `attendence_standard` (
  `attendence_id` int(10) NOT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `enable_status` int(1) DEFAULT '1',
  PRIMARY KEY (`attendence_id`) USING BTREE,
  KEY `fk_status_attend` (`enable_status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of attendence_standard
-- ----------------------------

-- ----------------------------
-- Table structure for attend_rank
-- ----------------------------
DROP TABLE IF EXISTS `attend_rank`;
CREATE TABLE `attend_rank` (
  `index_` int(10) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `attend_rate` double(10,2) DEFAULT NULL,
  `enattend_count` int(10) DEFAULT NULL,
  `late_count` int(10) DEFAULT NULL,
  `quit_count` int(10) DEFAULT NULL,
  PRIMARY KEY (`index_`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of attend_rank
-- ----------------------------

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `department_id` int(10) NOT NULL,
  `department_name` varchar(255) NOT NULL,
  `p_id` int(10) DEFAULT NULL,
  `chief_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`department_id`) USING BTREE,
  KEY `fk_chief_id_user_id` (`chief_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '总经理办公室', null, '11');
INSERT INTO `department` VALUES ('2', '业务集群I-王琰', '1', '8');
INSERT INTO `department` VALUES ('3', '业务集群II-余笑', '1', '7');
INSERT INTO `department` VALUES ('4', '财务部', '1', '2');
INSERT INTO `department` VALUES ('5', '人力资源部', '1', '3');
INSERT INTO `department` VALUES ('6', '行政管理部', '1', '3');
INSERT INTO `department` VALUES ('7', '市场部', '2', '4');
INSERT INTO `department` VALUES ('8', '销售部', '3', '5');
INSERT INTO `department` VALUES ('9', '就业部', '2', '6');
INSERT INTO `department` VALUES ('10', '教学部', '3', '19');
INSERT INTO `department` VALUES ('11', '教务部', '10', '19');

-- ----------------------------
-- Table structure for doc_status
-- ----------------------------
DROP TABLE IF EXISTS `doc_status`;
CREATE TABLE `doc_status` (
  `enable_status` int(10) NOT NULL,
  `status_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`enable_status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of doc_status
-- ----------------------------
INSERT INTO `doc_status` VALUES ('1', '启用');
INSERT INTO `doc_status` VALUES ('2', '弃用');

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `file_id` int(10) NOT NULL,
  `file_name` varchar(255) NOT NULL,
  `file_url` varchar(255) DEFAULT NULL,
  `file_owner` int(10) DEFAULT NULL,
  `file_status` int(1) DEFAULT '1',
  PRIMARY KEY (`file_id`) USING BTREE,
  KEY `fk_file_status` (`file_status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of file
-- ----------------------------

-- ----------------------------
-- Table structure for form
-- ----------------------------
DROP TABLE IF EXISTS `form`;
CREATE TABLE `form` (
  `form_id` int(10) NOT NULL,
  `form_name` varchar(255) DEFAULT NULL,
  `form_url` varchar(255) DEFAULT NULL,
  `form_status` int(10) DEFAULT '1',
  PRIMARY KEY (`form_id`) USING BTREE,
  KEY `fk_form_status` (`form_status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of form
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` int(10) NOT NULL,
  `menu_name` varchar(255) NOT NULL,
  `menu_url` varchar(255) DEFAULT NULL,
  `p_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '人力资源', '', '');
INSERT INTO `menu` VALUES ('2', '公文模块', '', '');
INSERT INTO `menu` VALUES ('3', '邮箱模块', '', '');
INSERT INTO `menu` VALUES ('4', '个人办公', '', '');
INSERT INTO `menu` VALUES ('5', '系统设置', '', '');
INSERT INTO `menu` VALUES ('6', '考勤管理', '', '1');
INSERT INTO `menu` VALUES ('7', '公告管理', '', '1');
INSERT INTO `menu` VALUES ('8', '员工管理', 'user/show', '1');
INSERT INTO `menu` VALUES ('9', '部门管理', '', '1');
INSERT INTO `menu` VALUES ('10', '角色管理', 'role/show', '1');
INSERT INTO `menu` VALUES ('11', '权限管理', 'permission/show', '1');
INSERT INTO `menu` VALUES ('12', '公文设计', 'affair_module/show', '2');
INSERT INTO `menu` VALUES ('13', '公文管理', 'affair/show', '2');
INSERT INTO `menu` VALUES ('14', '邮箱管理', '', '3');
INSERT INTO `menu` VALUES ('15', '工作日志', '', '4');
INSERT INTO `menu` VALUES ('16', '行程安排', '', '4');
INSERT INTO `menu` VALUES ('17', '菜单管理', '', '5');
INSERT INTO `menu` VALUES ('18', '个人设置', '', '5');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_id` int(10) DEFAULT NULL,
  `reciver_id` varchar(255) DEFAULT NULL,
  `message_title` varchar(255) DEFAULT NULL,
  `message_content` longtext,
  `status` int(10) DEFAULT NULL,
  `message_time` datetime DEFAULT NULL,
  `accessory` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '1', '2', 'qwe', 'wsxwewe', '2', '2018-10-19 09:43:03', null);
INSERT INTO `message` VALUES ('2', '2', '3', '你好', '撒旦法撒旦撒旦法啊 电工房电工房 规范化人头费天润城V型吧', '2', '2018-10-19 14:27:47', null);
INSERT INTO `message` VALUES ('3', '2', '2,4,5', '梵蒂冈哈斯的风格到公司', '123123dsfas', '2', '2018-10-20 15:19:50', null);
INSERT INTO `message` VALUES ('4', '2', '5,7', '发顺丰的他儿童d当时发生的大法师fasfd', 'fgdfsg', '2', '2018-10-20 15:23:29', null);
INSERT INTO `message` VALUES ('5', '2', '6,7', '梵蒂冈哈斯的', 'ghjbvdsd', '2', '2018-10-20 15:25:01', null);
INSERT INTO `message` VALUES ('6', '2', '', '', '', '2', '2018-10-20 15:28:49', null);
INSERT INTO `message` VALUES ('7', '2', '', '', '', '2', '2018-10-20 15:30:02', null);
INSERT INTO `message` VALUES ('8', '2', '', '', '', '2', '2018-10-20 15:31:05', null);
INSERT INTO `message` VALUES ('9', '2', '', '', '', '2', '2018-10-20 15:32:33', null);

-- ----------------------------
-- Table structure for message_status
-- ----------------------------
DROP TABLE IF EXISTS `message_status`;
CREATE TABLE `message_status` (
  `message_status_id` int(11) NOT NULL,
  `message_status_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`message_status_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of message_status
-- ----------------------------
INSERT INTO `message_status` VALUES ('1', '未读');
INSERT INTO `message_status` VALUES ('2', '已读');
INSERT INTO `message_status` VALUES ('3', '删除');

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `note_id` int(10) NOT NULL AUTO_INCREMENT,
  `note_sort_id` int(10) DEFAULT NULL,
  `note_owner_id` int(10) DEFAULT NULL,
  `note_title` varchar(255) DEFAULT NULL,
  `note_content` varchar(255) DEFAULT NULL,
  `note_time` datetime DEFAULT NULL,
  `note_status` int(10) DEFAULT '1',
  PRIMARY KEY (`note_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of note
-- ----------------------------

-- ----------------------------
-- Table structure for operate
-- ----------------------------
DROP TABLE IF EXISTS `operate`;
CREATE TABLE `operate` (
  `operate_id` int(10) NOT NULL,
  `operate_name` varchar(255) DEFAULT NULL,
  `operate_code` varchar(255) DEFAULT NULL,
  `operate_url` varchar(255) DEFAULT NULL,
  `p_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`operate_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of operate
-- ----------------------------
INSERT INTO `operate` VALUES ('1', '博为峰OA办公自动化系统', 'OA', '', null);
INSERT INTO `operate` VALUES ('6', '考勤管理', 'Roster', '', '1');
INSERT INTO `operate` VALUES ('7', '公告管理', 'News', '', '1');
INSERT INTO `operate` VALUES ('8', '员工管理', 'User', '', '1');
INSERT INTO `operate` VALUES ('9', '部门管理', 'Department', '', '1');
INSERT INTO `operate` VALUES ('10', '角色管理', 'role/show', '', '1');
INSERT INTO `operate` VALUES ('11', '权限管理', 'permission/show', '', '1');
INSERT INTO `operate` VALUES ('12', '公文设计', 'affair/design', '', '1');
INSERT INTO `operate` VALUES ('13', '公文管理', 'affair/manage', '', '1');
INSERT INTO `operate` VALUES ('14', '邮箱管理', 'Email', '', '1');
INSERT INTO `operate` VALUES ('15', '工作日志', 'Daily', '', '1');
INSERT INTO `operate` VALUES ('16', '行程安排', 'Schedule', '', '1');
INSERT INTO `operate` VALUES ('17', '菜单管理', 'Menu', '', '1');
INSERT INTO `operate` VALUES ('18', '个人设置', 'Setting', '', '1');
INSERT INTO `operate` VALUES ('19', '添加公告', 'NewsAdd', '', '1');
INSERT INTO `operate` VALUES ('20', '修改公告', 'NewsUpdate', '', '1');
INSERT INTO `operate` VALUES ('21', '删除公告', 'NewsDelete', '', '1');
INSERT INTO `operate` VALUES ('22', '添加考勤', 'RosterAdd', '', '1');
INSERT INTO `operate` VALUES ('23', '修改考勤', 'RosterUpdate', '', '1');
INSERT INTO `operate` VALUES ('24', '删除考勤', 'RosterDelete', '', '1');
INSERT INTO `operate` VALUES ('25', '新增员工', 'UserAdd', '', '1');
INSERT INTO `operate` VALUES ('26', '修改员工', 'UserUpdate', '', '1');
INSERT INTO `operate` VALUES ('27', '删除员工', 'UserDelete', '', '1');
INSERT INTO `operate` VALUES ('28', '新增部门', 'DepartmentAdd', '', '1');
INSERT INTO `operate` VALUES ('29', '修改部门', 'DepartmentUpdate', '', '1');
INSERT INTO `operate` VALUES ('30', '删除部门', 'DepartmentDelete', '', '1');
INSERT INTO `operate` VALUES ('31', '新增角色', 'role/add', '', '1');
INSERT INTO `operate` VALUES ('32', '修改角色', 'role/edit', '', '1');
INSERT INTO `operate` VALUES ('33', '删除角色', 'role/delete', '', '1');
INSERT INTO `operate` VALUES ('34', '新增公文模板', 'affair/add', '', '1');
INSERT INTO `operate` VALUES ('35', '修改公文模板', 'affair/edit', '', '1');
INSERT INTO `operate` VALUES ('36', '删除公文模板', 'affair/delete', '', '1');
INSERT INTO `operate` VALUES ('37', '添加公告保存', 'NewsSave', '', '1');
INSERT INTO `operate` VALUES ('38', '修改公告保存', 'NewsAlter', '', '1');
INSERT INTO `operate` VALUES ('39', '添加考勤保存', 'RosterSave', '', '1');
INSERT INTO `operate` VALUES ('40', '修改考勤保存', 'RosterAlter', '', '1');
INSERT INTO `operate` VALUES ('41', '新增员工保存', 'UserSave', '', '1');
INSERT INTO `operate` VALUES ('42', '修改员工保存', 'UserAlter', '', '1');
INSERT INTO `operate` VALUES ('43', '新增部门保存', 'DepartmentSave', '', '1');
INSERT INTO `operate` VALUES ('44', '修改部门保存', 'DepartmentAlter', '', '1');
INSERT INTO `operate` VALUES ('45', '新增角色保存', 'role/doAdd', '', '1');
INSERT INTO `operate` VALUES ('46', '修改角色保存', 'affair/doEdit', '', '1');
INSERT INTO `operate` VALUES ('47', '新增公文模板保存', 'affair/doAdd', '', '1');
INSERT INTO `operate` VALUES ('48', '修改公文模板保存', 'affair/doEdit', '', '1');

-- ----------------------------
-- Table structure for operate_log
-- ----------------------------
DROP TABLE IF EXISTS `operate_log`;
CREATE TABLE `operate_log` (
  `operate_log_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `operate_id` int(11) DEFAULT NULL,
  `operate_time` datetime DEFAULT NULL,
  `operate_remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`operate_log_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of operate_log
-- ----------------------------

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `organization_id` int(11) NOT NULL,
  `organization_name` varchar(255) DEFAULT NULL,
  `organization_shortten` varchar(255) DEFAULT NULL,
  `organization_leader_id` int(11) DEFAULT NULL,
  `organization_introduce` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`organization_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of organization
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permission_id` int(10) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) DEFAULT NULL,
  `permission_type` varchar(255) DEFAULT NULL,
  `p_id` int(10) DEFAULT NULL,
  `permission_status` int(10) DEFAULT '1',
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '人力资源', '', null, '1');
INSERT INTO `permission` VALUES ('2', '公文模块', '', null, '1');
INSERT INTO `permission` VALUES ('3', '邮箱模块', '', null, '1');
INSERT INTO `permission` VALUES ('4', '个人办公', '', null, '1');
INSERT INTO `permission` VALUES ('5', '系统设置', '', null, '1');
INSERT INTO `permission` VALUES ('6', '考勤管理', '', '1', '1');
INSERT INTO `permission` VALUES ('7', '公告管理', '', '1', '1');
INSERT INTO `permission` VALUES ('8', '员工管理', '', '1', '1');
INSERT INTO `permission` VALUES ('9', '部门管理', '', '1', '1');
INSERT INTO `permission` VALUES ('10', '角色管理', '', '1', '1');
INSERT INTO `permission` VALUES ('11', '权限管理', '', '1', '1');
INSERT INTO `permission` VALUES ('12', '公文设计', '', '2', '1');
INSERT INTO `permission` VALUES ('13', '公文管理', '', '2', '1');
INSERT INTO `permission` VALUES ('14', '邮箱管理', '', '3', '1');
INSERT INTO `permission` VALUES ('15', '工作日志', '', '4', '1');
INSERT INTO `permission` VALUES ('16', '行程安排', '', '4', '1');
INSERT INTO `permission` VALUES ('17', '菜单管理', '', '5', '1');
INSERT INTO `permission` VALUES ('18', '个人设置', '', '5', '1');
INSERT INTO `permission` VALUES ('19', '添加公告', '', '7', '1');
INSERT INTO `permission` VALUES ('20', '修改公告', '', '7', '1');
INSERT INTO `permission` VALUES ('21', '删除公告', '', '7', '1');
INSERT INTO `permission` VALUES ('22', '添加考勤', '', '6', '1');
INSERT INTO `permission` VALUES ('23', '修改考勤', '', '6', '1');
INSERT INTO `permission` VALUES ('24', '删除考勤', '', '6', '1');
INSERT INTO `permission` VALUES ('25', '新增员工', '', '8', '1');
INSERT INTO `permission` VALUES ('26', '修改员工', '', '8', '1');
INSERT INTO `permission` VALUES ('27', '删除员工', '', '8', '1');
INSERT INTO `permission` VALUES ('28', '新增部门', '', '9', '1');
INSERT INTO `permission` VALUES ('29', '修改部门', '', '9', '1');
INSERT INTO `permission` VALUES ('30', '删除部门', '', '9', '1');
INSERT INTO `permission` VALUES ('31', '新增角色', '', '10', '1');
INSERT INTO `permission` VALUES ('32', '修改角色', '', '10', '1');
INSERT INTO `permission` VALUES ('33', '删除角色', '', '10', '1');
INSERT INTO `permission` VALUES ('34', '新增公文模板', '', '12', '1');
INSERT INTO `permission` VALUES ('35', '修改公文模板', '', '12', '1');
INSERT INTO `permission` VALUES ('36', '删除公文模板', '', '12', '1');
INSERT INTO `permission` VALUES ('45', 'testPermission', null, '1', '2');

-- ----------------------------
-- Table structure for rel_organization_department
-- ----------------------------
DROP TABLE IF EXISTS `rel_organization_department`;
CREATE TABLE `rel_organization_department` (
  `organization_id` int(11) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of rel_organization_department
-- ----------------------------

-- ----------------------------
-- Table structure for rel_permission_menu
-- ----------------------------
DROP TABLE IF EXISTS `rel_permission_menu`;
CREATE TABLE `rel_permission_menu` (
  `permission_id` int(10) NOT NULL,
  `menu_id` int(10) DEFAULT NULL,
  KEY `fk_permission_id_menu` (`permission_id`) USING BTREE,
  KEY `fk_menu_id_per` (`menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of rel_permission_menu
-- ----------------------------
INSERT INTO `rel_permission_menu` VALUES ('1', '1');
INSERT INTO `rel_permission_menu` VALUES ('2', '2');
INSERT INTO `rel_permission_menu` VALUES ('3', '3');
INSERT INTO `rel_permission_menu` VALUES ('4', '4');
INSERT INTO `rel_permission_menu` VALUES ('5', '5');
INSERT INTO `rel_permission_menu` VALUES ('6', '6');
INSERT INTO `rel_permission_menu` VALUES ('7', '7');
INSERT INTO `rel_permission_menu` VALUES ('8', '8');
INSERT INTO `rel_permission_menu` VALUES ('9', '9');
INSERT INTO `rel_permission_menu` VALUES ('10', '10');
INSERT INTO `rel_permission_menu` VALUES ('11', '11');
INSERT INTO `rel_permission_menu` VALUES ('12', '12');
INSERT INTO `rel_permission_menu` VALUES ('13', '13');
INSERT INTO `rel_permission_menu` VALUES ('14', '14');
INSERT INTO `rel_permission_menu` VALUES ('15', '15');
INSERT INTO `rel_permission_menu` VALUES ('16', '16');
INSERT INTO `rel_permission_menu` VALUES ('17', '17');
INSERT INTO `rel_permission_menu` VALUES ('18', '18');
INSERT INTO `rel_permission_menu` VALUES ('45', '1');

-- ----------------------------
-- Table structure for rel_permission_operate
-- ----------------------------
DROP TABLE IF EXISTS `rel_permission_operate`;
CREATE TABLE `rel_permission_operate` (
  `permission_id` int(10) NOT NULL,
  `operate_id` int(10) DEFAULT NULL,
  KEY `fk_permission_id_ope` (`permission_id`) USING BTREE,
  KEY `fk_operate_id_per` (`operate_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of rel_permission_operate
-- ----------------------------
INSERT INTO `rel_permission_operate` VALUES ('6', '6');
INSERT INTO `rel_permission_operate` VALUES ('7', '7');
INSERT INTO `rel_permission_operate` VALUES ('8', '8');
INSERT INTO `rel_permission_operate` VALUES ('9', '9');
INSERT INTO `rel_permission_operate` VALUES ('10', '10');
INSERT INTO `rel_permission_operate` VALUES ('11', '11');
INSERT INTO `rel_permission_operate` VALUES ('12', '12');
INSERT INTO `rel_permission_operate` VALUES ('13', '13');
INSERT INTO `rel_permission_operate` VALUES ('14', '14');
INSERT INTO `rel_permission_operate` VALUES ('15', '15');
INSERT INTO `rel_permission_operate` VALUES ('16', '16');
INSERT INTO `rel_permission_operate` VALUES ('17', '17');
INSERT INTO `rel_permission_operate` VALUES ('18', '18');
INSERT INTO `rel_permission_operate` VALUES ('19', '19');
INSERT INTO `rel_permission_operate` VALUES ('20', '20');
INSERT INTO `rel_permission_operate` VALUES ('21', '21');
INSERT INTO `rel_permission_operate` VALUES ('22', '22');
INSERT INTO `rel_permission_operate` VALUES ('23', '23');
INSERT INTO `rel_permission_operate` VALUES ('24', '24');
INSERT INTO `rel_permission_operate` VALUES ('25', '25');
INSERT INTO `rel_permission_operate` VALUES ('26', '26');
INSERT INTO `rel_permission_operate` VALUES ('27', '27');
INSERT INTO `rel_permission_operate` VALUES ('28', '28');
INSERT INTO `rel_permission_operate` VALUES ('29', '29');
INSERT INTO `rel_permission_operate` VALUES ('30', '30');
INSERT INTO `rel_permission_operate` VALUES ('31', '31');
INSERT INTO `rel_permission_operate` VALUES ('32', '32');
INSERT INTO `rel_permission_operate` VALUES ('33', '33');
INSERT INTO `rel_permission_operate` VALUES ('34', '34');
INSERT INTO `rel_permission_operate` VALUES ('35', '35');
INSERT INTO `rel_permission_operate` VALUES ('36', '36');
INSERT INTO `rel_permission_operate` VALUES ('19', '37');
INSERT INTO `rel_permission_operate` VALUES ('20', '38');
INSERT INTO `rel_permission_operate` VALUES ('22', '39');
INSERT INTO `rel_permission_operate` VALUES ('23', '40');
INSERT INTO `rel_permission_operate` VALUES ('25', '41');
INSERT INTO `rel_permission_operate` VALUES ('26', '42');
INSERT INTO `rel_permission_operate` VALUES ('28', '43');
INSERT INTO `rel_permission_operate` VALUES ('29', '44');
INSERT INTO `rel_permission_operate` VALUES ('31', '45');
INSERT INTO `rel_permission_operate` VALUES ('32', '46');
INSERT INTO `rel_permission_operate` VALUES ('34', '47');
INSERT INTO `rel_permission_operate` VALUES ('35', '48');
INSERT INTO `rel_permission_operate` VALUES ('45', '6');

-- ----------------------------
-- Table structure for rel_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `rel_role_permission`;
CREATE TABLE `rel_role_permission` (
  `role_id` int(10) NOT NULL,
  `permission_id` int(10) DEFAULT NULL,
  KEY `fk_role_id_per` (`role_id`) USING BTREE,
  KEY `fk_permission_id_rol` (`permission_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of rel_role_permission
-- ----------------------------
INSERT INTO `rel_role_permission` VALUES ('2', '1');
INSERT INTO `rel_role_permission` VALUES ('2', '2');
INSERT INTO `rel_role_permission` VALUES ('2', '3');
INSERT INTO `rel_role_permission` VALUES ('2', '4');
INSERT INTO `rel_role_permission` VALUES ('2', '5');
INSERT INTO `rel_role_permission` VALUES ('2', '6');
INSERT INTO `rel_role_permission` VALUES ('2', '7');
INSERT INTO `rel_role_permission` VALUES ('2', '8');
INSERT INTO `rel_role_permission` VALUES ('2', '9');
INSERT INTO `rel_role_permission` VALUES ('2', '10');
INSERT INTO `rel_role_permission` VALUES ('2', '11');
INSERT INTO `rel_role_permission` VALUES ('2', '12');
INSERT INTO `rel_role_permission` VALUES ('2', '13');
INSERT INTO `rel_role_permission` VALUES ('2', '14');
INSERT INTO `rel_role_permission` VALUES ('2', '15');
INSERT INTO `rel_role_permission` VALUES ('2', '16');
INSERT INTO `rel_role_permission` VALUES ('2', '17');
INSERT INTO `rel_role_permission` VALUES ('2', '18');
INSERT INTO `rel_role_permission` VALUES ('2', '19');
INSERT INTO `rel_role_permission` VALUES ('2', '20');
INSERT INTO `rel_role_permission` VALUES ('2', '21');
INSERT INTO `rel_role_permission` VALUES ('2', '22');
INSERT INTO `rel_role_permission` VALUES ('2', '23');
INSERT INTO `rel_role_permission` VALUES ('2', '24');
INSERT INTO `rel_role_permission` VALUES ('2', '25');
INSERT INTO `rel_role_permission` VALUES ('2', '26');
INSERT INTO `rel_role_permission` VALUES ('2', '27');
INSERT INTO `rel_role_permission` VALUES ('2', '28');
INSERT INTO `rel_role_permission` VALUES ('2', '29');
INSERT INTO `rel_role_permission` VALUES ('2', '30');
INSERT INTO `rel_role_permission` VALUES ('2', '31');
INSERT INTO `rel_role_permission` VALUES ('2', '32');
INSERT INTO `rel_role_permission` VALUES ('2', '33');
INSERT INTO `rel_role_permission` VALUES ('2', '34');
INSERT INTO `rel_role_permission` VALUES ('2', '35');
INSERT INTO `rel_role_permission` VALUES ('2', '36');
INSERT INTO `rel_role_permission` VALUES ('3', '1');
INSERT INTO `rel_role_permission` VALUES ('3', '2');
INSERT INTO `rel_role_permission` VALUES ('3', '3');
INSERT INTO `rel_role_permission` VALUES ('3', '4');
INSERT INTO `rel_role_permission` VALUES ('3', '5');
INSERT INTO `rel_role_permission` VALUES ('3', '6');
INSERT INTO `rel_role_permission` VALUES ('3', '7');
INSERT INTO `rel_role_permission` VALUES ('3', '8');
INSERT INTO `rel_role_permission` VALUES ('3', '9');
INSERT INTO `rel_role_permission` VALUES ('3', '10');
INSERT INTO `rel_role_permission` VALUES ('3', '11');
INSERT INTO `rel_role_permission` VALUES ('3', '12');
INSERT INTO `rel_role_permission` VALUES ('3', '13');
INSERT INTO `rel_role_permission` VALUES ('3', '14');
INSERT INTO `rel_role_permission` VALUES ('3', '15');
INSERT INTO `rel_role_permission` VALUES ('3', '16');
INSERT INTO `rel_role_permission` VALUES ('3', '17');
INSERT INTO `rel_role_permission` VALUES ('3', '18');
INSERT INTO `rel_role_permission` VALUES ('3', '19');
INSERT INTO `rel_role_permission` VALUES ('3', '20');
INSERT INTO `rel_role_permission` VALUES ('3', '21');
INSERT INTO `rel_role_permission` VALUES ('3', '22');
INSERT INTO `rel_role_permission` VALUES ('3', '23');
INSERT INTO `rel_role_permission` VALUES ('3', '24');
INSERT INTO `rel_role_permission` VALUES ('3', '25');
INSERT INTO `rel_role_permission` VALUES ('3', '26');
INSERT INTO `rel_role_permission` VALUES ('3', '27');
INSERT INTO `rel_role_permission` VALUES ('3', '28');
INSERT INTO `rel_role_permission` VALUES ('3', '29');
INSERT INTO `rel_role_permission` VALUES ('3', '30');
INSERT INTO `rel_role_permission` VALUES ('3', '31');
INSERT INTO `rel_role_permission` VALUES ('3', '32');
INSERT INTO `rel_role_permission` VALUES ('3', '33');
INSERT INTO `rel_role_permission` VALUES ('3', '34');
INSERT INTO `rel_role_permission` VALUES ('3', '35');
INSERT INTO `rel_role_permission` VALUES ('3', '36');
INSERT INTO `rel_role_permission` VALUES ('26', '2');
INSERT INTO `rel_role_permission` VALUES ('26', '3');
INSERT INTO `rel_role_permission` VALUES ('26', '4');
INSERT INTO `rel_role_permission` VALUES ('26', '5');
INSERT INTO `rel_role_permission` VALUES ('26', '13');
INSERT INTO `rel_role_permission` VALUES ('26', '14');
INSERT INTO `rel_role_permission` VALUES ('26', '15');
INSERT INTO `rel_role_permission` VALUES ('26', '16');
INSERT INTO `rel_role_permission` VALUES ('26', '18');
INSERT INTO `rel_role_permission` VALUES ('27', '2');
INSERT INTO `rel_role_permission` VALUES ('27', '3');
INSERT INTO `rel_role_permission` VALUES ('27', '4');
INSERT INTO `rel_role_permission` VALUES ('27', '5');
INSERT INTO `rel_role_permission` VALUES ('27', '13');
INSERT INTO `rel_role_permission` VALUES ('27', '14');
INSERT INTO `rel_role_permission` VALUES ('27', '15');
INSERT INTO `rel_role_permission` VALUES ('27', '16');
INSERT INTO `rel_role_permission` VALUES ('27', '18');
INSERT INTO `rel_role_permission` VALUES ('28', '2');
INSERT INTO `rel_role_permission` VALUES ('28', '3');
INSERT INTO `rel_role_permission` VALUES ('28', '4');
INSERT INTO `rel_role_permission` VALUES ('28', '5');
INSERT INTO `rel_role_permission` VALUES ('28', '13');
INSERT INTO `rel_role_permission` VALUES ('28', '14');
INSERT INTO `rel_role_permission` VALUES ('28', '15');
INSERT INTO `rel_role_permission` VALUES ('28', '16');
INSERT INTO `rel_role_permission` VALUES ('28', '18');
INSERT INTO `rel_role_permission` VALUES ('8', '1');
INSERT INTO `rel_role_permission` VALUES ('8', '2');
INSERT INTO `rel_role_permission` VALUES ('8', '3');
INSERT INTO `rel_role_permission` VALUES ('8', '4');
INSERT INTO `rel_role_permission` VALUES ('8', '5');
INSERT INTO `rel_role_permission` VALUES ('8', '6');
INSERT INTO `rel_role_permission` VALUES ('8', '7');
INSERT INTO `rel_role_permission` VALUES ('8', '8');
INSERT INTO `rel_role_permission` VALUES ('8', '9');
INSERT INTO `rel_role_permission` VALUES ('8', '10');
INSERT INTO `rel_role_permission` VALUES ('8', '11');
INSERT INTO `rel_role_permission` VALUES ('8', '12');
INSERT INTO `rel_role_permission` VALUES ('8', '13');
INSERT INTO `rel_role_permission` VALUES ('8', '14');
INSERT INTO `rel_role_permission` VALUES ('8', '15');
INSERT INTO `rel_role_permission` VALUES ('8', '16');
INSERT INTO `rel_role_permission` VALUES ('8', '17');
INSERT INTO `rel_role_permission` VALUES ('8', '18');
INSERT INTO `rel_role_permission` VALUES ('8', '19');
INSERT INTO `rel_role_permission` VALUES ('8', '20');
INSERT INTO `rel_role_permission` VALUES ('8', '21');
INSERT INTO `rel_role_permission` VALUES ('8', '22');
INSERT INTO `rel_role_permission` VALUES ('8', '23');
INSERT INTO `rel_role_permission` VALUES ('8', '24');
INSERT INTO `rel_role_permission` VALUES ('8', '25');
INSERT INTO `rel_role_permission` VALUES ('8', '26');
INSERT INTO `rel_role_permission` VALUES ('8', '27');
INSERT INTO `rel_role_permission` VALUES ('8', '28');
INSERT INTO `rel_role_permission` VALUES ('8', '29');
INSERT INTO `rel_role_permission` VALUES ('8', '30');
INSERT INTO `rel_role_permission` VALUES ('8', '31');
INSERT INTO `rel_role_permission` VALUES ('8', '32');
INSERT INTO `rel_role_permission` VALUES ('8', '33');
INSERT INTO `rel_role_permission` VALUES ('8', '34');
INSERT INTO `rel_role_permission` VALUES ('8', '35');
INSERT INTO `rel_role_permission` VALUES ('8', '36');
INSERT INTO `rel_role_permission` VALUES ('13', '2');
INSERT INTO `rel_role_permission` VALUES ('13', '3');
INSERT INTO `rel_role_permission` VALUES ('13', '4');
INSERT INTO `rel_role_permission` VALUES ('13', '5');
INSERT INTO `rel_role_permission` VALUES ('13', '13');
INSERT INTO `rel_role_permission` VALUES ('13', '14');
INSERT INTO `rel_role_permission` VALUES ('13', '15');
INSERT INTO `rel_role_permission` VALUES ('13', '16');
INSERT INTO `rel_role_permission` VALUES ('13', '18');

-- ----------------------------
-- Table structure for rel_user_role
-- ----------------------------
DROP TABLE IF EXISTS `rel_user_role`;
CREATE TABLE `rel_user_role` (
  `user_id` int(10) NOT NULL,
  `role_id` int(10) DEFAULT NULL,
  KEY `fk_role_id_use` (`role_id`) USING BTREE,
  KEY `fk_user_id_rol` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of rel_user_role
-- ----------------------------
INSERT INTO `rel_user_role` VALUES ('1', '2');
INSERT INTO `rel_user_role` VALUES ('2', '5');
INSERT INTO `rel_user_role` VALUES ('3', '8');
INSERT INTO `rel_user_role` VALUES ('3', '13');
INSERT INTO `rel_user_role` VALUES ('4', '17');
INSERT INTO `rel_user_role` VALUES ('5', '20');
INSERT INTO `rel_user_role` VALUES ('6', '23');
INSERT INTO `rel_user_role` VALUES ('7', '30');
INSERT INTO `rel_user_role` VALUES ('8', '29');
INSERT INTO `rel_user_role` VALUES ('9', '4');
INSERT INTO `rel_user_role` VALUES ('10', '4');
INSERT INTO `rel_user_role` VALUES ('11', '3');
INSERT INTO `rel_user_role` VALUES ('12', '6');
INSERT INTO `rel_user_role` VALUES ('13', '10');
INSERT INTO `rel_user_role` VALUES ('14', '12');
INSERT INTO `rel_user_role` VALUES ('15', '21');
INSERT INTO `rel_user_role` VALUES ('16', '22');
INSERT INTO `rel_user_role` VALUES ('17', '24');
INSERT INTO `rel_user_role` VALUES ('18', '25');
INSERT INTO `rel_user_role` VALUES ('19', '26');
INSERT INTO `rel_user_role` VALUES ('20', '27');
INSERT INTO `rel_user_role` VALUES ('21', '27');
INSERT INTO `rel_user_role` VALUES ('22', '27');
INSERT INTO `rel_user_role` VALUES ('23', '27');
INSERT INTO `rel_user_role` VALUES ('24', '28');
INSERT INTO `rel_user_role` VALUES ('25', '15');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(10) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  `department_id` int(10) DEFAULT NULL,
  `role_status` int(10) DEFAULT '1',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('2', '超级管理员', null, '1');
INSERT INTO `role` VALUES ('3', '总经理', '1', '1');
INSERT INTO `role` VALUES ('4', '副总经理', '1', '1');
INSERT INTO `role` VALUES ('5', '财务经理', '4', '1');
INSERT INTO `role` VALUES ('6', '出纳', '4', '1');
INSERT INTO `role` VALUES ('7', '会计', '4', '1');
INSERT INTO `role` VALUES ('8', '人力资源经理', '5', '1');
INSERT INTO `role` VALUES ('9', '招聘主管', '5', '1');
INSERT INTO `role` VALUES ('10', '薪酬主管', '5', '1');
INSERT INTO `role` VALUES ('11', '招聘专员', '5', '1');
INSERT INTO `role` VALUES ('12', '薪酬专员', '5', '1');
INSERT INTO `role` VALUES ('13', '行政经理', '6', '1');
INSERT INTO `role` VALUES ('14', '行政专员', '6', '1');
INSERT INTO `role` VALUES ('15', '前台', '6', '1');
INSERT INTO `role` VALUES ('16', '法务', '6', '1');
INSERT INTO `role` VALUES ('17', '市场经理', '7', '1');
INSERT INTO `role` VALUES ('18', '网络推广', '7', '1');
INSERT INTO `role` VALUES ('19', '广告宣传', '7', '1');
INSERT INTO `role` VALUES ('20', '销售经理', '8', '1');
INSERT INTO `role` VALUES ('21', '电话销售', '8', '1');
INSERT INTO `role` VALUES ('22', '产品顾问', '8', '1');
INSERT INTO `role` VALUES ('23', '就业经理', '9', '1');
INSERT INTO `role` VALUES ('24', '就业主管', '9', '1');
INSERT INTO `role` VALUES ('25', '就业顾问', '9', '1');
INSERT INTO `role` VALUES ('26', '教学经理', '10', '1');
INSERT INTO `role` VALUES ('27', '讲师', '10', '1');
INSERT INTO `role` VALUES ('28', '班主任', '11', '1');
INSERT INTO `role` VALUES ('29', '分管业务副总I-王琰', '2', '1');
INSERT INTO `role` VALUES ('30', '分管业务副总II-余笑', '3', '1');
INSERT INTO `role` VALUES ('31', 'testRole', null, '1');
INSERT INTO `role` VALUES ('34', 'testRole2', null, '1');

-- ----------------------------
-- Table structure for sign_log
-- ----------------------------
DROP TABLE IF EXISTS `sign_log`;
CREATE TABLE `sign_log` (
  `sign_log_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `sign_in_time` datetime DEFAULT NULL,
  `ip_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sign_log_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sign_log
-- ----------------------------

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `status_id` int(10) NOT NULL,
  `status_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES ('1', '正常使用');
INSERT INTO `status` VALUES ('2', '已注销');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT '',
  `nickname` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `leader_id` int(10) DEFAULT NULL,
  `status` int(10) DEFAULT '1',
  PRIMARY KEY (`user_id`) USING BTREE,
  KEY `fk_status` (`status`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '21232F297A57A5A743894A0E4A801FC3', 'admin', '1.jpg', null, '1');
INSERT INTO `user` VALUES ('2', 'maxuemei', '202CB962AC59075B964B07152D234B70', '马雪梅', '2.jpg', '11', '1');
INSERT INTO `user` VALUES ('3', 'nixiaoyu', '202CB962AC59075B964B07152D234B70', '倪笑宇', '3.jpg', '11', '1');
INSERT INTO `user` VALUES ('4', 'zhangming', '202CB962AC59075B964B07152D234B70', '张明', '4.jpg', '11', '1');
INSERT INTO `user` VALUES ('5', 'huofang', '202CB962AC59075B964B07152D234B70', '霍芳', '5.jpg', '7', '1');
INSERT INTO `user` VALUES ('6', 'sunlirui', '202CB962AC59075B964B07152D234B70', '孙丽睿', '6.jpg', '8', '1');
INSERT INTO `user` VALUES ('7', 'yuxiao', '202CB962AC59075B964B07152D234B70', '余笑', '7.jpg', '11', '1');
INSERT INTO `user` VALUES ('8', 'wangyan', '202CB962AC59075B964B07152D234B70', '王琰', '8.jpg', '11', '1');
INSERT INTO `user` VALUES ('9', 'zhoufeng', '202CB962AC59075B964B07152D234B70', '周峰', '9.jpg', '11', '1');
INSERT INTO `user` VALUES ('10', 'wangwei', '202CB962AC59075B964B07152D234B70', '王威', '10.jpg', '11', '1');
INSERT INTO `user` VALUES ('11', 'libo', '202CB962AC59075B964B07152D234B70', '李波', '11.jpg', null, '1');
INSERT INTO `user` VALUES ('12', 'zhuminghua', '202CB962AC59075B964B07152D234B70', '朱明华', '12.jpg', '2', '1');
INSERT INTO `user` VALUES ('13', 'kangshanshan', '202CB962AC59075B964B07152D234B70', '康珊珊', '13.jpg', '3', '1');
INSERT INTO `user` VALUES ('14', 'xujiayao', '202CB962AC59075B964B07152D234B70', '徐佳瑶', '14.jpg', '13', '1');
INSERT INTO `user` VALUES ('15', 'lipingran', '202CB962AC59075B964B07152D234B70', '李品然', '15.jpg', '5', '1');
INSERT INTO `user` VALUES ('16', 'wanglixia', '202CB962AC59075B964B07152D234B70', '王丽霞', '16.jpg', '5', '1');
INSERT INTO `user` VALUES ('17', 'donghuanhuan', '202CB962AC59075B964B07152D234B70', '董欢欢', '17.jpg', '6', '1');
INSERT INTO `user` VALUES ('18', 'zhuqiong', '202CB962AC59075B964B07152D234B70', '朱琼', '18.jpg', '17', '1');
INSERT INTO `user` VALUES ('19', 'gongweibin', '202CB962AC59075B964B07152D234B70', '龚玮斌', '19.jpg', '7', '1');
INSERT INTO `user` VALUES ('20', 'fengrui', '202CB962AC59075B964B07152D234B70', '冯瑞', '20.jpg', '19', '1');
INSERT INTO `user` VALUES ('21', 'chenchen', '202CB962AC59075B964B07152D234B70', '陈晨', '21.jpg', '19', '1');
INSERT INTO `user` VALUES ('22', 'zhaokai', '202CB962AC59075B964B07152D234B70', '赵凯', '22.jpg', '19', '1');
INSERT INTO `user` VALUES ('23', 'caigenrong', '202CB962AC59075B964B07152D234B70', '蔡根荣', '23.jpg', '19', '1');
INSERT INTO `user` VALUES ('24', 'wenshuqing', '202CB962AC59075B964B07152D234B70', '闻书晴', '24.jpg', '19', '1');
INSERT INTO `user` VALUES ('25', 'chengfengjiao', '202CB962AC59075B964B07152D234B70', '陈凤娇', '25.jpg', '3', '1');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `info_id` int(10) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`info_id`) USING BTREE,
  KEY `fk_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_info
-- ----------------------------

-- ----------------------------
-- Table structure for user_status
-- ----------------------------
DROP TABLE IF EXISTS `user_status`;
CREATE TABLE `user_status` (
  `status_id` int(10) NOT NULL,
  `status_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`status_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_status
-- ----------------------------
INSERT INTO `user_status` VALUES ('1', '正常使用');
INSERT INTO `user_status` VALUES ('2', '已注销');
SET FOREIGN_KEY_CHECKS=1;

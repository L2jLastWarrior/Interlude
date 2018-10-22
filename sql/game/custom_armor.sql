DROP TABLE IF EXISTS `custom_armor`;
CREATE TABLE `custom_armor` (
  `item_id` int(11) NOT NULL default '0',
  `name` varchar(70) default NULL,
  `bodypart` varchar(15) NOT NULL default '',
  `crystallizable` varchar(5) NOT NULL default '',
  `armor_type` varchar(5) NOT NULL default '',
  `weight` int(5) NOT NULL default '0',
  `crystal_type` ENUM("none","d","c","b","a","s") NOT NULL default 'none', 
  `avoid_modify` int(1) NOT NULL default '0',
  `duration` int(3) NOT NULL default '0',
  `p_def` int(3) NOT NULL default '0',
  `m_def` int(2) NOT NULL default '0',
  `mp_bonus` int(3) NOT NULL default '0',
  `price` int(11) NOT NULL default '0',
  `crystal_count` int(4) default NULL,
  `sellable` varchar(5) default NULL,
  `dropable` varchar(5) default NULL,
  `destroyable` varchar(5) default NULL,
  `tradeable` varchar(5) default NULL,
  `item_skill_id` decimal(11,0) NOT NULL default '0',
  `item_skill_lvl` decimal(11,0) NOT NULL default '0',
  PRIMARY KEY  (`item_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `custom_armor` VALUES ('9416', 'Dynasty Plate', 'chest', 'false', 'heavy', '7620', 's', '0', '-1', '219', '0', '0', '0', '0', 'true', 'true', 'true', 'true', '0', '0');
INSERT INTO `custom_armor` VALUES ('9421', 'Dyanasty Gaiters', 'legs', 'false', 'heavy', '3060', 's', '0', '-1', '137', '0', '0', '0', '0', 'true ', 'true', 'true', 'true', '0', '0');
INSERT INTO `custom_armor` VALUES ('9422', 'Dynasty Helm', 'head', 'false', 'none', '550', 's', '0', '-1', '89', '0', '0', '0', '0', 'true', 'true', 'true', 'true', '0', '0');
INSERT INTO `custom_armor` VALUES ('9423', 'Dynasty Gloves', 'gloves', 'false', 'none', '540', 's', '0', '-1', '59', '0', '0', '0', '0', 'true', 'true', 'true', 'true', '0', '0');
INSERT INTO `custom_armor` VALUES ('9424', 'Dynasty Boots', 'feet', 'false', 'none', '1110', 's', '0', '-1', '59', '0', '0', '0', '0', 'true', 'true', 'true', 'true', '0', '0');
INSERT INTO `custom_armor` VALUES ('9425', 'Dynasty Leather', 'chest', 'false', 'light', '7620', 's', '0', '-1', '219', '0', '0', '0', '0', 'true ', 'true', 'true', 'true', '0', '0');
INSERT INTO `custom_armor` VALUES ('9428', 'Dynasty Leather Pants ', 'legs', 'false', 'light', '3260', 's', '0', '-1', '137', '0', '0', '0', '0', 'true', 'true', 'true', 'true', '0', '0');
INSERT INTO `custom_armor` VALUES ('9429', 'Dynasty Leather Helm', 'head', 'false', 'none', '550', 's', '0', '-1', '89', '0', '0', '0', '0', 'true', 'true', 'true', 'true', '0', '0');
INSERT INTO `custom_armor` VALUES ('9430', 'Dynasty Leather Gloves', 'gloves', 'false', 'none', '540', 's', '0', '-1', '59', '0', '0', '0', '0', 'true', 'true', 'true', 'true', '0', '0');
INSERT INTO `custom_armor` VALUES ('9431', 'Dynasty Leather Shoes', 'feet', 'false', 'none', '1110', 's', '0', '-1', '59', '0', '0', '0', '0', 'true', 'true', 'true', 'true', '0', '0');
INSERT INTO `custom_armor` VALUES ('9432', 'Dynasty Robe', 'chest', 'false', 'magic', '7620', 's', '0', '-1', '219', '0', '0', '0', '0', 'true', 'true', 'true', 'true', '0', '0');
INSERT INTO `custom_armor` VALUES ('9437', 'Dynasty Paints', 'legs', 'false', 'magic', '3060', 's', '0', '-1', '137', '0', '0', '0', '0', 'true', 'true', 'true', 'true', '0', '0');
INSERT INTO `custom_armor` VALUES ('9438', 'Dynasty Cap', 'head', 'false', 'none', '550', 's', '0', '1', '89', '0', '0', '0', '0', 'true', 'true', 'true', 'true', '0', '0');
INSERT INTO `custom_armor` VALUES ('9439', 'Dynasty Mittens', 'gloves', 'false', 'none', '540', 's', '0', '-1', '59', '0', '0', '0', '0', 'true', 'true', 'true', 'true', '0', '0');
INSERT INTO `custom_armor` VALUES ('9440', 'Dynasty Slippers', 'feet', 'false', 'none', '1110', 's', '0', '-1', '59', '0', '0', '0', '0', 'true', 'true', 'true', 'true', '0', '0');


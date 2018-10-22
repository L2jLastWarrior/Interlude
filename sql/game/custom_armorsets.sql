-- 
-- Table structure for table `armorsets`
-- 

DROP TABLE IF EXISTS custom_armorsets;
CREATE TABLE custom_armorsets (
 id int(3) NOT NULL auto_increment,
 chest decimal(11,0) NOT NULL default '0',
 legs decimal(11,0) NOT NULL default '0',
 head decimal(11,0) NOT NULL default '0',
 gloves decimal(11,0) NOT NULL default '0',
 feet decimal(11,0) NOT NULL default '0',
 skill_id decimal(11,0) NOT NULL default '0',
 shield decimal(11,0) NOT NULL default '0',
 shield_skill_id decimal(11,0) NOT NULL default '0',
 enchant6skill decimal(11,0) NOT NULL default '0',
 PRIMARY KEY (id,chest)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `custom_armorsets` VALUES ('52', '9425', '9428', '9429', '9430', '9431', '9050', '0', '0', '3624');
INSERT INTO `custom_armorsets` VALUES ('53', '9416', '9421', '9422', '9423', '9424', '9051', '0', '0', '3623');
INSERT INTO `custom_armorsets` VALUES ('54', '9432', '9437', '9438', '9439', '9440', '9052', '0', '0', '3625');


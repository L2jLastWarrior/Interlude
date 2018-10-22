-- 
-- Table structure for table `weapon`
-- 

DROP TABLE IF EXISTS `custom_weapon`;
CREATE TABLE `custom_weapon` (
  `item_id` decimal(11,0) NOT NULL default '0',
  `name` varchar(70) default NULL,
  `bodypart` varchar(15) default NULL,
  `crystallizable` varchar(5) default NULL,
  `weight` decimal(4,0) default NULL,
  `soulshots` decimal(2,0) default NULL,
  `spiritshots` decimal(1,0) default NULL,
  `crystal_type` ENUM("none","d","c","b","a","s") NOT NULL default 'none',
  `p_dam` decimal(5,0) default NULL,
  `rnd_dam` decimal(2,0) default NULL,
  `weaponType` varchar(8) default NULL,
  `critical` decimal(2,0) default NULL,
  `hit_modify` decimal(6,5) default NULL,
  `avoid_modify` decimal(2,0) default NULL,
  `shield_def` decimal(3,0) default NULL,
  `shield_def_rate` decimal(2,0) default NULL,
  `atk_speed` decimal(3,0) default NULL,
  `mp_consume` decimal(2,0) default NULL,
  `m_dam` decimal(3,0) default NULL,
  `duration` decimal(3,0) default NULL,
  `price` decimal(11,0) default NULL,
  `crystal_count` int(4) default NULL,
  `sellable` varchar(5) default NULL,
  `dropable` varchar(5) default NULL,
  `destroyable` varchar(5) default NULL,
  `tradeable` varchar(5) default NULL,
  `item_skill_id` decimal(11,0) NOT NULL default '0',
  `item_skill_lvl` decimal(11,0) NOT NULL default '0',
  `enchant4_skill_id` decimal(11,0) NOT NULL default '0',
  `enchant4_skill_lvl` decimal(11,0) NOT NULL default '0',
  `onCast_skill_id` decimal(11,0) NOT NULL default '0',
  `onCast_skill_lvl` decimal(11,0) NOT NULL default '0',
  `onCast_skill_chance` decimal(11,0) NOT NULL default '0',
  `onCrit_skill_id` decimal(11,0) NOT NULL default '0',
  `onCrit_skill_lvl` decimal(11,0) NOT NULL default '0',
  `onCrit_skill_chance` decimal(11,0) NOT NULL default '0',
  PRIMARY KEY  (`item_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `weapon`
-- 

INSERT INTO `custom_weapon` VALUES ('9202', 'Dynasty Rapier - Focus', 'rhand', 'true', '1300', '1', '1', 's', '278', '10', 'sword', '8', '0.00000', '0', '0', '0', '433', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3010', '6', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9203', 'Dynasty Rapier - Health', 'rhand', 'true', '1300', '1', '1', 's', '278', '10', 'sword', '8', '0.00000', '0', '0', '0', '433', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3013', '5', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9204', 'Dynasty Rapier - Light', 'rhand', 'true', '910', '1', '1', 's', '278', '10', 'sword', '8', '0.00000', '0', '0', '0', '433', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9205', 'Dynasty Ancient Sword - Focus', 'rhand', 'true', '1300', '1', '1', 's', '322', '10', 'sword', '8', '0.00000', '0', '0', '0', '325', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3010', '6', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9206', 'Dynasty Ancient Sword - Health', 'rhand', 'true', '1300', '1', '1', 's', '322', '10', 'sword', '8', '0.00000', '0', '0', '0', '325', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3013', '5', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9207', 'Dynasty Ancient Sword - Light', 'rhand', 'true', '910', '1', '1', 's', '322', '10', 'sword', '8', '0.00000', '0', '0', '0', '325', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9208', 'Dynasty Crossbow - Cheap Shot', 'lrhand', 'true', '1640', '1', '1', 's', '389', '5', 'bow', '12', '-3.00000', '0', '0', '0', '293', '11', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9209', 'Dynasty Crossbow - Guidance', 'lrhand', 'true', '1640', '1', '1', 's', '389', '5', 'bow', '12', '-3.00000', '0', '0', '0', '293', '11', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3007', '6', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9210', 'Dynasty Crossbow - Evasion', 'lrhand', 'true', '1640', '1', '1', 's', '389', '5', 'bow', '12', '-3.00000', '0', '0', '0', '293', '11', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9211', 'Dynasty Shield', 'lhand', 'true', '1170', '0', '0', 's', '0', '5', 'none', '0', '0.00000', '-8', '300', '50', '0', '0', '0', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9212', 'Dynasty Shield - Evasion', 'lhand', 'true', '1170', '0', '0', 's', '0', '5', 'none', '0', '0.00000', '0', '300', '50', '0', '0', '0', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9213', 'Dynasty Blade - Focus', 'rhand', 'true', '1300', '1', '1', 's', '307', '10', 'sword', '8', '0.00000', '0', '0', '0', '379', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3010', '6', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9214', 'Dynasty Blade - Health', 'rhand', 'true', '1300', '1', '1', 's', '307', '10', 'sword', '8', '0.00000', '0', '0', '0', '379', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3013', '5', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9215', 'Dynasty Blade - Light', 'rhand', 'true', '910', '1', '1', 's', '307', '10', 'sword', '8', '0.00000', '0', '0', '0', '379', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9216', 'Dynasty Two Handed Sword - Focus', 'lrhand', 'true', '1820', '1', '1', 's', '374', '5', 'bigsword', '8', '0.00000', '0', '0', '0', '325', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3010', '6', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9217', 'Dynasty Two Handed Sword - Health', 'lrhand', 'true', '1820', '1', '1', 's', '374', '5', 'bigsword', '8', '0.00000', '0', '0', '0', '325', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3013', '5', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9218', 'Dynasty Two Handed Sword - Light', 'lrhand', 'true', '1274', '1', '1', 's', '374', '5', 'bigsword', '8', '0.00000', '0', '0', '0', '325', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9219', 'Dynasty Magic Sword - Acumen', 'rhand', 'true', '1300', '1', '1', 's', '246', '10', 'sword', '8', '0.00000', '0', '0', '0', '379', '0', '186', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3047', '3', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9220', 'Dynasty Magic Sword - Mana Up', 'rhand', 'true', '1300', '1', '1', 's', '246', '10', 'sword', '8', '0.00000', '0', '0', '0', '379', '0', '186', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3014', '3', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9221', 'Dynasty Magic Sword - Conversion', 'rhand', 'true', '1300', '1', '1', 's', '246', '10', 'sword', '8', '0.00000', '0', '0', '0', '379', '0', '186', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3048', '3', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9222', 'Dynasty Bow - Cheap Shot', 'lrhand', 'true', '1640', '1', '1', 's', '634', '5', 'bow', '12', '-3.00000', '0', '0', '0', '293', '11', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9223', 'Dynasty Bow - Guidance', 'lrhand', 'true', '1640', '1', '1', 's', '634', '5', 'bow', '12', '-3.00000', '0', '0', '0', '293', '11', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3007', '6', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9224', 'Dynasty Bow - Evasion', 'lrhand', 'true', '1640', '1', '1', 's', '634', '5', 'bow', '12', '-3.00000', '0', '0', '0', '293', '11', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9225', 'Dynasty Dagger - Focus', 'rhand', 'true', '930', '1', '1', 's', '269', '5', 'dagger', '12', '-3.00000', '0', '0', '0', '433', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3010', '6', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9226', 'Dynasty Dagger - Evasion', 'rhand', 'true', '930', '1', '1', 's', '269', '5', 'dagger', '12', '-3.00000', '0', '0', '0', '433', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9227', 'Dynasty Dagger - Critical Damage', 'rhand', 'true', '930', '1', '1', 's', '269', '5', 'dagger', '12', '-3.00000', '0', '0', '0', '433', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3023', '6', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9228', 'Dynasty Spear - Anger', 'lrhand', 'true', '1820', '1', '1', 's', '307', '5', 'pole', '8', '-3.00000', '0', '0', '0', '325', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3012', '6', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9229', 'Dynasty Spear - Critical Stun', 'lrhand', 'true', '1820', '1', '1', 's', '307', '5', 'pole', '8', '-3.00000', '0', '0', '0', '325', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3016', '6', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9230', 'Dynasty Spear - Light', 'lrhand', 'true', '1274', '1', '1', 's', '307', '5', 'pole', '8', '-3.00000', '0', '0', '0', '325', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9231', 'Dynasty Hammer - Anger', 'rhand', 'true', '1550', '1', '1', 's', '307', '20', 'blunt', '4', '4.00000', '0', '0', '0', '379', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3012', '6', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9232', 'Dynasty Hammer - Health', 'rhand', 'true', '1550', '1', '1', 's', '307', '20', 'blunt', '4', '4.00000', '0', '0', '0', '379', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3013', '5', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9233', 'Dynasty Hammer - Risk Focus', 'rhand', 'true', '1550', '1', '1', 's', '307', '20', 'blunt', '4', '4.00000', '0', '0', '0', '379', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3027', '6', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9234', 'Dynasty Staff - Mana Up', 'rhand', 'true', '1510', '1', '1', 's', '299', '20', 'sword', '4', '4.00000', '0', '0', '0', '325', '0', '186', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3014', '3', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9235', 'Dynasty Staff - Conversion', 'rhand', 'true', '1510', '1', '1', 's', '299', '20', 'sword', '4', '4.00000', '0', '0', '0', '325', '0', '186', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3048', '3', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9236', 'Dynasty Staff - Acumen', 'rhand', 'true', '1510', '1', '1', 's', '299', '20', 'sword', '4', '4.00000', '0', '0', '0', '325', '0', '186', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3047', '3', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9237', 'Dynasty Fist - Risk Haste', 'lrhand', 'true', '1330', '1', '1', 's', '374', '5', 'dualfist', '4', '4.00000', '0', '0', '0', '325', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3034', '6', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9238', 'Dynasty Fist - Risk Evasion', 'lrhand', 'true', '1330', '1', '1', 's', '374', '5', 'dualfist', '4', '4.00000', '0', '0', '0', '325', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3028', '6', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9239', 'Dynasty Fist - Haste', 'lrhand', 'true', '1330', '1', '1', 's', '374', '5', 'dualfist', '4', '4.00000', '0', '0', '0', '325', '0', '140', '-1', '800000000', '2440', 'true', 'true', 'true', 'true', '0', '0', '3045', '20', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9240', 'dynasty_spellbook', 'rhand', 'true', '650', '1', '1', 's', '140', '10', 'etc', '8', '0.00000', '0', '0', '0', '379', '0', '186', '-1', '24400000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9241', 'dynasty_spellbook-acumen', 'rhand', 'true', '650', '1', '1', 's', '140', '10', 'etc', '8', '0.00000', '0', '0', '0', '379', '0', '186', '-1', '24400000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9242', 'dynasty_spellbook-mana up', 'rhand', 'true', '650', '1', '1', 's', '140', '10', 'etc', '8', '0.00000', '0', '0', '0', '379', '0', '186', '-1', '24400000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9243', 'dynasty_spellbook-conversion', 'rhand', 'true', '650', '1', '1', 's', '140', '10', 'etc', '8', '0.00000', '0', '0', '0', '379', '0', '186', '-1', '24400000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9244', 'dynasty_dual_rapiers', 'lrhand', 'true', '2080', '1', '1', 's', '140', '10', 'dual', '8', '0.00000', '0', '0', '0', '379', '0', '186', '-1', '24400000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9245', 'dynasty_dual_Dagger', 'lrhand', 'true', '2080', '1', '1', 's', '140', '10', 'dual', '8', '0.00000', '0', '0', '0', '379', '0', '186', '-1', '24400000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9246', 'dynasty_dual_Blades', 'lrhand', 'true', '2080', '1', '1', 's', '140', '10', 'dual', '8', '0.00000', '0', '0', '0', '379', '0', '186', '-1', '24400000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9247', 'dynasty_dual_MagicSwords', 'lrhand', 'true', '2080', '1', '1', 's', '140', '10', 'dual', '8', '0.00000', '0', '0', '0', '379', '0', '186', '-1', '24400000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9248', 'dynasty_dual_dms/rapier', 'lrhand', 'true', '2080', '1', '1', 's', '140', '10', 'dual', '8', '0.00000', '0', '0', '0', '379', '0', '186', '-1', '24400000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9249', 'dynasty_dual_blade/dms', 'lrhand', 'true', '2080', '1', '1', 's', '140', '10', 'dual', '8', '0.00000', '0', '0', '0', '379', '0', '186', '-1', '24400000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9250', 'Dynasty Crusher - Focus', 'lrhand', 'true', '1300', '1', '1', 's', '361', '10', 'bigblunt', '8', '0.00000', '0', '0', '0', '325', '0', '137', '-1', '57000000', '2850', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9252', 'Dynasty Crusher - Health', 'lrhand', 'true', '1300', '1', '1', 's', '361', '10', 'bigblunt', '8', '0.00000', '0', '0', '0', '325', '0', '137', '-1', '57000000', '2850', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9253', 'Dynasty Crusher - Light', 'lrhand', 'true', '1300', '1', '1', 's', '361', '10', 'bigblunt', '8', '0.00000', '0', '0', '0', '325', '0', '137', '-1', '57000000', '2850', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9251', 'Dynasty Scepter - Acumen', 'lrhand', 'true', '1300', '1', '1', 's', '290', '20', 'sword', '4', '4.00000', '0', '0', '0', '325', '0', '182', '-1', '57000000', '2850', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9254', 'Dynasty Scepter - Mana Up', 'lrhand', 'true', '1300', '1', '1', 's', '290', '20', 'sword', '4', '4.00000', '0', '0', '0', '325', '0', '182', '-1', '57000000', '2850', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `custom_weapon` VALUES ('9255', 'Dynasty Scepter - Conversion', 'lrhand', 'true', '1300', '1', '1', 's', '290', '20', 'sword', '4', '4.00000', '0', '0', '0', '325', '0', '182', '-1', '57000000', '2850', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
-- 
-- End Dynasty Weapon.
-- 
INSERT INTO custom_weapon VALUES ('9500', 'L][Division Akra Shield', 'lhand', 'true', '0', '0', '0',   's', '0', '0', 'none', '0', '0.00000', '0', '0', '0', '0', '0', '0', '-1', '48800000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9501', 'L][Division Dynaksus Shield', 'lhand', 'true', '0', '0', '0',   's', '0', '0', 'none', '0', '0.00000', '0', '0', '0', '0', '0', '0', '-1', '48800000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9502', 'L][Division Karyen Shield', 'lhand', 'true', '0', '0', '0',   's', '0', '0', 'none', '0', '0.00000', '0', '0', '0', '0', '0', '0', '-1', '48800000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9503', 'L][Division Sacon Shield', 'lhand', 'true', '0', '0', '0',   's', '0', '0', 'none', '0', '0.00000', '0', '0', '0', '0', '0', '0', '-1', '48800000', '2440', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9504', 'L][Division Kirche Fist', 'lrhand', 'true', '1550', '1', '1',   's', '532', '5', 'dualfist', '4', '4', '0', '0', '0', '325', '0', '192', '-1', '-1', '205668000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9505', 'L][Division Grabathus Bow', 'lrhand', 'true', '1520', '1', '1',   's', '794', '5', 'bow', '12', '-3', '0', '0', '0', '293', '12', '192', '-1', '-1', '205668000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9506', 'L][Division Lapis Crossbow', 'lrhand', 'true', '1520', '1', '1',   's', '794', '5', 'bow', '12', '-3', '0', '0', '0', '293', '12', '192', '-1', '-1', '205668000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9507', 'L][Division Shayaka Crossbow', 'lrhand', 'true', '1520', '1', '1',   's', '794', '5', 'bow', '12', '-3', '0', '0', '0', '293', '12', '192', '-1', '-1', '205668000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9508', 'L][Division Spina Dorsi Bow', 'lrhand', 'true', '1520', '1', '1',   's', '794', '5', 'bow', '12', '-3', '0', '0', '0', '293', '12', '192', '-1', '-1', '205668000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9509', 'L][Division Grangkaz Staff', 'lrhand', 'true', '1740', '1', '1',   's', '532', '20', 'bigblunt', '4', '4', '0', '0', '0', '325', '0', '192', '-1', '-1', '205668000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9510', 'L][Division Grave Spear', 'lrhand', 'true', '2010', '1', '1',   's', '415', '10', 'pole', '8', '-3', '0', '0', '0', '325', '0', '183', '-1', '-1', '171530000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9511', 'L][Division Herencia Staff', 'lrhand', 'true', '1740', '1', '1',   's', '532', '20', 'bigblunt', '4', '4', '0', '0', '0', '325', '0', '192', '-1', '-1', '205668000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9512', 'L][Division Soryu Spear', 'lrhand', 'true', '2010', '1', '1',   's', '415', '10', 'pole', '8', '-3', '0', '0', '0', '325', '0', '183', '-1', '-1', '171530000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9513', 'L][Division Fuego Hammer', 'lrhand', 'true', '1740', '1', '1',   's', '532', '20', 'bigblunt', '4', '4', '0', '0', '0', '325', '0', '192', '-1', '-1', '205668000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9514', 'L][Division Polion Sword', 'lrhand', 'true', '1800', '1', '1',   's', '473', '15', 'bigsword', '8', '2', '0', '0', '0', '350', '0', '192', '-1', '-1', '205668000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9515', 'L][Division Volver Sword', 'lrhand', 'true', '1800', '1', '1',   's', '473', '15', 'bigsword', '8', '2', '0', '0', '0', '350', '0', '192', '-1', '-1', '205668000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9516', 'L][Division Aspeda Dagger', 'rhand', 'true', '1520', '1', '1',   's', '382', '5', 'dagger', '12', '-3', '0', '0', '0', '433', '0', '192', '-1', '-1', '205668000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9517', 'L][Division Phasian Dagger', 'rhand', 'true', '1520', '1', '1',   's', '382', '5', 'dagger', '12', '-3', '0', '0', '0', '433', '0', '192', '-1', '-1', '205668000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9518', 'L][Division Estia Sword', 'rhand', 'true', '2080', '1', '1',   's', '309', '40', 'sword', '8', '0', '0', '0', '0', '325', '0', '145', '-1', '-1', '78800000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9519', 'L][Division Imerose Sword', 'rhand', 'true', '2080', '1', '1',   's', '309', '40', 'sword', '8', '0', '0', '0', '0', '325', '0', '145', '-1', '-1', '78800000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9520', 'L][Division Kaynon Sword', 'rhand', 'true', '2080', '1', '1',   's', '309', '40', 'sword', '8', '0', '0', '0', '0', '325', '0', '145', '-1', '-1', '78800000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9521', 'L][Division Pasis Sword', 'rhand', 'true', '2080', '1', '1',   's', '309', '40', 'sword', '8', '0', '0', '0', '0', '325', '0', '145', '-1', '-1', '78800000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9522', 'L][Division Batista Hammer', 'rhand', 'true', '2080', '1', '1',   's', '309', '40', 'blunt', '8', '0', '0', '0', '0', '325', '0', '145', '-1', '-1', '78800000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9523', 'L][Division Raksilion Hammer', 'rhand', 'true', '2080', '1', '1',   's', '309', '40', 'blunt', '8', '0', '0', '0', '0', '325', '0', '145', '-1', '-1', '78800000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9524', 'L][Division Kiabe Mace', 'rhand', 'true', '1080', '1', '1',   's', '332', '20', 'blunt', '4', '4', '0', '0', '0', '379', '0', '244', '-1', '-1', '171530000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO custom_weapon VALUES ('9525', 'L][Division Pilia Mace', 'rhand', 'true', '1080', '1', '1',   's', '332', '20', 'blunt', '4', '4', '0', '0', '0', '379', '0', '244', '-1', '-1', '171530000', 'true', 'true', 'true', 'true', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');

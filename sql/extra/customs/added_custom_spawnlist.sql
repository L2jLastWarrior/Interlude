--
-- Dumping data for table `spawnlist`
--
DROP TABLE IF EXISTS `custom_spawnlist`;
CREATE TABLE `custom_spawnlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `location` varchar(40) NOT NULL DEFAULT '',
  `count` int(9) NOT NULL DEFAULT '0',
  `npc_templateid` int(9) NOT NULL DEFAULT '0',
  `locx` int(9) NOT NULL DEFAULT '0',
  `locy` int(9) NOT NULL DEFAULT '0',
  `locz` int(9) NOT NULL DEFAULT '0',
  `randomx` int(9) NOT NULL DEFAULT '0',
  `randomy` int(9) NOT NULL DEFAULT '0',
  `heading` int(9) NOT NULL DEFAULT '0',
  `respawn_delay` int(9) NOT NULL DEFAULT '0',
  `loc_id` int(9) NOT NULL DEFAULT '0',
  `periodOfDay` decimal(2,0) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `key_npc_templateid` (`npc_templateid`)
) ENGINE=MyISAM AUTO_INCREMENT=235903 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of custom_spawnlist
-- ----------------------------
INSERT INTO `custom_spawnlist` VALUES ('225768', '', '1', '31228', '82236', '148608', '-3470', '0', '0', '65163', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225769', '', '1', '1564', '82391', '148802', '-3470', '0', '0', '6134', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225770', '', '1', '1564', '82388', '148413', '-3470', '0', '0', '569', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225771', '', '1', '93000', '82115', '149076', '-3470', '0', '0', '20066', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225772', '', '1', '50020', '82842', '149358', '-3472', '0', '0', '49753', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225773', '', '1', '50019', '83101', '148843', '-3412', '0', '0', '64238', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225774', '', '1', '31049', '83084', '148843', '-3472', '0', '0', '65170', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225776', '', '1', '50019', '83105', '148396', '-3412', '0', '0', '946', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225778', '', '1', '1570', '83074', '148396', '-3472', '0', '0', '33462', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225779', '', '1', '1566', '82931', '147776', '-3472', '0', '0', '15480', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225781', '', '1', '55555', '82114', '148136', '-3470', '0', '0', '56909', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225782', '', '1', '7077', '83486', '147906', '-3408', '0', '0', '16838', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225783', '', '1', '53', '83692', '148383', '-3408', '0', '0', '33758', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225784', '', '1', '50007', '83871', '148184', '-3396', '0', '0', '33202', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225792', '', '1', '7077', '9669', '15468', '-4577', '0', '0', '64460', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225793', '', '1', '1564', '9602', '15569', '-4577', '0', '0', '12884', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225795', '', '1', '1566', '28080', '11027', '-4235', '0', '0', '27820', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225801', '', '1', '7077', '115075', '-178222', '-889', '0', '0', '232', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225802', '', '1', '1564', '115081', '-178088', '-889', '0', '0', '2059', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225803', '', '1', '1566', '108265', '-174189', '-413', '0', '0', '13167', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225805', '', '1', '7077', '-45263', '-112569', '-242', '0', '0', '64238', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225806', '', '1', '1564', '-45268', '-112413', '-242', '0', '0', '62305', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225807', '', '1', '1566', '-56415', '-113615', '-680', '0', '0', '33217', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225810', '', '1', '7077', '-84069', '244556', '-3732', '0', '0', '39920', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225811', '', '1', '1564', '-84181', '244669', '-3732', '0', '0', '41572', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225812', '', '1', '1566', '-71601', '258087', '-3105', '0', '0', '9520', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225814', '', '1', '1566', '-90602', '248298', '-3574', '0', '0', '39334', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225815', '', '1', '7077', '46902', '51546', '-2979', '0', '0', '38643', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225816', '', '1', '1564', '46998', '51489', '-2980', '0', '0', '47371', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225817', '', '1', '1566', '46041', '41507', '-3511', '0', '0', '5219', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225819', '', '1', '7077', '146729', '25872', '-2016', '0', '0', '1', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225820', '', '1', '1564', '147601', '27265', '-2206', '0', '0', '51015', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225821', '', '1', '31228', '147456', '27224', '-2206', '0', '0', '47559', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225822', '', '1', '1570', '147308', '27260', '-2206', '0', '0', '46987', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225825', '', '1', '50019', '147222', '27370', '-2208', '0', '0', '49151', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225826', '', '1', '50019', '147686', '27377', '-2208', '0', '0', '45409', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225831', '', '1', '7077', '15586', '142893', '-2709', '0', '0', '14662', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225832', '', '1', '1564', '15743', '142883', '-2709', '0', '0', '14326', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225833', '', '1', '31228', '15571', '143021', '-2709', '0', '0', '26702', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225834', '', '1', '50019', '18293', '145147', '-3072', '0', '0', '6927', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225835', '', '1', '7077', '82992', '53111', '-1499', '0', '0', '32143', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225836', '', '1', '1564', '82997', '53271', '-1499', '0', '0', '30312', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225837', '', '1', '1566', '82762', '53572', '-1498', '0', '0', '33682', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225838', '', '1', '1566', '15797', '142877', '-2709', '0', '0', '15460', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225839', '', '1', '7077', '-12781', '122809', '-3120', '0', '0', '48573', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225840', '', '1', '1564', '-12621', '122825', '-3120', '0', '0', '49151', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225841', '', '1', '50019', '-12578', '122822', '-3118', '0', '0', '47997', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225842', '', '1', '1566', '-12672', '122612', '-3120', '0', '0', '3009', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225843', '', '1', '7077', '111332', '219415', '-3549', '0', '0', '49151', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225844', '', '1', '1564', '111446', '219445', '-3549', '0', '0', '48247', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225845', '', '1', '7077', '148003', '-55225', '-2736', '0', '0', '48351', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225846', '', '1', '1564', '148028', '-55905', '-2768', '0', '0', '31046', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225847', '', '1', '50019', '148096', '-55814', '-2760', '0', '0', '34643', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225848', '', '1', '50020', '148151', '-55701', '-2752', '0', '0', '33807', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225849', '', '1', '31049', '148176', '-55592', '-2744', '0', '0', '41760', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225850', '', '1', '7077', '-80719', '149813', '-3047', '0', '0', '20608', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225851', '', '1', '1564', '-81054', '149986', '-3047', '0', '0', '1', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225852', '', '1', '1566', '-81056', '149887', '-3047', '0', '0', '3041', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225853', '', '1', '7077', '117107', '76963', '-2698', '0', '0', '35670', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225855', '', '1', '1564', '117165', '76826', '-2697', '0', '0', '36433', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225856', '', '1', '50019', '117175', '76793', '-2697', '0', '0', '34826', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225862', '', '1', '7077', '43774', '-47669', '-799', '0', '0', '49426', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225863', '', '1', '1564', '43857', '-47665', '-799', '0', '0', '47722', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('225864', '', '1', '1566', '43841', '-47920', '-800', '0', '0', '60751', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('230807', '', '1', '1572', '83483', '149268', '-3400', '0', '0', '49783', '10', '0', '0');
INSERT INTO `custom_spawnlist` VALUES ('235902', '', '1', '1573', '83068', '149325', '-3472', '0', '0', '33511', '10', '0', '0');

-- -----------------------
-- Table structure for party_pvp
-- -----------------------
DROP TABLE IF EXISTS `party_pvp`;
CREATE TABLE `party_pvp` (
  `Joining_Location` varchar(255) NOT NULL DEFAULT '',
  `Min_Lvl` int(4) NOT NULL DEFAULT '0',
  `Max_Lvl` int(4) NOT NULL DEFAULT '0',
  `Npc_Id` int(8) NOT NULL DEFAULT '0',
  `Npc_X` int(11) NOT NULL DEFAULT '0',
  `Npc_Y` int(11) NOT NULL DEFAULT '0',
  `Npc_Z` int(11) NOT NULL DEFAULT '0',
  `Npc_Heading` int(11) NOT NULL DEFAULT '0',
  `Reward_Id` int(11) NOT NULL DEFAULT '0',
  `Reward_Amount` int(11) NOT NULL DEFAULT '0',
  `Party_Member_Count` int(4) NOT NULL DEFAULT '0',
  `Join_Time` int(11) NOT NULL DEFAULT '0',
  `Party_Pvp_Time` int(11) NOT NULL DEFAULT '0',
  `Min_Members` int(4) NOT NULL DEFAULT '0',
  `Max_Members` int(4) NOT NULL DEFAULT '0',
  `Leader_Register` int(11) Not Null default '0',
  `Leader_Party_Members` int(11) not null default '0',
) DEFAULT CHARSET=utf8;
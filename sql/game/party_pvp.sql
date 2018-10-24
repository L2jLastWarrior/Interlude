-- -----------------------
-- Table structure for party_pvp
-- -----------------------
DROP TABLE IF EXISTS `party_pvp`;
CREATE TABLE `party_pvp` (
  `Joining_Location` varchar(255) NOT NULL,
  `Min_Lvl` int(4) NOT NULL,
  `Max_Lvl` int(4) NOT NULL,
  `Npc_Id` int(8) NOT NULL,
  `Npc_X` int(11) NOT NULL,
  `Npc_Y` int(11) NOT NULL,
  `Npc_Z` int(11) NOT NULL,
  `Npc_Heading` int(11) NOT NULL,
  `Reward_Id` int(11) NOT NULL,
  `Reward_Amount` int(11) NOT NULL,
  `Party_Member_Count` int(4) NOT NULL,
  `Join_Time` int(11) NOT NULL,
  `Party_Pvp_Time` int(11) NOT NULL,
  `Min_Members` int(4) NOT NULL,
  `Max_Members` int(4) NOT NULL,
  `Leader_Register` int(11) NOT NULL,
  `Leader_Party_Members` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
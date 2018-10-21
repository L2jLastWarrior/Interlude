/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 * http://www.gnu.org/copyleft/gpl.html
 */
package com.l2j;

public class FService
{
	//Server Config Files Paths:
	//========================================================================================================================
	//Administrator Configs
	public static final String ACCESS_CONFIGURATION_FILE = "./config/Administrator_Settings/Access_Settings.ini";
	
	//Developer Configs
	public static final String DEVELOPER = "./config/Developer_Settings/Developer_Settings.ini";
	
	//L2jPack Configs
	public static final String L2JLASTWARRIOR_CONFIG_FILE ="config/L2jLastWarrior_Settings/L2jLastWarrior_Settings.ini";
	
	//L2jPack Version Configs
	public static final String SERVER_VERSION_FILE = "./config/L2jPack_Version/L2jServerCoreVersion.ini";
	public static final String DATAPACK_VERSION_FILE = "./config/L2jPack_Version/L2jDataPack-Version.ini";
	
	//Other Configs
	public static final String BANNED_IP = "./config/Others_Settings/banned_ip.cfg";
	public static final String FILTER_FILE = "./config/Others_Settings/chatfilter.txt";
	public static final String PROTECT_KEY_FILE = "./config/Others_Settings/key.cfg";
	public static final String LOG_CONF_FILE = "./config/Others_Settings/log.cfg";
	public static final String SERVER_NAME_FILE = "./config/Others_Settings/servername.xml";
	
	//Server Commands Configs
	public static final String AWAY_FILE = "./config/Server_Commands/Away_Settings.ini";
	public static final String BANK_FILE = "./config/Server_Commands/Bank_Settings.ini";
	public static final String DELEVEL_COMMAND_FILE = "./config/Server_Commands/Delevel_Settings.ini";
	public static final String OFFLINE_FILE = "./config/Server_Commands/Offline_Settings.ini";
	public static final String REPAIR_COMMAND_FILE = "./config/Server_Commands/Repair_Settings.ini";
	public static final String MENU_CMD_FILE = "./config/Server_Commands/Reward_Info_Settings.ini";
	public static final String MASS_SIEGE_CASTLE_MANAGER_FILE = "./config/Server_Commands/Siege_Info_Settings.ini";
	public static final String SOCIAL_ACTION_CMD_FILE = "./config/Server_Commands/Social_Action_Settings.ini";
	
	//Server Event Configs
	public static final String EVENT_CTF_FILE = "./config/Server_Events/CTF_Settings.ini";
	public static final String EVENT_DM_FILE = "./config/Server_Events/DM_Settings.ini";
	public static final String EVENT_TVT_FILE = "./config/Server_Events/TVT_Settings.ini";
	public static final String EVENT_TW_FILE = "./config/Server_Events/TW_Settings.ini";
	public static final String EVENT_PARTY_PVP_SETTINGS_FILE = "./config/Server_Events/PartyVsParty_Settings.ini";
	
	//Server Load Configs
	public static final String DAEMONS_FILE = "./config/Server_Loader/Daemons_Settings.ini";
	public static final String EXTENDER_FILE = "./config/Server_Loader/Extensions_Settings.ini";
	public static final String ID_CONFIG_FILE = "./config/Server_Loader/IDFactory_Settings.ini";
	public static final String SCRIPT_FILE = "./config/Server_Loader/Scripts_Settings.ini";
	public static final String HEXID_FILE = "./config/Server_Loader/hexid.txt";
	
	//Server Mods Configs
	public static final String EVENT_CHAMPION_FILE = "./config/Server_Mods/Champion_Settings.ini";
	public static final String SPECIAL_CLAN_MANAGER_FILE = "./config/Server_Mods/Clan_Manager_Settings.ini";
	public static final String ENGRAVER_NPC_FILE = "./config/Server_Mods/Engrave_Settings.ini";
	public static final String GATEKEEPER_NPC_FILE = "./config/Server_Mods/GlobalGatekeeper_Settings.ini";
	public static final String GMSHOP_NPC_FILE = "./config/Server_Mods/GMShop_Settings.ini";
	public static final String GRAND_BOSS_NPC_INFO_FILE = "./config/Server_Mods/GrandBoss_Info_Settings.ini";
	public static final String EVENT_REBIRTH_FILE = "./config/Server_Mods/Rebirth_Settings.ini";
	public static final String SCHAME_BUFFER_NPC_FILE = "./config/Server_Mods/SchameBuffer_Settings.ini";
	public static final String EVENT_WEDDING_FILE = "./config/Server_Mods/Wedding_Settings.ini";
	
	//Server Network Configs
	public static final String CONFIGURATION_FILE = "./config/Server_Network/GameServer_Settings.ini";
	public static final String IRC_FILE = "./config/Server_Network/IRC_Settings.ini";
	public static final String LOGIN_CONFIGURATION_FILE = "./config/Server_Network/LoginServer_Settings.ini";
	public static final String TELNET_FILE = "./config/Server_Network/Telnet_Settings.ini";
	
	//Server PowerPack Configs
	public static final String AUTO_RESTART_GS_SYSTEM_FILE = "./config/Server_PowerPack/Auto_Restart_Game_Server_System_Settings.ini";
	public static final String VOTE_SYSTEM_FILE = "./config/Server_PowerPack/Auto_Reward_Settings.ini";
	public static final String CUSTOM_CLAN_REPUTATION_ITEM_FILE = "./config/Server_PowerPack/Clan_Reputation_Custom_Item_Settings.ini";
	public static final String CUSTOM_HERO_ITEM_FILE = "./config/Server_PowerPack/Hero_Custom_Item_Settings.ini";
	public static final String CUSTOM_NOBLESS_ITEM_FILE = "./config/Server_PowerPack/Nobless_Custom_Item_Settings.ini";
	public static final String POWERPACK_SETTINGS_FILE = "./config/Server_PowerPack/PowerPack_Settings.ini";
	public static final String WEBSERVER_XMLRPC_FILE = "./config/Server_PowerPack/WebServices_Settings.ini";
	
	//Server Protect Configs
	public static final String PROTECT_FLOOD_CONFIG_FILE = "./config/Server_Protected/Flood_Settings.ini";
	public static final String PROTECT_OTHER_CONFIG_FILE = "./config/Server_Protected/Other_Settings.ini";
	public static final String PROTECT_PACKET_CONFIG_FILE = "./config/Server_Protected/Packets_Settings.ini";
	public static final String QUESTION_FILE = "./config/Server_Protected/questionwords.txt";
	
	//Server Rates Configs
	public static final String CLASS_DAMAGES_FILE = "./config/Server_Rates/Class_Damages_Settings.ini";
	public static final String CRAFTING = "./config/Server_Rates/Craft_System_Settings.ini";
	public static final String ENCHANT_CONFIG_FILE = "./config/Server_Rates/Enchant_Settings.ini";
	public static final String PHYSICS_CONFIGURATION_FILE = "./config/Server_Rates/Physics_Balance_System_Settings.ini";
	public static final String RATES_CONFIG_FILE = "./config/Server_Rates/Server_Rates_Settings.ini";
	
	//Server Settings Configs
	public static final String ALT_SETTINGS_FILE = "./config/Server_Settings/Alt_Settings.ini";
	public static final String BOSS_CONFIG_FILE = "./config/Server_Settings/Boss_Settings.ini";
	public static final String CUSTOMRAIDBOSSDIVISION_SETTINGS_FILE = "./config/Server_Settings/Boss_Settings.ini";
	public static final String CLANHALL_CONFIG_FILE = "./config/Server_Settings/Clan_Hall_Settings.ini";
	public static final String ELIT_CLANHALL_CONFIG_FILE = "./config/Server_Settings/Elit_Clan_Hall_Settings.ini";
	public static final String FORTSIEGE_CONFIGURATION_FILE = "./config/Server_Settings/Fort_Settings.ini";
	public static final String OPTIONS_FILE = "./config/Server_Settings/General_Options_Settings.ini";
	public static final String GEODATA_CONFIG_FILE = "./config/Server_Settings/Geodata_Settings.ini";
	public static final String OLYMP_CONFIG_FILE = "./config/Server_Settings/Olympiad_Settings.ini";
	public static final String OTHER_CONFIG_FILE = "./config/Server_Settings/Others_Settings.ini";
	public static final String EVENT_PC_BANG_POINT_FILE = "./config/Server_Settings/PcBang_Settings.ini";
	public static final String PVP_CONFIG_FILE = "./config/Server_Settings/PvP_Settings.ini";
	public static final String SEVENSIGNS_FILE = "./config/Server_Settings/Seven_Signs_Settings.ini";
	public static final String SIEGE_CONFIGURATION_FILE = "./config/Server_Settings/Siege_Settings.ini";
	public static final String L2SERVER_CONFIG_FILE = "./config/Server_Settings/Welcome_Settings.ini";
	
	// Legacy others position
	public static final String LEGACY_LOG_CONF_FILE = "./log.cfg";
	public static final String LEGACY_BANNED_IP = "./config/banned_ip.cfg";
	public static final String LEGACY_SERVER_NAME_FILE = "./servername.xml";
	//========================================================================================================================
}
	
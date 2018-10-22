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
package com.l2j.gameserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.l2j.Config;
import com.l2j.FService;
import com.l2j.developers.L2jDevTeam;
import com.l2j.ServerType;
import com.l2j.crypt.nProtect;
import com.l2j.gameserver.ai.special.manager.AILoader;
import com.l2j.gameserver.cache.CrestCache;
import com.l2j.gameserver.cache.HtmCache;
import com.l2j.gameserver.communitybbs.Manager.ForumsBBSManager;
import com.l2j.gameserver.controllers.GameTimeController;
import com.l2j.gameserver.controllers.RecipeController;
import com.l2j.gameserver.controllers.TradeController;
import com.l2j.gameserver.datatables.GmListTable;
import com.l2j.gameserver.datatables.HeroSkillTable;
import com.l2j.gameserver.datatables.NobleSkillTable;
import com.l2j.gameserver.datatables.OfflineTradeTable;
import com.l2j.gameserver.datatables.SkillTable;
import com.l2j.gameserver.datatables.csv.DoorTable;
import com.l2j.gameserver.datatables.csv.ExtractableItemsData;
import com.l2j.gameserver.datatables.csv.FishTable;
import com.l2j.gameserver.datatables.csv.HennaTable;
import com.l2j.gameserver.datatables.csv.MapRegionTable;
import com.l2j.gameserver.datatables.csv.NpcWalkerRoutesTable;
import com.l2j.gameserver.datatables.csv.RecipeTable;
import com.l2j.gameserver.datatables.csv.StaticObjects;
import com.l2j.gameserver.datatables.csv.SummonItemsData;
import com.l2j.gameserver.datatables.sql.AccessLevels;
import com.l2j.gameserver.datatables.sql.AdminCommandAccessRights;
import com.l2j.gameserver.datatables.sql.ArmorSetsTable;
import com.l2j.gameserver.datatables.sql.CharNameTable;
import com.l2j.gameserver.datatables.sql.CharTemplateTable;
import com.l2j.gameserver.datatables.sql.ClanTable;
import com.l2j.gameserver.datatables.sql.CustomArmorSetsTable;
import com.l2j.gameserver.datatables.sql.HelperBuffTable;
import com.l2j.gameserver.datatables.sql.HennaTreeTable;
import com.l2j.gameserver.datatables.sql.ItemTable;
import com.l2j.gameserver.datatables.sql.L2PetDataTable;
import com.l2j.gameserver.datatables.sql.LevelUpData;
import com.l2j.gameserver.datatables.sql.NpcTable;
import com.l2j.gameserver.datatables.sql.SkillSpellbookTable;
import com.l2j.gameserver.datatables.sql.SkillTreeTable;
import com.l2j.gameserver.datatables.sql.SpawnTable;
import com.l2j.gameserver.datatables.sql.TeleportLocationTable;
import com.l2j.gameserver.datatables.xml.AugmentationData;
import com.l2j.gameserver.datatables.xml.ExperienceData;
import com.l2j.gameserver.datatables.xml.ZoneData;
import com.l2j.gameserver.geo.GeoData;
import com.l2j.gameserver.geo.geoeditorcon.GeoEditorListener;
import com.l2j.gameserver.geo.pathfinding.PathFinding;
import com.l2j.gameserver.handler.AdminCommandHandler;
import com.l2j.gameserver.handler.AutoAnnouncementHandler;
import com.l2j.gameserver.handler.AutoChatHandler;
import com.l2j.gameserver.handler.AutoVoteRewardHandler;
import com.l2j.gameserver.handler.ItemHandler;
import com.l2j.gameserver.handler.SkillHandler;
import com.l2j.gameserver.handler.UserCommandHandler;
import com.l2j.gameserver.handler.VoicedCommandHandler;
import com.l2j.gameserver.idfactory.IdFactory;
import com.l2j.gameserver.managers.AuctionManager;
import com.l2j.gameserver.managers.AutoSaveManager;
import com.l2j.gameserver.managers.AwayManager;
import com.l2j.gameserver.managers.BoatManager;
import com.l2j.gameserver.managers.CastleManager;
import com.l2j.gameserver.managers.CastleManorManager;
import com.l2j.gameserver.managers.ClanHallManager;
import com.l2j.gameserver.managers.ClassDamageManager;
import com.l2j.gameserver.managers.CoupleManager;
import com.l2j.gameserver.managers.CrownManager;
import com.l2j.gameserver.managers.CursedWeaponsManager;
import com.l2j.gameserver.managers.DayNightSpawnManager;
import com.l2j.gameserver.managers.DimensionalRiftManager;
import com.l2j.gameserver.managers.DuelManager;
import com.l2j.gameserver.managers.FortManager;
import com.l2j.gameserver.managers.FortSiegeManager;
import com.l2j.gameserver.managers.FourSepulchersManager;
import com.l2j.gameserver.managers.GrandBossManager;
import com.l2j.gameserver.managers.IrcManager;
import com.l2j.gameserver.managers.ItemsOnGroundManager;
import com.l2j.gameserver.managers.MercTicketManager;
import com.l2j.gameserver.managers.PetitionManager;
import com.l2j.gameserver.managers.QuestManager;
import com.l2j.gameserver.managers.RaidBossPointsManager;
import com.l2j.gameserver.managers.RaidBossSpawnManager;
import com.l2j.gameserver.managers.SiegeManager;
import com.l2j.gameserver.model.L2Manor;
import com.l2j.gameserver.model.L2World;
import com.l2j.gameserver.model.PartyMatchRoomList;
import com.l2j.gameserver.model.PartyMatchWaitingList;
import com.l2j.gameserver.model.entity.Announcements;
import com.l2j.gameserver.model.entity.Hero;
import com.l2j.gameserver.model.entity.MonsterRace;
import com.l2j.gameserver.model.entity.event.manager.EventManager;
import com.l2j.gameserver.model.entity.olympiad.Olympiad;
import com.l2j.gameserver.model.entity.sevensigns.SevenSigns;
import com.l2j.gameserver.model.entity.sevensigns.SevenSignsFestival;
import com.l2j.gameserver.model.entity.siege.clanhalls.BanditStrongholdSiege;
import com.l2j.gameserver.model.entity.siege.clanhalls.DevastatedCastle;
import com.l2j.gameserver.model.entity.siege.clanhalls.FortressOfResistance;
import com.l2j.gameserver.model.multisell.L2Multisell;
import com.l2j.gameserver.model.spawn.AutoSpawn;
import com.l2j.gameserver.network.L2GameClient;
import com.l2j.gameserver.network.L2GamePacketHandler;
import com.l2j.gameserver.powerpack.PowerPack;
import com.l2j.gameserver.powerpack.Buffer.BuffHandler;
import com.l2j.gameserver.powerpack.Buffer.BuffTable;
import com.l2j.gameserver.powerpack.RaidInfo.RaidInfoHandler;
import com.l2j.gameserver.powerpack.Servers.WebServer;
import com.l2j.gameserver.powerpack.engrave.EngraveManager;
import com.l2j.gameserver.powerpack.globalGK.GKHandler;
import com.l2j.gameserver.powerpack.gmshop.GMShop;
import com.l2j.gameserver.powerpack.vote.L2TopDeamon;
import com.l2j.gameserver.powerpack.xmlrpc.XMLRPCServer;
import com.l2j.gameserver.powerpack.vote.L2TopDeamon;
import com.l2j.gameserver.script.EventDroplist;
import com.l2j.gameserver.script.faenor.FaenorScriptEngine;
import com.l2j.gameserver.scripting.CompiledScriptCache;
import com.l2j.gameserver.scripting.L2ScriptEngineManager;
import com.l2j.gameserver.taskmanager.TaskManager;
import com.l2j.gameserver.thread.LoginServerThread;
import com.l2j.gameserver.thread.ThreadPoolManager;
import com.l2j.gameserver.thread.daemons.DeadlockDetector;
import com.l2j.gameserver.thread.daemons.ItemsAutoDestroy;
import com.l2j.gameserver.thread.daemons.PcPoint;
import com.l2j.gameserver.util.DynamicExtension;
import com.l2j.gameserver.util.sql.SQLQueue;
import com.l2j.netcore.SelectorConfig;
import com.l2j.netcore.SelectorThread;
import com.l2j.status.Status;
import com.l2j.util.IPv4Filter;
import com.l2j.util.Memory;
import com.l2j.util.Util;
import com.l2j.util.database.L2DatabaseFactory;

import com.l2j.Config;
import com.l2j.gameserver.communitybbs.CommunityBoard;
import com.l2j.gameserver.datatables.BufferSkillsTable;
import com.l2j.gameserver.datatables.CharSchemesTable;
import com.l2j.gameserver.handler.AutoVoteRewardHandler;
import com.l2j.gameserver.handler.VoicedCommandHandler;
import com.l2j.gameserver.handler.custom.CustomBypassHandler;
import com.l2j.gameserver.handler.voicedcommandhandlers.Repair;
import com.l2j.gameserver.model.actor.instance.L2PcInstance;
import com.l2j.gameserver.powerpack.Buffer.BuffHandler;
import com.l2j.gameserver.powerpack.Buffer.BuffTable;
import com.l2j.gameserver.powerpack.RaidInfo.RaidInfoHandler;
import com.l2j.gameserver.powerpack.Servers.WebServer;
import com.l2j.gameserver.powerpack.engrave.EngraveManager;
import com.l2j.gameserver.powerpack.globalGK.GKHandler;
import com.l2j.gameserver.powerpack.gmshop.GMShop;
import com.l2j.gameserver.powerpack.vote.L2TopDeamon;
import com.l2j.gameserver.powerpack.xmlrpc.XMLRPCServer;

public class GameServer
{
	private static Logger _log = Logger.getLogger("Loader");
	private static SelectorThread<L2GameClient> _selectorThread;
	private static LoginServerThread _loginThread;
	private static L2GamePacketHandler _gamePacketHandler;
	private static Status _statusServer;
	
	public static final Calendar dateTimeServerStarted = Calendar.getInstance();
	
	public static void main(String[] args) throws Exception
	{
		ServerType.serverMode = ServerType.MODE_GAMESERVER;
		
		final String LOG_FOLDER_BASE = "log"; // Name of folder for log base file
		File logFolderBase = new File(LOG_FOLDER_BASE);
		logFolderBase.mkdir();
		
		// Local Constants
		final String LOG_FOLDER = "log/game";
		
		// Create log folder
		File logFolder = new File(LOG_FOLDER);
		logFolder.mkdir();
		
		// Create input stream for log file -- or store file data into memory
		
		// check for legacy Implementation
		File log_conf_file = new File(FService.LOG_CONF_FILE);
		if (!log_conf_file.exists())
		{
			// old file position
			log_conf_file = new File(FService.LEGACY_LOG_CONF_FILE);
		}
		
		InputStream is = new FileInputStream(log_conf_file);
		LogManager.getLogManager().readConfiguration(is);
		is.close();
		is = null;
		logFolder = null;
		
		long serverLoadStart = System.currentTimeMillis();
		
		Util.printSection("Dev_Team");
		
		// Dev_Team info
		L2jDevTeam.info();
		
		// Load GameServer Configs
		Config.load();
		
		Util.printSection("Database");
		L2DatabaseFactory.getInstance();
		_log.info("L2DatabaseFactory: loaded.");
		
		Util.printSection("Threads");
		ThreadPoolManager.getInstance();
		if (Config.DEADLOCKCHECK_INTIAL_TIME > 0)
		{
			ThreadPoolManager.getInstance().scheduleGeneralAtFixedRate(DeadlockDetector.getInstance(), Config.DEADLOCKCHECK_INTIAL_TIME, Config.DEADLOCKCHECK_DELAY_TIME);
		}
		new File(Config.DATAPACK_ROOT, "data/clans").mkdirs();
		new File(Config.DATAPACK_ROOT, "data/crests").mkdirs();
		new File(Config.DATAPACK_ROOT, "data/pathnode").mkdirs();
		new File(Config.DATAPACK_ROOT, "data/geodata").mkdirs();
		
		HtmCache.getInstance();
		CrestCache.getInstance();
		L2ScriptEngineManager.getInstance();
		
		nProtect.getInstance();
		if (nProtect.isEnabled())
			_log.info("nProtect System Enabled");
		
		Util.printSection("World");
		L2World.getInstance();
		MapRegionTable.getInstance();
		Announcements.getInstance();
		AutoAnnouncementHandler.getInstance();
		if (!IdFactory.getInstance().isInitialized())
		{
			_log.info("Could not read object IDs from DB. Please Check Your Data.");
			throw new Exception("Could not initialize the ID factory");
		}
		StaticObjects.getInstance();
		TeleportLocationTable.getInstance();
		PartyMatchWaitingList.getInstance();
		PartyMatchRoomList.getInstance();
		GameTimeController.getInstance();
		CharNameTable.getInstance();
		ExperienceData.getInstance();
		DuelManager.getInstance();
		
		if (Config.ENABLE_CLASS_DAMAGES)
			ClassDamageManager.loadConfig();
		
		if (Config.AUTOSAVE_DELAY_TIME > 0)
		{
			AutoSaveManager.getInstance().startAutoSaveManager();
		}
		
		Util.printSection("Skills");
		if (!SkillTable.getInstance().isInitialized())
		{
			_log.info("Could not find the extraced files. Please Check Your Data.");
			throw new Exception("Could not initialize the skill table");
		}
		SkillTreeTable.getInstance();
		SkillSpellbookTable.getInstance();
		NobleSkillTable.getInstance();
		HeroSkillTable.getInstance();
		_log.info("Skills: All skills loaded.");
		
		Util.printSection("Items");
		if (!ItemTable.getInstance().isInitialized())
		{
			_log.info("Could not find the extraced files. Please Check Your Data.");
			throw new Exception("Could not initialize the item table");
		}
		ArmorSetsTable.getInstance();
		if (Config.CUSTOM_ARMORSETS_TABLE)
		{
			CustomArmorSetsTable.getInstance();
		}
		ExtractableItemsData.getInstance();
		SummonItemsData.getInstance();
		if (Config.ALLOWFISHING)
			FishTable.getInstance();
		
		Util.printSection("Npc");
		NpcWalkerRoutesTable.getInstance().load();
		if (!NpcTable.getInstance().isInitialized())
		{
			_log.info("Could not find the extraced files. Please Check Your Data.");
			throw new Exception("Could not initialize the npc table");
		}
		
		Util.printSection("Characters");
		if (Config.COMMUNITY_TYPE.equals("full"))
		{
			ForumsBBSManager.getInstance().initRoot();
		}
		
		ClanTable.getInstance();
		CharTemplateTable.getInstance();
		LevelUpData.getInstance();
		if (!HennaTable.getInstance().isInitialized())
		{
			throw new Exception("Could not initialize the Henna Table");
		}
		
		if (!HennaTreeTable.getInstance().isInitialized())
		{
			throw new Exception("Could not initialize the Henna Tree Table");
		}
		
		if (!HelperBuffTable.getInstance().isInitialized())
		{
			throw new Exception("Could not initialize the Helper Buff Table");
		}
		
		Util.printSection("Geodata");
		GeoData.getInstance();
		if (Config.GEODATA == 2)
		{
			PathFinding.getInstance();
		}
		
		Util.printSection("Economy");
		TradeController.getInstance();
		L2Multisell.getInstance();
		_log.info("Multisell: loaded.");
		
		Util.printSection("Clan Halls");
		ClanHallManager.getInstance();
		FortressOfResistance.getInstance();
		DevastatedCastle.getInstance();
		BanditStrongholdSiege.getInstance();
		AuctionManager.getInstance();
		
		Util.printSection("Zone");
		ZoneData.getInstance();
		
		Util.printSection("Spawnlist");
		if (!Config.ALT_DEV_NO_SPAWNS)
		{
			SpawnTable.getInstance();
		}
		else
		{
			_log.info("Spawn: disable load.");
		}
		if (!Config.ALT_DEV_NO_RB)
		{
			RaidBossSpawnManager.getInstance();
			GrandBossManager.getInstance();
			RaidBossPointsManager.init();
		}
		else
		{
			_log.info("RaidBoss: disable load.");
		}
		DayNightSpawnManager.getInstance().notifyChangeMode();
		
		Util.printSection("Dimensional Rift");
		DimensionalRiftManager.getInstance();
		
		Util.printSection("Misc");
		RecipeTable.getInstance();
		RecipeController.getInstance();
		EventDroplist.getInstance();
		AugmentationData.getInstance();
		MonsterRace.getInstance();
		MercTicketManager.getInstance();
		PetitionManager.getInstance();
		CursedWeaponsManager.getInstance();
		TaskManager.getInstance();
		L2PetDataTable.getInstance().loadPetsData();
		SQLQueue.getInstance();
		if (Config.ACCEPT_GEOEDITOR_CONN)
		{
			GeoEditorListener.getInstance();
		}
		if (Config.SAVE_DROPPED_ITEM)
		{
			ItemsOnGroundManager.getInstance();
		}
		if (Config.AUTODESTROY_ITEM_AFTER > 0 || Config.HERB_AUTO_DESTROY_TIME > 0)
		{
			ItemsAutoDestroy.getInstance();
		}
		
		Util.printSection("Manor");
		L2Manor.getInstance();
		CastleManorManager.getInstance();
		
		Util.printSection("Castles");
		CastleManager.getInstance();
		SiegeManager.getInstance();
		FortManager.getInstance();
		FortSiegeManager.getInstance();
		CrownManager.getInstance();
		
		Util.printSection("Boat");
		BoatManager.getInstance();
		
		Util.printSection("Doors");
		DoorTable.getInstance().parseData();
		
		Util.printSection("Four Sepulchers");
		FourSepulchersManager.getInstance();
		
		Util.printSection("Seven Signs");
		SevenSigns.getInstance();
		SevenSignsFestival.getInstance();
		AutoSpawn.getInstance();
		AutoChatHandler.getInstance();
		
		Util.printSection("Olympiad System");
		Olympiad.getInstance();
		Hero.getInstance();
		
		Util.printSection("Access Levels");
		AccessLevels.getInstance();
		AdminCommandAccessRights.getInstance();
		GmListTable.getInstance();
		
		Util.printSection("Handlers");
		ItemHandler.getInstance();
		SkillHandler.getInstance();
		AdminCommandHandler.getInstance();
		UserCommandHandler.getInstance();
		VoicedCommandHandler.getInstance();
		
		if(Config.REPAIR_ENABLE)
		{
			Repair repair_handler = new Repair();
			VoicedCommandHandler.getInstance().registerVoicedCommandHandler(repair_handler);
			CustomBypassHandler.getInstance().registerCustomBypassHandler(repair_handler);
			_log.info("Char Repair is Enabled.");
		}
		
		_log.info("AutoChatHandler : Loaded " + AutoChatHandler.getInstance().size() + " handlers in total.");
		_log.info("AutoSpawnHandler : Loaded " + AutoSpawn.getInstance().size() + " handlers in total.");
		
		Runtime.getRuntime().addShutdownHook(Shutdown.getInstance());
		
		try
		{
			DoorTable doorTable = DoorTable.getInstance();
			
			// Opened by players like L2OFF
			//doorTable.getDoor(19160010).openMe();
			//doorTable.getDoor(19160011).openMe();
			
			doorTable.getDoor(19160012).openMe();
			doorTable.getDoor(19160013).openMe();
			doorTable.getDoor(19160014).openMe();
			doorTable.getDoor(19160015).openMe();
			doorTable.getDoor(19160016).openMe();
			doorTable.getDoor(19160017).openMe();
			doorTable.getDoor(24190001).openMe();
			doorTable.getDoor(24190002).openMe();
			doorTable.getDoor(24190003).openMe();
			doorTable.getDoor(24190004).openMe();
			doorTable.getDoor(23180001).openMe();
			doorTable.getDoor(23180002).openMe();
			doorTable.getDoor(23180003).openMe();
			doorTable.getDoor(23180004).openMe();
			doorTable.getDoor(23180005).openMe();
			doorTable.getDoor(23180006).openMe();
			doorTable.checkAutoOpen();
			if (Config.CUSTOM_DOORS_OPEN)
			{
			doorTable.CustomDoorsOpen();
			doorTable.getDoor(24140007).openMe();
			doorTable.getDoor(24140008).openMe();
			doorTable.getDoor(23150003).openMe();
			doorTable.getDoor(23150004).openMe();
			doorTable.getDoor(24190001).closeMe();
			doorTable.getDoor(24190004).closeMe();
			_log.info("Custom PvP Zone Doors is Open!");
			}
			else
				_log.info("Custom PvP Zone Doors is Closed!");
			doorTable = null;
		}
		catch (NullPointerException e)
		{
			_log.info("There is errors in your Door.csv file. Update door.csv");
			if (Config.ENABLE_ALL_EXCEPTIONS)
				e.printStackTrace();
		}
		
		Util.printSection("Quests");
		if (!Config.ALT_DEV_NO_QUESTS)
		{
			QuestManager.getInstance();
			QuestManager.getInstance().report();
		}
		else
			_log.info("Quest: disable load.");
		
		Util.printSection("AI");
		if (!Config.ALT_DEV_NO_AI)
		{
			AILoader.init();
		}
		else
		{
			_log.info("AI: disable load.");
		}
		
		Util.printSection("Scripts");
		if (!Config.ALT_DEV_NO_SCRIPT)
		{
			File scripts = new File(Config.DATAPACK_ROOT, "data/scripts.cfg");
			L2ScriptEngineManager.getInstance().executeScriptsList(scripts);
			
			CompiledScriptCache compiledScriptCache = L2ScriptEngineManager.getInstance().getCompiledScriptCache();
			if (compiledScriptCache == null)
				_log.info("Compiled Scripts Cache is disabled.");
			else
			{
				compiledScriptCache.purge();
				if (compiledScriptCache.isModified())
				{
					compiledScriptCache.save();
					_log.info("Compiled Scripts Cache was saved.");
				}
				else
					_log.info("Compiled Scripts Cache is up-to-date.");
			}
			FaenorScriptEngine.getInstance();
		}
		else
		{
			_log.info("Script: disable load.");
		}
		
		Util.printSection("Game Server");
		
		if (Config.IRC_ENABLED)
			IrcManager.getInstance().getConnection().sendChan(Config.IRC_MSG_START);
		
		_log.info("IdFactory: Free ObjectID's remaining: " + IdFactory.getInstance().size());
		try
		{
			DynamicExtension.getInstance();
		}
		catch (Exception ex)
		{
			if (Config.ENABLE_ALL_EXCEPTIONS)
				ex.printStackTrace();
			
			_log.info("DynamicExtension could not be loaded and initialized" + ex);
		}
		
		Util.printSection("Custom Mods");
		
		if (Config.L2JMOD_ALLOW_WEDDING || Config.ALLOW_AWAY_STATUS || Config.PCB_ENABLE || Config.ENABLE_POWERPACK)
		{
			if (Config.L2JMOD_ALLOW_WEDDING)
			{
				CoupleManager.getInstance();
				_log.info("Wedding is Enable");
			}
			
			if (Config.ALLOW_AWAY_STATUS)
			{
				AwayManager.getInstance();
			}
			
			if (Config.PCB_ENABLE)
			{
				ThreadPoolManager.getInstance().scheduleGeneralAtFixedRate(PcPoint.getInstance(), Config.PCB_INTERVAL * 1000, Config.PCB_INTERVAL * 1000);
				_log.info("PcBang is Enable");
			}
			
			if(Config.BUFFER_ENABLED)
			{
				_log.info("Buffer is Enabled.");
				BuffTable.getInstance();				
				if((Config.BUFFER_COMMAND != null && Config.BUFFER_COMMAND.length() > 0) || Config.BUFFER_USEBBS){	
					
					BuffHandler handler = new BuffHandler();
					if(Config.BUFFER_USECOMMAND && Config.BUFFER_COMMAND != null && Config.BUFFER_COMMAND.length() > 0)
					{
						VoicedCommandHandler.getInstance().registerVoicedCommandHandler(handler);
					}
	
					if(Config.BUFFER_USEBBS)
					{
						CommunityBoard.getInstance().registerBBSHandler(handler);
					}
					CustomBypassHandler.getInstance().registerCustomBypassHandler(handler);
					
				}
				
				BufferSkillsTable.getInstance();
				CharSchemesTable.getInstance();
			}
			
			if(Config.GLOBALGK_ENABDLED)
			{
				GKHandler handler = new GKHandler();
				if(Config.GLOBALGK_COMMAND != null && Config.GLOBALGK_COMMAND.length() > 0)
				{
					VoicedCommandHandler.getInstance().registerVoicedCommandHandler(handler);
				}

				if(Config.GLOBALGK_USEBBS)
				{
					CommunityBoard.getInstance().registerBBSHandler(handler);
				}
				CustomBypassHandler.getInstance().registerCustomBypassHandler(handler);
				_log.info("Global Gatekeeper is Enabled.");
			}
			
			if(Config.GMSHOP_ENABLED)
			{
				GMShop gs = new GMShop();
				CustomBypassHandler.getInstance().registerCustomBypassHandler(gs);
				if(Config.GLOBALGK_COMMAND!=null && Config.GLOBALGK_COMMAND.length()>0)
				{
					VoicedCommandHandler.getInstance().registerVoicedCommandHandler(gs);
				}

				if(Config.GMSHOP_USEBBS)
				{
					CommunityBoard.getInstance().registerBBSHandler(gs);
				}
				_log.info("GM Shop is Enabled.");
			}
			
			if(Config.ENGRAVER_ENABLED)
			{
				EngraveManager.getInstance();
				_log.info("Engrave System is Enabled.");
			}
			
			if(Config.GRANDBOSS_INFO_ENABLE)
			{
				RaidInfoHandler handler = new RaidInfoHandler();
			CustomBypassHandler.getInstance().registerCustomBypassHandler(handler);
			_log.info("Raidboss Info is Enabled.");
			}
			
			if(Config.WORLD_MASTER)
			{
				_log.info("World Master is Enabled.");
			}
		}
		else
			_log.info("All custom mods are Disabled.");
		
		Util.printSection("Event Manager");
		EventManager.getInstance().startEventRegistration();
		
		if (EventManager.TVT_EVENT_ENABLED || EventManager.CTF_EVENT_ENABLED || EventManager.DM_EVENT_ENABLED)
		{
			if (EventManager.TVT_EVENT_ENABLED)
				_log.info("TVT Event is Enabled.");
			if (EventManager.CTF_EVENT_ENABLED)
				_log.info("CTF Event is Enabled.");
			if (EventManager.DM_EVENT_ENABLED)
				_log.info("DM Event is Enabled.");
		}
		else
			_log.info("All events are Disabled.");
		
		if ((Config.OFFLINE_TRADE_ENABLE || Config.OFFLINE_CRAFT_ENABLE) && Config.RESTORE_OFFLINERS)
			OfflineTradeTable.restoreOfflineTraders();
		
		Util.printSection("Power Pack");
		
		if(Config.WEBSERVER_ENABLED)
			{
				WebServer.getInstance();
				_log.info("WEBSERVER is Enabled.");
			}
			
			if(Config.XMLRPC_ENABLED)
			{
				XMLRPCServer.getInstance();
				_log.info("XMLRPC is Enabled.");
			}
			
			if(Config.AUTOVOTEREWARD_ENABLED)
			{
				AutoVoteRewardHandler.getInstance();
				_log.info("Auto Vote System is Enabled.");
			}
			
			if(Config.L2TOPDEMON_ENABLED)
			{
				L2TopDeamon.getInstance();
				_log.info("L2TOPDEMON is Enabled.");
			}

			 if(Config.RESTART_BY_TIME_OF_DAY)
			 {
				 Restart.getInstance().StartCalculationOfNextRestartTime();
			 }
			
			else
				_log.info("All Power Packs Stuffs are Disable.");
		
		
		
		Util.printSection("Status");
		System.gc();
		_log.info("Server Loaded in " + (System.currentTimeMillis() - serverLoadStart) / 1000 + " seconds");
		ServerStatus.getInstance();
		
		// Load telnet status
		Util.printSection("Telnet");
		if (Config.IS_TELNET_ENABLED)
		{
			_statusServer = new Status(ServerType.serverMode);
			_statusServer.start();
		}
		else
		{
			_log.info("Telnet server is disabled.");
		}
		
		Util.printSection("Login");
		_loginThread = LoginServerThread.getInstance();
		_loginThread.start();
		
		final SelectorConfig sc = new SelectorConfig();
		sc.MAX_READ_PER_PASS = com.l2j.netcore.Config.getInstance().MMO_MAX_READ_PER_PASS;
		sc.MAX_SEND_PER_PASS = com.l2j.netcore.Config.getInstance().MMO_MAX_SEND_PER_PASS;
		sc.SLEEP_TIME = com.l2j.netcore.Config.getInstance().MMO_SELECTOR_SLEEP_TIME;
		sc.HELPER_BUFFER_COUNT = com.l2j.netcore.Config.getInstance().MMO_HELPER_BUFFER_COUNT;
		
		_gamePacketHandler = new L2GamePacketHandler();
		
		_selectorThread = new SelectorThread<L2GameClient>(sc, _gamePacketHandler, _gamePacketHandler, _gamePacketHandler, new IPv4Filter());
		
		InetAddress bindAddress = null;
		if (!Config.GAMESERVER_HOSTNAME.equals("*"))
		{
			try
			{
				bindAddress = InetAddress.getByName(Config.GAMESERVER_HOSTNAME);
			}
			catch (UnknownHostException e1)
			{
				if (Config.ENABLE_ALL_EXCEPTIONS)
					e1.printStackTrace();
				
				_log.log(Level.SEVERE, "WARNING: The GameServer bind address is invalid, using all avaliable IPs. Reason: " + e1.getMessage(), e1);
			}
		}
		
		try
		{
			_selectorThread.openServerSocket(bindAddress, Config.PORT_GAME);
		}
		catch (IOException e)
		{
			if (Config.ENABLE_ALL_EXCEPTIONS)
				e.printStackTrace();
			
			_log.log(Level.SEVERE, "FATAL: Failed to open server socket. Reason: " + e.getMessage(), e);
			System.exit(1);
		}
		_selectorThread.start();		
	}
	
	public static SelectorThread<L2GameClient> getSelectorThread()
	{
		return _selectorThread;
	}
}
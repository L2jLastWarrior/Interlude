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
package com.l2j.gameserver.handler;

import java.util.Map;
import java.util.logging.Logger;

import javolution.util.FastMap;

import com.l2j.Config;
import com.l2j.gameserver.GameServer;
import com.l2j.gameserver.handler.voicedcommandhandlers.AwayCmd;
import com.l2j.gameserver.handler.voicedcommandhandlers.BankingCmd;
import com.l2j.gameserver.handler.voicedcommandhandlers.ChangePasswordNPC;
import com.l2j.gameserver.handler.voicedcommandhandlers.CTFCmd;
import com.l2j.gameserver.handler.voicedcommandhandlers.DelevelCmd;
import com.l2j.gameserver.handler.voicedcommandhandlers.DMCmd;
import com.l2j.gameserver.handler.voicedcommandhandlers.FarmPvpCmd;
import com.l2j.gameserver.handler.voicedcommandhandlers.MenuCmd;
import com.l2j.gameserver.handler.voicedcommandhandlers.OfflineShop;
import com.l2j.gameserver.handler.voicedcommandhandlers.Online;
import com.l2j.gameserver.handler.voicedcommandhandlers.SiegeManagerCmd;
import com.l2j.gameserver.handler.voicedcommandhandlers.StatsCmd;
import com.l2j.gameserver.handler.voicedcommandhandlers.TvTCmd;
import com.l2j.gameserver.handler.voicedcommandhandlers.VersionCmd;
import com.l2j.gameserver.handler.voicedcommandhandlers.Voting;
import com.l2j.gameserver.handler.voicedcommandhandlers.Wedding;
import com.l2j.gameserver.handler.voicedcommandhandlers.Repair;

/**
 * This class ...
 * @version $Revision: 1.1.4.6 $ $Date: 2009/05/12 19:44:09 $
 */
public class VoicedCommandHandler
{
	private static Logger _log = Logger.getLogger(GameServer.class.getName());
	
	private static VoicedCommandHandler _instance;
	
	private Map<String, IVoicedCommandHandler> _datatable;
	
	public static VoicedCommandHandler getInstance()
	{
		if (_instance == null)
		{
			_instance = new VoicedCommandHandler();
		}
		
		return _instance;
	}
	
	private VoicedCommandHandler()
	{
		_datatable = new FastMap<String, IVoicedCommandHandler>();
		
		registerVoicedCommandHandler(new Voting());
		
		if (Config.BANKING_SYSTEM_ENABLED)
		{
			registerVoicedCommandHandler(new BankingCmd());
			System.out.println("Command_Bank is Enabled.");
		}
		
		if (Config.CTF_COMMAND)
		{
			registerVoicedCommandHandler(new CTFCmd());
			System.out.println("Command_CTF Event is Enabled.");
		}
		
		if (Config.TVT_COMMAND)
		{
			registerVoicedCommandHandler(new TvTCmd());
			System.out.println("Command_TVT Event is Enabled.");
		}
		
		if (Config.DM_COMMAND)
		{
			registerVoicedCommandHandler(new DMCmd());
			System.out.println("Command_DM Event is Enabled.");
		}
		
		if (Config.L2JMOD_ALLOW_WEDDING)
		{
			registerVoicedCommandHandler(new Wedding());
			System.out.println("Command_Wedding is Enabled.");
		}
		
		registerVoicedCommandHandler(new StatsCmd());
		
		if (Config.ALLOW_VERSION_COMMAND)
		{
			registerVoicedCommandHandler(new VersionCmd());
			System.out.println("Command_Server Version is Enabled.");
		}
		
		if (Config.ALLOW_AWAY_STATUS)
		{
			registerVoicedCommandHandler(new AwayCmd());
			System.out.println("Command_Away is Enabled.");
		}
		
		if (Config.ALLOW_FARM1_COMMAND || Config.ALLOW_FARM2_COMMAND || Config.ALLOW_PVP1_COMMAND || Config.ALLOW_PVP2_COMMAND)
		{
			registerVoicedCommandHandler(new FarmPvpCmd());
			System.out.println("Command_PvP & Farm Area is Enabled.");
		}
		
		if (Config.ALLOW_ONLINE_VIEW)
		{
			registerVoicedCommandHandler(new Online());
			System.out.println("Command_Online is Enabled.");
		}
		
		if (Config.OFFLINE_TRADE_ENABLE && Config.OFFLINE_COMMAND2)
		{
			registerVoicedCommandHandler(new OfflineShop());
			System.out.println("Command_Offline Shop is Enabled.");
		}
		
		if (Config.REPAIR_ENABLE)
		{
			registerVoicedCommandHandler(new Repair());
			System.out.println("Command_Repair is Enabled.");
		}
		
		if (Config.DELEVEL_ENABLE)
		{
			registerVoicedCommandHandler(new DelevelCmd());
			System.out.println("Command_Delevel is Enabled.");
		}
		
		if (Config.ENABLE_MASS_SIEGE_CASTLE_MANAGER)
		{
			registerVoicedCommandHandler(new SiegeManagerCmd());
			System.out.println("Command_Castle_Manager is Enabled.");
		}
		
		if (Config.ENABLE_MENU_CMD)
		{
			registerVoicedCommandHandler(new MenuCmd());
			System.out.println("Command_Menu is Enabled.");
		}
		
		registerVoicedCommandHandler(new ChangePasswordNPC());
				
		_log.config("VoicedCommandHandler: Loaded " + _datatable.size() + " handlers.");
		
	}
	
	public void registerVoicedCommandHandler(IVoicedCommandHandler handler)
	{
		String[] ids = handler.getVoicedCommandList();
		
		for (String id : ids)
		{
			if (Config.DEBUG)
			{
				_log.fine("Adding handler for command " + id);
			}
			
			_datatable.put(id, handler);
		}
		
		ids = null;
	}
	
	public IVoicedCommandHandler getVoicedCommandHandler(String voicedCommand)
	{
		String command = voicedCommand;
		
		if (voicedCommand.indexOf(" ") != -1)
		{
			command = voicedCommand.substring(0, voicedCommand.indexOf(" "));
		}
		
		if (Config.DEBUG)
		{
			_log.fine("getting handler for command: " + command + " -> " + (_datatable.get(command) != null));
		}
		
		return _datatable.get(command);
	}
	
	/**
	 * @return
	 */
	public int size()
	{
		return _datatable.size();
	}
}
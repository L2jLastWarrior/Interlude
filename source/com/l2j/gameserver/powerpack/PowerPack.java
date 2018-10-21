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
package com.l2j.gameserver.powerpack;

/**
 * 
 * @author LastWarrior
 *
 */

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

public class PowerPack
{
private static PowerPack _instance = null;

public static PowerPack getInstance()
{
	if(_instance == null)
	{
		_instance = new PowerPack();
	}
	return _instance;
}
	
	public void chatHandler(L2PcInstance sayer, int chatType, String message)
	{
		
	}
}
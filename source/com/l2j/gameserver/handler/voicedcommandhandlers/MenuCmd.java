/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2j.gameserver.handler.voicedcommandhandlers;

import com.l2j.Config;
import com.l2j.gameserver.handler.IVoicedCommandHandler;
import com.l2j.gameserver.model.actor.instance.L2PcInstance;
import com.l2j.gameserver.network.serverpackets.NpcHtmlMessage;

/**
 * This class trades Gold Bars for Adena and vice versa.
 * @author Ahmed
 */
public class MenuCmd implements IVoicedCommandHandler
{
	private static String[] _voicedCommands =
	{
		"menu"
	};
	
	/**
	 * @see com.l2j.gameserver.handler.IVoicedCommandHandler#useVoicedCommand(java.lang.String, com.l2j.gameserver.model.actor.instance.L2PcInstance, java.lang.String)
	 */
	
	@Override
	public boolean useVoicedCommand(String command, L2PcInstance activeChar, String target)
	{
		if(command.startsWith("menu"))
		{
			sendHtml(activeChar);
		}
		return true;
	}

	private void sendHtml(L2PcInstance activeChar)
    {
        NpcHtmlMessage menu = new NpcHtmlMessage(5);
        StringBuilder tb = new StringBuilder("");
            
        tb.append("<html><head><title>Reward Menu</title></head><body>");
        tb.append("<center>");
        tb.append("<img src=\"L2Font-e.replay_logo-e\" width=256 height=80>");
        tb.append("<br>");
        tb.append("<img src=\"l2ui_ch3.herotower_deco\" width=256 height=32 align=center>"); 
        tb.append("<br>");
        tb.append("<font color=\"FFAA00\">TvT Reward = "+ Config.TVT_REWARD +" "+ Config.TVT_REWARD_AMOUNT +"</font>");
        tb.append("<br>");
        tb.append("<font color=\"FFAA00\">DM Reward = "+ Config.DM_REWARD +" "+ Config.DM_REWARD_AMOUNT +"</font>");
        tb.append("<br>");
        tb.append("<font color=\"FFAA00\">VIP Reward = "+ Config.VIP_REWARD +" "+ Config.VIP_REWARD_AMOUNT +"</font>");
        tb.append("<br>");
        tb.append("<font color=\"FFAA00\">HopZone Reward = "+ Config.HOPZONE_REWARD +" "+ Config.HT_REWARD_AMOUNT +"</font>");
        tb.append("<br>");
        tb.append("<font color=\"FFAA00\">TopZone Reward = "+ Config.TOPZONE_REWARD +" "+ Config.HT_REWARD_AMOUNT +"</font>");
        tb.append("<br>");
        tb.append("</center>");
        tb.append("<center>");
        tb.append("<img src=\"l2ui_ch3.herotower_deco\" width=256 height=32 align=center>");
        tb.append("<br>");  
        tb.append("</center>");
        tb.append("</body></html>");
            
        menu.setHtml(tb.toString());
        activeChar.sendPacket(menu);
    }	
	
	@Override
	public String[] getVoicedCommandList()
	{
		return _voicedCommands;
	}
}
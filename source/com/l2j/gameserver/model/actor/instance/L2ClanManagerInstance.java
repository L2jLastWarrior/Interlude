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
package com.l2j.gameserver.model.actor.instance;

import com.l2j.Config;
import com.l2j.gameserver.ai.CtrlIntention;
import com.l2j.gameserver.network.serverpackets.ActionFailed;
import com.l2j.gameserver.network.serverpackets.MagicSkillUser;
import com.l2j.gameserver.network.serverpackets.MyTargetSelected;
import com.l2j.gameserver.network.serverpackets.NpcHtmlMessage;
import com.l2j.gameserver.network.serverpackets.SocialAction;
import com.l2j.gameserver.network.serverpackets.ValidateLocation;
import com.l2j.gameserver.templates.L2NpcTemplate;
import com.l2j.util.random.Rnd;


/**
 * 
 * @author LastWarrior_Dev
 *
 */
public class L2ClanManagerInstance extends L2NpcInstance
{
	public L2ClanManagerInstance(int objectId, L2NpcTemplate template)
	{
		super(objectId, template);
	}
	
	@Override
	public void onBypassFeedback(L2PcInstance player, String command)
	{
		if (command.startsWith("levelup"))
		{
			if(player.getClan() != null)
			{
				if (!player.isClanLeader())
				{
					player.sendMessage("Only clan leaders, can use this service.");
				}
				if (player.isClanLeader() && player.getClan().getReputationScore() > Config.REPUTATION_POINT)
				{
					player.getClan().setReputationScore(player.getClan().getReputationScore()+Config.REPUTATION_POINT, true);
					player.getClan().changeLevel(Config.CLAN_LEVEL);
					player.sendMessage("Your clan successfully changed to level "+Config.CLAN_LEVEL+".");
					MagicSkillUser  MSU = new MagicSkillUser(player, player, 2024, 1, 1, 0);
					player.broadcastPacket(MSU);
				}
				else
				{
					player.sendMessage("Your clan must have "+Config.REPUTATION_POINT+" clan reputation points in order to buy level "+Config.CLAN_LEVEL+".");
				}
			}
			else
			{
				player.sendMessage("You don't have a clan.");
			}
		}
	}
	
    @Override
    public void onAction(L2PcInstance player)
	{
		if(!canTarget(player))
			return;
		
		// Check if the L2PcInstance already target the L2Npc
		if(this != player.getTarget())
		{
			// Set the target of the L2PcInstance player
			player.setTarget(this);

			// Send a Server->Client packet MyTargetSelected to the L2PcInstance player
			MyTargetSelected my = new MyTargetSelected(getObjectId(), 0);
			player.sendPacket(my);

			// Send a Server->Client packet ValidateLocation to correct the L2Npc position and heading on the client
			player.sendPacket(new ValidateLocation(this));
		}
		else
		{
			// Calculate the distance between the L2PcInstance and the L2Npc
			if(!canInteract(player))
			{
				// Notify the L2PcInstance AI with AI_INTENTION_INTERACT
				player.getAI().setIntention(CtrlIntention.AI_INTENTION_INTERACT, this);
			}
			else
			{
				showMessageWindow(player);
			}
		}
		// Send a Server->Client ActionFailed to the L2PcInstance in order to avoid that the client wait another packet
		player.sendPacket(new ActionFailed());
	}
    private void showMessageWindow(L2PcInstance player)
    {
        NpcHtmlMessage SpecialClanManager = new NpcHtmlMessage(5);
        StringBuilder tb = new StringBuilder("");
            
        tb.append("<html><head><title>Clan Manager</title></head><body>");
        tb.append("<center>");
        tb.append("<img src=\"L2Font-e.replay_logo-e\" width=256 height=80>");
        tb.append("<br>");
        tb.append("<img src=\"l2ui_ch3.herotower_deco\" width=256 height=32 align=center>"); 
        tb.append("<br>");
        tb.append("<font color=\"FFAA00\">Special Clan Manager</font>");
        tb.append("<br>");
        tb.append("</center>");
        tb.append("<center>");
        tb.append("<a action=\"bypass -h npc_" + getObjectId() + "_levelup\">Get your clan at level "+Config.CLAN_LEVEL+".</a><br>");
        tb.append("<font color=\"FFAA00\">It costs "+Config.REPUTATION_POINT+" clan reputation points.</font>");
        tb.append("<br>");
        tb.append("</center>");
        tb.append("<center>");
        tb.append("<img src=\"l2ui_ch3.herotower_deco\" width=256 height=32 align=center>");
        tb.append("<br>");  
        tb.append("</center>");
        tb.append("</body></html>");
            
        SpecialClanManager.setHtml(tb.toString());
        player.sendPacket(SpecialClanManager);
    }	
}
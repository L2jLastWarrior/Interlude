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
package com.l2j.gameserver.handler.itemhandlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.l2j.Config;
import com.l2j.gameserver.handler.IItemHandler;
import com.l2j.gameserver.model.actor.instance.L2ItemInstance;
import com.l2j.gameserver.model.actor.instance.L2PcInstance;
import com.l2j.gameserver.model.actor.instance.L2PlayableInstance;
import com.l2j.gameserver.network.serverpackets.MagicSkillUser;
import com.l2j.gameserver.network.serverpackets.SocialAction;
import com.l2j.util.CloseUtil;
import com.l2j.util.database.L2DatabaseFactory;

/**
  *
  *
  * @author LastWarrior_Dev
  * 
  */

public class ClanReputationPointsCustomItem implements IItemHandler
{

	public ClanReputationPointsCustomItem()
	{
	//null
	}

	protected static final Logger _log = Logger.getLogger(ClanReputationPointsCustomItem.class.getName());
	
	String INSERT_DATA = "REPLACE INTO clan_data (clan_Id, clan_name, clan_level, reputation_score, hasCastle, ally_id, ally_name, leader_id, crest_id, crest_large_id, ally_crest_id, auction_bid_at, ally_penalty_expiry_time, ally_penalty_type, char_penalty_expiry_time, dissolving_expiry_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	@Override
	public void useItem(L2PlayableInstance playable, L2ItemInstance item)
	{
		L2PcInstance activeChar = (L2PcInstance)playable;
		if(Config.ENABLE_CLAN_REPUTATION_ITEM)
		{
						
			if (!(playable instanceof L2PcInstance))
                return;

			if (!activeChar.isClanLeader())
            {
                activeChar.sendMessage("This can be used only by Clan Leaders!");
                return;
            }
           
            else if (!(activeChar.getClan().getLevel() >= Config.CLAN_MIN_LEVEL))
            {
               activeChar.sendMessage("Your Clan Level is not big enough to use this item!");
               return;
            }
            else
            {
               activeChar.getClan().setReputationScore(activeChar.getClan().getReputationScore()+Config.CLAN_REPUTATION_REWARD_POINTS, true);
               activeChar.sendMessage("Your clan has earned "+ Config.CLAN_REPUTATION_REWARD_POINTS +" reputation points!");
               MagicSkillUser  MSU = new MagicSkillUser(activeChar, activeChar, 2024, 1, 1, 0);
               activeChar.broadcastPacket(MSU);
              playable.destroyItem("Consume", item.getObjectId(), 1, null, false);
            }
		}
		else
		{
			activeChar.sendMessage("[CRPCI]:You can't use this item right now.For more info PM Dev_Team");
		}
    }

	@Override
	public int[] getItemIds()
	{
		return ITEM_IDS;
	}
	
	private static final int ITEM_IDS[] =
	{
		Config.CLAN_REPUTATION_ITEM_ID
	};

}

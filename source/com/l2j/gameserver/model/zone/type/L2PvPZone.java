package com.l2j.gameserver.model.zone.type;

import com.l2j.gameserver.datatables.csv.MapRegionTable;
import com.l2j.gameserver.model.L2Character;
import com.l2j.gameserver.model.actor.instance.L2PcInstance;
import com.l2j.gameserver.model.zone.L2ZoneType;
import com.l2j.gameserver.network.SystemMessageId;
import com.l2j.gameserver.network.serverpackets.SystemMessage;

/**
 * 
 * @author LastWarrior
 * @Version:1.1.7
 *
 */

public class L2PvPZone extends L2ZoneType
{
	private L2PcInstance activeChar;

	public L2PvPZone(int id)
	{
		super(1564);
	}
	        	
	protected void onEnter(L2Character character)
	{
		if (character instanceof L2PcInstance)
		{
			if (!character.isInsideZone(L2Character.ZONE_FLAG_PVP))
				((L2PcInstance) character).sendPacket(new SystemMessage(SystemMessageId.ENTERED_COMBAT_ZONE));
		}
		character.setInsideZone(L2Character.ZONE_FLAG_PVP, true);
		character.setInsideZone(L2Character.ZONE_NOSUMMONFRIEND, true);
		activeChar.decayMe();
		activeChar.spawnMe();
        activeChar.isNoblesseBlessed();
		activeChar.setPvpFlag(1);
		activeChar.setTitle("Lets Fight");
		activeChar.broadcastUserInfo();
	}

	protected void onExit(L2Character character)
	{
		character.setInsideZone(L2Character.ZONE_FLAG_PVP, false);
		character.setInsideZone(L2Character.ZONE_NOSUMMONFRIEND, false);
		activeChar.decayMe();
		activeChar.spawnMe();
		activeChar.stopNoblesseBlessing(null);
		activeChar.setPvpFlag(0);
		activeChar.setTitle("");
		activeChar.broadcastUserInfo();
		
		if (character instanceof L2PcInstance)
		{
			if (!character.isInsideZone(L2Character.ZONE_FLAG_PVP))
				((L2PcInstance) character).sendPacket(new SystemMessage(SystemMessageId.LEFT_COMBAT_ZONE));
		}
	}

	public void onDieInside(L2Character character) 
	{
		MapRegionTable.getInstance().getTeleToLocation(activeChar, MapRegionTable.TeleportWhereType.Town);
	}

	public void onReviveInside(L2Character character) 
	{
		//nothing 
	}
}
/*
<zone id="11037" type="ZONE_FLAG_PVP" shape="NPoly" minZ="-3600" maxZ="-3400">
		<stat name="isPeaceZone" val="false" />
		<spawn X="x" Y="y5" Z="z" /> 
</zone>
On X,Y,Z is loc
*Change Location from data/zone/
*/
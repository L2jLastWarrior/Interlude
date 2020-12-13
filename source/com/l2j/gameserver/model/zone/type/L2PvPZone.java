/* This program is free software; you can redistribute it and/or modify
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
package com.l2j.gameserver.model.zone.type;

import com.l2j.gameserver.datatables.csv.MapRegionTable;
import com.l2j.gameserver.model.L2Character;
import com.l2j.gameserver.model.actor.instance.L2PcInstance;
import com.l2j.gameserver.model.zone.L2ZoneType;
import com.l2j.gameserver.network.SystemMessageId;
import com.l2j.gameserver.network.serverpackets.SystemMessage;

/**
 * @author anatolius - l2jlastwarrior
 * @version 1.1.8
 */

/*
How to create an PvPZone - Flag Zone:

<zone id="1564" type="ZONE_FLAG_PVP" shape="NPoly" minZ="-3600" maxZ="-3400">
    <stat name="isPeaceZone" val="false" />
    <spawn X="x" Y="y" Z="z" /> 
</zone>
where the x,y,z is the location in game!
You can add more in data/zones.
*/

public class L2PvPZone extends L2ZoneType{
    
    public L2PvPZone(int id){
        super(id);
    }
    
    @Override
    protected void onEnter(L2Character character){
        if(character instanceof L2PcInstance){
            if(character.isInsideZone(L2Character.ZONE_FLAG_PVP)){
                character.sendPacket(new SystemMessage(SystemMessageId.ENTERED_COMBAT_ZONE));
            }
            character.setInsideZone(L2Character.ZONE_FLAG_PVP, true);
            character.setInsideZone(L2Character.ZONE_NOSUMMONFRIEND, true);
            character.decayMe();
            character.spawnMe();
            ((L2PcInstance) character).isNoblesseBlessed();
            ((L2PcInstance) character).setPvpFlag(1);
            character.setTitle("Lets Fight");
            ((L2PcInstance) character).broadcastUserInfo();
        }
    }
    
    @Override
    protected void onExit(L2Character character){
        if(character instanceof L2PcInstance){
            if(!character.isInsideZone(L2Character.ZONE_FLAG_PVP)){
                ((L2PcInstance) character).sendPacket(new SystemMessage(SystemMessageId.LEFT_COMBAT_ZONE));
            }
        }
        character.setInsideZone(L2Character.ZONE_FLAG_PVP, false);
        character.setInsideZone(L2Character.ZONE_NOSUMMONFRIEND, false);
        character.decayMe();
        character.spawnMe();
        ((L2PcInstance) character).stopNoblesseBlessing(null);
        ((L2PcInstance) character).setPvpFlag(0);
        character.setTitle("");
        ((L2PcInstance) character).broadcastUserInfo();
    }
    
    @Override
    protected void onDieInside(L2Character character){
        MapRegionTable.getInstance().getTeleToLocation(character, MapRegionTable.TeleportWhereType.Town);
    }
    
    @Override
    protected void onReviveInside(L2Character character){
        
    }
}
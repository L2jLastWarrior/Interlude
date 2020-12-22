/*
 * Copyright (C) 2020 konstantinos
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2j.gameserver.model.actor.instance;

import java.util.ArrayList;
import java.util.logging.Logger;
import com.l2j.Config;
import com.l2j.gameserver.datatables.BuffTable;
import com.l2j.gameserver.datatables.BuffTable.Buff;
import com.l2j.gameserver.model.L2Character;
import com.l2j.gameserver.model.L2Object;

/**
 * @author anatolis - L2jLastWarrior
 */
public class L2BufferInstance{
    static Logger _log = Logger.getLogger(Config.class.getName());
    static L2PcInstance selfBuffer;
    static L2NpcInstance npcBuffer;
    
    public static void makeBuffs(L2PcInstance activeChar, int _templateId, L2Object efector, boolean paymentRequired){
        if(activeChar == null){
            return;
        }
        L2NpcInstance buffer = null;
        if(activeChar.getTarget() != null){
            if(activeChar.getTarget()instanceof L2NpcInstance){
                buffer = (L2NpcInstance) getbufferType(efector);
            }
        }
        if(buffer ==null){
            return;
        }
        buffer.setTarget(activeChar);
        ArrayList<Buff> _templateBuffs = new ArrayList<Buff>();
        _templateBuffs = BuffTable.getInstance().getBuffsForID(_templateId);
        if ((_templateBuffs == null) || (_templateBuffs.size() == 0)){
            return;
        }
        int _priceTotal = 0;
        for(Buff _buff : _templateBuffs){
            if(paymentRequired){
                if(!_buff.checkPrice(activeChar)){
                    activeChar.sendMessage("Not enough Adena");
                    return;
                }
                _priceTotal += _buff._price;
            }
            if(_buff._force || (activeChar.getFirstEffect(_buff._skill) == null)){
                buffer.setBusy(true);
                buffer.setCurrentMp(buffer.getMaxMp());
                buffer.setTarget(activeChar);
                buffer.doCast(_buff._skill);
                buffer.setBusy(false);
            }
            else{
                _buff._skill.getEffects(activeChar, activeChar, false, false, false);
            }
        }
        if(paymentRequired && (_priceTotal > 0)){
            activeChar.reduceAdena("NpcBuffer", _priceTotal, activeChar.getLastFolkNPC(), true);
        }
    }
    
    private static L2Character getbufferType(L2Object efector){
        if(efector instanceof L2PcInstance){
            selfBuffer = (L2PcInstance) efector;
            efector = selfBuffer;
        }
        if(efector instanceof L2NpcInstance){
            npcBuffer = (L2NpcInstance) efector;
            efector = npcBuffer;
        }
        return (L2Character) efector;
    }
}
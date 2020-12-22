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
package com.l2j.gameserver.datatables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javolution.util.FastMap;

import com.l2j.Config;
import com.l2j.gameserver.model.L2Skill;
import com.l2j.gameserver.model.actor.instance.L2PcInstance;
import com.l2j.util.CloseUtil;
import com.l2j.util.database.L2DatabaseFactory;

/**
 * @author anatolius - L2jLastWarrior
 */

public class BuffTable{
    private static BuffTable _instance = null;
    private Map<String, ArrayList<Buff>> _buffs;
    private Map<Integer, ArrayList<Buff>> _buffs_by_id;
    
    public static BuffTable getInstance(){
        if(_instance == null){
            _instance = new BuffTable();
        }
        return _instance;
    }
    
    private BuffTable(){
        _buffs = new FastMap<String, ArrayList<Buff>>();
        _buffs_by_id = new FastMap<Integer, ArrayList<Buff>>();
        Connection con = null;
        
        try{
            con = L2DatabaseFactory.getInstance().getConnection(false);
            PreparedStatement stm = con.prepareStatement("select name,skill_id,skill_level,skill_force,char_min_level,char_max_level,price_adena,id from buff_templates");
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                if(_buffs.get(rs.getString(1)) == null){
                    _buffs.put(rs.getString(1), new ArrayList<Buff>());
                }
                if(_buffs_by_id.get(rs.getInt(8)) == null){
                    _buffs_by_id.put(rs.getInt(8), new ArrayList<>());
                }
                ArrayList<Buff> a = _buffs.get(rs.getString(1));
                ArrayList<Buff> b = _buffs_by_id.get(rs.getInt(8));
                Buff new_buff = new Buff(rs);
                a.add(new_buff);
                b.add(new_buff);
            }
            rs.close();
            stm.close();
            System.out.println("Loaded \" + _buffs_by_id.size() + \" buff templates");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("...Error while loading buffs. Please, check buff_templates table");
        }
        finally{
            CloseUtil.close(con);
            con = null;
        }
    }
    
    public ArrayList<Buff> getBuffsForName(String name){
        ArrayList<Buff> output = new ArrayList<Buff>();
        if((name == null) || name.equals("all")){
            for(ArrayList<Buff> actual:_buffs.values()){
                output.addAll(actual);
            }
        }
        else{
            if(_buffs.get(name) !=null){
                output = _buffs.get(name);
            }
        }
        return output;
    }
    
    public ArrayList<Buff> getBuffsForID(Integer id){
        return _buffs_by_id.get(id);
    }
    
    public Iterator<String> skill_groups(){
        return _buffs.keySet().iterator();
    }
    
    public class Buff{
        public int _skillId;
        public int _skillLevel;
        public boolean _force;
        public int _minLevel;
        public int _maxLevel;
        public int _price;
        public L2Skill _skill;
        
        public Buff(ResultSet r) throws SQLException{
            _skillId = r.getInt(2);
            _skillLevel = r.getInt(3);
            _force = r.getInt(4) == 1;
            _minLevel = r.getInt(5);
            _maxLevel = r.getInt(6);
            _price = r.getInt(7);
            
            if(_price == -1){
                _price = Config.BUFFER_PRICE;
            }
            
            _skill = SkillTable.getInstance().getInfo(_skillId, _skillLevel);
        }
        
        public boolean checkLevel(L2PcInstance activeChar){
            return (_minLevel == 0 || activeChar.getLevel() >= _minLevel) && (_maxLevel == 0 || activeChar.getLevel() <= _maxLevel);
        }
        
        public boolean checkPrice(L2PcInstance activeChar){
            return (_price == 0 || activeChar.getInventory().getAdena() >= _price);
        }
    }
}
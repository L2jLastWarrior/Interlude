package com.l2j.gameserver.handler.voicedcommandhandlers;

import com.l2j.Config;
//import com.l2j.gameserver.datatables.SkillTable;
import com.l2j.gameserver.datatables.xml.ExperienceData;
import com.l2j.gameserver.handler.IVoicedCommandHandler;
import com.l2j.gameserver.managers.SiegeManager;
import com.l2j.gameserver.model.actor.instance.L2PcInstance;
import com.l2j.gameserver.model.entity.siege.Siege;
import com.l2j.gameserver.model.L2Skill;

/**
 * @author LastWarrior_Dev_Team
 */

public class DelevelCmd implements IVoicedCommandHandler
{
	private static final String[] VOICED_COMMANDS =
	{
			"delevel"
	};
	
	public static final int ZONE_PEACE = 2;
	
	@Override
	public boolean useVoicedCommand(String command, L2PcInstance activeChar, String target)
	{
		if(command.startsWith("delevel"))
		{
			requestDelevel(activeChar);
		}
		return true;
	}
	
	public boolean requestDelevel (L2PcInstance activeChar)
		{
			Siege siege = SiegeManager.getInstance().getSiege(activeChar);
		
			// Check the activeChar's level.
			if (activeChar.getLevel() < Config.DELEVEL_MIN_LEVEL)
			{
				activeChar.sendMessage("You do not meet the level requirement for Delevel!");
				return false;
			}	
			// Check activeChar if have SubClass
			else if (activeChar.isSubClassActive())
			{
				activeChar.sendMessage("Please switch to your Main Class before attempting Delevel.");
				return false;
			}	
			// Check activeChar if in Peace Zone
			else if(!activeChar.isInsideZone(ZONE_PEACE))
			{
				activeChar.sendMessage("You can only Delevel in peace zone.");
				return false;
			}
			 // Check activeChar is death/fake death and movement disable 
			else if(activeChar.isMovementDisabled() || activeChar.isAlikeDead())
			{	activeChar.sendMessage("You can't Delevel on death mode");
				return false; 
			}
			// Check if activeChar is in Siege
			else if(siege != null && siege.getIsInProgress())
			{
				activeChar.sendMessage("You are in siege, you can't Delevel.");
				return false;
			}
			// Check if activeChar is a Cursed Weapon owner
			else if(activeChar.isCursedWeaponEquiped())
			{
				activeChar.sendMessage("You can't Delevel! You are currently holding a cursed weapon.");
				return false;
			}
			// Check if activeChar is in Duel
			else if(activeChar.isInDuel())
			{
				activeChar.sendMessage("You can't Delevel You are in a duel!");
				return false;
			}
			// Check is in DimensionsRift
			else if(activeChar.isInParty() && activeChar.getParty().isInDimensionalRift())
			{
				activeChar.sendMessage("You can't Delevel! You are in the dimensional rift.");
				return false;
			}
			// Check to see if the activeChar is in an event
			else if(activeChar.isInFunEvent())
			{
				activeChar.sendMessage("You can't Delevel! You are in event now.");
				return false;
			}
			// Check activeChar is in Olympiade
			else if(activeChar.isInOlympiadMode() || activeChar.getOlympiadGameId() != -1)
			{
				activeChar.sendMessage("You can't Delevel! Your are fighting in Olympiad!");
				return false;
			}
			// Check activeChar is in observer mode
			else if(activeChar.inObserverMode())
			{
				activeChar.sendMessage("You can't Delevel in Observer mode!");
				return false;
			}
			// Check activeChar have karma/pk/pvp status
			if(activeChar.getKarma() > 0 || activeChar.getPvpFlag() > 0)
			{
				activeChar.sendMessage("player in PVP or with Karma can't use the Delevel command!");
				return false;
			}			
			// Check if activeChar have no one in target
			else if(activeChar.getTarget() == null)
			{
				activeChar.sendMessage("You can't have any one in your target when Delevel only your self.");
				return false;
			}
			// If activeChar have not any of theis can delevel
			delevelstart(activeChar);
			return true;
		}
	
	public boolean delevelstart(L2PcInstance activeChar)
	{
		try
		{
			double actual_hp = activeChar.getCurrentHp();
			double actual_cp = activeChar.getCurrentCp();				
			int max_level = ExperienceData.getInstance().getMaxLevel();				
			// Protections
			Integer returnToLevel = Config.DELEVEL_TO_LEVEL;
			if (returnToLevel < 1)
				returnToLevel = 1;
			if (returnToLevel > max_level)
				returnToLevel = max_level;				
			// Resets character to first class.
			activeChar.setClassId(activeChar.getBaseClass());				
			activeChar.broadcastUserInfo();				
			final byte lvl = Byte.parseByte(returnToLevel + "");				
			final long pXp = activeChar.getStat().getExp();
			final long tXp = ExperienceData.getInstance().getExpForLevel(lvl);		
			if (pXp > tXp)
			{
				activeChar.getStat().removeExpAndSp(pXp - tXp, 0);
			}
			else if (pXp < tXp)
			{
				activeChar.getStat().addExpAndSp(tXp - pXp, 0);
			}
			// Remove the activeChar's current skills.
			for (L2Skill skill : activeChar.getAllSkills())
			{
				activeChar.removeSkill(skill);
			}
			// Give activeChars their eligible skills.
			activeChar.giveAvailableSkills();		
			// restore Hp-Mp-Cp
			activeChar.setCurrentCp(actual_cp);
			activeChar.setCurrentMp(activeChar.getMaxMp());
			activeChar.setCurrentHp(actual_hp);
			activeChar.broadcastStatusUpdate();
			// Updates the activeChar's information in the Character Database.
			activeChar.store();
			// Update skill list
			activeChar.sendSkillList();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public String[] getVoicedCommandList()
	{
		return VOICED_COMMANDS;
	}
	
}
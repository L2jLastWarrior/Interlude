package com.l2j.gameserver.ai.special;

import com.l2j.gameserver.model.quest.Quest;

/**
 * 
 * Division AI
 * @author LastWarrior
 *
 */

public class Division extends Quest implements Runnable
{
	// Kernon NpcID
	private static final int DIVISION = 1582;

	public Division(int questId, String name, String descr)
	{
		super(questId, name, descr);

		addEventId(DIVISION, Quest.QuestEventType.ON_ATTACK);
	}

	@Override
	public void run()
	{}
}

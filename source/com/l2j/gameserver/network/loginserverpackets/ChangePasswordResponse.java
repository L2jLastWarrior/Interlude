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
package com.l2j.gameserver.network.loginserverpackets;

import com.l2j.gameserver.model.L2World;
import com.l2j.gameserver.model.actor.instance.L2PcInstance;

/**
 * 
 * @author LastWarrior
 *
 */

public class ChangePasswordResponse extends LoginServerBasePacket
{

	public ChangePasswordResponse(byte[] decrypt)
	{
		super(decrypt);
		//boolean isSuccessful = readC() > 0;
		String character = readS();
		String msgToSend = readS();
		
		L2PcInstance player = L2World.getInstance().getPlayer(character);
		
		if (player != null)
			player.sendMessage(msgToSend);
	}
}
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

import java.util.StringTokenizer;

import com.l2j.gameserver.cache.HtmCache;
import com.l2j.gameserver.handler.IVoicedCommandHandler;
import com.l2j.gameserver.model.actor.instance.L2PcInstance;
import com.l2j.gameserver.model.actor.instance.L2NpcInstance;
import com.l2j.gameserver.network.serverpackets.NpcHtmlMessage;
import com.l2j.gameserver.templates.L2NpcTemplate;
import com.l2j.gameserver.thread.LoginServerThread;

/**
 * 
 * Password Changer NPC
 * @author LastWarrior
 * @version 1.1.6a 
 *
 */

public class L2PasswordChangerInstance extends L2NpcInstance
{
	public L2PasswordChangerInstance(int objectId, L2NpcTemplate template)
	{
		super(objectId, template);
	}
	
	public boolean CheckValues(String command, L2PcInstance activeChar, String target)
	{
		if (command.startsWith("changepassword"))
		{
		if (target != null)
		{
			StringTokenizer st = new StringTokenizer(target);
			try
			{
				String curpass = null, newpass = null, repeatnewpass = null;
				if (st.hasMoreTokens()) curpass = st.nextToken();
				if (st.hasMoreTokens()) newpass = st.nextToken();
				if (st.hasMoreTokens()) repeatnewpass = st.nextToken();
				
				if (!(curpass == null || newpass == null || repeatnewpass == null))
				{
					if (!newpass.equals(repeatnewpass))
					{
						activeChar.sendMessage("The new password doesn't match with the repeated one!");
						return false;
					}
					if (newpass.length() < 3)
					{
						activeChar.sendMessage("The new password is shorter than 3 chars! Please try with a longer one.");
						return false;
					}
					if (newpass.length() > 30)
					{
						activeChar.sendMessage("The new password is longer than 30 chars! Please try with a shorter one.");
						return false;
					}
					
					LoginServerThread.getInstance().sendChangePassword(activeChar.getAccountName(), activeChar.getName(), curpass, newpass);
				}
				else
				{
					activeChar.sendMessage("Invalid password data! You have to fill all boxes.");
					return true;
				}
			}
			catch (Exception e)
			{
				activeChar.sendMessage("A problem occured while changing password!");
				//_log.log(Level.WARNING, "", e);
			}
		}return true;
		}return true;
	}
	
	@Override
	public void onAction(L2PcInstance activeChar)
	{
		NpcVoice(activeChar);
	}
	
	public boolean NpcVoice(L2PcInstance activeChar)
	{
		String htmFile ="data/html/mods/ChangePassword.htm";
		NpcHtmlMessage msg = new NpcHtmlMessage(5);
        msg.setFile(htmFile);
        activeChar.sendPacket(msg);
        if (htmFile == null)
        	htmFile = "<html><body><br><br><center><font color=LEVEL>404:</font> File Not Found</center></body></html>";
		return true;
	}
}













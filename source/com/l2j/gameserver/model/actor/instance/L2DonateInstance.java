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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Collection;
import java.util.StringTokenizer;

import javolution.text.TextBuilder;

import com.l2j.Config;
import com.l2j.gameserver.model.L2World;
import com.l2j.gameserver.network.serverpackets.NpcHtmlMessage;
import com.l2j.gameserver.templates.L2NpcTemplate;

/**
 * 
 * @author LastWarrior
 *
 */

public class L2DonateInstance extends L2FolkInstance
{
	private static boolean ENABLE_DONATE_NPC = Config.ENABLE_DONATE_NPC;
	
	public L2DonateInstance(int objectId, L2NpcTemplate template)
	{
		super(objectId, template);
	
	}

	@Override
	public void onBypassFeedback(final L2PcInstance player, String command)
	  {
		      if(player == null)
		      {
		         return;
		      }
		      
		      if(command.startsWith("dlist"))
		      {
		    	  info(player);
		      }
		      if(command.startsWith("donate"))
		      {
		    	  StringTokenizer st = new StringTokenizer(command);
		    	  st.nextToken();
		    	  String amount = null;
		    	  int pin1 = 0;
		    	  int pin2 = 0;
		    	  int pin3 = 0;
		    	  int pin4 = 0;
		    	  String message = "";
		    	  
		    	  try
		    	  {
		    		 amount = st.nextToken();
		    		 pin1 = Integer.parseInt(st.nextToken());
		    		 pin2 = Integer.parseInt(st.nextToken());
		    		 pin3 = Integer.parseInt(st.nextToken());
		    		 pin4 = Integer.parseInt(st.nextToken());
		    		 while(st.hasMoreTokens())
		    			 
		    			 message = message + st.nextToken() + " ";
		    		 /*String fname = "./data/donates/"+player.getName()+".txt";
		    		 File file = new File(fname);
		    		 boolean exist = file.createNewFile();
		    		 if(!exist)
		    		 {
		    		     player.sendMessage("You have already sent a donation , GMs must check it first");
		    		     return;
		    		 }
		    		 FileWriter fstream = new FileWriter(fname);
		    		 BufferedWriter out = new BufferedWriter(fstream);
		    		 out.write("Character Info: [Character: "+ player.getName() +"["+ player.getObjectId()+"] - Account: "+ player.getAccountName()+" - IP: "+player.getClient().getConnection().getInetAddress().getHostAddress()+"]\nMessage : donate "+ amount +" "+ message + " "+ pin1+ " "+ pin2+ " "+ pin3+ " "+ pin4);
		    		 out.close();
		    		 */
		    		 final String DATA_FOLDER_BASE = "data";
		    		 File datafolderbase = new File (DATA_FOLDER_BASE);
		    		 datafolderbase.mkdir();
		    		 final String DONATION_FOLDER = "data/donates";
		    		 File donationfolder = new File (DONATION_FOLDER);
		    		 donationfolder.mkdir();
		    		 final String DonatePlayer = "./data/donates/"+player.getName()+".txt";
		    		 File DonatePlayerFile = new File(DonatePlayer);
		    		 boolean DonationExist = DonatePlayerFile.createNewFile();
		    		 if (!DonationExist)
		    		 {
		    			 player.sendMessage("You have already sent a donation , GMs must check it first");
		    		     return;
		    		 }
		    		 FileWriter fstream = new FileWriter(DonatePlayer);
		    		 BufferedWriter out = new BufferedWriter(fstream);
		    		 out.write("Character Info: [Character: "+ player.getName() +"["+ player.getObjectId()+"] - Account: "+ player.getAccountName()+" - IP: "+player.getClient().getConnection().getInetAddress().getHostAddress()+"]\nMessage : donate "+ amount +" "+ message + " "+ pin1+ " "+ pin2+ " "+ pin3+ " "+ pin4);
		    		 out.close();
		    		 player.sendMessage("Thank you for your donation.All the items that you order will be tranfer to your account in the next 1~5 hours.Thank you for supporting our server.FOR ANY PROBLEM CONTACT WITH L][Division Team AT L2protocol@hotmail.gr");
		    		 
		    		 Collection<L2PcInstance> pls = L2World.getInstance().getAllPlayers();
		    			 for (L2PcInstance gms : pls)
		    				{
		    				 	if(gms.isGM())
		    				 	gms.sendMessage(player.getName() +" sent a donation.");
		    				}
		    	  }
		    	  catch(Exception e)
		    	  {
		    		  e.printStackTrace();
		    	  }
		      }  
	  }
	
	  @Override
	public void onAction(L2PcInstance player)
	  /*
	  {
	    if (!canTarget(player)) {
	      return;
	    }
	      showHtmlWindow(player);
	  }
	  */
	  {
		  if(ENABLE_DONATE_NPC)
		  {
			  if (!canTarget(player)) 
			  {
			      return;
			  }
			  showHtmlWindow(player);
		  }
		  else if(!ENABLE_DONATE_NPC)
		  {
			  DonateNpcLocked(player);
		  }
	  }
	
	  private void showHtmlWindow(L2PcInstance activeChar)
	  {
			TextBuilder tb = new TextBuilder();
			NpcHtmlMessage html = new NpcHtmlMessage(1);
			        
			tb.append("<html><head><title>Donation Manager</title></head><body><center><table width=\"250\" bgcolor=\"000000\"><tr><td align=center><font color=\"6fd3d1\">Donate via PaySafe System</font></td></tr></table>_______________________________________<br><br><table width=\"250\"><tr><td><font color=\"ddc16d\">1) Select Donation Amount:</font></td><td><combobox width=80 height=17 var=amount list=05-euro;10-euro;15-euro;20-euro;25-euro;30-euro;35-euro;40-euro;45-euro;50-euro;55-euro;60-euro;65-euro;70-euro;75-euro;80-euro;85-euro;90-euro;95-euro;100-euro;></td></tr></table><br><br><font color=\"ddc16d\">2) Paysafe Card Pin:</font><table width=\"250\"><tr><td><edit var=\"pin1\" width=50 height=12 type=number></td><td><edit var=\"pin2\" width=50 height=12 type=number></td><td><edit var=\"pin3\" width=50 height=12 type=number></td><td><edit var=\"pin4\" width=50 height=12 type=number></td></table><br><br><font color=\"ddc16d\">3) Write what you want to Buy and your E-mail<br> so we can contact you for any problem :</font><br><multiedit var=\"message\" width=240 height=40><br><br><button value=\"Donate!\" action=\"bypass -h npc_"+getObjectId()+"_donate $amount $pin1 $pin2 $pin3 $pin4 $message\" width=95 height=21 back=\"bigbutton_over\" fore=\"bigbutton\"><br><button value=\"Donation List\" action=\"bypass -h npc_"+getObjectId()+"_dlist\" width=95 height=21 back=\"bigbutton_over\" fore=\"bigbutton\"><br><font color=\"a1df64\">Fill all the fields.All informations are required..<br>L2jLastWarrior Donate System</font></center></body></html>");
			        
			html.setHtml(tb.toString());
			activeChar.sendPacket(html);
	  }
	  
	  private void info(L2PcInstance activeChar)
	  {
			TextBuilder tb = new TextBuilder();
			NpcHtmlMessage html = new NpcHtmlMessage(1);
			        
			tb.append("<html><head><title>Donation Manager</title></head><body><center>Armors:<br>Dynasty Armor = ?e<br>Weapons:<br>Dynasty Weapons = ?e<br>Jewelrys:<br>RaidBoss Jawelrys = ?e<br>Arguments:<br>1 Agument Skills = ?<br>Bonus At 2 Agument Skills +1 Free Gift<br>Others:<br>30 Heros Coins = 15e<br></center></body></html>");
			html.setHtml(tb.toString());
			activeChar.sendPacket(html);
	  }
	  
	  private void DonateNpcLocked(L2PcInstance activeChar)
	  {
		  TextBuilder tb = new TextBuilder();
		  NpcHtmlMessage html = new NpcHtmlMessage(1);
		  tb.append("<html><body><br><br><center><font color=LEVEL>404:</font> File Not Found or Npc is Locked<br>For more info contact with L2jLastWarriorDevTeam</center></body></html>");
		  html.setHtml(tb.toString());
		  activeChar.sendPacket(html);
	  }
}








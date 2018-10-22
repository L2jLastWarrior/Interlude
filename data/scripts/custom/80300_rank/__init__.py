import sys
from com.l2j.gameserver.model.actor.instance import L2PcInstance
from java.util import Iterator
from com.l2j.gameserver.datatables import SkillTable
from com.l2j.util.database import L2DatabaseFactory
from com.l2j.gameserver.model.quest import State
from com.l2j.gameserver.model.quest import QuestState
from com.l2j.gameserver.model.quest.jython import QuestJython as JQuest

print "start loading Top PvP/PK Status custom script NPC"

NPC=[80300]
Precio_ID   = 57

QuestId     = 80300
QuestName   = "rank"
QuestDesc   = "custom"
InitialHtml = "1.htm"

class Quest (JQuest) :

	def __init__(self,id,name,descr): JQuest.__init__(self,id,name,descr)

	def onTalk (self,npc,player):
		return InitialHtml
	def onEvent(self,event,st):
		htmltext = event
		cantidad_pago = st.getQuestItemsCount(Precio_ID)
		
		# *********
		# PK info *
		# *********
		
		if event == "1" and cantidad_pago >= 0 :
			st.takeItems(Precio_ID,0)
			total_asesinados = 0
			htmltext_ini = "<html><head><title>Pk Info</title></head><body><table width=300><tr><td><font color =\"FF00FF\"></td><td><center><font color =\"FFFF00\">Player</color></center></td><td><center>Kills</center></td></tr>"
			htmltext_info =""			
			color = 1
			pos = 0
			con = L2DatabaseFactory.getInstance().getConnection()
			pks = con.prepareStatement("SELECT char_name,pkkills FROM characters WHERE pkkills>0 and accesslevel=0 order by pkkills desc limit 30")
			rs = pks.executeQuery()
			while (rs.next()) :
				char_name = rs.getString("char_name")
				char_pkkills = rs.getString("pkkills")
				total_asesinados = total_asesinados + int(char_pkkills)
				pos = pos + 1
				posstr = str(pos)
				if color == 1:
					color_text = "<font color =\"00FFFF\">"
					color = 2
					htmltext_info = htmltext_info + "<tr><td><center><font color =\"FF00FF\">" + posstr + "</td><td><center>" + color_text + char_name +"</center></td><td><center>" + char_pkkills + "</center></td></tr>"
				elif color == 2:
					color_text = "<font color =\"FF0000\">"
					color = 1
					htmltext_info = htmltext_info + "<tr><td><center><font color =\"FF00FF\">" + posstr + "</td><td><center>" + color_text + char_name +"</center></td><td><center>" + char_pkkills + "</center></td></tr>"
			htmltext_end = "</table><center><font color=\"FFFFFF\">" + "A Total of " + str(total_asesinados) + " Pk's.</center></body></html>"
			htmltext_pklist = htmltext_ini + htmltext_info + htmltext_end
			con.close()
			return htmltext_pklist
		elif event == "1" and cantidad_pago < 0 :
			htmltext = "<html><head><title>PK info Online</title></head><body><font color =\"FF0000\">Primero pagame...!! son 0 adenas.</body></html>"
			return htmltext
			
		# **********
		# PvP info *
		# **********
			
		if event == "2" and cantidad_pago >= 0 :
			st.takeItems(Precio_ID,0)
			total_asesinados = 0
			htmltext_ini = "<html><head><title>PvP info</title></head><body><table width=300><tr><td><font color =\"FF00FF\"></td><td><center><font color =\"FFFF00\">Player</color></center></td><td><center>Kills</center></td></tr>"
			htmltext_info =""			
			color = 1
			pos = 0
			con = L2DatabaseFactory.getInstance().getConnection()
			pks = con.prepareStatement("SELECT char_name,pvpkills FROM characters WHERE pvpkills>0 and accesslevel=0 order by pvpkills desc limit 30")
			rs = pks.executeQuery()
			while (rs.next()) :
				char_name = rs.getString("char_name")
				char_pkkills = rs.getString("pvpkills")
				total_asesinados = total_asesinados + int(char_pkkills)
				pos = pos + 1
				posstr = str(pos)
				if color == 1:
					color_text = "<font color =\"00FFFF\">"
					color = 2
					htmltext_info = htmltext_info + "<tr><td><center><font color =\"FF00FF\">" + posstr + "</td><td><center>" + color_text + char_name +"</center></td><td><center>" + char_pkkills + "</center></td></tr>"
				elif color == 2:
					color_text = "<font color =\"FF0000\">"
					color = 1
					htmltext_info = htmltext_info + "<tr><td><center><font color =\"FF00FF\">" + posstr + "</td><td><center>" + color_text + char_name +"</center></td><td><center>" + char_pkkills + "</center></td></tr>"
			htmltext_end = "</table><center><font color=\"FFFFFF\">" + "A Total of " + str(total_asesinados) + " Kills.</center></body></html>"
			htmltext_pklist = htmltext_ini + htmltext_info + htmltext_end
			con.close()
			return htmltext_pklist
		elif event == "2" and cantidad_pago < 0 :
			htmltext = "<html><head><title>PK info</title></head><body><font color =\"FF0000\">Primero pagame...!! son 0 adenas.</body></html>"
			return htmltext

		# *************
		# Adenas info *
		# *************
	
		if event == "3" and cantidad_pago >= 0 :
			st.takeItems(Precio_ID,0)
			total_cantidad = 0
			htmltext_ini = "<html><head><title>Adena info Online</title></head><body><table width=300><tr><td><font color =\"FF00FF\">Pos.</td><td><center><font color =\"FFFF00\">*** Name ***</color></center></td><td><center>*** Adenas ***</center></td></tr>"
			htmltext_info =""			
			color = 1
			pos = 0
			con = L2DatabaseFactory.getInstance().getConnection()
			pks = con.prepareStatement("SELECT count,owner_id FROM items WHERE item_id=57 order by count desc limit 20")
			rs = pks.executeQuery()
			while (rs.next()) :
				cantidad = rs.getString("count")
				pj_id = rs.getString("owner_id")
				total_cantidad = total_cantidad + long(cantidad)
				pos = pos + 1
				posstr = str(pos)
				charname = con.prepareStatement("SELECT char_name FROM characters WHERE charId=" + pj_id)
				rs2 = charname.executeQuery()
				while (rs2.next()) :
					char_name = rs2.getString("char_name")
				if color == 1:
					color_text = "<font color =\"00FFFF\">"
					color = 2
					htmltext_info = htmltext_info + "<tr><td><center><font color =\"FF00FF\">" + posstr + "</td><td><center>" + color_text + char_name +"</center></td><td><center>" + cantidad + "</center></td></tr>"
				elif color == 2:
					color_text = "<font color =\"FF0000\">"
					color = 1
					htmltext_info = htmltext_info + "<tr><td><center><font color =\"FF00FF\">" + posstr + "</td><td><center>" + color_text + char_name +"</center></td><td><center>" + cantidad + "</center></td></tr>"
			htmltext_end = "</table><center><font color=\"FFFFFF\">" + "Los TOPS suman " + str(total_cantidad) + " adenas.</center></body></html>"
			htmltext_pklist = htmltext_ini + htmltext_info + htmltext_end
			con.close()
			return htmltext_pklist
		elif event == "3" and cantidad_pago < 0 :
			htmltext = "<html><head><title>Adenas info Online</title></head><body><font color =\"FF0000\">Primero pagame...!! son 100k adenas.</body></html>"
			return htmltext

	

QUEST       = Quest(QuestId,str(QuestId) + "_" + QuestName,QuestDesc)


for npcId in NPC:
	QUEST.addStartNpc(npcId)
	QUEST.addTalkId(npcId)


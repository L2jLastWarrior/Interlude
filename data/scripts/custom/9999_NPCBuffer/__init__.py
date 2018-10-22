import sys
from com.l2j.gameserver.model.actor.instance import L2PcInstance
from java.util import Iterator
from com.l2j.gameserver.datatables import SkillTable
from com.l2j.gameserver.model.quest import State
from com.l2j.gameserver.model.quest import QuestState
from com.l2j.gameserver.model.quest.jython import QuestJython as JQuest

qn = "9999_NPCBuffer"

NPC=[90000]
ADENA_ID=57
QuestId     = 9999
QuestName   = "NPCBuffer"
QuestDesc   = "custom"
InitialHtml = "1.htm"

print "start loading buffer custom script NPC"

class Quest (JQuest) :

	def __init__(self,id,name,descr): JQuest.__init__(self,id,name,descr)


	def onEvent(self,event,st):
		htmltext = event
		count=st.getQuestItemsCount(ADENA_ID)
		if count < 1000  or st.getPlayer().getLevel() < 0 :
			htmltext = "<html><head><body>You dont have enought Adena.</body></html>"
		else:
			st.takeItems(ADENA_ID,0)
			st.getPlayer().setTarget(st.getPlayer())

			#nob
			if event == "70":
				st.takeItems
				SkillTable.getInstance().getInfo(1323,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "1.htm"
				st.setState(State.COMPLETED)


			#MP-HP
			if event == "6":
				st.takeItems
				st.getPlayer().setCurrentCp(st.getPlayer().getMaxCp())
                                st.getPlayer().setCurrentHp(st.getPlayer().getMaxHp())
                                st.getPlayer().setCurrentMp(st.getPlayer().getMaxMp())
				return "1.htm"				
				st.setState(COMPLETED)

			#Wind Walk
			if event == "7":
				st.takeItems
				SkillTable.getInstance().getInfo(1204,2).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)

			#Shield
			if event == "9":
				st.takeItems
				SkillTable.getInstance().getInfo(1040,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)

			#Might
			if event == "10":
				st.takeItems
				SkillTable.getInstance().getInfo(1068,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)

                        #Mental Shield
			if event == "11":
				st.takeItems
				SkillTable.getInstance().getInfo(1035,4).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)

			#Blessed Body
			if event == "12":
				st.takeItems
				SkillTable.getInstance().getInfo(1045,6).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)

			#Blessed Soul
		        if event == "13":
				st.takeItems
				SkillTable.getInstance().getInfo(1048,6).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)		
				st.setState(COMPLETED)

			#Magic Barrier
			if event == "14":
				st.takeItems
				SkillTable.getInstance().getInfo(1036,2).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)

			#Resist Shock
			if event == "15":
				st.takeItems
				SkillTable.getInstance().getInfo(1259,4).getEffects(st.getPlayer(),st.getPlayer())				
				return "7.htm"
				st.setState(State.COMPLETED)

			#Concentration
			if event == "16":
				st.takeItems
				SkillTable.getInstance().getInfo(1078,6).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)

			#Berserker Spirit
			if event == "17":
				st.takeItems
				SkillTable.getInstance().getInfo(1062,2).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)

			#Bless Shield
			if event == "18":
				st.takeItems
				SkillTable.getInstance().getInfo(1243,6).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)

			#Vampiric Rage
			if event == "19":
				st.takeItems
				SkillTable.getInstance().getInfo(1268,4).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)

			#Acumen
			if event == "20":
				st.takeItems
				SkillTable.getInstance().getInfo(1085,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)

			#Empower
			if event == "21":
				st.takeItems
				SkillTable.getInstance().getInfo(1059,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)

			#Haste
			if event == "22":
				st.takeItems
				SkillTable.getInstance().getInfo(1086,2).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)

			#Guidance
			if event == "23":
				st.takeItems
				SkillTable.getInstance().getInfo(1240,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)

			#Focus
			if event == "24":
				st.takeItems
				SkillTable.getInstance().getInfo(1077,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)

			#Death Whisper
			if event == "25":
				st.takeItems
				SkillTable.getInstance().getInfo(1242,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)

			#Dance of Aqua Guard
			if event == "26":
				st.takeItems
				SkillTable.getInstance().getInfo(271,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "3.htm"
				st.setState(State.COMPLETED)


			#Dance of Concentration
			if event == "27":
				st.takeItems
				SkillTable.getInstance().getInfo(272,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "3.htm"
				st.setState(State.COMPLETED)

			#Dance of Earth Guard
			if event == "28":
				st.takeItems
				SkillTable.getInstance().getInfo(273,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "3.htm"
				st.setState(State.COMPLETED)

			#Dance of Fire
			if event == "29":
				st.takeItems
				SkillTable.getInstance().getInfo(274,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "3.htm"
				st.setState(State.COMPLETED)

			#Dance of Fury
			if event == "30":
				st.takeItems
				SkillTable.getInstance().getInfo(275,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "3.htm"
				st.setState(State.COMPLETED)

			#Dance of Inspiration
			if event == "31":
				st.takeItems
				SkillTable.getInstance().getInfo(276,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "3.htm"
				st.setState(State.COMPLETED)

			#Dance of Light
			if event == "32":
				st.takeItems
				SkillTable.getInstance().getInfo(277,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "3.htm"
				st.setState(State.COMPLETED)

			#Dance of the Mystic
			if event == "33":
				st.takeItems
				SkillTable.getInstance().getInfo(307,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "3.htm"
				st.setState(State.COMPLETED)

			#Dance of Protection
			if event == "34":
				st.takeItems
				SkillTable.getInstance().getInfo(309,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "3.htm"
				st.setState(State.COMPLETED)

			#Siren's Dance
			if event == "35":
				st.takeItems
				SkillTable.getInstance().getInfo(310,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "3.htm"
				st.setState(State.COMPLETED)

			#Dance of the Vampire
			if event == "36":
				st.takeItems
				SkillTable.getInstance().getInfo(311,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "3.htm"
				st.setState(State.COMPLETED)

			#Dance of the Warrior
			if event == "37":
				st.takeItems
				SkillTable.getInstance().getInfo(366,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "3.htm"
				st.setState(State.COMPLETED)

			#Song of Champion
			if event == "38":
				st.takeItems
				SkillTable.getInstance().getInfo(365,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "3.htm"
				st.setState(State.COMPLETED)

			#Song of Earth
			if event == "39":
				st.takeItems
				SkillTable.getInstance().getInfo(264,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "4.htm"
				st.setState(State.COMPLETED)

			#Song of Flame Guard
			if event == "40":
				st.takeItems
				SkillTable.getInstance().getInfo(265,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "4.htm"
				st.setState(State.COMPLETED)

			#Song of Hunter
			if event == "41":
				st.takeItems
				SkillTable.getInstance().getInfo(266,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "4.htm"
				st.setState(State.COMPLETED)

			#Song of Invocation
			if event == "42":
				st.takeItems
				SkillTable.getInstance().getInfo(267,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "4.htm"
				st.setState(State.COMPLETED)

			#Song of Life
			if event == "43":
				st.takeItems
				SkillTable.getInstance().getInfo(268,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "4.htm"
				st.setState(State.COMPLETED)

			#Song of Meditation
			if event == "44":
				st.takeItems
				SkillTable.getInstance().getInfo(269,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "4.htm"
				st.setState(State.COMPLETED)

			#Song of Renewal
			if event == "45":
				st.takeItems
				SkillTable.getInstance().getInfo(270,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "4.htm"
				st.setState(State.COMPLETED)

			#Song of Storm Guard
			if event == "46":
				st.takeItems
				SkillTable.getInstance().getInfo(304,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "4.htm"
				st.setState(State.COMPLETED)

			#Song of Vengeance
			if event == "47":
				st.takeItems
				SkillTable.getInstance().getInfo(305,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "4.htm"
				st.setState(State.COMPLETED)

			#Song of Vitality
			if event == "48":
				st.takeItems
				SkillTable.getInstance().getInfo(306,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "4.htm"
				st.setState(State.COMPLETED)

			#Song of Warding
			if event == "49":
				st.takeItems
				SkillTable.getInstance().getInfo(308,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "4.htm"
				st.setState(State.COMPLETED)
			#Song of Water
			if event == "50":
				st.takeItems
				SkillTable.getInstance().getInfo(363,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "4.htm"
				st.setState(State.COMPLETED)
			#Song of Wind
			if event == "51":
				st.takeItems
				SkillTable.getInstance().getInfo(364,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "4.htm"
				st.setState(State.COMPLETED)

			
			#Greater Might
			if event == "52":
				st.takeItems
				SkillTable.getInstance().getInfo(349,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "4.htm"
				st.setState(State.COMPLETED)

			#Greater Shield
			if event == "53":
				st.takeItems
				SkillTable.getInstance().getInfo(1007,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "5.htm"
				st.setState(State.COMPLETED)

			#Chant of Victory
			if event == "54":
				st.takeItems
				SkillTable.getInstance().getInfo(1009,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "5.htm"
				st.setState(State.COMPLETED)

			#Prophecy of Fire
			if event == "55":
				st.takeItems
				SkillTable.getInstance().getInfo(1006,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "5.htm"
				st.setState(State.COMPLETED)

			#Prophecy of Water
			if event == "56":
				st.takeItems
				SkillTable.getInstance().getInfo(1002,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "5.htm"
				st.setState(State.COMPLETED)

			#Prophecy of Wind
			if event == "57":
				st.takeItems
				SkillTable.getInstance().getInfo(1229,18).getEffects(st.getPlayer(),st.getPlayer())				
				return "7.htm"
				st.setState(State.COMPLETED)

			#Prophecy of Wind
			if event == "58":
				st.takeItems
				SkillTable.getInstance().getInfo(1251,2).getEffects(st.getPlayer(),st.getPlayer())				
				return "5.htm"
				st.setState(State.COMPLETED)
	

        		#Chant of Magnus
			if event == "59":
				st.takeItems
				SkillTable.getInstance().getInfo(1252,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "5.htm"
				st.setState(State.COMPLETED)

 
       			#Wild Magic
			if event == "60":
				st.takeItems
				SkillTable.getInstance().getInfo(1253,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "5.htm"
				st.setState(State.COMPLETED)

			#Blesing Of Queen
			if event == "61":
				st.takeItems
				SkillTable.getInstance().getInfo(1284,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "5.htm"
				st.setState(State.COMPLETED)

			#Gift Of Queen
			if event == "62":
				st.takeItems
				SkillTable.getInstance().getInfo(1310,4).getEffects(st.getPlayer(),st.getPlayer())				
				return "5.htm"
				st.setState(State.COMPLETED)

			#Blessing Of Seraphim
			if event == "98":
				st.takeItems
				SkillTable.getInstance().getInfo(1309,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "5.htm"
				st.setState(State.COMPLETED)

			#Song of Storm Guard
			if event == "65":
				st.takeItems
				SkillTable.getInstance().getInfo(1362,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "5.htm"
				st.setState(State.COMPLETED)

			#Song of Vengeance
			if event == "66":
				st.takeItems
				SkillTable.getInstance().getInfo(1363,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "5.htm"
				st.setState(State.COMPLETED)

			#Song of Vitality
			if event == "67":
				st.takeItems
				SkillTable.getInstance().getInfo(1413,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "5.htm"
				st.setState(State.COMPLETED)

			#Song of Warding
			if event == "68":
				st.takeItems
				SkillTable.getInstance().getInfo(1323,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "1.htm"
				st.setState(State.COMPLETED)
			#Song of Water
			if event == "71":
				st.takeItems
				SkillTable.getInstance().getInfo(1388,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "7.htm"
				st.setState(State.COMPLETED)
			#Song of Wind
			if event == "72":
				st.takeItems
				SkillTable.getInstance().getInfo(1389,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "7.htm"
				st.setState(State.COMPLETED)

			
			#Greater Might
			if event == "73":
				st.takeItems
				SkillTable.getInstance().getInfo(1303,2).getEffects(st.getPlayer(),st.getPlayer())				
				return "7.htm"
				st.setState(State.COMPLETED)

			#Greater Shield
			if event == "74":
				st.takeItems
				SkillTable.getInstance().getInfo(1352,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "7.htm"
				st.setState(State.COMPLETED)

			#Chant of Victory
			if event == "75":
				st.takeItems
				SkillTable.getInstance().getInfo(1356,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "7.htm"
				st.setState(State.COMPLETED)

			#Prophecy of Fire
			if event == "76":
				st.takeItems
				SkillTable.getInstance().getInfo(1357,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "7.htm"
				st.setState(State.COMPLETED)

			#Prophecy of Water
			if event == "77":
				st.takeItems
				SkillTable.getInstance().getInfo(1355,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "7.htm"
				st.setState(State.COMPLETED)

			#Prophecy of Wind
			if event == "78":
				st.takeItems
				SkillTable.getInstance().getInfo(1191,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "7.htm"
				st.setState(State.COMPLETED)

			#Prophecy of Wind
			if event == "79":
				st.takeItems
				SkillTable.getInstance().getInfo(1033,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "7.htm"
				st.setState(State.COMPLETED)

			if event == "80":
				st.takeItems
				SkillTable.getInstance().getInfo(1182,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "7.htm"
				st.setState(State.COMPLETED)

			#Song of Vengeance
			if event == "81":
				st.takeItems
				SkillTable.getInstance().getInfo(1189,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "7.htm"
				st.setState(State.COMPLETED)

			#Song of Vitality
			if event == "82":
				st.takeItems
				SkillTable.getInstance().getInfo(1392,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "7.htm"
				st.setState(State.COMPLETED)

			#Song of Warding
			if event == "83":
				st.takeItems
				SkillTable.getInstance().getInfo(1393,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "7.htm"
				st.setState(State.COMPLETED)
			#Song of Water
			if event == "84":
				st.takeItems
				SkillTable.getInstance().getInfo(1354,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "7.htm"
				st.setState(State.COMPLETED)
			#Song of Wind
			if event == "85":
				st.takeItems
				SkillTable.getInstance().getInfo(1353,1).getEffects(st.getPlayer(),st.getPlayer())				
				return "7.htm"
				st.setState(State.COMPLETED)

			
			#Greater Might
			if event == "86":
				st.takeItems
				SkillTable.getInstance().getInfo(1032,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "7.htm"
				st.setState(State.COMPLETED)

			#Greater Shield
			if event == "87":
				st.takeItems
				SkillTable.getInstance().getInfo(1390,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "5.htm"
				st.setState(State.COMPLETED)

			#Chant of Victory
			if event == "88":
				st.takeItems
				SkillTable.getInstance().getInfo(1391,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "5.htm"
				st.setState(State.COMPLETED)

			#Blessing of Queen
			if event == "89":
				st.takeItems
				SkillTable.getInstance().getInfo(4699,13).getEffects(st.getPlayer(),st.getPlayer())				
				return "6.htm"
				st.setState(State.COMPLETED)

			#Prophecy of Water
			if event == "90":
				st.takeItems
				SkillTable.getInstance().getInfo(4700,13).getEffects(st.getPlayer(),st.getPlayer())				
				return "6.htm"
				st.setState(State.COMPLETED)

			#Blessing of Seraphim
			if event == "91":
				st.takeItems
				SkillTable.getInstance().getInfo(4702,13).getEffects(st.getPlayer(),st.getPlayer())				
				return "6.htm"
				st.setState(State.COMPLETED)

			#Prophecy of Wind
			if event == "92":
				st.takeItems
				SkillTable.getInstance().getInfo(4703,13).getEffects(st.getPlayer(),st.getPlayer())				
				return "6.htm"
				st.setState(State.COMPLETED)


                                  #Prophecy of Fire
			if event == "93":
				st.takeItems
				SkillTable.getInstance().getInfo(1304,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)

			#Prophecy of Water
			if event == "94":
				st.takeItems
				SkillTable.getInstance().getInfo(1397,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)

			#Prophecy of Wind
			if event == "95":
				st.takeItems
				SkillTable.getInstance().getInfo(1044,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)

			#Prophecy of Wind
			if event == "96":
				st.takeItems
				SkillTable.getInstance().getInfo(1087,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "2.htm"
				st.setState(State.COMPLETED)

			#Prophecy of Wind
			if event == "64":
				st.takeItems
				SkillTable.getInstance().getInfo(1308,3).getEffects(st.getPlayer(),st.getPlayer())				
				return "5.htm"
				st.setState(State.COMPLETED)


			#Cancellation
			if event == "99":
				st.takeItems
				SkillTable.getInstance().getInfo(1087,3).getEffects(st.getPlayer(),st.getPlayer())
				st.getPlayer().stopAllEffects()
				return "1.htm"
				st.setState(State.COMPLETED)
                 
			#CPHEAL
			if event == "69":
				st.takeItems(ADENA_ID,1000)
				st.getPlayer().restoreCP()
				return "1.htm"		
				st.setState(COMPLETED)

			if event == "100": 
				st.getPlayer().stopAllEffects()
				SkillTable.getInstance().getInfo(1204,2).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4344,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4346,4).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4349,2).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1243,6).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1389,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4347,6).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4348,6).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4355,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4356,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4352,2).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1303,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1087,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1397,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4351,6).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1044,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(264,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(266,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(268,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(267,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(269,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(304,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(273,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(276,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(365,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1413,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4699,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4702,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4703,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1323,1).getEffects(st.getPlayer(),st.getPlayer())
				st.getPlayer().setCurrentCp(st.getPlayer().getMaxCp())
                                st.getPlayer().setCurrentHp(st.getPlayer().getMaxHp())
                                st.getPlayer().setCurrentMp(st.getPlayer().getMaxMp())
				return "1.htm"
				st.setState(COMPLETED)

			if event == "200":
				st.getPlayer().stopAllEffects()
				SkillTable.getInstance().getInfo(4344,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4346,4).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4349,2).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1389,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4345,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4347,6).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4348,6).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4354,4).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1087,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4360,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4358,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4357,2).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4359,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1032,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4342,2).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1397,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(264,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(266,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(267,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(268,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(269,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(304,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(271,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(274,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(275,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(310,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1363,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4700,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4703,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1323,1).getEffects(st.getPlayer(),st.getPlayer())
				st.getPlayer().setCurrentCp(st.getPlayer().getMaxCp())
                                st.getPlayer().setCurrentHp(st.getPlayer().getMaxHp())
                                st.getPlayer().setCurrentMp(st.getPlayer().getMaxMp())
				return "1.htm"
				st.setState(COMPLETED)

			if event == "300": 
				st.getPlayer().stopAllEffects()
				SkillTable.getInstance().getInfo(4344,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4346,4).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4349,2).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1243,6).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1389,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4347,6).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4348,6).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4355,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4356,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4352,2).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1303,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1087,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1397,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4351,6).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1044,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(264,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(266,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(268,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(267,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(269,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(304,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(273,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(276,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(365,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1413,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4699,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4702,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4703,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1323,1).getEffects(st.getPlayer(),st.getPlayer())
				st.getPlayer().setCurrentCp(st.getPlayer().getMaxCp())
                                st.getPlayer().setCurrentHp(st.getPlayer().getMaxHp())
                                st.getPlayer().setCurrentMp(st.getPlayer().getMaxMp())
				return "1.htm"
				st.setState(COMPLETED)

			if event == "400":
				st.getPlayer().stopAllEffects()
				SkillTable.getInstance().getInfo(4344,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4346,4).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4349,2).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1389,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4345,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4347,6).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4348,6).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4352,2).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4354,4).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1087,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4360,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4358,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4357,2).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4359,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1032,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4342,2).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1397,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(264,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(266,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(267,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(268,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(269,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(304,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(271,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(274,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(275,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(310,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1363,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4700,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4703,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1323,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1388,3).getEffects(st.getPlayer(),st.getPlayer())
				st.getPlayer().setCurrentCp(st.getPlayer().getMaxCp())
                                st.getPlayer().setCurrentHp(st.getPlayer().getMaxHp())
                                st.getPlayer().setCurrentMp(st.getPlayer().getMaxMp())
				return "1.htm"
				st.setState(COMPLETED)
                        
			if event == "500":
				st.getPlayer().stopAllEffects()
				SkillTable.getInstance().getInfo(4344,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4346,4).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4349,2).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1389,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4345,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4347,6).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4352,2).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4354,4).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1087,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4360,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4358,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4357,2).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4359,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1032,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4342,2).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1397,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(264,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(266,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(267,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(268,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(269,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(304,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(271,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(274,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(275,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(310,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1363,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4700,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(4703,3).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1323,1).getEffects(st.getPlayer(),st.getPlayer())
				SkillTable.getInstance().getInfo(1389,3).getEffects(st.getPlayer(),st.getPlayer())
				st.getPlayer().setCurrentCp(st.getPlayer().getMaxCp())
                                st.getPlayer().setCurrentHp(st.getPlayer().getMaxHp())
                                st.getPlayer().setCurrentMp(st.getPlayer().getMaxMp())
				return "1.htm"
				st.setState(COMPLETED)

                        #Nobles
		if event == "122":
			SkillTable.getInstance().getInfo(1323,1).getEffects(st.getPlayer(),st.getPlayer())
			
			return "1.htm"
			st.setState(COMPLETED)


			if htmltext != event:
				st.setState(COMPLETED)
				st.exitQuest(1)
		return htmltext


	def onTalk (self,npc,player):
	   st = player.getQuestState(qn)
	   htmltext = "<html><head><body>I have nothing to say to you</body></html>"
	   st.setState(STARTED)
	   return InitialHtml

QUEST       = Quest(QuestId,str(QuestId) + "_" + QuestName,QuestDesc)
CREATED=State('Start',QUEST)
STARTED=State('Started',QUEST)
COMPLETED=State('Completed',QUEST)

QUEST.setInitialState(CREATED)

for npcId in NPC:
 QUEST.addStartNpc(npcId)
 QUEST.addTalkId(npcId)
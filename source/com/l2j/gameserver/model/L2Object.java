/*
 * This program is free software; you can redistribute it and/or modify
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
package com.l2j.gameserver.model;

import java.lang.reflect.Constructor;

import com.l2j.Config;
import com.l2j.gameserver.idfactory.IdFactory;
import com.l2j.gameserver.managers.ItemsOnGroundManager;
import com.l2j.gameserver.managers.MercTicketManager;
import com.l2j.gameserver.model.actor.instance.L2ItemInstance;
import com.l2j.gameserver.model.actor.instance.L2PcInstance;
import com.l2j.gameserver.model.actor.knownlist.ObjectKnownList;
import com.l2j.gameserver.model.actor.poly.ObjectPoly;
import com.l2j.gameserver.model.actor.position.ObjectPosition;
import com.l2j.gameserver.model.extender.BaseExtender;
import com.l2j.gameserver.model.extender.BaseExtender.EventType;
import com.l2j.gameserver.network.L2GameClient;
import com.l2j.gameserver.network.serverpackets.ActionFailed;
import com.l2j.gameserver.network.serverpackets.GetItem;

/**
 * Mother class of all objects in the world which ones is it possible to interact (PC, NPC, Item...)<BR>
 * <BR>
 * L2Object :<BR>
 * <BR>
 * <li>L2Character</li> <li>L2ItemInstance</li> <li>L2Potion</li>
 */

public abstract class L2Object
{
	// =========================================================
	// Data Field
	private boolean _isVisible; // Object visibility
	private ObjectKnownList _knownList;
	private String _name;
	private int _objectId; // Object identifier
	private ObjectPoly _poly;
	private ObjectPosition _position;

	// Objects can only see objects in same instancezone, instance 0 is normal world -1 the all seeing world
	private int _instanceId = 0;

	// =========================================================
	// Constructor
	// by Azagthtot
	private BaseExtender _extender = null;

	// =========================================================
	// Constructor

	public L2Object(int objectId)
	{
		_objectId = objectId;
		if(Config.EXTENDERS.get(this.getClass().getName()) != null)
		{
			for(String className : Config.EXTENDERS.get(this.getClass().getName()))
			{
				try
				{
					Class<?> clazz = Class.forName(className);
					if(clazz == null)
					{
						continue;
					}
					if(!BaseExtender.class.isAssignableFrom(clazz))
					{
						continue;
					}
					if(!(Boolean) clazz.getMethod("canCreateFor", L2Object.class).invoke(null, this))
					{
						continue;
					}
					Constructor<?> construct = clazz.getConstructor(L2Object.class);
					if(construct != null)
					{
						addExtender((BaseExtender) construct.newInstance(this));
					}
				}
				catch(Exception e)
				{
					continue;
				}
			}
		}
	}
	
	/**
	 * @param newExtender as BaseExtender
	 */
	public void addExtender(BaseExtender newExtender)
	{
		if(_extender == null)
		{
			_extender = newExtender;
		}
		else
		{
			_extender.addExtender(newExtender);
		}
	}

	/**
	 * @param simpleName as String<br>
	 * @return as BaseExtender - null<br>
	 */
	public BaseExtender getExtender(final String simpleName)
	{
		if(_extender == null)
			return null;
		return _extender.getExtender(simpleName);
	}

	/**
	 * 
	 * @param event as String<br>
	 * @param params
	 * @return as Object
	 */
	public Object fireEvent(final String event, Object... params)
	{
		if(_extender == null)
			return null;
		return _extender.onEvent(event, params);
	}
	public void removeExtender(BaseExtender ext) {
		if(_extender!=null)
			if(_extender==ext)
				_extender = _extender.getNextExtender();
			else 
				_extender.removeExtender(ext);
	}
	// =========================================================
	// Event - Public
	public void onAction(L2PcInstance player)
	{
		player.sendPacket(ActionFailed.STATIC_PACKET);
	}

	public void onActionShift(L2GameClient client)
	{
		// Like L2OFF send to L2PcInstance
		onActionShift(client.getActiveChar());
	}

	/**
	 * @param player 
	 */
	public void onActionShift(L2PcInstance player)
	{
		player.sendPacket(ActionFailed.STATIC_PACKET);
	}

	public void onForcedAttack(L2PcInstance player)
	{
		player.sendPacket(ActionFailed.STATIC_PACKET);
	}

	/**
	 * Do Nothing.<BR>
	 * <BR>
	 * <B><U> Overridden in </U> :</B><BR>
	 * <BR>
	 * <li>L2GuardInstance : Set the home location of its L2GuardInstance</li> <li>L2Attackable : Reset the Spoiled flag
	 * </li><BR>
	 * <BR>
	 */
	public void onSpawn()
	{
		fireEvent(EventType.SPAWN.name, (Object[]) null);
	}

	// =========================================================
	// Position - Should remove to fully move to L2ObjectPosition
	public final void setXYZ(int x, int y, int z)
	{
		getPosition().setXYZ(x, y, z);
	}

	public final void setXYZInvisible(int x, int y, int z)
	{
		getPosition().setXYZInvisible(x, y, z);
	}

	public final int getX()
	{
		if(Config.ASSERT)
		{
			assert getPosition().getWorldRegion() != null || _isVisible;
		}

		return getPosition().getX();
	}

	public final int getY()
	{
		if(Config.ASSERT)
		{
			assert getPosition().getWorldRegion() != null || _isVisible;
		}

		return getPosition().getY();
	}

	public final int getZ()
	{
		if(Config.ASSERT)
		{
			assert getPosition().getWorldRegion() != null || _isVisible;
		}

		return getPosition().getZ();
	}

	// =========================================================
	// Method - Public
	/**
	 * Remove a L2Object from the world.<BR>
	 * <BR>
	 * <B><U> Actions</U> :</B><BR>
	 * <BR>
	 * <li>Remove the L2Object from the world</li><BR>
	 * <BR>
	 * <FONT COLOR=#FF0000><B> <U>Caution</U> : This method DOESN'T REMOVE the object from _allObjects of L2World
	 * </B></FONT><BR>
	 * <FONT COLOR=#FF0000><B> <U>Caution</U> : This method DOESN'T SEND Server->Client packets to players</B></FONT><BR>
	 * <BR>
	 * <B><U> Assert </U> :</B><BR>
	 * <BR>
	 * <li>_worldRegion != null <I>(L2Object is visible at the beginning)</I></li><BR>
	 * <BR>
	 * <B><U> Example of use </U> :</B><BR>
	 * <BR>
	 * <li>Delete NPC/PC or Unsummon</li><BR>
	 * <BR>
	 */
	public final void decayMe()
	{
		if(Config.ASSERT)
		{
			assert getPosition().getWorldRegion() != null;
		}

		L2WorldRegion reg = getPosition().getWorldRegion();

		synchronized (this)
		{
			_isVisible = false;
			getPosition().setWorldRegion(null);
		}

		// this can synchronize on others instances, so it's out of
		// synchronized, to avoid deadlocks
		// Remove the L2Object from the world
		L2World.getInstance().removeVisibleObject(this, reg);
		L2World.getInstance().removeObject(this);

		if(Config.SAVE_DROPPED_ITEM)
		{
			ItemsOnGroundManager.getInstance().removeObject(this);
		}

		reg = null;
		fireEvent(EventType.DELETE.name, (Object[]) null);
	}

	/**
	 * Remove a L2ItemInstance from the world and send server->client GetItem packets.<BR>
	 * <BR>
	 * <B><U> Actions</U> :</B><BR>
	 * <BR>
	 * <li>Send a Server->Client Packet GetItem to player that pick up and its _knowPlayers member</li> <li>Remove the
	 * L2Object from the world</li><BR>
	 * <BR>
	 * <FONT COLOR=#FF0000><B> <U>Caution</U> : This method DOESN'T REMOVE the object from _allObjects of L2World
	 * </B></FONT><BR>
	 * <BR>
	 * <B><U> Assert </U> :</B><BR>
	 * <BR>
	 * <li>this instanceof L2ItemInstance</li> <li>_worldRegion != null <I>(L2Object is visible at the beginning)</I></li>
	 * <BR>
	 * <BR>
	 * <B><U> Example of use </U> :</B><BR>
	 * <BR>
	 * <li>Do Pickup Item : PCInstance and Pet</li><BR>
	 * <BR>
	 * 
	 * @param player Player that pick up the item
	 */
	public final void pickupMe(L2Character player) // NOTE: Should move this function into L2ItemInstance because it does not apply to L2Character
	{
		if(Config.ASSERT)
		{
			assert this instanceof L2ItemInstance;
		}

		if(Config.ASSERT)
		{
			assert getPosition().getWorldRegion() != null;
		}

		L2WorldRegion oldregion = getPosition().getWorldRegion();

		// Create a server->client GetItem packet to pick up the L2ItemInstance
		GetItem gi = new GetItem((L2ItemInstance) this, player.getObjectId());
		player.broadcastPacket(gi);
		gi = null;

		synchronized (this)
		{
			_isVisible = false;
			getPosition().setWorldRegion(null);
		}

		// if this item is a mercenary ticket, remove the spawns!
		if(this instanceof L2ItemInstance)
		{
			int itemId = ((L2ItemInstance) this).getItemId();
			if(MercTicketManager.getInstance().getTicketCastleId(itemId) > 0)
			{
				MercTicketManager.getInstance().removeTicket((L2ItemInstance) this);
				ItemsOnGroundManager.getInstance().removeObject(this);
			}
		}

		// this can synchronize on others instancies, so it's out of
		// synchronized, to avoid deadlocks
		// Remove the L2ItemInstance from the world
		L2World.getInstance().removeVisibleObject(this, oldregion);

		oldregion = null;
	}

	public void refreshID()
	{
		L2World.getInstance().removeObject(this);
		IdFactory.getInstance().releaseId(getObjectId());
		_objectId = IdFactory.getInstance().getNextId();
	}

	/**
	 * Init the position of a L2Object spawn and add it in the world as a visible object.<BR>
	 * <BR>
	 * <B><U> Actions</U> :</B><BR>
	 * <BR>
	 * <li>Set the x,y,z position of the L2Object spawn and update its _worldregion</li> <li>Add the L2Object spawn in
	 * the _allobjects of L2World</li> <li>Add the L2Object spawn to _visibleObjects of its L2WorldRegion</li> <li>Add
	 * the L2Object spawn in the world as a <B>visible</B> object</li><BR>
	 * <BR>
	 * <B><U> Assert </U> :</B><BR>
	 * <BR>
	 * <li>_worldRegion == null <I>(L2Object is invisible at the beginning)</I></li><BR>
	 * <BR>
	 * <B><U> Example of use </U> :</B><BR>
	 * <BR>
	 * <li>Create Door</li> <li>Spawn : Monster, Minion, CTs, Summon...</li><BR>
	 */
	public final void spawnMe()
	{
		if(Config.ASSERT)
		{
			assert getPosition().getWorldRegion() == null && getPosition().getWorldPosition().getX() != 0 && getPosition().getWorldPosition().getY() != 0 && getPosition().getWorldPosition().getZ() != 0;
		}

		synchronized (this)
		{
			// Set the x,y,z position of the L2Object spawn and update its _worldregion
			_isVisible = true;
			getPosition().setWorldRegion(L2World.getInstance().getRegion(getPosition().getWorldPosition()));

			// Add the L2Object spawn in the _allobjects of L2World
			L2World.getInstance().storeObject(this);

			// Add the L2Object spawn to _visibleObjects and if necessary to _allplayers of its L2WorldRegion
			getPosition().getWorldRegion().addVisibleObject(this);
		}

		// this can synchronize on others instances, so it's out of
		// synchronized, to avoid deadlocks
		// Add the L2Object spawn in the world as a visible object
		L2World.getInstance().addVisibleObject(this, getPosition().getWorldRegion(), null);

		onSpawn();
	}

	public final void spawnMe(int x, int y, int z)
	{
		if(Config.ASSERT)
		{
			assert getPosition().getWorldRegion() == null;
		}

		synchronized (this)
		{
			// Set the x,y,z position of the L2Object spawn and update its _worldregion
			_isVisible = true;

			if(x > L2World.MAP_MAX_X)
			{
				x = L2World.MAP_MAX_X - 5000;
			}
			if(x < L2World.MAP_MIN_X)
			{
				x = L2World.MAP_MIN_X + 5000;
			}
			if(y > L2World.MAP_MAX_Y)
			{
				y = L2World.MAP_MAX_Y - 5000;
			}
			if(y < L2World.MAP_MIN_Y)
			{
				y = L2World.MAP_MIN_Y + 5000;
			}

			getPosition().setWorldPosition(x, y, z);
			getPosition().setWorldRegion(L2World.getInstance().getRegion(getPosition().getWorldPosition()));
		}

		// these can synchronize on others instances, so they're out of
		// synchronized, to avoid deadlocks
		// Add the L2Object spawn in the _allobjects of L2World
		L2World.getInstance().storeObject(this);

		// Add the L2Object spawn to _visibleObjects and if necessary to _allplayers of its L2WorldRegion
		L2WorldRegion region = getPosition().getWorldRegion();
		if(region!=null)
			region.addVisibleObject(this);
		else{
			System.out.println("ATTENTION: no region found for location "+x+","+y+","+z+". It's not possible to spawn object "+_objectId+" here...");
			return;
		}
		// this can synchronize on others instances, so it's out of
		// synchronized, to avoid deadlocks
		// Add the L2Object spawn in the world as a visible object
		L2World.getInstance().addVisibleObject(this, region, null);

		onSpawn();
	}

	public void toggleVisible()
	{
		if(isVisible())
		{
			decayMe();
		}
		else
		{
			spawnMe();
		}
	}

	// =========================================================
	// Method - Private

	// =========================================================
	// Property - Public
	public boolean isAttackable()
	{
		return false;
	}

	public abstract boolean isAutoAttackable(L2Character attacker);

	public boolean isMarker()
	{
		return false;
	}

	/**
	 * <B><U> Concept</U> :</B><BR>
	 * <BR>
	 * A L2Object is visible if <B>__IsVisible</B>=true and <B>_worldregion</B>!=null <BR>
	 * <BR>
	 * @return the visibility state of the L2Object.
	 */
	public final boolean isVisible()
	{
		//return getPosition().getWorldRegion() != null && _IsVisible;
		return getPosition().getWorldRegion() != null;
	}

	public final void setIsVisible(boolean value)
	{
		_isVisible = value;

		if(!_isVisible)
		{
			getPosition().setWorldRegion(null);
		}
	}

	public ObjectKnownList getKnownList()
	{
		if(_knownList == null)
		{
			_knownList = new ObjectKnownList(this);
		}

		return _knownList;
	}

	public final void setKnownList(ObjectKnownList value)
	{
		_knownList = value;
	}

	public final String getName()
	{
		return _name;
	}

	public final void setName(String value)
	{
		_name = value;
	}

	public final int getObjectId()
	{
		return _objectId;
	}

	public final ObjectPoly getPoly()
	{
		if(_poly == null)
		{
			_poly = new ObjectPoly(this);
		}

		return _poly;
	}

	public final ObjectPosition getPosition()
	{
		if(_position == null)
		{
			_position = new ObjectPosition(this);
		}

		return _position;
	}

	/**
	 * @return reference to region this object is in
	 */
	public L2WorldRegion getWorldRegion()
	{
		return getPosition().getWorldRegion();
	}

	/**
	 * @return The id of the instance zone the object is in - id 0 is global since everything like dropped items, mobs,
	 *         players can be in a instantiated area, it must be in l2object
	 */
	public int getInstanceId()
	{
		return _instanceId;
	}

	/**
	 * @param instanceId The id of the instance zone the object is in - id 0 is global
	 */
	public void setInstanceId(int instanceId)
	{
		_instanceId = instanceId;

		// If we change it for visible objects, me must clear & revalidates knownlists
		if(_isVisible && _knownList != null)
		{
			if(this instanceof L2PcInstance)
			{
				// We don't want some ugly looking disappear/appear effects, so don't update
				// the knownlist here, but players usually enter instancezones through teleporting
				// and the teleport will do the revalidation for us.
			}
			else
			{
				decayMe();
				spawnMe();
			}
		}
	}
	
	public L2PcInstance getActingPlayer()
	{
		return null;
	}
	
	@Override
	public String toString()
	{
		return "" + getObjectId();
	}
}

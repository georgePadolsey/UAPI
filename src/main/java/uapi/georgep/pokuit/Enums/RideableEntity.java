package uapi.georgep.pokuit.Enums;

import org.bukkit.entity.EntityType;

public enum RideableEntity {
	
	BAT(EntityType.BAT),
	BLAZE(EntityType.BLAZE),
	BOAT(EntityType.BOAT),
	CAVE_SPIDER(EntityType.CAVE_SPIDER),
	CHICKEN(EntityType.CHICKEN),
	COW(EntityType.COW),
	CREEPER(EntityType.CREEPER),
	ENDER_CRYSTAL(EntityType.ENDER_CRYSTAL),
	ENDER_DRAGON(EntityType.ENDER_DRAGON),
	ENDERMAN(EntityType.ENDERMAN),
	EXPERIENCE_ORB(EntityType.EXPERIENCE_ORB),
	GHAST(EntityType.GHAST),
	//HORSE(EntityType.HORSE),
	IRON_GOLEM(EntityType.IRON_GOLEM),
	MAGMA_CUBE(EntityType.MAGMA_CUBE),
	MINECART(EntityType.MINECART),
	MINECART_CHEST(EntityType.MINECART_CHEST),
	MINECAT_FURNACE(EntityType.MINECART_FURNACE),
	MINECART_HOPPER(EntityType.MINECART_HOPPER),
	MINECART_MOB_SPAWNER(EntityType.MINECART_MOB_SPAWNER),
	MINECART_TNT(EntityType.MINECART_TNT),
	MUSHROOM_COW(EntityType.MUSHROOM_COW),
	OCELOT(EntityType.OCELOT),
	PIG(EntityType.PIG),
	PIG_ZOMBIE(EntityType.PIG_ZOMBIE),
	SHEEP(EntityType.SHEEP),
	SILVERFISH(EntityType.SILVERFISH),
	SKELETON(EntityType.SKELETON),
	SLIME(EntityType.SLIME),
	SNOWMAN(EntityType.SNOWMAN),
	SPIDER(EntityType.SPIDER),
	SQUID(EntityType.SQUID),
	VILLAGER(EntityType.VILLAGER),
	WITCH(EntityType.WITCH),
	WITHER(EntityType.WITHER),
	WOLF(EntityType.WOLF),
	ZOMBIE(EntityType.ZOMBIE);
	
	EntityType e;
	
	RideableEntity(EntityType e) {
		this.e = e;
	}
	
	public EntityType getEntityType() {
		return e;
	}
}

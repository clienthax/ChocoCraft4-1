package net.chococraft.registry;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
	public static final FoodProperties GYSAHL_GREEN = (new FoodProperties.Builder()).nutrition(1).saturationModifier(1F).build();
	public static final FoodProperties CHOCOBO_DRUMSTICK_RAW = (new FoodProperties.Builder()).nutrition(2).saturationModifier(1F).build();
	public static final FoodProperties CHOCOBO_DRUMSTICK_COOKED = (new FoodProperties.Builder()).nutrition(4).saturationModifier(1F).build();
	public static final FoodProperties PICKLED_GYSAHL_RAW = (new FoodProperties.Builder()).nutrition(1).saturationModifier(1F).build();
	public static final FoodProperties PICKLED_GYSAHL_COOKED = (new FoodProperties.Builder()).nutrition(3).saturationModifier(1F).build();
}

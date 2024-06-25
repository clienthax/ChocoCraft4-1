package net.chococraft.common.items.armor;

import net.chococraft.registry.ModRegistry;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterial {

	public static final Holder<ArmorMaterial> CHOCO_DISGUISE = register(
			"choco_disguise",
			Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 3);
				map.put(ArmorItem.Type.LEGGINGS, 7);
				map.put(ArmorItem.Type.CHESTPLATE, 6);
				map.put(ArmorItem.Type.HELMET, 3);
				map.put(ArmorItem.Type.BODY, 0);
			}),
			10,
			SoundEvents.ARMOR_EQUIP_LEATHER,
			0.0F,
			0.0F,
			() -> Ingredient.of(ModRegistry.CHOCOBO_FEATHER.get())
	);

	private static Holder<ArmorMaterial> register(String string, EnumMap<ArmorItem.Type, Integer> enumMap, int i, Holder<SoundEvent> arg, float f, float g, Supplier<Ingredient> supplier) {
		List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(ResourceLocation.withDefaultNamespace(string)));
		return register(string, enumMap, i, arg, f, g, supplier, list);
	}

	private static Holder<ArmorMaterial> register(String string, EnumMap<ArmorItem.Type, Integer> enumMap, int i, Holder<SoundEvent> arg, float f, float g, Supplier<Ingredient> supplier, List<ArmorMaterial.Layer> list) {
		EnumMap<ArmorItem.Type, Integer> enumMap2 = new EnumMap(ArmorItem.Type.class);
		ArmorItem.Type[] var9 = ArmorItem.Type.values();
		int var10 = var9.length;

		for (int var11 = 0; var11 < var10; ++var11) {
			ArmorItem.Type type = var9[var11];
			enumMap2.put(type, (Integer) enumMap.get(type));
		}

		return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, ResourceLocation.withDefaultNamespace(string), new ArmorMaterial(enumMap2, i, arg, supplier, list, f, g));
	}
}

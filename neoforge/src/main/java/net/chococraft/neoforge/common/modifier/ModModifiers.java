package net.chococraft.neoforge.common.modifier;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.chococraft.Chococraft;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModModifiers {
	public static final DeferredRegister<MapCodec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS = DeferredRegister.create(
			NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Chococraft.MOD_ID);

	public static final Supplier<MapCodec<AddChocoboModifier>> ADD_CHOCOBO = BIOME_MODIFIER_SERIALIZERS.register("add_chocobo", () ->
			RecordCodecBuilder.mapCodec((builder) ->
					builder.group(Biome.LIST_CODEC.fieldOf("biomes").forGetter(AddChocoboModifier::biomes))
							.apply(builder, AddChocoboModifier::new)));
}

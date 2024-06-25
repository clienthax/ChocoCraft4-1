package net.chococraft.neoforge.registry;

import net.chococraft.Chococraft;
import net.chococraft.common.entity.properties.ChocoboColor;
import net.chococraft.common.entity.properties.MovementType;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModDataSerializers {
	public static final DeferredRegister<EntityDataSerializer<?>> ENTITY_DATA_SERIALIZER = DeferredRegister.create(NeoForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS, Chococraft.MOD_ID);

	public final static Supplier<EntityDataSerializer<ChocoboColor>> CHOCOBO_COLOR = ENTITY_DATA_SERIALIZER.register("chocobo_color", () -> EntityDataSerializer.forValueType(ChocoboColor.STREAM_CODEC));
	public final static Supplier<EntityDataSerializer<MovementType>> MOVEMENT_TYPE = ENTITY_DATA_SERIALIZER.register("movement_type", () -> EntityDataSerializer.forValueType(MovementType.STREAM_CODEC));
}

package net.chococraft.fabric.registry;

import net.chococraft.common.entity.properties.ChocoboColor;
import net.chococraft.common.entity.properties.MovementType;
import net.minecraft.network.syncher.EntityDataSerializer;

public class ModDataSerializers {
	public final static EntityDataSerializer<ChocoboColor> CHOCOBO_COLOR = EntityDataSerializer.forValueType(ChocoboColor.STREAM_CODEC);
	public final static EntityDataSerializer<MovementType> MOVEMENT_TYPE = EntityDataSerializer.forValueType(MovementType.STREAM_CODEC);
}

package net.chococraft.common.entity.properties;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;

import java.util.Locale;
import java.util.function.IntFunction;

public enum MovementType implements StringRepresentable {
	WANDER(0), FOLLOW_OWNER(1), STANDSTILL(2);

	public static final StringRepresentable.EnumCodec<MovementType> CODEC = StringRepresentable.fromEnum(MovementType::values);
	private static final IntFunction<MovementType> BY_ID = ByIdMap.continuous(MovementType::getId, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
	public static final StreamCodec<ByteBuf, MovementType> STREAM_CODEC = ByteBufCodecs.idMapper(BY_ID, MovementType::getId);
	private final int id;

	MovementType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public String getSerializedName() {
		return this.name().toLowerCase(Locale.ROOT);
	}
}

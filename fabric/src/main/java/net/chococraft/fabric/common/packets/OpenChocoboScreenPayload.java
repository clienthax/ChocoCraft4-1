package net.chococraft.fabric.common.packets;

import net.chococraft.fabric.ChococraftFabric;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record OpenChocoboScreenPayload(int entityId, int containerId) implements CustomPacketPayload {
	public static final StreamCodec<FriendlyByteBuf, OpenChocoboScreenPayload> CODEC = CustomPacketPayload.codec(
			OpenChocoboScreenPayload::write,
			OpenChocoboScreenPayload::new);
	public static final Type<OpenChocoboScreenPayload> ID = new Type<>(ChococraftFabric.OPEN_CHOCOBO_SCREEN);

	public OpenChocoboScreenPayload(final FriendlyByteBuf packetBuffer) {
		this(packetBuffer.readInt(), packetBuffer.readInt());
	}

	public void write(FriendlyByteBuf buf) {
		buf.writeInt(entityId);
		buf.writeInt(containerId);
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return ID;
	}
}

package net.chococraft.fabric.common.items;

import net.chococraft.common.items.armor.AbstractChocoDisguiseItem;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class FabricChocoDisguiseItem extends AbstractChocoDisguiseItem {
	public FabricChocoDisguiseItem(Holder<ArmorMaterial> material, ArmorItem.Type type, Properties properties) {
		super(material, type, properties);
	}
}

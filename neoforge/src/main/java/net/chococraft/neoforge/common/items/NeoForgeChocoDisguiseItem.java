package net.chococraft.neoforge.common.items;

import net.chococraft.Chococraft;
import net.chococraft.ChococraftClient;
import net.chococraft.client.models.armor.ChocoDisguiseModel;
import net.chococraft.common.items.armor.AbstractChocoDisguiseItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class NeoForgeChocoDisguiseItem extends AbstractChocoDisguiseItem {
	private final LazyLoadedValue<HumanoidModel<?>> model;

	public NeoForgeChocoDisguiseItem(Holder<ArmorMaterial> material, ArmorItem.Type type, Properties properties) {
		super(material, type, properties);
		if(FMLEnvironment.dist.isClient()) {
			this.model = new LazyLoadedValue<>(() -> this.provideArmorModelForSlot(this.type));
		} else {
			this.model = new LazyLoadedValue<>(() -> null);
		}
	}

	@Override
	@Nullable
	public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
		return ResourceLocation.fromNamespaceAndPath(Chococraft.MOD_ID, "textures/models/armor/chocodisguise.png");
	}

	@OnlyIn(Dist.CLIENT)
	public HumanoidModel<?> provideArmorModelForSlot(ArmorItem.Type type) {
		return new ChocoDisguiseModel(Minecraft.getInstance().getEntityModels().bakeLayer(ChococraftClient.CHOCO_DISGUISE), type);
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {

			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
				return model.get();
			}
		});
	}
}

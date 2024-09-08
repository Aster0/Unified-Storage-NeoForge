package me.astero.unifiedstorage.items;

import me.astero.unifiedstorage.utils.ModUtils;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public abstract class UnifiedBaseItem extends Item {

    protected List<Component> shiftLoreList;
    public UnifiedBaseItem() {
        super(new Item.Properties());
    }


    public abstract List<Component> addShiftText();

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> components, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, components, tooltipFlag);

        List<Component> shiftTextList = addShiftText();

        if(shiftTextList != null) {

            if(Screen.hasShiftDown()) {

                components.addAll(shiftTextList);
                return;
            }

            components.addAll(ModUtils.breakComponentLine(Component.translatable("lore.unifiedstorage.default")));

        }

    }
}

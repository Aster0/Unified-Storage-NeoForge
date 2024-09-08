package me.astero.unifiedstorage.items.upgrade_cards;

import me.astero.unifiedstorage.items.UnifiedBaseItem;
import me.astero.unifiedstorage.utils.ModUtils;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class BlankUpgradeItem extends UnifiedBaseItem {



    @Override
    public List<Component> addShiftText() {
        return ModUtils.
                breakComponentLine(Component.translatable("lore.unifiedstorage.blank_upgrade_card"));
    }
}

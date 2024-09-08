package me.astero.unifiedstorage.setup;

import me.astero.unifiedstorage.items.upgrade_cards.BlankUpgradeItem;
import me.astero.unifiedstorage.items.upgrade_cards.SpeedUpgradeItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

import static me.astero.unifiedstorage.UnifiedStorage.MODID;

public class ModRegistration {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static void init(IEventBus modEventBus) {
        ITEMS.register(modEventBus);


        CreativeTabRegistration.init(modEventBus);
    }


    public static final DeferredItem<Item> BLANK_UPGRADE_CARD = registerItem(ITEMS.register(
            "blank_upgrade_card", BlankUpgradeItem::new), true);

    public static final DeferredItem<Item> SPEED_UPGRADE_CARD = registerItem(ITEMS.register(
            "speed_upgrade_card", SpeedUpgradeItem::new), true);



    public static List<UnifiedDeferredItem<DeferredHolder>> deferredItemList;

    private static DeferredItem<Item> registerItem(DeferredItem<Item> deferredItem, boolean inCreativeTab) {

        if(deferredItemList == null) {
            deferredItemList = new ArrayList<>();
        }

        deferredItemList.add(new UnifiedDeferredItem<>(deferredItem, inCreativeTab));
        return deferredItem;
    }

}

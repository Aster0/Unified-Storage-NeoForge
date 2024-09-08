package me.astero.unifiedstorage.setup;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static me.astero.unifiedstorage.UnifiedStorage.MODID;

public class CreativeTabRegistration {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TABS.register("unified_storage_tab", () -> CreativeModeTab.builder()
            .title(Component.literal("Unified Storage"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModRegistration.BLANK_UPGRADE_CARD.get().getDefaultInstance())
            .displayItems((parameters, output) -> {

                for(UnifiedDeferredItem item : ModRegistration.deferredItemList) {
                    if(item.inCreativeTab) {
                        output.accept((Item) item.type.get());
                    }
                }
                output.accept(ModRegistration.BLANK_UPGRADE_CARD.get());

            }).build());

    public static void init(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);

    }
}

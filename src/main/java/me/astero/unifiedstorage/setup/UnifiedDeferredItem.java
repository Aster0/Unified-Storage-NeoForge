package me.astero.unifiedstorage.setup;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

public class UnifiedDeferredItem<T extends DeferredHolder> {


    public T type;
    public boolean inCreativeTab;

    public UnifiedDeferredItem(T type, boolean inCreativeTab) {
        this.type = type;
        this.inCreativeTab = inCreativeTab;

    }
}

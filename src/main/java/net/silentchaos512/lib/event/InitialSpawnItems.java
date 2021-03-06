/*
 * Silent Lib -- InitialSpawnItems
 * Copyright (C) 2018 SilentChaos512
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 3
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.silentchaos512.lib.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.silentchaos512.lib.SilentLib;
import net.silentchaos512.lib.util.PlayerHelper;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Can be used to give players items when they first join a world. Call {@link
 * #add(ResourceLocation, Supplier)} in either init or post-init. <em>This should be used
 * sparingly</em>; we spawn with enough junk already. It is recommended to have config options to
 * disable spawn items.
 *
 * @author SilentChaos512
 * @since 3.0.3
 */
@Mod.EventBusSubscriber(modid = SilentLib.MOD_ID)
@ParametersAreNonnullByDefault
public final class InitialSpawnItems {
    private static final Map<ResourceLocation, Supplier<ItemStack>> SPAWN_ITEMS = new HashMap<>();
    private static final String NBT_KEY = SilentLib.MOD_ID + ".SpawnItemsGiven";

    private InitialSpawnItems() {}

    /**
     * Add a spawn item. If the supplier returns an empty stack ({@link ItemStack#EMPTY}), nothing
     * is given. If the item is given, the player will never receive a spawn item with the same
     * {@code key} again. If no item is given, the key will not be marked as given.
     *
     * @param key   The key to uniquely identify the spawn item
     * @param stack The {@link ItemStack} supplier. If it returns an empty stack, nothing is given.
     */
    public static void add(ResourceLocation key, Supplier<ItemStack> stack) {
        SPAWN_ITEMS.put(key, stack);
    }

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        EntityPlayer player = event.player;
        NBTTagCompound givenItems = PlayerHelper.getPersistedDataSubcompound(player, NBT_KEY);

        SPAWN_ITEMS.forEach((key, supplier) -> {
            String nbtKey = key.toString().replaceFirst(":", ".");
            if (!givenItems.getBoolean(nbtKey)) {
                ItemStack stack = supplier.get();
                if (!stack.isEmpty()) {
                    SilentLib.LOGGER.debug("Giving player {} spawn item \"{}\" = {}",
                            player.getName(), nbtKey, stack);
                    PlayerHelper.giveItem(player, stack);
                    givenItems.setBoolean(nbtKey, true);
                }
            }
        });
    }
}

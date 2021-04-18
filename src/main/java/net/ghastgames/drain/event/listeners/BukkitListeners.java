package net.ghastgames.drain.event.listeners;

import net.ghastgames.drain.command.BukkitCommandRegistry;
import net.ghastgames.drain.command.DrainCommand;
import net.ghastgames.drain.event.BukkitEventHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockExpEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockMultiPlaceEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.block.NotePlayEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreeperPowerEvent;
import org.bukkit.event.entity.EntityBreakDoorEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import org.bukkit.event.entity.EntityCombustByEntityEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityCreatePortalEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.EntityPortalEnterEvent;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.entity.EntityPortalExitEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.EntityTameEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.entity.EntityUnleashEvent;
import org.bukkit.event.entity.ExpBottleEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.entity.FireworkExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.HorseJumpEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.PigZapEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.entity.SheepDyeWoolEvent;
import org.bukkit.event.entity.SheepRegrowWoolEvent;
import org.bukkit.event.entity.SlimeSplitEvent;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.painting.PaintingBreakByEntityEvent;
import org.bukkit.event.painting.PaintingBreakEvent;
import org.bukkit.event.painting.PaintingPlaceEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.event.server.RemoteServerCommandEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.server.ServiceRegisterEvent;
import org.bukkit.event.server.ServiceUnregisterEvent;
import org.bukkit.event.vehicle.VehicleBlockCollisionEvent;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.event.vehicle.VehicleUpdateEvent;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.event.world.SpawnChangeEvent;
import org.bukkit.event.world.StructureGrowEvent;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.event.world.WorldUnloadEvent;
import org.spigotmc.event.entity.EntityDismountEvent;
import org.spigotmc.event.entity.EntityMountEvent;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

import java.util.function.Predicate;

public class BukkitListeners implements Listener {

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent(null, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onBlockBurnEvent(BlockBurnEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onBlockCanBuildEvent(BlockCanBuildEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onBlockDamageEvent(BlockDamageEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent(null, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onBlockDispenseEvent(BlockDispenseEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onBlockExpEvent(BlockExpEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onBlockExplodeEvent(BlockExplodeEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onBlockFadeEvent(BlockFadeEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onBlockFormEvent(BlockFormEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onBlockFromToEvent(BlockFromToEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onBlockGrowEvent(BlockGrowEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onBlockIgniteEvent(BlockIgniteEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent(null, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onBlockMultiPlaceEvent(BlockMultiPlaceEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent(null, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onBlockPhysicsEvent(BlockPhysicsEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onBlockPistonExtendEvent(BlockPistonExtendEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onBlockPistonRetractEvent(BlockPistonRetractEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent(null, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onBlockRedstoneEvent(BlockRedstoneEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onBlockSpreadEvent(BlockSpreadEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onEntityBlockFormEvent(EntityBlockFormEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(null, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onLeavesDecayEvent(LeavesDecayEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onNotePlayEvent(NotePlayEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onSignChangeEvent(SignChangeEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent(null, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onEnchantItemEvent(EnchantItemEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onPrepareItemEnchantEvent(PrepareItemEnchantEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onCreatureSpawnEvent(CreatureSpawnEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onCreeperPowerEvent(CreeperPowerEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntityBreakDoorEvent(EntityBreakDoorEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntityChangeBlockEvent(EntityChangeBlockEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntityCombustByBlockEvent(EntityCombustByBlockEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntityCombustByEntityEvent(EntityCombustByEntityEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntityCombustEvent(EntityCombustEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntityCreatePortalEvent(EntityCreatePortalEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntityDamageByBlockEvent(EntityDamageByBlockEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntityDeathEvent(EntityDeathEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), null);
    }


    @EventHandler
    public void onEntityExplodeEvent(EntityExplodeEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntityInteractEvent(EntityInteractEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntityPortalEnterEvent(EntityPortalEnterEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), null);
    }


    @EventHandler
    public void onEntityPortalEvent(EntityPortalEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntityPortalExitEvent(EntityPortalExitEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntityRegainHealthEvent(EntityRegainHealthEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntityShootBowEvent(EntityShootBowEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntitySpawnEvent(EntitySpawnEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntityTameEvent(EntityTameEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntityTargetEvent(EntityTargetEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntityTargetLivingEntityEvent(EntityTargetLivingEntityEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntityTeleportEvent(EntityTeleportEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onEntityUnleashEvent(EntityUnleashEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), null);
    }


    @EventHandler
    public void onExpBottleEvent(ExpBottleEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), null);
    }


    @EventHandler
    public void onExplosionPrimeEvent(ExplosionPrimeEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onFireworkExplodeEvent(FireworkExplodeEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onFoodLevelChangeEvent(FoodLevelChangeEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onHorseJumpEvent(HorseJumpEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onItemDespawnEvent(ItemDespawnEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onItemMergeEvent(ItemMergeEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onItemSpawnEvent(ItemSpawnEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onPigZapEvent(PigZapEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), null);
    }


    @EventHandler
    public void onPlayerLeashEntityEvent(PlayerLeashEntityEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent(null, event.getClass(), event.getPlayer(), event);
        BukkitEventHandler.handleEntityEvent(null, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onPotionSplashEvent(PotionSplashEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onProjectileHitEvent(ProjectileHitEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), null);
    }


    @EventHandler
    public void onProjectileLaunchEvent(ProjectileLaunchEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onSheepDyeWoolEvent(SheepDyeWoolEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onSheepRegrowWoolEvent(SheepRegrowWoolEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onSlimeSplitEvent(SlimeSplitEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onSpawnerSpawnEvent(SpawnerSpawnEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onHangingBreakByEntityEvent(HangingBreakByEntityEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(null, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onHangingBreakEvent(HangingBreakEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(null, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onHangingPlaceEvent(HangingPlaceEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent(null, event.getClass(), event.getPlayer(), event);
        BukkitEventHandler.handleEntityEvent(null, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onBrewEvent(BrewEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onCraftItemEvent(CraftItemEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onFurnaceBurnEvent(FurnaceBurnEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onFurnaceExtractEvent(FurnaceExtractEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handlePlayerBukkitEvent(null, event.getClass(), event.getPlayer(), null);
    }


    @EventHandler
    public void onFurnaceSmeltEvent(FurnaceSmeltEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onInventoryCloseEvent(InventoryCloseEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handlePlayerBukkitEvent(null, event.getClass(), (Player) event.getPlayer(), ((event instanceof Cancellable ? (Cancellable) event : null)));
    }


    @EventHandler
    public void onInventoryCreativeEvent(InventoryCreativeEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onInventoryDragEvent(InventoryDragEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onInventoryEvent(InventoryEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onInventoryMoveItemEvent(InventoryMoveItemEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onInventoryOpenEvent(InventoryOpenEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent(null, event.getClass(), (Player) event.getPlayer(), event);
    }


    @EventHandler
    public void onInventoryPickupItemEvent(InventoryPickupItemEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onPrepareItemCraftEvent(PrepareItemCraftEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onPaintingBreakByEntityEvent(PaintingBreakByEntityEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onPaintingBreakEvent(PaintingBreakEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }

    @EventHandler
    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onAsyncPlayerPreLoginEvent(AsyncPlayerPreLoginEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onPlayerAchievementAwardedEvent(PlayerAchievementAwardedEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerAnimationEvent(PlayerAnimationEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerArmorStandManipulateEvent(PlayerArmorStandManipulateEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerBedEnterEvent(PlayerBedEnterEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerBedLeaveEvent(PlayerBedLeaveEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), (event instanceof Cancellable ? (Cancellable) event : null));
    }


    @EventHandler
    public void onPlayerBucketEmptyEvent(PlayerBucketEmptyEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerBucketFillEvent(PlayerBucketFillEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerChangedWorldEvent(PlayerChangedWorldEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), (event instanceof Cancellable ? (Cancellable) event : null));
    }


    @EventHandler
    public void onPlayerChatEvent(PlayerChatEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerChatTabCompleteEvent(PlayerChatTabCompleteEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), (event instanceof Cancellable ? (Cancellable) event : null));
    }


    @EventHandler
    public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);

        for(DrainCommand command : BukkitCommandRegistry.getCommands()) {
            if(command.getCommand().equalsIgnoreCase((event.getMessage().contains(" ") ? event.getMessage().substring(1, event.getMessage().indexOf(" ")) : event.getMessage().replace("/", "")))) {
                if(!command.getPermission().isEmpty()) {
                    if (!event.getPlayer().hasPermission(command.getPermission())) {
                        event.getPlayer().sendMessage(command.getPermissionErrorMessage());
                        event.setCancelled(true);
                    }
                }
                if(!command.getStaticResponse().isEmpty()) {
                    String[] messages = command.getStaticResponse()
                            .replace("%player%", event.getPlayer().getName())
                            .replace("%player_displayname%", event.getPlayer().getDisplayName())
                            .split("\n");
                    for(String message : messages) {
                        event.getPlayer().sendMessage(message);
                    }
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerDropItemEvent(PlayerDropItemEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerEditBookEvent(PlayerEditBookEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerEggThrowEvent(PlayerEggThrowEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), (event instanceof Cancellable ? (Cancellable) event : null));
    }


    @EventHandler
    public void onPlayerExpChangeEvent(PlayerExpChangeEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), (event instanceof Cancellable ? (Cancellable) event : null));
    }


    @EventHandler
    public void onPlayerFishEvent(PlayerFishEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerGameModeChangeEvent(PlayerGameModeChangeEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerInteractAtEntityEvent(PlayerInteractAtEntityEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerInventoryEvent(PlayerInventoryEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), (event instanceof Cancellable ? (Cancellable) event : null));
    }


    @EventHandler
    public void onPlayerItemBreakEvent(PlayerItemBreakEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), (event instanceof Cancellable ? (Cancellable) event : null));
    }


    @EventHandler
    public void onPlayerItemConsumeEvent(PlayerItemConsumeEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerItemDamageEvent(PlayerItemDamageEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerItemHeldEvent(PlayerItemHeldEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), null);
    }


    @EventHandler
    public void onPlayerKickEvent(PlayerKickEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerLevelChangeEvent(PlayerLevelChangeEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), null);
    }


    @EventHandler
    public void onPlayerLoginEvent(PlayerLoginEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), null);
    }


    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerPickupItemEvent(PlayerPickupItemEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerPortalEvent(PlayerPortalEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerPreLoginEvent(PlayerPreLoginEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), null);
    }


    @EventHandler
    public void onPlayerRegisterChannelEvent(PlayerRegisterChannelEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), null);
    }


    @EventHandler
    public void onPlayerResourcePackStatusEvent(PlayerResourcePackStatusEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), null);
    }


    @EventHandler
    public void onPlayerRespawnEvent(PlayerRespawnEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), null);
    }


    @EventHandler
    public void onPlayerShearEntityEvent(PlayerShearEntityEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
        BukkitEventHandler.handleEntityEvent(null, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onPlayerStatisticIncrementEvent(PlayerStatisticIncrementEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerTeleportEvent(PlayerTeleportEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerToggleFlightEvent(PlayerToggleFlightEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerToggleSprintEvent(PlayerToggleSprintEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onPlayerUnleashEntityEvent(PlayerUnleashEntityEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent(null, event.getClass(), event.getPlayer(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onPlayerUnregisterChannelEvent(PlayerUnregisterChannelEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), null);
    }


    @EventHandler
    public void onPlayerVelocityEvent(PlayerVelocityEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onMapInitializeEvent(MapInitializeEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onPluginDisableEvent(PluginDisableEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onPluginEnableEvent(PluginEnableEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onRemoteServerCommandEvent(RemoteServerCommandEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onServerCommandEvent(ServerCommandEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onServerListPingEvent(ServerListPingEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onServiceRegisterEvent(ServiceRegisterEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onServiceUnregisterEvent(ServiceUnregisterEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onVehicleBlockCollisionEvent(VehicleBlockCollisionEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onVehicleCreateEvent(VehicleCreateEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onVehicleDamageEvent(VehicleDamageEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onVehicleDestroyEvent(VehicleDestroyEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onVehicleEnterEvent(VehicleEnterEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onVehicleEntityCollisionEvent(VehicleEntityCollisionEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(null, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onVehicleExitEvent(VehicleExitEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onVehicleMoveEvent(VehicleMoveEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onVehicleUpdateEvent(VehicleUpdateEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onLightningStrikeEvent(LightningStrikeEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onThunderChangeEvent(ThunderChangeEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onWeatherChangeEvent(WeatherChangeEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onChunkLoadEvent(ChunkLoadEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onChunkPopulateEvent(ChunkPopulateEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onChunkUnloadEvent(ChunkUnloadEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onPortalCreateEvent(PortalCreateEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onSpawnChangeEvent(SpawnChangeEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onStructureGrowEvent(StructureGrowEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handlePlayerBukkitEvent(null, event.getClass(), event.getPlayer(), event);
    }


    @EventHandler
    public void onWorldInitEvent(WorldInitEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onWorldLoadEvent(WorldLoadEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onWorldSaveEvent(WorldSaveEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
    }


    @EventHandler
    public void onWorldUnloadEvent(WorldUnloadEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
    }


    @EventHandler
    public void onEntityDismountEvent(EntityDismountEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), null);
    }


    @EventHandler
    public void onEntityMountEvent(EntityMountEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), event);
        BukkitEventHandler.handleEntityEvent(event, event.getClass(), event.getEntity(), event);
    }


    @EventHandler
    public void onPlayerSpawnLocationEvent(PlayerSpawnLocationEvent event) {
        BukkitEventHandler.handleBukkitEvent(event.getClass());
        if(event instanceof Cancellable) {
            BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);
        }
        BukkitEventHandler.handlePlayerBukkitEvent((PlayerEvent) event, event.getClass(), event.getPlayer(), null);
    }
}

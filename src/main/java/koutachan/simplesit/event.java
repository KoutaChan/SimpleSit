package koutachan.simplesit;

import org.bukkit.Material;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.spigotmc.event.entity.EntityDismountEvent;

public class event implements Listener{

    @EventHandler
    public void PlayerInteractEvent(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getPlayer().getVehicle() == null) {
            Material StairsCheck = e.getClickedBlock().getType();
            if (StairsCheck.equals(Material.OAK_STAIRS) || StairsCheck.equals(Material.SPRUCE_STAIRS) || StairsCheck.equals(Material.BIRCH_STAIRS) || StairsCheck.equals(Material.JUNGLE_STAIRS) || StairsCheck.equals(Material.ACACIA_STAIRS) || StairsCheck.equals(Material.DARK_OAK_STAIRS) || StairsCheck.equals(Material.CRIMSON_STAIRS) || StairsCheck.equals(Material.WARPED_STAIRS) || StairsCheck.equals(Material.STONE_STAIRS) || StairsCheck.equals(Material.COBBLESTONE_STAIRS) || StairsCheck.equals(Material.MOSSY_COBBLESTONE_STAIRS) || StairsCheck.equals(Material.STONE_BRICK_STAIRS) || StairsCheck.equals(Material.MOSSY_STONE_BRICK_STAIRS) || StairsCheck.equals(Material.ANDESITE_STAIRS) || StairsCheck.equals(Material.POLISHED_ANDESITE_STAIRS) || StairsCheck.equals(Material.DIORITE_STAIRS) || StairsCheck.equals(Material.POLISHED_DIORITE_STAIRS) || StairsCheck.equals(Material.GRANITE_STAIRS) || StairsCheck.equals(Material.POLISHED_GRANITE_STAIRS) || StairsCheck.equals(Material.SANDSTONE_STAIRS) || StairsCheck.equals(Material.SMOOTH_SANDSTONE_STAIRS) || StairsCheck.equals(Material.RED_SANDSTONE_STAIRS) || StairsCheck.equals(Material.SMOOTH_RED_SANDSTONE_STAIRS) || StairsCheck.equals(Material.BRICK_STAIRS) || StairsCheck.equals(Material.PRISMARINE_STAIRS) || StairsCheck.equals(Material.PRISMARINE_BRICK_STAIRS) || StairsCheck.equals(Material.DARK_PRISMARINE_STAIRS) || StairsCheck.equals(Material.NETHER_BRICK_STAIRS) || StairsCheck.equals(Material.RED_NETHER_BRICK_STAIRS) || StairsCheck.equals(Material.QUARTZ_STAIRS) || StairsCheck.equals(Material.SMOOTH_QUARTZ_STAIRS) || StairsCheck.equals(Material.PURPUR_STAIRS) || StairsCheck.equals(Material.END_STONE_BRICK_STAIRS) || StairsCheck.equals(Material.BLACKSTONE_STAIRS) || StairsCheck.equals(Material.POLISHED_BLACKSTONE_STAIRS) || StairsCheck.equals(Material.POLISHED_BLACKSTONE_BRICK_STAIRS)) {
                if(((Stairs) e.getClickedBlock().getBlockData()).getHalf() == Bisected.Half.BOTTOM) {
                    Arrow arrow = e.getClickedBlock().getWorld().spawn(e.getClickedBlock().getLocation().add(0.5, 0.0, 0.5), Arrow.class);
                    arrow.setGravity(false);
                    arrow.addPassenger(e.getPlayer());
                }
            }
        }
    }

    @EventHandler
    public void EntityDismountEvent(EntityDismountEvent e) {
        if (e.getEntity() instanceof Player && e.getDismounted() instanceof Arrow) {
            e.getDismounted().remove();
        }
    }
}
package koutachan.simplesit;

import org.bukkit.GameMode;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import org.bukkit.event.block.Action;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.spigotmc.event.entity.EntityDismountEvent;


public class event implements Listener {

    @EventHandler
    public void PlayerInteractEvent(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getPlayer().getVehicle() == null && e.getPlayer().getGameMode() != GameMode.SPECTATOR && !e.getPlayer().isSneaking()) {
            if (e.getClickedBlock().toString().contains("STAIRS") && (((Stairs) e.getClickedBlock().getBlockData()).getHalf() == Bisected.Half.BOTTOM)) {
                float yaw = 0.0F;
                switch (((Stairs) e.getClickedBlock().getBlockData()).getFacing()) {
                    case WEST:
                        yaw = -90F;
                        break;
                    case SOUTH:
                        yaw = 180F;
                        break;
                    case EAST:
                        yaw = 90F;
                        break;
                }
                Location location = new Location(e.getClickedBlock().getWorld(),e.getClickedBlock().getX() + 0.5,e.getClickedBlock().getY() - 1.0, e.getClickedBlock().getZ() + 0.5, yaw,0F);
                ArmorStand armorstand = (ArmorStand) e.getClickedBlock().getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
                armorstand.setGravity(false);
                armorstand.setVisible(false);
                armorstand.setMarker(false);
                armorstand.addPassenger(e.getPlayer());
            }
        }
    }

    @EventHandler
    public void EntityDismountEvent(EntityDismountEvent e) {
        if (e.getEntity() instanceof Player && e.getDismounted() instanceof ArmorStand) {
            e.getDismounted().remove();
        }
    }
}
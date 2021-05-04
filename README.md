![Drain - The Minecraft Plugin Library](https://i.imgur.com/x8Ks6aN.png)

## What is Drain?
Drain is a library for **Spigot and Bukkit** plugins that helps you to develop your plugins faster and easier.
It includes many functionalities to make your development life easier. Head over to the [wiki](https://github.com/GhastGames/Drain/wiki) section for a tutorial!

SpigotMC: https://www.spigotmc.org/resources/drain.91445

## Example: A /heal command

Without Drain:

```java
public class HealCommand implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("command.heal")) {
                player.setHealth(20);
                return true;
            } else {
                player.sendMessage("§cYou are not allowed to do this!");
                return false;
            }
        } else {
            commandSender.sendMessage("§cThis command is player-only!");
            return false;
        }
    }
}
```

With Drain:

```java
new DynamicCommandBuilder("heal", this)
        .setPlayerOnly(true)
        .setPermission("command.heal")
        .setPermissionErrorMessage("§cYou are not allowed to do this!")
        .setExecutor(data -> ((Player) data.getSender()).setHealth(20))
        .build();
```

Also available on Spigot

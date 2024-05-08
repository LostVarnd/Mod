package net.lostvarnd.testmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EightBallItem extends Item {
    public EightBallItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            outputRandomNumber(player);
            player.getCooldowns().addCooldown(this, 20);
        }

        return super.use(level, player, hand);
    }

    private void outputRandomNumber(Player player) {
        int number = getRandomNumber();
        if (number == 0) {
            player.sendSystemMessage(Component.literal("Your pp is smol."));
        }
        else if (number == 1) {
            player.sendSystemMessage(Component.literal("Your pp is average."));
        }
        else if (number == 2) {
            player.sendSystemMessage(Component.literal("Your pp is big."));
        }
        else {
            player.sendSystemMessage(Component.literal("Your pp is godlike size."));
        }
    }

    private int getRandomNumber() {
        return RandomSource.createNewThreadLocalInstance().nextInt(4);
    }
}

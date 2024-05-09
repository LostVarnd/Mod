package net.lostvarnd.testmod.item.custom;

import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CigaretteItem extends Item {
    public CigaretteItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            effectGiver(player);
        }

        return super.use(level, player, hand);
    }

    private void effectGiver(Player player) {
        int number = randomNumber();
        if (number == 0) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20 * 120, 2));
        }
        else if (number == 1) {
            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 20 * 60));
        }
    }

    private int randomNumber() {
        return RandomSource.createNewThreadLocalInstance().nextInt(2);
    }
}

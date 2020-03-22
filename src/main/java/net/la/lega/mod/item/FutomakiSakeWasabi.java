package net.la.lega.mod.item;

import net.la.lega.mod.loader.LLoader;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

public class FutomakiSakeWasabi extends Item
{
    public static final Identifier ID = new Identifier(LLoader.MOD_ID, "futomaki_sake_wasabi");
    
    public static final StatusEffect effect = StatusEffects.SPEED;
    public static final int effectDuration = 20 * 14;
    public static final float effectChance = 0.385F;
    public static final float saturation = 3.55F;
    public static final int hunger = 8;
    
    public FutomakiSakeWasabi()
    {
        super(new Item.Settings().group(ItemGroup.FOOD)
              .food(new FoodComponent.Builder()
                    .hunger(hunger)
                    .saturationModifier(saturation)
                    .statusEffect(new StatusEffectInstance(effect, effectDuration), effectChance)
                    .alwaysEdible()
                    .build())
        );
    }
}

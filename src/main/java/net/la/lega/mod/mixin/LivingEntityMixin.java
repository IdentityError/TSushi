package net.la.lega.mod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.la.lega.mod.block.LauncherBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity
{
    public LivingEntityMixin(EntityType<?> type, World world) 
    {
        super(type, world);
    }

    @Inject(at = @At("HEAD"), method = "jump", cancellable = true)
    private void jump(CallbackInfo info)
    {  
        BlockPos pos = new BlockPos(getX(), getY() - 1, getZ());
        if(world.getBlockState(pos).getBlock() instanceof LauncherBlock)
        {
            LauncherBlock launcherBlock = (LauncherBlock) world.getBlockState(pos).getBlock();         
            LivingEntity instance = (LivingEntity) (Object) this;
            launcherBlock.launchLivingEntity(world, pos, instance);
            info.cancel();
        }
    }
}
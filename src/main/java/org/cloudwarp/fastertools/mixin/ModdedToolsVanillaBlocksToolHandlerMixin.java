package org.cloudwarp.fastertools.mixin;

import net.fabricmc.fabric.api.tool.attribute.v1.DynamicAttributeTool;
import net.fabricmc.fabric.impl.tool.attribute.handlers.ModdedToolsVanillaBlocksToolHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.tag.Tag;
import net.minecraft.util.TypedActionResult;
import org.cloudwarp.fastertools.FasterTools;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ModdedToolsVanillaBlocksToolHandler.class)
public class ModdedToolsVanillaBlocksToolHandlerMixin {

    @Inject(method = "getMiningSpeedMultiplier", at = @At("RETURN"), cancellable = true)
    private void getMiningSpeedMultiplier(CallbackInfoReturnable<TypedActionResult<Float>> cir) {
        if(cir.getReturnValue() == null){
            return;
        }
        cir.setReturnValue(TypedActionResult.pass(cir.getReturnValue().getValue() * (FasterTools.toolSpeedModifier/ 100f)));
    }
}
package nl.theepicblock.notflying.mixin;

import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerPlayNetworkHandler.class)
public class DisableRubberbanding {
    @Redirect(method = "onPlayerMove", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/network/ServerPlayerEntity;isInTeleportationState()Z"))
    private boolean relaxPlayerMovementByMakingItSeemLikeTheyAreTeleporting(ServerPlayerEntity playerEntity) {
        return true;
    }
}

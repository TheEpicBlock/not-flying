package nl.theepicblock.notflying.mixin;

import net.minecraft.server.network.ServerPlayNetworkHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayNetworkHandler.class)
public class DisableFlyCheck {
    @Shadow private boolean floating;

    @Shadow private int floatingTicks;

    @Shadow private boolean vehicleFloating;

    @Inject(method = "tick", at = @At("HEAD"))
    private void setNotFlying(CallbackInfo ci) {
        this.floating = false;
        this.vehicleFloating = false;
        this.floatingTicks = 0;
    }
}

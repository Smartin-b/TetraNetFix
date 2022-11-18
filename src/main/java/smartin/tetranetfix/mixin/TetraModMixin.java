package smartin.tetranetfix.mixin;


import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import se.mickelus.mutil.network.PacketHandler;
import se.mickelus.tetra.TetraMod;
import se.mickelus.tetra.blocks.forged.container.ChangeCompartmentPacket;
import se.mickelus.tetra.blocks.forged.extractor.CoreExtractorPistonUpdatePacket;
import se.mickelus.tetra.blocks.workbench.WorkbenchPacketCraft;
import se.mickelus.tetra.blocks.workbench.WorkbenchPacketTweak;
import se.mickelus.tetra.blocks.workbench.WorkbenchPacketUpdate;
import se.mickelus.tetra.blocks.workbench.action.WorkbenchActionPacket;
import se.mickelus.tetra.data.UpdateDataPacket;
import se.mickelus.tetra.effect.LungeEchoPacket;
import se.mickelus.tetra.effect.TruesweepPacket;
import se.mickelus.tetra.effect.howling.HowlingPacket;
import se.mickelus.tetra.effect.revenge.AddRevengePacket;
import se.mickelus.tetra.effect.revenge.RemoveRevengePacket;
import se.mickelus.tetra.items.modular.ChargedAbilityPacket;
import se.mickelus.tetra.items.modular.SecondaryAbilityPacket;
import se.mickelus.tetra.items.modular.impl.bow.ProjectileMotionPacket;
import se.mickelus.tetra.items.modular.impl.toolbelt.EquipToolbeltItemPacket;
import se.mickelus.tetra.items.modular.impl.toolbelt.OpenToolbeltItemPacket;
import se.mickelus.tetra.items.modular.impl.toolbelt.booster.UpdateBoosterPacket;
import se.mickelus.tetra.items.modular.impl.toolbelt.suspend.ToggleSuspendPacket;
import se.mickelus.tetra.module.improvement.HonePacket;
import se.mickelus.tetra.module.improvement.SettlePacket;
import smartin.tetranetfix.TetraNetFix;

@Mixin({TetraMod.class})
public class TetraModMixin {

    //@Shadow public static PacketHandler packetHandler;

    @Inject(
            at = @At(value = "TAIL"),
            method = "Lse/mickelus/tetra/TetraMod;<init>()V",
            remap = true,
            require = 1
    )
    private void test(CallbackInfo ci){
        PacketHandler packetHandler = TetraMod.packetHandler;
        packetHandler.registerPacket(HonePacket.class, HonePacket::new);
        packetHandler.registerPacket(SettlePacket.class, SettlePacket::new);
        packetHandler.registerPacket(UpdateDataPacket.class, UpdateDataPacket::new);
        packetHandler.registerPacket(SecondaryAbilityPacket.class, SecondaryAbilityPacket::new);
        packetHandler.registerPacket(ChargedAbilityPacket.class, ChargedAbilityPacket::new);
        packetHandler.registerPacket(TruesweepPacket.class, TruesweepPacket::new);
        packetHandler.registerPacket(HowlingPacket.class, HowlingPacket::new);
        packetHandler.registerPacket(ProjectileMotionPacket.class, ProjectileMotionPacket::new);
        packetHandler.registerPacket(AddRevengePacket.class, AddRevengePacket::new);
        packetHandler.registerPacket(RemoveRevengePacket.class, RemoveRevengePacket::new);
        packetHandler.registerPacket(LungeEchoPacket.class, LungeEchoPacket::new);
        packetHandler.registerPacket(ChangeCompartmentPacket.class, ChangeCompartmentPacket::new);
        packetHandler.registerPacket(CoreExtractorPistonUpdatePacket.class, CoreExtractorPistonUpdatePacket::new);
        packetHandler.registerPacket(WorkbenchPacketUpdate.class, WorkbenchPacketUpdate::new);
        packetHandler.registerPacket(WorkbenchPacketCraft.class, WorkbenchPacketCraft::new);
        packetHandler.registerPacket(WorkbenchActionPacket.class, WorkbenchActionPacket::new);
        packetHandler.registerPacket(WorkbenchPacketTweak.class, WorkbenchPacketTweak::new);
        packetHandler.registerPacket(EquipToolbeltItemPacket.class, EquipToolbeltItemPacket::new);
        packetHandler.registerPacket(OpenToolbeltItemPacket.class, OpenToolbeltItemPacket::new);
        packetHandler.registerPacket(UpdateBoosterPacket.class, UpdateBoosterPacket::new);
        packetHandler.registerPacket(ToggleSuspendPacket.class, ToggleSuspendPacket::new);
    }
}

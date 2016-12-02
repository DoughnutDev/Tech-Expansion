package abused_master.TechExpansion.gui.generators;

import abused_master.TechExpansion.Info;
import abused_master.TechExpansion.tileentities.container.generators.CoalGenContainer;
import abused_master.TechExpansion.tileentities.container.machine.PulverizerContainer;
import abused_master.TechExpansion.tileentities.generators.TileCoalGen;
import abused_master.TechExpansion.tileentities.machine.TilePulverizer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.config.GuiUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammad on 12/1/2016.
 */
public class GuiCoalGen extends GuiContainer {

    private static final ResourceLocation CoalGen = new ResourceLocation(Info.MODID, "textures/gui/coalgen_gui.png");
    public static final int WIDTH = 176;
    public static final int HEIGHT = 166;
    TileCoalGen coalgen;

    public GuiCoalGen(TileCoalGen tileEntity, CoalGenContainer container, TileEntity te) {
        super(container);
        xSize = WIDTH;
        ySize = HEIGHT;
        coalgen = (TileCoalGen) tileEntity;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(CoalGen);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);


        /**
         * Bcs why not? #Determination, Deal with it
         */
        if (coalgen.storage.getEnergyStored() > 0 && coalgen.storage.getEnergyStored() <= 1250) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 43, 11, 1);
        } else if (coalgen.storage.getEnergyStored() > 1250 && coalgen.storage.getEnergyStored() <= 1250 * 2) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 42, 11, 2);
        } else if (coalgen.storage.getEnergyStored() > 1250 * 2 && coalgen.storage.getEnergyStored() <= 1250 * 3) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 41, 11, 3);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 3 && coalgen.storage.getEnergyStored() <= 1250 * 4) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 40, 11, 4);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 4 && coalgen.storage.getEnergyStored() <= 1250 * 5) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 39, 11, 5);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 5 && coalgen.storage.getEnergyStored() <= 1250 * 6) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 38, 11, 6);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 6 && coalgen.storage.getEnergyStored() <= 1250 * 7) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 37, 11, 7);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 7 && coalgen.storage.getEnergyStored() <= 1250 * 8) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 36, 11, 8);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 8 && coalgen.storage.getEnergyStored() <= 1250 * 9) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 35, 11, 9);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 9 && coalgen.storage.getEnergyStored() <= 1250 * 10) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 34, 11, 10);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 10 && coalgen.storage.getEnergyStored() <= 1250 * 11) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 33, 11, 11);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 11 && coalgen.storage.getEnergyStored() <= 1250 * 12) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 32, 11, 11);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 12 && coalgen.storage.getEnergyStored() <= 1250 * 13) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 31, 11, 13);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 13 && coalgen.storage.getEnergyStored() <= 1250 * 14) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 30, 11, 14);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 14 && coalgen.storage.getEnergyStored() <= 1250 * 15) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 29, 11, 15);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 15 && coalgen.storage.getEnergyStored() <= 1250 * 16) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 28, 11, 16);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 16 && coalgen.storage.getEnergyStored() <= 1250 * 17) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 27, 11, 17);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 17 && coalgen.storage.getEnergyStored() <= 1250 * 18) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 26, 11, 18);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 18 && coalgen.storage.getEnergyStored() <= 1250 * 19) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 25, 11, 19);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 19 && coalgen.storage.getEnergyStored() <= 1250 * 20) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 24, 11, 20);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 20 && coalgen.storage.getEnergyStored() <= 1250 * 21) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 23, 11, 21);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 21 && coalgen.storage.getEnergyStored() <= 1250 * 22) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 22, 11, 22);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 22 && coalgen.storage.getEnergyStored() <= 1250 * 23) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 21, 11, 23);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 23 && coalgen.storage.getEnergyStored() <= 1250 * 24) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 20, 11, 24);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 24 && coalgen.storage.getEnergyStored() <= 1250 * 25) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 19, 11, 25);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 25 && coalgen.storage.getEnergyStored() <= 1250 * 26) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 18, 11, 26);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 26 && coalgen.storage.getEnergyStored() <= 1250 * 27) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 17, 11, 27);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 27 && coalgen.storage.getEnergyStored() <= 1250 * 28) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 16, 11, 28);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 28 && coalgen.storage.getEnergyStored() <= 1250 * 29) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 15, 11, 29);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 29 && coalgen.storage.getEnergyStored() <= 1250 * 30) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 14, 11, 30);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 30 && coalgen.storage.getEnergyStored() <= 1250 * 31) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 13, 11, 31);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 31 && coalgen.storage.getEnergyStored() <= 1250 * 32) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 11, 11, 32);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 32 && coalgen.storage.getEnergyStored() <= 1250 * 33) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 11, 11, 33);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 33 && coalgen.storage.getEnergyStored() <= 1250 * 34) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 10, 11, 34);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 34 && coalgen.storage.getEnergyStored() <= 1250 * 35) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 9, 11, 35);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 35 && coalgen.storage.getEnergyStored() <= 1250 * 36) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 8, 11, 36);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 36 && coalgen.storage.getEnergyStored() <= 1250 * 37) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 7, 11, 37);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 37 && coalgen.storage.getEnergyStored() <= 1250 * 38) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 6, 11, 38);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 38 && coalgen.storage.getEnergyStored() <= 1250 * 39) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 5, 11, 39);

        } else if (coalgen.storage.getEnergyStored() > 1250 * 39 && coalgen.storage.getEnergyStored() <= 1250 * 40) {
            drawTexturedModalRect(guiLeft + 56, guiTop + 9, 178, 4, 11, 40);
        }


        if (this.isPointInRegion(56, 9, 14, 42, mouseX, mouseY)) {
            List<String> rf = new ArrayList<String>();
            rf.add(coalgen.storage.getEnergyStored() + "/100,000 RF");
            GuiUtils.drawHoveringText(rf, mouseX, mouseY, 25, 120, -10, mc.fontRendererObj);
        }
    }

}

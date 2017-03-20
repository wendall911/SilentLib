package net.silentchaos512.lib;

import java.util.Map;

import com.google.common.collect.Maps;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.silentchaos512.lib.debug.DataDump;
import net.silentchaos512.lib.util.LocalizationHelper;
import net.silentchaos512.lib.util.LogHelper;

@Mod(modid = SilentLib.MOD_ID, name = SilentLib.MOD_NAME, version = SilentLib.VERSION, dependencies = SilentLib.DEPENDENCIES)
public class SilentLib {

  public static final String MOD_ID = "silentlib";
  public static final String MOD_NAME = "Silent Lib";
  public static final String DEPENDENCIES = "required-after:Forge@[12.18.2.2125,);";
  public static final String VERSION = "SL_VERSION";

  public static LogHelper logHelper = new LogHelper(MOD_NAME);

  @Instance(MOD_ID)
  public static SilentLib instance;

  private final Map<String, LocalizationHelper> locHelpers = Maps.newHashMap();

  public LocalizationHelper getLocalizationHelperForMod(String modId) {

    return locHelpers.get(modId.toLowerCase());
  }

  public void registerLocalizationHelperForMod(String modId, LocalizationHelper loc) {

    locHelpers.put(modId.toLowerCase(), loc);
  }

  @EventHandler
  public void postInit(FMLPostInitializationEvent event) {

    DataDump.dumpEnchantments();
    DataDump.dumpPotionEffects();
  }

  public static int getMCVersion() {

    return 10;
  }
}

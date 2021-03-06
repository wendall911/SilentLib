# Changelog

Changelog format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

Silent Lib's changelog is not updated very frequently and most changes are not important for end-users.
Only recent changes use the new format, the old format has been left alone for previous versions.

## [3.0.12] - 2019-02-05
Backports some changes to Color class from 1.13, which allows for more intelligent parsing of color codes.

## [3.0.11] - 2019-02-03
Just pushing an update to make sure code is synced up with another source. You can continue to use 3.0.9 or 3.0.10 without issues.

## [3.0.10] - 2018-12-18
### Changed
- Removed Patreon button from guide book
- Possibly improve some logging (ClientTicks overflow)

## [3.0.9] - 2018-11-15
### Added
- Wildcard support for match lists (entity and item lists in configs). Wildcard character is '*' and may only be used at the end of the entered value (for now). Example: `modid:*` or `modid:something_*`
### Fixed
- Default min value on float and double configs were wrong, should allow negative values in all cases now
- Silent Gear tool/armor crashes when on a Tinkers Construct table. See [Silent's Gems #348](https://github.com/SilentChaos512/SilentGems/issues/348)

## [3.0.8] - 2018-10-31
### Added
- Drop-down GUI element (usable, but needs some work)

## [3.0.7] - 2018-10-27
### Added
- Instances of recipes being registered the "old way" (without JSON) are counted and logged.
For Silent's Gems users: Yes, I am aware of the 160+ recipes it counts (the mod contains a total of
about 1300 recipes, most are now JSON but some are... problematic right now).
### Fixed
- Ore dictionary lookup optimizations

## Old log (original format) starts here:

3.0.4
Added: HudAnchor

3.0.3
Added: InitialSpawnItems

3.0.2
Documented recipe serializers
Added: ItemLootContainer, an item that gives player items from a loot table when used
Fixed: IColoredBlock not registering item color handler

3.0.1
Fixed: Guide book crash (Silent's Gems #328)

3.0.0
Removes many deprecated components, breaking compatibility with older versions
Added: IRecipeSerializer to support creation of recipe JSONs for custom recipe factories

2.3.17
Added: I18nHelper option to replaces colons with dots (enabled by default)
Added: SRegistry setModel methods
Added: Greetings class (takes message suppliers to display on login)

2.3.14
Added: I18nHelper translatedName methods

2.3.13
Updated I18nHelper with additional methods
Updated ChatHelper with additional methods and javadoc
Fixed: Some issues with BlockMetaSubtypes

2.3.2
Added: StackHelper.getOreNames
Fixed: Color codes with alpha not loading properly

2.3.0
Mostly tweaks/additions for Borderblocks
Added: Dev-only keybindings to switch gamemodes. These are not registered in distributed builds.
Added: ConfigOptionOreGen (more-or-less direct copy from Silent's Gems)
Added: Advancement trigger registration method

2.2.16
Added: ConfigMultiValueLineParser

2.2.15
Added: zh_CN.lang (Snownee)

2.2.14
Added: Blending functions to the Color class.

2.2.11
Added: RecipeBaseSL#getNonEmptyStacks

2.2.9
Added: EntityHelper#heal method, which can bypass cancelable healing events.
Added: GuideBook#showPatreonButton field. Defaults to false for all mods but Silent's Gems.

2.2.8
Added: Patreon button to guide book main page.
Changed: LogHelper now takes a build number and will not output debug lines if it is not zero. Should fix "log spam" issues that pop up from time-to-time.
Fixed: Potion registration handler now works (currently, none of my mods use this).

2.2.7
Fixed: Food subitems not working properly.

2.2.6
Added: ModelHelperSL, which helps to fix the OBJ model issues in Silent's Gems.

2.2.5
Updated to be compatible with 1.10.2 and 1.11.2.
Some rendering compatibility additions. Minor bugfixes.

2.2.4
Updated for Forge 2387.
Fixed: Recipes being double registered, causing a crash in latest Forge when opening recipe book. (Silent's Gems #170)
Fixed: Hide custom recipe types in the recipe book (gets rid of the recipes for "air")

2.2.3
Forge 2373
Fixed: Model loading crash
Fixed: Models for most metadata items not loading
Fixed: Items displaying in all creative tabs

2.2.2
Forge 2365

2.2.1
Added: Smelting recipe adders to RecipeMaker (kind of unnecessary right now, but...)
Added: TileEntitySpecialRendererSL
Fixed: addInformation handlers of Item classes
Fixed: Shaped/shapeless ore recipe adders being reversed

2.2.0
Initial 1.12 update! Expect things to break as Forge updates.
Added: RecipeMaker. Handles creation of recipes.
Added: WorldGeneratorSL (ideal is to allow retrogen, but that doesn't work yet).
Changed: IRegistryObject#addRecipes now takes a parameter: the mod's RecipeMaker instance.
Removed: The deprecated RecipeBase class.
Removed: RecipeHelper (methods merged into RecipeMaker).

2.1.4
Added: Safe method for spawning entities from other threads (EntityHelper#safeSpawn)
Added: Left-click (empty/block) handlers for items. These can capture left-clicks on the client and send a packet to the server for processing.

2.1.3
Added: EntityHelper#getEntityNameList to fix a Silent's Gems issue.
Fixed: The "quote guy" not being cleared properly (guide book main page)

2.1.2
Fixed: Buggy enchantments causing a crash (Good ol' PvP's silliness, for example)

2.1.1
Added: Implemented config/achievement buttons in guide book.
Added: Implemented quotes in guide book.
Fixed: [1.10.2] Missing localizations caused by the resources folder having the wrong structure.

2.1.0
Added: A guide book system. It is heavily inspired by (and partially copied from) Actually Additions. Any mod should be able to easily(?) create a decent guide book with this.
Note on the guide book system: This was introduced because Silent's Gems was using Guide-API, which does not work across Minecraft versions. An alternative solution might have been to add a Guide-API adaptor system into Lib, but this is probably for the best.

2.0.6
Added: Minecraft version getter
Added: SyncVariable interface. Allows tile entities to sync data with less code.
Changed: Improved CreativeTabSL, making it less likely to self-destruct in 1.10.2.

2.0.5
Added: KeyTrackerSL, a base class for key trackers
Added: WorldHelper (needed for a Gems bugfix)

2.0.4
Added: ItemHelper (needed for a Gems bugfix)

2.0.3
Fixed: Custom recipes not consuming ingredients.
Fixed: Some containers not dropping their inventories (eg Gems' material grader)

2.0.2
Added: BiomeHelper (fix for a Fun Ores issue in 1.10.2)

2.0.1
~

2.0.0-37
Fixes the armor constructor.

2.0.0-36
First XCompat build

1.2.0
Added: An adaptive config system inspired by Botania's. Still needs a bit of work, but functions for some values.
Fixed: Forge blockstate JSONs not loading properly. This may prevent some models from existing mods from loading properly. It also creates a bit of log spam on load about missing models that I haven't figured out, but that doesn't hurt anything.

1.1.0
Fixed an issue with entity renderer registration.
Modified SRegistry to use generics for block/item registry.
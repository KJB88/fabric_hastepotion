package net.kjb88.potion;


import net.kjb88.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.kjb88.HastePotion.MOD_ID;

public class hastePotion {
    public static Potion HASTE_POTION;
    public static Potion LONG_HASTE_POTION;
    public static Potion STRONG_HASTE_POTION;

    // Register the standard Haste Potion
    public static Potion registerHastePotion(String name){
        return Registry.register(
                Registries.POTION,
                new Identifier(MOD_ID, name),
                new Potion(new StatusEffectInstance(
                        StatusEffects.HASTE, 3600, 0)));
    }
    // Register the Long Haste Potion
    public static Potion registerLongHastePotion(String name){
        return Registry.register(
                Registries.POTION,
                new Identifier(MOD_ID, name),
                new Potion(new StatusEffectInstance(
                        StatusEffects.HASTE, 9600, 0)));
    }
    // Register the Strong Haste Potion
    public static Potion registerStrongHastePotion(String name){
        return Registry.register(
                Registries.POTION,
                new Identifier(MOD_ID, name),
                new Potion(new StatusEffectInstance(
                        StatusEffects.HASTE, 3600, 2)));
    }

    public static void registerPotions()
    {
        HASTE_POTION = registerHastePotion("haste_potion");
        LONG_HASTE_POTION = registerLongHastePotion("long_haste_potion");
        STRONG_HASTE_POTION = registerStrongHastePotion("strong_haste_potion");
        registerPotionRecipes();
    }

    private static void registerPotionRecipes()
    {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.GOLDEN_APPLE, hastePotion.HASTE_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(hastePotion.HASTE_POTION, Items.REDSTONE, hastePotion.LONG_HASTE_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(hastePotion.HASTE_POTION, Items.GLOWSTONE_DUST, hastePotion.STRONG_HASTE_POTION);
    }
}

package com.github.klyser.astralhorizons;

import com.github.klyser.astralhorizons.registry.AHItems;

public class AstralHorizons
{
	public static final String MOD_ID = "astralhorizons";

	public static void init() {
		AHItems.register();
	}
}

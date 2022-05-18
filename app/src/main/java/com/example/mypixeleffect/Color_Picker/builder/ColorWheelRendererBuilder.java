package com.example.mypixeleffect.Color_Picker.builder;


import com.example.mypixeleffect.Color_Picker.ColorPickerView;
import com.example.mypixeleffect.Color_Picker.renderer.ColorWheelRenderer;
import com.example.mypixeleffect.Color_Picker.renderer.FlowerColorWheelRenderer;
import com.example.mypixeleffect.Color_Picker.renderer.SimpleColorWheelRenderer;

public class ColorWheelRendererBuilder {
	public static ColorWheelRenderer getRenderer(ColorPickerView.WHEEL_TYPE wheelType) {
		switch (wheelType) {
			case CIRCLE:
				return new SimpleColorWheelRenderer();
			case FLOWER:
				return new FlowerColorWheelRenderer();
		}
		throw new IllegalArgumentException("wrong WHEEL_TYPE");
	}
}
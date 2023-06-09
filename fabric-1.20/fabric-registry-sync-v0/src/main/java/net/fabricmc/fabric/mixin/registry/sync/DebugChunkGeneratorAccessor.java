/*
 * Copyright (c) 2016, 2017, 2018, 2019 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fabricmc.fabric.mixin.registry.sync;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.chunk.DebugChunkGenerator;

@Mixin(DebugChunkGenerator.class)
public interface DebugChunkGeneratorAccessor {
	@Accessor
	@Mutable
	static void setBLOCK_STATES(List<BlockState> blockStates) {
		throw new UnsupportedOperationException();
	}

	@Accessor
	@Mutable
	static void setX_SIDE_LENGTH(int length) {
		throw new UnsupportedOperationException();
	}

	@Accessor
	@Mutable
	static void setZ_SIDE_LENGTH(int length) {
		throw new UnsupportedOperationException();
	}
}

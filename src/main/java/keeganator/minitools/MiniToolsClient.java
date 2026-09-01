package keeganator.minitools;

import keeganator.minitools.entity.ModEntities;
import keeganator.minitools.entity.client.RockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class MiniToolsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.ROCK_ENTITY, RockEntityRenderer::new);

    }
}

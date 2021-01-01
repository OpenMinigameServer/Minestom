package net.minestom.server.chat;

import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.jetbrains.annotations.NotNull;

public class AdventureMessage extends JsonMessage.RawJsonMessage {
    public AdventureMessage(@NotNull ComponentLike component) {
        super(GsonComponentSerializer.gson().serializer().toJsonTree(component.asComponent()).getAsJsonObject());
    }
}

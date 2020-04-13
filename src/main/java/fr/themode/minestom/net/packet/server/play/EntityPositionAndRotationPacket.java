package fr.themode.minestom.net.packet.server.play;

import fr.themode.minestom.net.packet.PacketWriter;
import fr.themode.minestom.net.packet.server.ServerPacket;
import fr.themode.minestom.net.packet.server.ServerPacketIdentifier;

public class EntityPositionAndRotationPacket implements ServerPacket {

    public int entityId;
    public short deltaX, deltaY, deltaZ;
    public float yaw, pitch;
    public boolean onGround;

    @Override
    public void write(PacketWriter writer) {
        writer.writeVarInt(entityId);
        writer.writeShort(deltaX);
        writer.writeShort(deltaY);
        writer.writeShort(deltaZ);
        writer.writeByte((byte) (yaw * 256 / 360));
        writer.writeByte((byte) (pitch * 256 / 360));
        writer.writeBoolean(onGround);
    }


    @Override
    public int getId() {
        return ServerPacketIdentifier.ENTITY_POSITION_AND_ROTATION;
    }
}
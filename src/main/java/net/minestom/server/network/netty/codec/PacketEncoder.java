package net.minestom.server.network.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.utils.PacketUtils;
import us.myles.ViaVersion.api.data.UserConnection;
import us.myles.ViaVersion.exception.CancelEncoderException;

public class PacketEncoder extends MessageToByteEncoder<ServerPacket> {

    private final UserConnection info;

    public PacketEncoder(UserConnection info) {
        this.info = info;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, ServerPacket packet, ByteBuf outBuf) throws Exception {
        if (!info.shouldTransformPacket()) {
            PacketUtils.writePacket(outBuf, packet);
            return;
        }
        PacketUtils.writePacket(outBuf, packet);
        info.transformOutgoing(outBuf, CancelEncoderException::generate);
    }

}

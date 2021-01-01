package net.minestom.server.network.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import net.minestom.server.network.netty.packet.InboundPacket;
import net.minestom.server.utils.Utils;
import us.myles.ViaVersion.api.data.UserConnection;
import us.myles.ViaVersion.exception.CancelDecoderException;

import java.util.List;

public class PacketDecoder extends ByteToMessageDecoder {

    private final UserConnection info;

    public PacketDecoder(UserConnection info) {
        this.info = info;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> list) throws Exception {
        ByteBuf buf1 = ctx.alloc().buffer().writeBytes(buf);
        if (info.shouldTransformPacket()) {
            info.transformIncoming(buf1, CancelDecoderException::generate);
        }

        if (buf1.readableBytes() > 0) {
            final int packetId = Utils.readVarInt(buf1);
            list.add(new InboundPacket(packetId, buf1.retain()));
        }
    }
}

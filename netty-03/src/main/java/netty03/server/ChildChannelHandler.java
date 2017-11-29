package netty03.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;


public class ChildChannelHandler extends ChannelInitializer<SocketChannel>{
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new TImeServerHandler());
    }
}

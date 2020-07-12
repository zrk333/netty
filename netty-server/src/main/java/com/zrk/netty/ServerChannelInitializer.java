package com.zrk.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;


/**
 * @Description: netty服务初始化器
 * @Author: zrk
 * @Date: 2020/7/12
 */
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //添加编码、解码
        socketChannel.pipeline().addLast("decoder",new StringDecoder(CharsetUtil.UTF_8));
        socketChannel.pipeline().addLast("encoder",new StringEncoder(CharsetUtil.UTF_8));
        socketChannel.pipeline().addLast(new NettyServerHandler());
    }
}

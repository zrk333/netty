package com.zrk.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: netty服务端处理器
 * @Author: zrk
 * @Date: 2020/7/12
 */
@Slf4j
public class NettyServerHandler extends ChannelInboundHandlerAdapter{

    /**
     * 客户端连接触发
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        log.info("客户端连接...");
    }

    /**
     * 客户端发消息触发
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        log.info("服务器收到消息: {}", msg.toString());
        ctx.write("消息已收到");
        ctx.flush();
    }

    /**
     * 发生异常触发
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error(cause.getMessage(),cause);
        ctx.close();
    }
}

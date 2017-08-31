package org.sprintdragon.opensource.netty.reactordemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by wangdi on 17-8-24.
 */
public class ReactorDemo1 {

    /**
     * 单线程模型
     */
    public void singleThread() {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        ServerBootstrap b = new ServerBootstrap();
        /**
         * 注意, 我们实例化了一个 NioEventLoopGroup,
         * 构造器参数是1, 表示 NioEventLoopGroup 的线程池大小是1. 然
         * 后接着我们调用 b.group(bossGroup) 设置了服务器端的 EventLoopGroup.
         * 有些朋友可能会有疑惑: 我记得在启动服务器端的 Netty 程序时,
         * 是需要设置 bossGroup 和 workerGroup 的, 为什么这里就只有一个 bossGroup?
         其实很简单, ServerBootstrap 重写了 group 方法:
         */
        b.group(bossGroup).channel(NioServerSocketChannel.class);
        /**
         * 因此当传入一个 group 时, 那么 bossGroup 和 workerGroup 就是同一个 NioEventLoopGroup 了.
         这时候呢, 因为 bossGroup 和 workerGroup 就是同一个 NioEventLoopGroup,
         并且这个 NioEventLoopGroup 只有一个线程, 这样就会导致 Netty 中的 acceptor
         和后续的所有客户端连接的 IO 操作都是在一个线程中处理的. 那么对应到 Reactor 的线程模型中,
         我们这样设置 NioEventLoopGroup 时, 就相当于 Reactor 单线程模型.
         */
    }

    /**
     * 多线程模型
     */
    public void singleMutiThread() {
        /**
         * bossGroup 中只有一个线程, 而 workerGroup 中的线程是 CPU 核心数乘以2,
         * 因此对应的到 Reactor 线程模型中, 我们知道, 这样设置的 NioEventLoopGroup
         * 其实就是 Reactor 多线程模型.
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class);
    }

    /**
     * 主从多线程模型
     */
    public void masterSlave() {
        /**
         * bossGroup 线程池中的线程数我们设置为4, 而 workerGroup 中的线程是 CPU 核心数乘以2,
         * 因此对应的到 Reactor 线程模型中, 我们知道, 这样设置的 NioEventLoopGroup
         * 其实就是 Reactor 主从多线程模型.
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup(4);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class);
        /**
         * 根据 @labmem 的提示, Netty 的服务器端的 acceptor 阶段, 没有使用到多线程, 因此上面的
         * 主从多线程模型 在 Netty 的服务器端是不存在的.
         服务器端的 ServerSocketChannel 只绑定到了 bossGroup 中的一个线程,
         因此在调用 Java NIO 的 Selector.select 处理客户端的连接请求时, 实际上是在一个线程中的,
         所以对只有一个服务的应用来说, bossGroup 设置多个线程是没有什么作用的, 反而还会造成资源浪费.
         */
    }

}

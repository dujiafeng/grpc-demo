package cn.feng.news;

import cn.feng.news.service.NewsService;
import cn.feng.news.service.SmsService;
import io.grpc.ServerBuilder;

/**
 * @author feng
 * @date 2023/3/28 22:23
 * @email:dujiafeng@gyyx.com
 * @description:
 */
public class GrpcServer {
    //自定义一个占用端口
    private static final int port = 9999;

    public static void main(String[] args){
        try {
            io.grpc.Server server = ServerBuilder.forPort(port)
                    .addService(new NewsService())
                    .addService(new SmsService()).build().start();
            System.out.println("gRPC服务端启动，端口号为"+port);
            server.awaitTermination();
        }catch (Exception e){
            System.out.println("服务端异常");
        }
    }
}

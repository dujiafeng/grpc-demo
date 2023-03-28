package cn.feng.news.service;

import cn.feng.news.proto.NewsServiceGrpc;
import cn.feng.news.proto.NewsProto;
import io.grpc.stub.StreamObserver;

import java.util.Date;

/**
 * @author feng
 * @date 2023/3/28 22:19
 * @email:dujiafeng@gyyx.com
 * @description:
 */
public class NewsService extends NewsServiceGrpc.NewsServiceImplBase {
    /**
     * 此处注意，我们之前在news.proto文件中定义过，list方法的返回值应该是NewsResponse，但此处的返回值却是void。
     * 可以得知，在gRPC中，返回值是作为传入参数放在传入参数的最后一个位置上。
     * */
    @Override
    public void list(NewsProto.NewsRequest request, StreamObserver<NewsProto.NewsResponse> responseObserver) {
        String date = request.getDate();
        NewsProto.NewsResponse newList = null;
        try {
            //gRPC中有大量的构造器模式使用情景
            NewsProto.NewsResponse.Builder newListBuilder = NewsProto.NewsResponse.newBuilder();
            for (int i = 1; i <= 100; i++) {
                NewsProto.News news = NewsProto.News.newBuilder()
                        .setId(i)
                        .setTitle("新闻标题"+i)
                        .setContent(date + "当日新闻内容："+i)
                        .setCreateTime(new Date().getTime())
                        .build();
                newListBuilder.addNews(news);
            }
            newList = newListBuilder.build();
        }catch (Exception e){
            responseObserver.onError(e);
        }finally {
            //相当于返回数据
            responseObserver.onNext(newList);
        }
        responseObserver.onCompleted();
    }
}

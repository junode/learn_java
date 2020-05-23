package com.atguigu.test0522.rpcDemo1;

import com.atguigu.test0522.common.User;

import java.io.*;
import java.net.Socket;

/*
课堂笔记
1 从单机走向分布式，产生了很多分布式的通信方式。
    最古老也是最有效，且永远不过时的，TCP/UDP的二进制传输。事实上所有的通信方式归根结底都是TCP/UDP。

    CORBA Common Object Request Broker Architecture。古老而复杂，支持面向对象的通信协议(太过复杂，应该会被抛弃把)

    Web Service(SOA SOAP RDDI WSDL...协议):基于http + xml的标准化Web API。
        XML指的是接口文档以XML的形式进行展现，http指的是通信协议。

    RestFul(Representational State Transfer)：回归简单化本源的Web API的事实标准 http://mashibing.com/product/java
        通信协议是http，以json方式进行数据传出。

    RMI Remote Method Invocation:java内部的分布式通信协议，就是Java内部封装的RPC，不过名称叫做RMI摆了。

    JMS Java Message Service：JavaEE中的消息框架标准，为很多MQ所支持。

    RPC(Remote Procedure Call)：远程过程调用，就是调用远程的方法。
        远程方法调用，这只是一个统称，重点在于方法调用(不支持对象的概念)，具体实现甚至可以用RMI RestFul等去实现，
        但一般不用，因为RMI不能跨语言，而RestFul传输效率过低。

        RPC多用于服务器集群间的通信，因此常使用更加有效、短小精悍的传出模式以提高效率，如Thrift，Hessian，
        gooogle protobuf。

RPC根据序列化方式的不同，出现了多样的RPC序列化框架
    注意RPC序列化框架并不是RPC框架，RPC框架还包括服务发现，服务注册、服务治理等。。。
    1 java.io.Serializable
        java原生序列化，不好，序列化时间长，且序列化后的字节也非常大。
    2 Hessian
    3 google protobuf
    4 facebook Thrift
    5 kyro
    6 fst
    7 json序列化框架
        1 jackson
        2 google gson
        3 Ali FastJson
    8 xmlrpc(stream)
    9 ...
RPC通信协议:
    http
    http2.0(gRPC)
    TCP
        同步/异步/阻塞/非阻塞
    WebService

根据序列化方式和RPC通信协议方式的组合，可以产生多样的RPC使用方式，一般框架内部应该有集成，只需选择即可把。

分布式通信最基本最核心的部分：两台/多台服务器之间的二进制数据的传出

向外写的过程：
客户端的数据需要转换成二进制的过程，
    通过DataOutputStream的写入操作将123数值转成二进制的表示，然后
    通过调用toByteArray方式转成字节数组，
* */
public class client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("127.0.0.1",8888);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(123);
        s.getOutputStream().write(baos.toByteArray());
        s.getOutputStream().flush();

        /*上方的操作进行写出操作，下方读取服务器返回的数据，然后
        * 将基本类型进行拼接成User对象*/
        DataInputStream dis = new DataInputStream(s.getInputStream());
        int id = dis.readInt();
        String name = dis.readUTF();
        User user = new User(id,name);

        System.out.println(user);

        dos.close();
        dis.close();
    }
}

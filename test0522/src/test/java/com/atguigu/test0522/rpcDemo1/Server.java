package com.atguigu.test0522.rpcDemo1;

import com.atguigu.test0522.common.IUserService;
import com.atguigu.test0522.common.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static boolean running = true;

    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(8888);
        while(running){
            Socket s = ss.accept();
            process(s);
            s.close();
        }
        ss.close();
    }

    private static void process(Socket s)throws Exception{
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        DataInputStream dis = new DataInputStream(in);
        DataOutputStream dos = new DataOutputStream(out);
        /*
        * 获取客户端的数据
        * */
        int id = dis.readInt();
        IUserService service = new UserServiceImpl();
        /*
        * 如何将对象写入到客户端呢？
        * 把对象的基本类型写到客户端。
        * */
        User user = service.findUserById(id);
        dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
        dos.flush();
    }
}

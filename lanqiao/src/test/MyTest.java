package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class UserInfo implements Serializable {  
    private static final long serialVersionUID = 996890129747019948L;  
    private String name;  
    private transient String psw;  

    public UserInfo(String name, String psw) {  
        this.name = name;  
        this.psw = psw;  
    }  

    public String toString() {  
        return "name=" + name + ", psw=" + psw;  
    }  
}  
public class MyTest {
    public static void main(String[] args) {  
        UserInfo userInfo = new UserInfo("����", "123456");  
        System.out.println(userInfo);  
        try {  
            // ���л���������Ϊtransient������û�б����л�  
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("UserInfo.txt"));  
            o.writeObject(userInfo);  
            o.close();  
        } catch (Exception e) {  
            // TODO: handle exception  
            e.printStackTrace();  
        }  
        try {  
            // ���¶�ȡ����  
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("UserInfo.txt"));  
            UserInfo readUserInfo = (UserInfo) in.readObject();  
            //��ȡ��psw������Ϊnull  
            System.out.println(readUserInfo.toString());  
        } catch (Exception e) {  
            // TODO: handle exception  
            e.printStackTrace();  
        }  
    }  
}

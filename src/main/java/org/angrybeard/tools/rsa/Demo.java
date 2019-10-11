package org.angrybeard.tools.rsa;

import java.io.File;
import java.io.FileInputStream;
import java.security.interfaces.RSAPrivateKey;

/**
 * Created by angry_beary on 2019/10/11.
 */
public class Demo {

    private static String PWD = "vqGt7Z5vlqL/8KnjJpn+1zaqWSi+6PbGhLo9Jj1XzIIuL0MdEb6JsnfW6gx6gE4fYjf1ZJImK+uBenhYNzbDFCYpCx6oQvuoOOTqN89KKxgaLU6PeDgXgFlYwYSWWzg6CBtBqjet1RxOPDSJfXfDmGlMgNwMT/4KSSB0Vn4VQLw=";


    public static void main(String[] args) throws Exception {
        File file = new File("/Users/angry_beary/Desktop/rsa_1024_priv.pem");
        RSAPrivateKey privateKey = RsaUtil.getPrivateKey(new FileInputStream(file));
        String pwd = RsaUtil.decrypt(PWD, privateKey);
        System.out.println(pwd);
    }
}

package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: wangpeilei
 * @date: 2021/05/25 16:03
 **/
public class ProxyDemo {
    public static void main(String[] args) {

        // jdk动态代理 本体必须实现接口
        LawyerProxy lawyerProxy = new LawyerProxy(new ZhangSan());
        Speaker speaker = (Speaker) Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(), new Class[]{LawyerProxy.class}, lawyerProxy);
        speaker.speak();

        // cglib代理，不要求本地实现接口

    }
}

interface Speaker {
    void speak();
}

class LiSi {

}

class ZhangSan implements Speaker {

    @Override
    public void speak() {
        System.out.println("zhang san speak");
    }
}

class LawyerProxy implements InvocationHandler {

    private Object obj;

    public LawyerProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeAction();
        method.invoke(obj, args);
        afterAction();
        return obj;
    }

    private void afterAction() {
        System.out.println("after");
    }

    private void beforeAction() {
        System.out.println("before");
    }
}

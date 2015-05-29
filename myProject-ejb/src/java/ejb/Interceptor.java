package ejb;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class Interceptor {

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {

        System.out.println("SimpleInterceptor - BEFORE calling method :" + context.getMethod().getName());

        Object result = context.proceed();

        System.out.println("SimpleInterceptor - AFTER calling method :" + context.getMethod().getName());

        return result;
    }

}

package proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class proxyImpl implements Proxy {

	public static void main(String[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		ClassLoader classLoader = Aspect.class.getClassLoader();
		try {
			Class aClass = classLoader.loadClass("proxy.Addition");
			System.out.println("aClass.getName() = " + aClass.getName());

			Method method[] = aClass.getDeclaredMethods();

			for (Method m : method) {
				System.out.println(m.getName());
				for (Parameter p : m.getParameters()) {
					System.out.println("Parameter::" + p);
				}
				// System.out.println("invoked::" + m.invoke(aClass.newInstance(), new
				// Locale("1", "1")));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

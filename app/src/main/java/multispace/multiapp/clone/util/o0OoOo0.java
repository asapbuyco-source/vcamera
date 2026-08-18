package multispace.multiapp.clone.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.ByteCompanionObject;
import org.osmdroid.library.BuildConfig;

/* JADX INFO: loaded from: C:\Users\pc\vcfix\classes3.dex */
public class o0OoOo0 {
    private final Object OooO00o;
    private final boolean OooO0O0 = true;

    class OooO00o implements InvocationHandler {
        final /* synthetic */ boolean OooO00o;

        OooO00o(boolean z) {
            this.OooO00o = z;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            try {
                return o0OoOo0.OooOo(o0OoOo0.this.OooO00o).OooO0o(name, objArr).OooOOOo();
            } catch (o00O0O e) {
                if (this.OooO00o) {
                    Map map = (Map) o0OoOo0.this.OooO00o;
                    int length = objArr == null ? 0 : objArr.length;
                    if (length == 0 && name.startsWith(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-68, 18, -68}, new byte[]{-37, 119, -56, -116, 59, -57, 85, -46}))) {
                        return map.get(o0OoOo0.OooOoo(name.substring(3)));
                    }
                    if (length == 0 && name.startsWith(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-35, -5}, new byte[]{-76, -120, -100, -124, -57, 30, 41, -4}))) {
                        return map.get(o0OoOo0.OooOoo(name.substring(2)));
                    }
                    if (length == 1 && name.startsWith(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{109, -25, 65}, new byte[]{30, -126, 53, 111, -91, -110, -70, 26}))) {
                        map.put(o0OoOo0.OooOoo(name.substring(3)), objArr[0]);
                        return null;
                    }
                }
                throw e;
            }
        }
    }

    private static class OooO0O0 {
        private OooO0O0() {
        }
    }

    private o0OoOo0(Class<?> cls) {
        this.OooO00o = cls;
    }

    private o0OoOo0(Object obj) {
        this.OooO00o = obj;
    }

    public static <T extends AccessibleObject> T OooO0OO(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    private Field OooOO0o(String str) throws o00O0O {
        Class<?> clsOooo000 = Oooo000();
        try {
            return clsOooo000.getField(str);
        } catch (NoSuchFieldException e) {
            do {
                try {
                    return (Field) OooO0OO(clsOooo000.getDeclaredField(str));
                } catch (NoSuchFieldException unused) {
                    clsOooo000 = clsOooo000.getSuperclass();
                }
            } while (clsOooo000 != null);
            throw new o00O0O(e);
        }
    }

    private static Class<?> OooOOO(String str) throws o00O0O {
        try {
            return Class.forName(str);
        } catch (Exception e) {
            throw new o00O0O(e);
        }
    }

    private static Class<?> OooOOOO(String str, ClassLoader classLoader) throws o00O0O {
        try {
            return Class.forName(str, true, classLoader);
        } catch (Exception e) {
            throw new o00O0O(e);
        }
    }

    public static String OooOOo(Method method) {
        StringBuilder sb = new StringBuilder(40);
        sb.append(Modifier.toString(method.getModifiers()));
        sb.append(" ");
        sb.append(method.getReturnType().getName());
        sb.append(" ");
        sb.append(method.getName());
        sb.append(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-36}, new byte[]{-12, -10, -75, 80, 64, 34, 39, -115}));
        Class<?>[] parameterTypes = method.getParameterTypes();
        for (Class<?> cls : parameterTypes) {
            sb.append(cls.getName());
            sb.append(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-38, -38}, new byte[]{-10, -6, 72, -36, -59, 17, 43, -96}));
        }
        if (parameterTypes.length > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{ByteCompanionObject.MAX_VALUE}, new byte[]{86, 126, -10, -48, -52, 2, -54, 6}));
        return sb.toString();
    }

    private boolean OooOOoo(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && OooOo00(method.getParameterTypes(), clsArr);
    }

    public static o0OoOo0 OooOo(Object obj) {
        return new o0OoOo0(obj);
    }

    private boolean OooOo0(Class<?>[] clsArr) {
        return clsArr.length > 0 && clsArr[0].isAssignableFrom(Object[].class);
    }

    private boolean OooOo00(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != OooO0O0.class && !Oooo0(clsArr[i]).isAssignableFrom(Oooo0(clsArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    private boolean OooOo0O(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && OooOo0(method.getParameterTypes());
    }

    public static o0OoOo0 OooOo0o(Class<?> cls) {
        return new o0OoOo0(cls);
    }

    public static o0OoOo0 OooOoO(String str, ClassLoader classLoader) throws o00O0O {
        return OooOo0o(OooOOOO(str, classLoader));
    }

    public static o0OoOo0 OooOoO0(String str) throws o00O0O {
        return OooOo0o(OooOOO(str));
    }

    private static o0OoOo0 OooOoOO(Constructor<?> constructor, Object... objArr) throws o00O0O {
        try {
            return OooOo(((Constructor) OooO0OO(constructor)).newInstance(objArr));
        } catch (Exception e) {
            throw new o00O0O(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String OooOoo(String str) {
        int length = str.length();
        if (length == 0) {
            return BuildConfig.FLAVOR;
        }
        if (length == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    private static o0OoOo0 OooOoo0(Method method, Object obj, Object... objArr) throws o00O0O {
        try {
            OooO0OO(method);
            if (method.getReturnType() != Void.TYPE) {
                return OooOo(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return OooOo(obj);
        } catch (Exception e) {
            throw new o00O0O(e);
        }
    }

    private Method OooOooo(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> clsOooo000 = Oooo000();
        for (Method method : clsOooo000.getMethods()) {
            if (OooOOoo(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : clsOooo000.getDeclaredMethods()) {
                if (OooOOoo(method2, str, clsArr)) {
                    return method2;
                }
            }
            clsOooo000 = clsOooo000.getSuperclass();
        } while (clsOooo000 != null);
        throw new NoSuchMethodException(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{60, -68, -27, -37, 15, 71, -33, 78, 19, -95, -27, -59, 3, 94, -34, 77, 22, -13}, new byte[]{114, -45, -59, -88, 102, 42, -74, 34}) + str + multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{70, -31, 96, -85, -40, 110, -47, 43, 20, -9, 100, -84, -112}, new byte[]{102, -106, 9, -33, -80, 78, -95, 74}) + Arrays.toString(clsArr) + multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{27, 105, 111, 102, -127, -4, -83, 47, 94, 42, 102, 124, -104, -10, -23, 109, 84, 100, 32, 103, -108, -24, -24, 109}, new byte[]{59, 10, 0, 19, -19, -104, -115, 77}) + Oooo000() + multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-94}, new byte[]{-116, -124, 17, -66, 53, 86, -96, -121}));
    }

    public static Class<?> Oooo0(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            return Short.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        return Void.TYPE == cls ? Void.class : cls;
    }

    private static Class<?>[] Oooo00O(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? OooO0O0.class : obj.getClass();
        }
        return clsArr;
    }

    private static Object Oooo00o(Object obj) {
        return obj instanceof o0OoOo0 ? ((o0OoOo0) obj).OooOOOo() : obj;
    }

    public o0OoOo0 OooO(Object... objArr) throws o00O0O {
        Class<?>[] clsArrOooo00O = Oooo00O(objArr);
        try {
            return OooOoOO(Oooo000().getDeclaredConstructor(clsArrOooo00O), objArr);
        } catch (NoSuchMethodException e) {
            for (Constructor<?> constructor : Oooo000().getDeclaredConstructors()) {
                if (OooOo00(constructor.getParameterTypes(), clsArrOooo00O)) {
                    return OooOoOO(constructor, objArr);
                }
            }
            throw new o00O0O(e);
        }
    }

    public <P> P OooO0Oo(Class<P> cls) {
        return (P) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new OooO00o(this.OooO00o instanceof Map));
    }

    public o0OoOo0 OooO0o(String str, Object... objArr) throws o00O0O {
        Class<?>[] clsArrOooo00O = Oooo00O(objArr);
        try {
            return OooOoo0(OooOO0(str, clsArrOooo00O), this.OooO00o, objArr);
        } catch (NoSuchMethodException e) {
            try {
                return OooOoo0(OooOooo(str, clsArrOooo00O), this.OooO00o, objArr);
            } catch (NoSuchMethodException e2) {
                throw new o00O0O(e2);
            }
        }
    }

    public o0OoOo0 OooO0o0(String str) throws o00O0O {
        return OooO0o(str, new Object[0]);
    }

    public o0OoOo0 OooO0oO(String str, Object... objArr) throws o00O0O {
        Class<?>[] clsArrOooo00O = Oooo00O(objArr);
        Method method = null;
        char c = 0;
        for (Method method2 : Oooo000().getDeclaredMethods()) {
            if (OooOOoo(method2, str, clsArrOooo00O)) {
                c = 2;
                method = method2;
                break;
            }
            if (OooOo0O(method2, str, clsArrOooo00O)) {
                c = 1;
            } else {
                if (!method2.getName().equals(str) || method2.getParameterTypes().length != 0 || c != 0) {
                }
            }
            method = method2;
        }
        if (method != null) {
            if (c == 0) {
                objArr = new Object[0];
            }
            if (c == 1) {
                objArr = new Object[]{objArr};
            }
            return OooOoo0(method, this.OooO00o, objArr);
        }
        throw new o00O0O(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-126, 99, -52, -86, 47, 64, 73, -62, -120, 44, -118, -88, 63, 90, 69, -115, -118, 99, -98, -25}, new byte[]{-20, 12, -20, -57, 74, 52, 33, -83}) + str, new NoSuchMethodException(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{95, 46, -76, -127, 126, 26, 113, 113, 124, 36, -32, -117, 116, 13, 37}, new byte[]{17, 65, -108, -29, 27, 105, 5, 81}) + str + multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-8, -60, -114, -99, 6, 28, -2, -12, -86, -46, -118, -102, 78}, new byte[]{-40, -77, -25, -23, 110, 60, -114, -107}) + Arrays.toString(clsArrOooo00O) + multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-52, -124, -91, -108, -125, 8, 103, 53, -119, -57, -84, -114, -102, 2, 35, 119, -125, -119, -22, -107, -106, 28, 34, 119}, new byte[]{-20, -25, -54, -31, -17, 108, 71, 87}) + Oooo000() + multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{54}, new byte[]{24, -42, 91, 67, 34, 53, -17, -24})));
    }

    public o0OoOo0 OooO0oo() throws o00O0O {
        return OooO(new Object[0]);
    }

    public Method OooOO0(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> clsOooo000 = Oooo000();
        try {
            return clsOooo000.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return clsOooo000.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    clsOooo000 = clsOooo000.getSuperclass();
                }
            } while (clsOooo000 != null);
            throw new NoSuchMethodException();
        }
    }

    public o0OoOo0 OooOO0O(String str) throws o00O0O {
        try {
            return OooOo(OooOO0o(str).get(this.OooO00o));
        } catch (Exception e) {
            throw new o00O0O(this.OooO00o.getClass().getName(), e);
        }
    }

    public Map<String, o0OoOo0> OooOOO0() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Class<?> clsOooo000 = Oooo000();
        do {
            for (Field field : clsOooo000.getDeclaredFields()) {
                if ((!this.OooO0O0) ^ Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!linkedHashMap.containsKey(name)) {
                        linkedHashMap.put(name, OooOO0O(name));
                    }
                }
            }
            clsOooo000 = clsOooo000.getSuperclass();
        } while (clsOooo000 != null);
        return linkedHashMap;
    }

    public <T> T OooOOOo() {
        return (T) this.OooO00o;
    }

    public <T> T OooOOo0(String str) throws o00O0O {
        return (T) OooOO0O(str).OooOOOo();
    }

    public o0OoOo0 OooOooO(String str, Object obj) throws o00O0O {
        try {
            Field fieldOooOO0o = OooOO0o(str);
            fieldOooOO0o.setAccessible(true);
            fieldOooOO0o.set(this.OooO00o, Oooo00o(obj));
            return this;
        } catch (Exception e) {
            throw new o00O0O(e);
        }
    }

    public Class<?> Oooo000() {
        return this.OooO0O0 ? (Class) this.OooO00o : this.OooO00o.getClass();
    }

    public boolean equals(Object obj) {
        return (obj instanceof o0OoOo0) && this.OooO00o.equals(((o0OoOo0) obj).OooOOOo());
    }

    public int hashCode() {
        return this.OooO00o.hashCode();
    }

    public String toString() {
        return this.OooO00o.toString();
    }
}

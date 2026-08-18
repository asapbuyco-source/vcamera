package multispace.multiapp.clone.pro;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import multispace.multiapp.clone.util.OooO;
import virtual.camera.app.app.App;

public class XpDexLoader {
    private static boolean loaded = false;

    private static void expandField(Object obj, String name, Object[] extra) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        Field field = findField(obj, name);
        Object[] current = (Object[]) field.get(obj);
        Object[] merged = (Object[]) Array.newInstance(current.getClass().getComponentType(), current.length + extra.length);
        System.arraycopy(current, 0, merged, 0, current.length);
        System.arraycopy(extra, 0, merged, current.length, extra.length);
        field.set(obj, merged);
    }

    private static Field findField(Object obj, String name) throws NoSuchFieldException {
        for (Class<?> clazz = obj.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
            try {
                Field declaredField = clazz.getDeclaredField(name);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new NoSuchFieldException(name + " not found.");
    }

    private static Method findMethod(Object obj, String name, Class<?>... paramTypes) throws NoSuchMethodException {
        for (Class<?> clazz = obj.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
            try {
                Method declaredMethod = clazz.getDeclaredMethod(name, paramTypes);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new NoSuchMethodException(name + " not found.");
    }

    public static void OooO0Oo() {
        if (loaded) {
            return;
        }
        File dir = new File(App.getContext().getFilesDir() + "/mydex");
        dir.mkdirs();
        try {
            OooO.OooO00o(App.getContext(), "pelog.zip", dir.getAbsolutePath());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        loadDex(dir.getAbsolutePath() + "/pelog.apk");
        loaded = true;
    }

    private static Object[] makePathElements(Object obj, ArrayList<File> dexFiles, ArrayList<IOException> suppressed) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return (Object[]) findMethod(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, dexFiles, null, suppressed);
    }

    private static void loadDex(String dexPath) {
        Field pathListField;
        IOException[] suppressedArray;
        try {
            Object classLoader = XpDexLoader.class.getClassLoader();
            Object pathList = findField(classLoader, "pathList").get(classLoader);
            ArrayList<File> dexFiles = new ArrayList<>();
            ArrayList<IOException> suppressed = new ArrayList<>();
            dexFiles.add(new File(dexPath));
            expandField(pathList, "dexElements", makePathElements(pathList, dexFiles, suppressed));
            if (suppressed.size() > 0) {
                try {
                    pathListField = findField(classLoader, "dexElementsSuppressedExceptions");
                } catch (Throwable unused) {
                    pathListField = null;
                }
                if (pathListField == null) {
                    try {
                        pathListField = findField(pathList, "dexElementsSuppressedExceptions");
                    } catch (Throwable unused2) {
                    }
                    classLoader = pathList;
                }
                if (pathListField == null) {
                    throw new RuntimeException("dexElementsSuppressedExceptions not found.");
                }
                IOException[] existing = (IOException[]) pathListField.get(classLoader);
                if (existing == null) {
                    suppressedArray = (IOException[]) suppressed.toArray(new IOException[suppressed.size()]);
                } else {
                    IOException[] merged = new IOException[suppressed.size() + existing.length];
                    suppressed.toArray(merged);
                    System.arraycopy(existing, 0, merged, suppressed.size(), existing.length);
                    suppressedArray = merged;
                }
                pathListField.set(classLoader, suppressedArray);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static native void myinit(Object obj);
}
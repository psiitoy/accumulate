package org.sprintdragon.java.corejava.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangdi on 17-5-23.
 */
public class ObjectUtils {

    private static final Unsafe _unsafe;

    private static final Class<?>[] PRIMITIVES = {boolean.class, byte.class,
            char.class, short.class, int.class, long.class, float.class,
            double.class};

    private static final Class<?>[] WRAPPERS = {Boolean.class, Byte.class,
            Character.class, Short.class, Integer.class, Long.class,
            Float.class, Double.class};

    protected static Map<Class<?>, Class<?>> primitiveMap = new HashMap<Class<?>, Class<?>>();

    protected static Map<Class<?>, Class<?>> wrapperMap = new HashMap<Class<?>, Class<?>>();

    static {
        // 基本类型
        for (int i = 0; i < PRIMITIVES.length; i++) {
            primitiveMap.put(PRIMITIVES[i], WRAPPERS[i]);
            wrapperMap.put(WRAPPERS[i], PRIMITIVES[i]);
        }

        // Unsafe初始化
        Unsafe unsafe = null;
        try {
            Class<?> _unsafe_class = Class.forName("sun.misc.Unsafe");
            Field[] fields = _unsafe_class.getDeclaredFields();
            Field theUnsafe = null;
            for (int i = 0; i < fields.length; i++) {
                if (fields[i].getName().equals("theUnsafe")) {
                    theUnsafe = fields[i];
                }
            }
            if (theUnsafe != null) {
                theUnsafe.setAccessible(true);
                unsafe = (Unsafe) theUnsafe.get(null);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        _unsafe = unsafe;
    }


    /**
     * get对象属性值
     *
     * @param field
     * @param object
     * @return
     */
    public static Object getFieldValue(Field field, Object object) {
        long _offset = _unsafe.objectFieldOffset(field);
        if (_offset == Unsafe.INVALID_FIELD_OFFSET)
            throw new IllegalStateException();
        return _unsafe.getObject(object, _offset);
    }

    /**
     * get对象属性值
     *
     * @param fieldname
     * @param object
     * @return
     * @throws Exception
     */
    public static Object getFieldValue(String fieldname, Object object)
            throws Exception {
        return getFieldValue(getDeclaredField(object, fieldname), object);
    }

    /**
     * set对象属性
     *
     * @param object
     * @param field
     * @param value
     */
    public static void setFieldValue(Object object, Field field, Object value) {
        long _offset = _unsafe.objectFieldOffset(field);
        if (_offset == Unsafe.INVALID_FIELD_OFFSET)
            throw new IllegalStateException();
        _unsafe.putObject(object, _offset, value);
    }

    /**
     * set对象属性
     *
     * @param object
     * @param fieldname
     * @param value
     * @throws Exception
     */
    public static void setFieldValue(Object object, String fieldname, Object value)
            throws Exception {
        setFieldValue(object, getDeclaredField(object, fieldname), value);
    }

    /**
     * 获取对象属性
     *
     * @param object
     * @param fieldName
     * @return
     */
    protected static Field getDeclaredField(Object object, String fieldName) {
        return getDeclaredField(object.getClass(), fieldName);
    }

    /**
     * 获取对象属性
     *
     * @param cls
     * @param fieldName
     * @return
     */
    public static Field getDeclaredField(Class<?> cls, String fieldName) {
        Field field = null;
        Class<?> clazz = cls;
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                return field;
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static Map<String, Object> object2Map(Object object) throws Exception {
        Map<String, Object> data = new HashMap<String, Object>();
        for (Field field : object.getClass().getDeclaredFields()) {
            Object v = getFieldValue(field, object);
            if (v != null)
                data.put(field.getName(), v);
        }
        return data;
    }

    public static void object2Object(Object target, Object source) {
        Field[] fields = source.getClass().getDeclaredFields();
        for (Field f : fields) {
            Object value = ObjectUtils.getFieldValue(f, source);
            if (value != null)
                ObjectUtils.setFieldValue(target, f, value);
        }
    }
}

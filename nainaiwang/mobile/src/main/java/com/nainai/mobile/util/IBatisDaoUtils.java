//package com.nainai.mobile.util;
//
//import java.lang.reflect.Method;
//import java.text.MessageFormat;
//
//import org.springframework.util.ClassUtils;
//
//import com.entity.EntityPK;
//import com.entity.IBaseDto;
//import com.exception.BusiException;
///**
// * Created by haopeng yan on 2018/4/20
// *
// * @author haopeng yan
// * @version 1.0
// * @since 1.0
// * Copyright (C) 2018. haopeng yan All Rights Received
// */
//public final class IBatisDaoUtils {
//    /**
//     * 获取表名
//     *
//     * @param o
//     * @return
//     * @throws BusiException
//     */
//    public static String getTableName(Object o) {
//        // 获取对象o的注解类
//        EntityPK entity = o.getClass().getAnnotation(EntityPK.class);
//
//        if (entity == null || "".equals(entity)) {
//            String msg = MessageFormat.format("Could not set '{0}' tableName",
//                    new Object[] { ClassUtils.getShortName(o.getClass()) });
//        }
//
//        // 如果注解类不为空，则获取table
//        return entity.tableName();
//    }
//
//    /**
//     * 返回主键字段
//     *
//     * @param o
//     * @return
//     */
//    public static String getPrimaryKeyFieldName(Object o) {
//        // 获取对象o的注解类
//        EntityPK entity = o.getClass().getAnnotation(EntityPK.class);
//
//        if (entity == null || "".equals(entity)) {
//            return null;
//        }
//        return "".equals(entity.PK()) ? null : entity.PK();
//    }
//
//    public static Object getPrimaryKeyFieldValue(IBaseDto o) {
//        String fieldName = getPrimaryKeyFieldName(o);
//        if (fieldName == null) {
//            return null;
//        }
//        // 获取get方法
//        String getterMethod = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
//        try {
//            Method getMethod = o.getClass().getMethod(getterMethod, (Class[]) null);
//            // 回调方法
//            return getMethod.invoke(o, (Object[]) null);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static void setPrimaryKey(IBaseDto o, Object val) {
//        String fieldName = "";
//        try {
//            fieldName = getPrimaryKeyFieldName(o);
//            EntityPK entity = (EntityPK) o.getClass().getAnnotation(EntityPK.class);
//            Class clazz = o.getClass().getDeclaredField(entity.PK()).getType();
//            // 获取get方法
//            String getterMethod = "set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
//
//            Method setMethod = o.getClass().getMethod(getterMethod, (Class[]) null);
//            if (val != null) {
//                setMethod.invoke(o, new Object[] { val });
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            String msg = MessageFormat.format("Could not set '{0}.{1}' with value {2}",
//                    new Object[] { ClassUtils.getShortName(o.getClass()), fieldName, val });
//        }
//    }
//
//    public static String getTableName(Object ob, String tableName) {
//        if (tableName == null) {
//            tableName = ClassUtils.getShortName(ob.getClass());
//        }
//
//        return tableName;
//    }
//}

//package com.nainai.mobile.sql;
//
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.Reader;
//import java.lang.reflect.Field;
//import java.sql.Clob;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.BeanWrapper;
//import org.springframework.beans.BeanWrapperImpl;
//
//import com.entity.IBaseDto;
//import com.util.IBatisDaoUtils;
//
//import DynamicSql.KeyVO;
//
///**
// * Created by haopeng yan on 2018/4/20
// *
// * @author haopeng yan
// * @version 1.0
// * @since 1.0
// * Copyright (C) 2018. haopeng yan All Rights Received
// */
//public class DynamicSql {
//    private final Logger log = Logger.getLogger(getClass());
//
//    private static DynamicSql m_instance = null;
//
//    private void init() {
//    }
//
//    public static synchronized DynamicSql getInstance() {
//        if (m_instance == null) {
//            m_instance = new DynamicSql();
//            m_instance.init();
//        }
//
//        return m_instance;
//    }
//
//    public HashMap<String, Object> beanTohashmap(Object ob) throws IllegalArgumentException, IllegalAccessException {
//        Field[] field = ob.getClass().getDeclaredFields();
//
//        HashMap map = new HashMap();
//
//        for (int i = 0; i < field.length; i++) {
//            Field f = field[i];
//            f.setAccessible(true);
//            map.put(f.getName(), f.get(ob));
//        }
//
//        return map;
//    }
//
//    public HashMap<String, Object> UpdatebeanToSqlPk(Object ob, String tableName) {
//        HashMap sql_hs = new HashMap();
//
//        ArrayList setsql = new ArrayList();
//
//        ArrayList wherepk = new ArrayList();
//        try {
//            ObjectVOtoKeyVOListPK(ob, setsql, wherepk);
//
//            if (wherepk.size() <= 0) {
//                throw new RuntimeException("no pk value!!!!");
//            }
//
//            tableName = getTableName(ob, tableName);
//
//            sql_hs.put("sqltablename", tableName);
//
//            sql_hs.put("sqlvalue", setsql);
//
//            sql_hs.put("sqlwhere", wherepk);
//        } catch (IllegalArgumentException e) {
//            this.log.error("::", e);
//        } catch (IllegalAccessException e) {
//            this.log.error("::", e);
//        }
//
//        return sql_hs;
//    }
//
//    public HashMap<String, Object> DeletebeanToSqlPk(Object ob, String tableName) {
//        HashMap sql_hs = new HashMap();
//
//        ArrayList wherepk = new ArrayList();
//        try {
//            ObjectVOtoKeyVOListForWherePK(ob, wherepk);
//
//            if (wherepk.size() <= 0) {
//                throw new RuntimeException("no pk value!!!");
//            }
//
//            tableName = getTableName(ob, tableName);
//
//            sql_hs.put("sqltablename", tableName);
//
//            sql_hs.put("sqlwhere", wherepk);
//        } catch (IllegalArgumentException e) {
//            this.log.error("::", e);
//        } catch (IllegalAccessException e) {
//            this.log.error("::", e);
//        }
//
//        return sql_hs;
//    }
//
//    public HashMap<String, Object> DeletebeanToSql(Object ob, String tableName) {
//        HashMap sql_hs = new HashMap();
//
//        ArrayList setsql = new ArrayList();
//        try {
//            ObjectVOtoKeyVOList(ob, setsql);
//
//            tableName = getTableName(ob, tableName);
//
//            sql_hs.put("sqltablename", tableName);
//
//            sql_hs.put("sqlwhere", setsql);
//        } catch (IllegalArgumentException e) {
//            this.log.error("::", e);
//        } catch (IllegalAccessException e) {
//            this.log.error("::", e);
//        }
//
//        return sql_hs;
//    }
//
//    public HashMap<String, Object> SelectSql(Object ob, String tableName) {
//        StringBuffer selectsql = new StringBuffer(" ");
//
//        HashMap sql_hs = new HashMap();
//
//        ArrayList<KeyVO> wheresetsql = new ArrayList<KeyVO>();
//        try {
//            ObjectVOtoKeyVOListSelect(ob, wheresetsql, selectsql);
//
//            tableName = getTableName(ob, tableName);
//
//            sql_hs.put("sqltablename", tableName);
//
//            sql_hs.put("sqlvalue", selectsql.toString().substring(0, selectsql.toString().lastIndexOf(",")));
//
//            sql_hs.put("sqlwhere", wheresetsql);
//        } catch (IllegalArgumentException e) {
//            this.log.error("::", e);
//        } catch (IllegalAccessException e) {
//            this.log.error("::", e);
//        }
//
//        return sql_hs;
//    }
//
//    public HashMap<String, Object> SelectCountSql(Object ob, String tableName) {
//        StringBuffer selectsql = new StringBuffer(" ");
//
//        HashMap sql_hs = new HashMap();
//
//        ArrayList wheresetsql = new ArrayList();
//        try {
//            ObjectVOtoSelectCount(ob, wheresetsql);
//
//            tableName = getTableName(ob, tableName);
//
//            sql_hs.put("sqltablename", tableName);
//
//            sql_hs.put("sqlwhere", wheresetsql);
//        } catch (IllegalArgumentException e) {
//            this.log.error("::", e);
//        } catch (IllegalAccessException e) {
//            this.log.error("::", e);
//        }
//
//        return sql_hs;
//    }
//
//    public HashMap<String, Object> InsertSql(Object ob, String tableName, Object tablePk) {
//        StringBuffer selectsql = new StringBuffer("( ");
//
//        HashMap sql_hs = new HashMap();
//
//        ArrayList wheresetsql = new ArrayList();
//        try {
//            tableName = getTableName(ob, tableName);
//
//            ObjectVOtoKeyVOListInsert(ob, wheresetsql, selectsql, tablePk);
//
//            sql_hs.put("sqltablename", tableName);
//
//            sql_hs.put("sqlvalue", selectsql.toString().substring(0, selectsql.toString().lastIndexOf(",")) + " ) ");
//
//            sql_hs.put("sqlwhere", wheresetsql);
//        } catch (IllegalArgumentException e) {
//            this.log.error("::", e);
//        } catch (IllegalAccessException e) {
//            this.log.error("::", e);
//        }
//
//        return sql_hs;
//    }
//
//    private void ObjectVOtoKeyVOListPK(Object ob, ArrayList<KeyVO> keyVoList, ArrayList<KeyVO> wherePk)
//            throws IllegalArgumentException, IllegalAccessException {
//        Field[] field = getFields(ob);
//
//        KeyVO thisvo = null;
//
//        for (int i = 0; i < field.length; i++) {
//            Field f = field[i];
//
//            f.setAccessible(true);
//
//            if (!f.getName().toUpperCase().equals("SERIALVERSIONUID")) {
//                if (f.get(ob) != null) {
//                    String type = f.getType().getCanonicalName();
//
//                    if (CleanoutType(type)) {
//                        String selectColumn = f.getName();
//
//                        thisvo = new KeyVO();
//
//                        thisvo.setKey(selectColumn.toUpperCase());
//
//                        thisvo.setValue(f.get(ob));
//
//                        if (f.getName().toUpperCase()
//                                .equals(IBatisDaoUtils.getPrimaryKeyFieldName((IBaseDto) ob).toUpperCase())) {
//                            if (wherePk != null) {
//                                wherePk.add(thisvo);
//                            }
//
//                        } else {
//                            keyVoList.add(thisvo);
//                        }
//
//                        thisvo = null;
//                    }
//                }
//            }
//        }
//    }
//
//    private void ObjectVOtoKeyVOListForWherePK(Object ob, ArrayList<KeyVO> wherePk)
//            throws IllegalArgumentException, IllegalAccessException {
//        Field[] field = getFields(ob);
//
//        KeyVO thisvo = null;
//
//        for (int i = 0; i < field.length; i++) {
//            Field f = field[i];
//
//            f.setAccessible(true);
//
//            if (!f.getName().toUpperCase().equals("SERIALVERSIONUID")) {
//                if (f.get(ob) != null) {
//                    String type = f.getType().getCanonicalName();
//
//                    if (CleanoutType(type)) {
//                        String selectColumn = f.getName();
//
//                        thisvo = new KeyVO();
//
//                        thisvo.setKey(selectColumn.toUpperCase());
//
//                        thisvo.setValue(f.get(ob));
//
//                        if (f.getName().toUpperCase()
//                                .equals(IBatisDaoUtils.getPrimaryKeyFieldName((IBaseDto) ob).toUpperCase())) {
//                            if (wherePk != null) {
//                                wherePk.add(thisvo);
//                            }
//
//                        }
//
//                        thisvo = null;
//                    }
//                }
//            }
//        }
//    }
//
//    private void ObjectVOtoKeyVOList(Object ob, ArrayList<KeyVO> keyvolist)
//            throws IllegalArgumentException, IllegalAccessException {
//        Field[] field = ob.getClass().getDeclaredFields();
//
//        KeyVO thisvo = null;
//
//        for (int i = 0; i < field.length; i++) {
//            Field f = field[i];
//
//            f.setAccessible(true);
//
//            if (!f.getName().toUpperCase().equals("SERIALVERSIONUID")) {
//                if (f.get(ob) != null) {
//                    String type = f.getType().getCanonicalName();
//
//                    if (CleanoutType(type)) {
//                        String selectColumn = f.getName();
//
//                        thisvo = new KeyVO();
//
//                        thisvo.setKey(selectColumn.toUpperCase());
//
//                        thisvo.setValue(f.get(ob));
//
//                        keyvolist.add(thisvo);
//
//                        thisvo = null;
//                    }
//                }
//            }
//        }
//    }
//
//    private void ObjectVOtoKeyVOListSelect(Object ob, ArrayList<KeyVO> whereKeyVoList, StringBuffer selectValue)
//            throws IllegalArgumentException, IllegalAccessException {
//        Field[] field = getFields(ob);
//
//        KeyVO thisvo = null;
//
//        for (int i = 0; i < field.length; i++) {
//            Field f = field[i];
//
//            f.setAccessible(true);
//
//            if (!f.getName().toUpperCase().equals("SERIALVERSIONUID")) {
//                String selectColumn = f.getName();
//
//                String type = f.getType().getCanonicalName();
//
//                if (CleanoutType(type)) {
//                    selectValue.append(selectColumn + " \"" + selectColumn + "\" , ");
//
//                    if (f.get(ob) != null) {
//                        thisvo = new KeyVO();
//
//                        thisvo.setKey(selectColumn.toUpperCase());
//
//                        thisvo.setValue(f.get(ob));
//
//                        whereKeyVoList.add(thisvo);
//
//                        thisvo = null;
//                    }
//                }
//            }
//        }
//    }
//
//    private void ObjectVOtoSelectCount(Object ob, ArrayList<KeyVO> whereKeyVoList)
//            throws IllegalArgumentException, IllegalAccessException {
//        Field[] field = getFields(ob);
//
//        KeyVO thisvo = null;
//
//        for (int i = 0; i < field.length; i++) {
//            Field f = field[i];
//
//            f.setAccessible(true);
//
//            if (!f.getName().toUpperCase().equals("SERIALVERSIONUID")) {
//                String selectColumn = f.getName();
//
//                String type = f.getType().getCanonicalName();
//
//                if (f.get(ob) != null) {
//                    thisvo = new KeyVO();
//
//                    thisvo.setKey(selectColumn.toUpperCase());
//
//                    thisvo.setValue(f.get(ob));
//
//                    whereKeyVoList.add(thisvo);
//
//                    thisvo = null;
//                }
//            }
//        }
//    }
//
//    private void ObjectVOtoKeyVOListInsert(Object ob, ArrayList<KeyVO> keyvolist, StringBuffer selectvalue,
//                                           Object tablePk) throws IllegalArgumentException, IllegalAccessException {
//        Field[] field = getFields(ob);
//
//        KeyVO thisvo = null;
//
//        for (int i = 0; i < field.length; i++) {
//            Field f = field[i];
//
//            f.setAccessible(true);
//
//            if (f.getName().toUpperCase().equals(IBatisDaoUtils.getPrimaryKeyFieldName((IBaseDto) ob).toUpperCase())) {
//                selectvalue.append(f.getName().toUpperCase() + ", ");
//
//                thisvo = new KeyVO();
//
//                thisvo.setKey(f.getName().toUpperCase());
//
//                thisvo.setValue(tablePk);
//
//                keyvolist.add(thisvo);
//            } else if (f.get(ob) != null) {
//                if (!f.getName().toUpperCase().equals("SERIALVERSIONUID")) {
//                    String selectColumn = f.getName();
//
//                    String type = f.getType().getCanonicalName();
//
//                    if (CleanoutType(type)) {
//                        selectvalue.append(selectColumn.toUpperCase() + ", ");
//
//                        thisvo = new KeyVO();
//
//                        thisvo.setKey(selectColumn.toUpperCase());
//
//                        thisvo.setValue(f.get(ob));
//
//                        keyvolist.add(thisvo);
//
//                        thisvo = null;
//                    }
//                }
//            }
//        }
//    }
//
//    public HashMap<String, Object> UpdateBatchbeanToSqlPk(Object ob, List wherepk, String tableName) {
//        HashMap sql_hs = new HashMap();
//
//        ArrayList setsql = new ArrayList();
//        try {
//            ObjectVOtoKeyVOListPK(ob, setsql, null);
//
//            tableName = getTableName(ob, tableName);
//
//            sql_hs.put("sqltablename", tableName);
//
//            sql_hs.put("sqlvalue", setsql);
//
//            sql_hs.put("sqlwhere", wherepk);
//
//            sql_hs.put("sqltablepkname", IBatisDaoUtils.getPrimaryKeyFieldName((IBaseDto) ob).toUpperCase());
//        } catch (IllegalArgumentException e) {
//            this.log.error("::", e);
//        } catch (IllegalAccessException e) {
//            this.log.error("::", e);
//        }
//
//        return sql_hs;
//    }
//
//    public List ListHashToListbean(List list, Object model)
//    {
//        List beanlist = new ArrayList();
//        if (list != null) {
//            try {
//                for (int i = 0; i < list.size(); i++) {
//                    Object ob = model.getClass().newInstance();
//                    HashMap hs = (HashMap)list.get(i);
//                    BeanWrapper beanWrapper = new BeanWrapperImpl(ob);
//                    beanWrapper.setPropertyValues(hs);
//                    beanlist.add(ob);
//                }
//            } catch (IllegalAccessException e) {
//                this.log.error("::", e);
//            } catch (InstantiationException e) {
//                this.log.error("::", e);
//            } catch (Exception e) {
//                this.log.error("::", e);
//            }
//        }
//        return beanlist;
//    }
//
//    private boolean CleanoutType(String type) {
//        if ((type.equals("java.lang.Float")) || (type.equals("java.lang.Long")) || (type.equals("java.lang.String"))
//                || (type.equals("java.lang.Integer")) || (type.equals("java.lang.Double"))
//                || (type.equals("java.sql.Timestamp")) || (type.equals("java.math.BigDecimal"))
//                || (type.equals("java.util.Date")) || (type.equals("java.sql.Date"))) {
//            return true;
//        }
//        return false;
//    }
//
//    private String getTableName(Object ob, String tableName) {
//        return IBatisDaoUtils.getTableName(ob, tableName);
//    }
//
//    private Field[] getFields(Object ob) {
//        Field[] field = ob.getClass().getDeclaredFields();
//        return field;
//    }
//
//    private String clobToString(Clob clob) {
//        String reString = "";
//        Reader is = null;
//        try {
//            is = clob.getCharacterStream();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        BufferedReader br = new BufferedReader(is);
//        String s = null;
//        try {
//            s = br.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        StringBuffer sb = new StringBuffer();
//        while (s != null) {
//            sb.append(s);
//            try {
//                s = br.readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        reString = sb.toString();
//        return reString;
//    }
//}

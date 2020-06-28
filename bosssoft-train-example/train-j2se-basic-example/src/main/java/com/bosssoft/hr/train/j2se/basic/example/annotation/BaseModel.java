package com.bosssoft.hr.train.j2se.basic.example.annotation;

import com.bosssoft.hr.train.j2se.basic.example.database.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @param
 * @description:
 * @author: 张彦征
 * @create: 2020-06-01 12:03
 * @since
 **/
public abstract class BaseModel {
    private static final Logger log = LoggerFactory.getLogger(BaseModel.class);
    /**
     * 数据库列名对属性字段名转换
     */
    private Map<String, String> colToField = new HashMap<>();
    /**
     * 表名
     */
    private String tableName = null;
    /**
     * 主键名
     */
    private String primaryKey = null;
    /**
     * 所有列名
     */
    private StringBuilder allColumns = new StringBuilder();

    /**
     * 解析注解
     * 默认注解正确
     *
     * @return
     */
    public Map<String, String> analysisAnnotation() {
        //初始化大小
        Map<String, String> map = new LinkedHashMap<>(20);
        try {
            //获取Annotation的Class对象
            Class<?> cls = this.getClass();
            //首先获取tableName 考虑没标注解情况的话
            boolean isTable = cls.isAnnotationPresent(Table.class);
            if (isTable) {
                tableName = cls.getAnnotation(Table.class).value();
            } else {
                log.error("缺少@Table注解");
                return null;
            }
            //获取类中的字段
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                //设置访问性
                field.setAccessible(true);
                //获取注解 判断注解类型默认每个字段标注一个注解
                boolean isId = field.isAnnotationPresent(Id.class);
                boolean isColumn = field.isAnnotationPresent(Column.class);
                if (isId) {
                    primaryKey = field.getAnnotation(Id.class).value();
                    //主键的值
                    map.put(primaryKey, field.get(this).toString());
                    allColumns.append(primaryKey + ",");
                    //列名到字段映射
                    colToField.put(primaryKey, field.getName());
                } else if (isColumn) {
                    String column = field.getAnnotation(Column.class).value();
                    //添加普通的列和他们对应的value 相同覆盖
                    map.put(column, field.get(this).toString());

                    allColumns.append(column + ",");
                    //列名到字段映射
                    colToField.put(column, field.getName());
                } else {
                    //没有标注注解不做处理
                }
            }
            //去掉多余","
            allColumns = new StringBuilder(allColumns.substring(0, allColumns.lastIndexOf(",")));
            return map;
        } catch (Exception e) {
            log.error("反射解析异常:{}", e);
        }

        return null;
    }


    /**
     * 保存
     *
     * @return
     */
    public int save() {
        Map<String, String> map = analysisAnnotation();
        // 下面是为了获取列名
        int numColumns = allColumns.toString().split(",").length;
        StringBuilder preSql = new StringBuilder();
        for (int i = 0; i < numColumns; i++) {
            preSql.append("?");
            if (i < numColumns - 1) {
                preSql.append(",");
            }
        }
        String sql = "insert into " + tableName + "(" + allColumns + ")" + " values(" + preSql + ")";
        Connection conn = DBUtil.init();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
            int index = 0;
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                String value = entry.getValue();
                ps.setString(++index, value);
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            log.error("数据库save语句执行异常:{}", e);
        } finally {
            closeRes(ps);
        }
        return 0;
    }

    /**
     * 关闭连接
     *
     * @param ps
     */
    public void closeRes(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                log.error("ps关闭异常:{}", e);
            }
        }
        DBUtil.closeConn();
    }

    /**
     * 更新
     *
     * @return
     */
    public int update() {
        Map<String, String> map = analysisAnnotation();
        String[] columns = allColumns.toString().split(",");
        StringBuilder sql = new StringBuilder("update " + tableName + " set ");
        //过滤掉id
        for (int i = 0; i < columns.length; i++) {
            if (!primaryKey.equals(columns[i])) {
                sql.append(columns[i] + "=? ,");
            }
        }
        //最后会多一个逗号
        sql = new StringBuilder(sql.substring(0, sql.lastIndexOf(",")));
        sql.append("where " + primaryKey + " = ? ");
        Connection conn = DBUtil.init();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql.toString());
            Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
            int index = 0;
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                String key = entry.getKey();
                String value = entry.getValue();
                //如果是主键放在最后
                if (primaryKey.equals(key)) {
                    ps.setString(columns.length, value);
                } else {
                    ps.setString(++index, value);
                }
            }
            //执行
            return ps.executeUpdate();
        } catch (SQLException e) {
            log.error("数据库执行update异常:{}", e);
        } finally {
            closeRes(ps);
        }
        return 0;
    }

    /**
     * 按照id删除吧
     *
     * @return
     */
    public int remove() {
        Map<String, String> map = analysisAnnotation();
        String id = map.get(primaryKey);
        String sql = "delete from " + tableName + " where " + primaryKey + " =  ? ";
        //初始化数据库
        DBUtil.init();
        try {
            //执行sql
            return DBUtil.creatOrUpdateOrDelete(sql, id);
        } finally {
            //关闭连接
            DBUtil.closeConn();
        }
    }

    /**
     * 查找 默认全部搜索了
     *
     * @return
     */
    public List<Object> queryForList() {
        analysisAnnotation();
        String sql = "select *  from " + tableName + "";
        //初始化数据库
        DBUtil.init();
        ResultSet resultSet = DBUtil.select(sql);
        List<Object> result = new ArrayList<>();
        try {
            //拿到列数
            int columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                //拿到一个实例
                BaseModel instance = this.getClass().newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    //通过列名获取 属性的名字 进而获取字段名
                    Field field = instance
                            .getClass()
                            .getDeclaredField(colToField.get(resultSet.getMetaData().getColumnName(i)));
                    field.setAccessible(true);
                    //设置该实例字段的值
                    field.set(instance, resultSet.getObject(i));
                }
                //加入
                result.add(instance);
            }
        } catch (Exception e) {
            log.error("数据库异常:{}", e);
        } finally {
            //关闭连接
            DBUtil.closeConn();
        }
        log.info("查找结果：{}", result);
        return result;
    }
}

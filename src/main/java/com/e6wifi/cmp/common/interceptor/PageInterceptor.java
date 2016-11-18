package com.e6wifi.cmp.common.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.log4j.Logger;

import com.e6wifi.cmp.common.entity.BaseEntity;
import com.e6wifi.cmp.common.model.Page;


/**
 * 分页拦截器
 * @author luo
 *
 */
@Intercepts({
    @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class}),  
    @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})
}) 
public class PageInterceptor implements Interceptor {
	
	private Logger logger = Logger.getLogger(PageInterceptor.class);

	/**
	 * 方法最后四个字符为Page则分页查询
	 */
	private static final String SELECT_ID="Page";

    /**
     * 插件运行的代码，它将代替原有的方法
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (invocation.getTarget() instanceof StatementHandler) {  
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();  
            MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);  
            MappedStatement mappedStatement=(MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
            String selectId=mappedStatement.getId();
            String methodName = selectId.substring(selectId.lastIndexOf(".")+1);
            if(SELECT_ID.equals(methodName.substring(methodName.length()-4))){
                BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");  
                // 分页参数作为参数对象parameterObject的一个属性  
                String sql = boundSql.getSql();
                BaseEntity co = (BaseEntity)(boundSql.getParameterObject());
                if(co == null) {
                	return invocation.proceed();
                }
	            Connection connection = (Connection) invocation.getArgs()[0];  
	            this.setTotalRecord(co, mappedStatement, connection);  
	            // 重写sql  
                String pageSql = concatPageSql(sql, co.getPager());
                metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);            
            }
        } 
        
        return invocation.proceed();
    }
    
    
    private void setTotalRecord(BaseEntity co, MappedStatement mappedStatement, Connection connection) {
        BoundSql boundSql = mappedStatement.getBoundSql(co);  
        String sql = boundSql.getSql();  
        String countSql = this.concatCountSql(sql);  
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();  
        BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql, parameterMappings, co);  
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, co, countBoundSql);  
        PreparedStatement pstmt = null;  
        ResultSet rs = null;  
        try {  
            pstmt = connection.prepareStatement(countSql);  
            parameterHandler.setParameters(pstmt);  
            rs = pstmt.executeQuery();  
            if (rs.next()) {  
               int totalRecord = rs.getInt(1);  
               co.getPager().setRowCount(totalRecord);  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
               if (rs != null)  
                   rs.close();  
                if (pstmt != null)  
                   pstmt.close();  
            } catch (SQLException e) {  
               e.printStackTrace();  
            }  
        }  
     }  
    
    /**
     * 拦截类型StatementHandler 
     */
    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {  
            return Plugin.wrap(target, this);  
        } else {  
            return target;  
        }  
    }
    
    @Override
    public void setProperties(Properties properties) {
        
    }  
    
    
    public String concatCountSql(String sql){
        StringBuffer sb=new StringBuffer("select count(1) from (");
        sb.append(sql);
        sb.append(") h");
        return sb.toString();
    }
    
    public String concatPageSql(String sql, Page page){
        StringBuffer sb=new StringBuffer();
        sb.append(sql);
        sb.append(" limit ").append(page.getIndex()).append(" , ").append(page.getSize());
        return sb.toString();
    }
    
    public void setPageCount(){
        
    }

}

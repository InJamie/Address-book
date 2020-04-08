package pers.jamie.domain;

import org.springframework.jdbc.core.JdbcTemplate;
import pers.jamie.Utils.JDBCutil;

public class 信息生成器 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JDBCutil.getDataSource());
        String sql="";
    }
}

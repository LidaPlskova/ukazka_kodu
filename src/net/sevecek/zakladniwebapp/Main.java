package net.sevecek.zakladniwebapp;

import java.sql.*;
import javax.sql.*;
import org.mariadb.jdbc.*;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.web.servlet.config.annotation.*;
import net.sevecek.boot.standalone.*;
import net.sevecek.boot.war.*;

@Configuration
@ComponentScan
@EnableWebMvc
public class Main extends DefaultWebMvcConfigurer {

    @Bean
    public DataSource dataSource() throws SQLException{
        MariaDbDataSource dataSource;
        dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mysql://db.tomcat.cloud:3306/moje_zahradka");
        dataSource.setUser("student");
        dataSource.setPassword("password");
        return dataSource;
    }

    @Bean
    public JdbcTemplate pokladacDotazu(DataSource dataSource){
        JdbcTemplate pokladacDotazu;
        pokladacDotazu = new JdbcTemplate(dataSource);
        return pokladacDotazu;
    }

    public static void main(String[] args) {
        TomcatApplication.run();
    }
}

package me.jumen.demospringbootjdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class MysqlRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(MysqlRunner.class);

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try (Connection connection = dataSource.getConnection()) {
            logger.debug(String.valueOf(dataSource.getClass()));
            logger.debug(connection.getMetaData().getURL());
            logger.debug(connection.getMetaData().getUserName());

//            Statement statement = connection.createStatement();
//            String sql = "CREATE TABLE USER(id INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
//            statement.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }

//        jdbcTemplate.execute("INSERT INTO USER VALUES(1, 'Jumen')");
    }
}

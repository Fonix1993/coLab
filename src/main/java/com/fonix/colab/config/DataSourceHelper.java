package com.fonix.colab.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
@Configuration
public class DataSourceHelper {

    @Resource
    private DataSourceProperties dataSourceProperties;

    @PostConstruct
    public void init() {
        try {
            Class.forName(dataSourceProperties.getDriverClassName());
            URI uri = new URI(dataSourceProperties.getUrl().replace("jdbc:", ""));
            String host = uri.getHost();
            int port = uri.getPort();
            String path = uri.getPath();
            String query = uri.getQuery();
            Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "?" + query,
                    dataSourceProperties.getUsername(), dataSourceProperties.getPassword());
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS `" + path.replace("/", "") + "` DEFAULT CHARACTER SET = "
                    + "" + "`utf8` COLLATE `utf8_general_ci`;");
            statement.close();
            connection.close();
        } catch (URISyntaxException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}


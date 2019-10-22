//package cn.run.java.system.config;
//
//import io.r2dbc.spi.ConnectionFactories;
//import io.r2dbc.spi.ConnectionFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
//import org.springframework.data.r2dbc.core.DatabaseClient;
//import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
//
//@Configuration
//@EnableR2dbcRepositories
//class ApplicationConfig
//        extends AbstractR2dbcConfiguration
//{
//
//
//  @Bean
//  @Override
//  public ConnectionFactory connectionFactory() {
//    return ConnectionFactories.get("r2dbcs:mysql://root:root@127.0.0.1:3306/bs_system");
//  }
//
//  @Bean
//  public DatabaseClient databaseClient(@Qualifier("connectionFactory") ConnectionFactory connectionFactory) {
//    return DatabaseClient.create(connectionFactory);
//  }
//}
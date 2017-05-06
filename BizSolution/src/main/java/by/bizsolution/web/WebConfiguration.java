package by.bizsolution.web;

import by.bizsolution.web.controllers.ContactController;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;

@EnableWebMvc
@ComponentScan(basePackages = "by.bizsolution")
@EnableAspectJAutoProxy
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Value("${db.user}")
    String dataBaseUser;
    @Value("${db.password}")
    String dataBasePassword;
    @Value("${db.url}")
    String dataBaseUrl;
    @Value("${db.driverName}")
    String dataBaseDriverClassName;

    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dataBaseDriverClassName);
        dataSource.setUsername(dataBaseUser);
        dataSource.setPassword(dataBasePassword);
        dataSource.setUrl(dataBaseUrl);

        return  dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
        lsfb.setDataSource(dataSource());
        lsfb.setHibernateProperties(getHibernateProperties());
        lsfb.setPackagesToScan(new String[]{"by.bizsolution.web.model"});

        return lsfb;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager htm=new HibernateTransactionManager();
        htm.setSessionFactory(sessionFactory);

        return htm;
    }

    public Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", org.hibernate.dialect.MySQLDialect.class);
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", true);

        return properties;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
/*
    @Bean(name = "contact")
    public ContactController getHomeController() {
        return new ContactController();
    }
*/
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }


}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.configuracion;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;


/**
 *
 * @author jsuspes
 */
public class ConfiguradorIbatis {

    public static final ConfiguradorIbatis configuradorIbatis = new ConfiguradorIbatis();
    protected static Logger log = Logger.getLogger(ConfiguradorIbatis.class);
    private SqlSessionFactory sqlSessionFactory;

    private ConfiguradorIbatis() {
        super();
    }

    public static ConfiguradorIbatis getInstance() {
        return configuradorIbatis;
    }

    public void configurar(String ambiente) {

        //log.info("Inicia Configuracion ");
        try {
            String resource = "configuration.xml";
            Reader reader = Resources.getResourceAsReader(resource);

            this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, ambiente);
                log.info("SqlSession porceso de admisiones configurado OK!! ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SqlSessionFactory getSqlSessionFactory() {

        return sqlSessionFactory;
    }
}

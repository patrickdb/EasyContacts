package com.ec.apis.easycontacts;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class EasyContactsApplication {

    public static void main(String[] args) {
        setupH2Server();

        EntityManager em = Persistence
                .createEntityManagerFactory("H2_InMemory_PersistenceUnit")
                .createEntityManager();

        SpringApplication.run(EasyContactsApplication.class, args);
    }

    static void setupH2Server()
    {
        final String[] args = new String[] {
                "-tcpPort", "8092",
                "-tcpAllowOthers"};

        try {
            org.h2.tools.Server server = org.h2.tools.Server.createTcpServer(args).start();

            System.out.println("H2 in memory server started and now observable");
            System.out.println("Accessible @ jdbc:h2:tcp://localhost:8092/mem:fotoTest");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

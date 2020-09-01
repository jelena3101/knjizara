/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jelena.knjizara.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author Jelena
 */
@Configuration
@Import(value = JPAConfig.class)
@ComponentScan(basePackages = {
    "com.jelena.knjizara.service"
})
public class ApplicationConfig { 
}

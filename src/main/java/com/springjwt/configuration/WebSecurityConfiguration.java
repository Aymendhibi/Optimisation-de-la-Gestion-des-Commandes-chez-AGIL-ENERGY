package com.springjwt.configuration;

import com.springjwt.filters.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfiguration{

    @Autowired
    private JwtRequestFilter requestFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/authenticate", "/sign-up", "/Station","/{stationId}","/Equipement/{stationId}","/modifieruser","/{nomS}","/{userId}","/Produit/{produitId}","/Commande/{commandeId}","/Commande/prix/{nomE}",  "/Commande/modifierQuantiteEtCalculerPrixTotal/{ligneCommandeId}/{nouvelleQuantite}" , "/Commande/ajouterProduitAuPanier/{produitId}/{quantite}","/Commande/enregistrerCommande/{commandeId}","/Produit/cat/{category}","/Produit/prix/{nomE}","/Produit/prixU/{nomE}").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/api/**","/Station/**","/{stationId}","/Equipement/**"
                        ,"/Produit/{produitId}","/Depot/**","/Commande/**","/Commande//{commandeId}","/Produit/{produitId}",
                        "/Commande/valider","/Commande/prix/{nomE}",
                        "/Commande/modifierQuantiteEtCalculerPrixTotal/{ligneCommandeId}/{nouvelleQuantite}" ,
                        "/Commande/ajouterProduitAuPanier/{produitId}/{quantite}","/Commande/enregistrerCommande/{commandeId}","/Produit/**","/Produit/prix/{nomE}","/Produit/prixU/{nomE}"
                        ,"/Produit/cat/{category}","/Produit/categories","/Reclamation/** ","/Chauffeur/**","/Chauffeur/{chauffeurId}")
                .authenticated().and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }




}

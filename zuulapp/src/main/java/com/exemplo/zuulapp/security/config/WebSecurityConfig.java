package com.exemplo.zuulapp.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.exemplo.zuulapp.security.JwtAuthenticationEntryPoint;
import com.exemplo.zuulapp.security.JwtAuthorizationTokenFilter;
import com.exemplo.zuulapp.security.service.JwtUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	 private JwtUserDetailsService jwtUserDetailsService;
	
	 @Autowired
	 private JwtAuthenticationEntryPoint unauthorizedHandler;

	 // Custom JWT based security filter
	 @Autowired
	 JwtAuthorizationTokenFilter authenticationTokenFilter;
	 
	 @Value("${jwt.header}")
	 private String tokenHeader;
	 
	 @Value("${jwt.route.authentication.path}")
	 private String authenticationPath;
	 
	 
	 @Autowired
	 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth
	            .userDetailsService(jwtUserDetailsService)
	            .passwordEncoder(passwordEncoderBean());
	    }
	 @Bean
	    public PasswordEncoder passwordEncoderBean() {
	        return new BCryptPasswordEncoder();
	    }
	 
	 @Bean
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	    @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception {
	        httpSecurity
	            // we don't need CSRF because our token is invulnerable
	            .csrf().disable()

	            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()

	            // don't create session
	            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

	            .authorizeRequests()
	            .antMatchers("/sislog/home").permitAll()
	            .antMatchers("/sislog/say").permitAll()
	            .antMatchers("/sislog/pedido/consultar").permitAll()
	            .antMatchers("/sislog/pedido/solicitar").hasRole("PARCEIRA")
	            .antMatchers("/sislog/frete/incluir").hasRole("ADMIN")
				.antMatchers("/auth/**").permitAll()
				.antMatchers("/routes/**").permitAll()
				.antMatchers("/refresh/**").permitAll()
	        	.anyRequest().authenticated();

	       httpSecurity
	            .addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

	        // disable page caching
//	        httpSecurity
//	            .headers()
//	            .frameOptions().sameOrigin()  // required to set for H2 else H2 Console will be blank.
//	            .cacheControl();
	    }

	    @Override
	    public void configure(WebSecurity web) throws Exception {
	        // AuthenticationTokenFilter will ignore the below paths
	        web
//	            .ignoring()
//	            .antMatchers(
//	                HttpMethod.POST,
//	                authenticationPath
//	            )
//
//	            // allow anonymous resource requests
//	            .and()
	            .ignoring()
	            .antMatchers(
	                HttpMethod.GET,
	                "/",
	                "/*.html",
	                "/favicon.ico",
	                "/**/*.html",
	                "/**/*.css",
	                "/**/*.js"
	            );

	            // Un-secure H2 Database (for testing purposes, H2 console shouldn't be unprotected in production)
//	            .and()
//	            .ignoring()
//	            .antMatchers("/h2-console/**/**");
	    }

/*	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.csrf().disable().authorizeRequests()
			.antMatchers("/home").permitAll()
			.antMatchers(HttpMethod.POST, "/login").permitAll()
			.anyRequest().authenticated()
			.and()
			
			// filtra requisições de login
			.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
	                UsernamePasswordAuthenticationFilter.class)
			
			// filtra outras requisições para verificar a presença do JWT no header
			.addFilterBefore(new JWTAuthenticationFilter(),
	                UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// cria uma conta default
		 BCryptPasswordEncoder encoder = passwordEncoder();
		 auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//		auth.inMemoryAuthentication()
//			.withUser("admin")
//			.password(encoder.encode("paswsord"))
//			.roles("ADMIN");
//		System.out.println(encoder.encode("password"));
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		 BCryptPasswordEncoder encoder = passwordEncoder();
		auth.inMemoryAuthentication()
		.withUser("andre").password(encoder.encode("123123")).roles("ADMIN");
	}
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/style/**");
	}
	*/
	
}

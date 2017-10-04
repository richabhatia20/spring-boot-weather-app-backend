package com.spring.weatherapp.security;



public interface UserDetailsService {

    org.springframework.security.core.userdetails.UserDetails loadByUsername(java.lang.String s)
        throws org.springframework.security.core.userdetails.UsernameNotFoundException;

}

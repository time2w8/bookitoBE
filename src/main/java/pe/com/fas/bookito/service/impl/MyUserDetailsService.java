package pe.com.fas.bookito.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import pe.com.fas.bookito.model.HsUsuario;
import pe.com.fas.bookito.model.Usuario;
import pe.com.fas.bookito.service.IHsUsuarioService;
import pe.com.fas.bookito.service.IUsuarioService;

@Component
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private IHsUsuarioService service;

	@Override
	public UserDetails loadUserByUsername(String codigo) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		HsUsuario user = service.findByCodigo(codigo);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
	    List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));

	    return new User(user.getCodigo(), user.getPassword(), authorities);
	}

}

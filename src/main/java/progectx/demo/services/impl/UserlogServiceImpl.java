package progectx.demo.services.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import progectx.demo.models.UserLog;

import progectx.demo.services.UserLogService;
@Service
public class UserlogServiceImpl implements UserLogService, UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public void save(UserLog userLog) {

    }
}

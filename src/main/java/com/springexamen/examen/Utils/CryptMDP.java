package com.springexamen.examen.Utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CryptMDP {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String crypteMDP(String motdepass){

        String motdepassCrypter = passwordEncoder.encode(motdepass);
        return motdepassCrypter;
    }

    public boolean deCrypteMDP(String motdepassLogin,String motdepass)
    {
        boolean mdpMatches = passwordEncoder.matches(motdepassLogin,motdepass);
        if (mdpMatches)
        {
            return true;
        }else {
            return false;
        }
    }
}

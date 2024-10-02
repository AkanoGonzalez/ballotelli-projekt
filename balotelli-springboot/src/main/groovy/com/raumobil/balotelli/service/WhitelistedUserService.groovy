package com.raumobil.balotelli.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.yaml.snakeyaml.Yaml

@Service
class WhitelistedUserService {

    List<String> whitelistedEmails

    @Autowired
    WhitelistedUserService() {
        loadWhitelistedUsers()
    }

    private void loadWhitelistedUsers() {
        Yaml yaml = new Yaml()
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("whitelisted_users.yml")
        Map<String, Object> obj = yaml.load(inputStream)
        whitelistedEmails = obj?.emails ?: []
    }

    boolean isWhitelisted(String email) {
        return whitelistedEmails.contains(email)
    }
}

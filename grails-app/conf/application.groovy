// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.manifest.corp.Security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.manifest.corp.Security.UserRole'
grails.plugin.springsecurity.authority.className = 'com.manifest.corp.Security.Role'


grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/assets/**',      filters: 'none'],
        [pattern: '/**/js/**',       filters: 'none'],
        [pattern: '/**/css/**',      filters: 'none'],
        [pattern: '/**/images/**',   filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/**',             filters: 'JOINED_FILTERS']
]

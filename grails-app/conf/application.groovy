// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.manifest.Security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.manifest.Security.UserRole'
grails.plugin.springsecurity.authority.className = 'com.manifest.Security.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/**',         access: ['IS_AUTHENTICATED_FULLY']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/assets/**',      filters: 'none'],
        [pattern: '/**/js/**',       filters: 'none'],
        [pattern: '/**/css/**',      filters: 'none'],
        [pattern: '/**/images/**',   filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/**',             filters: 'JOINED_FILTERS']
]

<!doctype html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Hooplog"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="shortcut icon" href="${grailsApplication.config.cloudfront.cdn.url}${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
    <link href='http://fonts.googleapis.com/css?family=Frijole' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="${grailsApplication.config.cloudfront.cdn.url}${resource(dir: 'css', file: 'bootstrap.css')}">
    <style type="text/css">
    body {
        padding-top: 80px;
    }
    ul {
        list-style: none;
    }
    a:link, a:visited {
        color: #a300ff;
        padding: 14px 25px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
    }


    a:hover, a:active {
        background-color: #59a3f4;
    }
    </style>
    <script type="text/javascript" src="${grailsApplication.config.cloudfront.cdn.url}${resource(dir: 'js', file: 'jquery-1.7.1.js')}"></script>
    <g:layoutHead/>
</head>
<body style="background-color: #000202;">
<div class="topbar">
    <div class="topbar-inner">
        <div class="container-fluid" style="background-color: #000202;">
            <g:link class="brand" controller="home">
                <div style="font-family: Monaco;font-size: 90px;color:#00ffff; background-color: #020101">HOOPLOG</div>
                <div style="font-size:12px; color: #e8ffe2; background-color: #000202">When you need some hooplah in your life</div>
            </g:link>
            <ul class="nav" style="padding-top:27px;padding-left:20px;">
                <li id="homeTab">
                    <g:link controller="home">
                        Home
                    </g:link>
                </li>
                <li id="postsTab">
                    <g:link controller="entry" action="list">
                        All Posts
                    </g:link>
                </li>
                <li id="aboutTab">
                    <g:link controller="about" action="index">About</g:link>
                </li>
            </ul>
            <ul style="padding-top:27px;float:right;">
                <sec:ifLoggedIn>
                    <li style="color:#99BF38;padding-top:10px;">
                        Your signed in as <sec:loggedInUserInfo field="username"/>
                    <li>
                    <li>
                        <g:link action="index" controller="logout">Logout</g:link>
                    </li>
                </sec:ifLoggedIn>
                <sec:ifNotLoggedIn>
                    <li>
                        <g:link action="auth" controller="login">Login</g:link>
                    </li>
                </sec:ifNotLoggedIn>
            </ul>
        </div>
    </div>
</div>
<g:layoutBody/>
<script type="text/javascript" src="${grailsApplication.config.cloudfront.cdn.url}${resource(dir: 'js', file: 'application.js')}"></script>
</body>
</html>
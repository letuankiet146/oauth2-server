# oauth2-server
This project use to learning about the oauth2. Using the Spring framework to create an authorization server (<b>Authorization Code type</b>). It use the <a href='https://github.com/letuankiet146/demo-spring-boot'>Demo Spring boot</a> as the client in order to consume.<br>
<h3>Command to exchange token from code</h3>
<code>
curl localhost:8000/oauth2/token \
 -H"Content-type: application/x-www-form-urlencoded" \
 -d"grant_type=authorization_code" \
 -d"redirect_uri=http://127.0.0.1:9090/login/oauth2/code/taco-admin-client"\
 -d"code=YUKU3zmLN-62YjRndmhBoAAL0vmVtuYFwJOMUf7U353o6R2hAlKkjAjvYEMGs1Cdkh9JPKqc-ly5hxwxflVhiZkmhJuLkHMtvXg4jqNjFd1WjL-u5GQU_tBGs9RkXrgO" \
 -u taco-admin-client:secret
</code>

<h3>Command to refresh token</h3>
<code>
  curl localhost:8000/oauth2/token \
    -H"Content-type: application/x-www-form-urlencoded" \
    -d"grant_type=refresh_token&refresh_token=CUxsI5S2vGvhn9nUo21QRVa8sk_hi-AyEiThCBoVT-2gYm7DgaMys8TQ4EnFR05EKByjKR_u8EsrYRxEYUzVvVNsc68tfbEjcoKDVht_xQ78hj0CYJwt5RI3NOTHx8gv" \
    -u taco-admin-client:secret
</code>

<h3>Command to test as client</h3>
<code>
  curl localhost:8080/api/ingredients \
  -H"Content-type: application/json" \
  -H"Authorization: Bearer eyJraWQ..." \
  -d'{"id":"FISH","name":"Stinky Fish", "type":"PROTEIN"}'
</code>

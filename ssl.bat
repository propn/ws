set SERVER_DN="CN=Server, OU=ec, O=ec, L=nanchang, S=jiangxi, C=CN"
set CLIENT_DN="CN=Client, OU=ec, O=ec, L=nanchang, S=jiangxi, C=CN"
set KS_PASS=-storepass strongit
set KEYINFO=-keyalg RSA

#create server private Key
keytool -genkey -alias Server -dname %SERVER_DN% %KS_PASS% -keystore server.keystore %KEYINFO% -keypass strongit

# export server cert
keytool -export -alias Server -file server.cer %KS_PASS% -keystore server.keystore

# import server cert to client trust store
keytool -import -file server.cer %KS_PASS% -keystore client.truststore -alias serverkey -noprompt

# create client private key
keytool -genkey -alias Client -dname %CLIENT_DN% %KS_PASS% -keystore client.keystore %KEYINFO% -keypass strongit

# export client cert
keytool -export -alias Client -file client.cer %KS_PASS% -keystore client.keystore

# import client cert to server trust store
keytool -import -file client.cer %KS_PASS% -keystore server.truststore -alias clientkey -noprompt
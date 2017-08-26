**Small set of instructions to use the lab**

A compiled version of this app is presented with public access at https://s3.amazonaws.com/partner-factory-udi/aws-demo-1.0.war

**Sample User Data**

```
#!/bin/bash
mkdir /var/myapp
cd /var/myapp
wget https://s3.amazonaws.com/partner-factory-udi/aws-demo-1.0.war
chmod +x aws-demo-1.0.war
 
mkdir config
echo "spring.datasource.url: jdbc:mysql://<<RDS_HOSTNAME>>:3306/<<DATABASE>>" > config/application.properties
echo "spring.datasource.username: <<USERNAME>>" >> config/application.properties
echo "spring.datasource.password: <<PASSWORD>>" >> config/application.properties
 
ln -s /var/myapp/aws-demo-1.0.war /etc/init.d/myapp
chkconfig --add myapp
chkconfig myapp on

service myapp start
``` 
# MySQL Intallation Guide on RHEL 9

```shell
#Install MySQL server packages
dnf install mysql-server

#Start the mysqld service:
systemctl start mysqld.service

#Enable the mysqld service to start at boot
systemctl enable mysqld.service

#Recommended: To improve security when installing MySQL, run the following command:
mysql_secure_installation


```


- Verify status of Mysql

```shell
    sudo systemctl status mysqld
```

- Connect to Mysql server: The basic command to connect to a local MySQL server is:

```shell
    #default username=root pwd=  empty string
    mysql -u <username> -p
```

- Connecting to a Remote MySQL Server.
- If the MySQL server is on a different host, you need to specify the hostname or IP address using the -h option:

```shell
    mysql -h <hostname_or_ip> -u <username> -p
```


- Upon successful authentication, you will see the ``mysql> ``prompt, indicating that you are connected to the MySQL server and can execute SQL queries.
- To list databases: `SHOW DATABASES;`
- To select a database: `USE <database_name>;`
- To exit the MySQL client: `\q or exit`
#### Source:

1. https://docs.redhat.com/fr/documentation/red_hat_enterprise_linux/9/html/configuring_and_using_database_servers/installing-mysql_assembly_using-mysql


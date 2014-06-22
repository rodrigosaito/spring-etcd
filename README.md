Spring Etcd example
==========

This is an example Spring application that extends PropertyPlaceholderConfigurer to resolve properties from an etcd server.

Running application
-----

 Run project:

```
./gradle run
```

The application will listen on port 8080.

You can execute the following curl:

```
curl http://localhost:8080/config1
curl http://localhost:8080/config2
```

If you have a running etcd server you can set the following properties:

```
etcdctl set testApp/config1 "Config1"
etcdctl set testApp/config2 "123" # this should be an integer
```

After restarting spring application the new values should be returned, when executing curl commands above.

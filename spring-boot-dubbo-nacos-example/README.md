## spring boot dubbo nacos example

start up two application,view on nacos server home page and turn to "services management",
the following table would be show:

| service name | group | cluster counts |
| :---:|:----:|:----:|
|consumers:com.lcg.example.UserService:: | DEFAULT_GROUP | 1|
|consumers:com.lcg.example.EchoService:: | DEFAULT_GROUP | 1|
|providers:com.lcg.example.UserService:: | DEFAULT_GROUP | 1|
|providers:com.lcg.example.EchoService:: | DEFAULT_GROUP | 1|
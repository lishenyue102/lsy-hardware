技术栈:  
&emsp;服务调用：OpenFeign  
&emsp;注册中心：Nacos  
&emsp;缓存：Redis  
&emsp;权限：Spring Security

sql模块：如果把dao层放进去，就需要注解，那么需要添加spring依赖，失去分离的意义  
以api为暴露点，以后可能存在小程序、web等等，应当都依赖api

@EnableDiscoveryClient Nacos注册中心用  
@EnableFeignClients OpenFeign用,仅仅**服务调用方**用即可
@FeignClient("服务名") 这个名称给负载均衡用
@EnableRedisHttpSession 启用基于Redis的HttpSession实现  

Spring-security应当在入口处依赖




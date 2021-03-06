技术栈:
    服务调用：OpenFeign
    注册中心：Nacos

sql模块：如果把dao层放进去，就需要注解，那么需要添加spring依赖，失去分离的意义
以api为暴露点，以后可能存在小程序、web等等，应当都依赖api

@EnableDiscoveryClient Nacos注册中心用
@EnableFeignClients OpenFeign用,仅仅**服务调用方**用即可
@FeignClient("服务名") 这个名称给负载均衡用




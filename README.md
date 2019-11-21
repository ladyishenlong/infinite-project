# infinite-project 
- 本项目使用consul作为注册中心，可以使用docker部署
- 配置了consul作为注册中心的项目，如果consul没有起来，启动的时候会报错导致无法启动

## infinite-gateway 10000 
- webflux gateway 网关
- 配合注册中心使用实现反向代理，限流等功能

## test-service 10001
- 用于测试的服务

## security-session-service 10002
- spring security 使用sessionId作为登录凭证

## security-jwt-service 10003
- spring security使用jew token作为登录凭证
- token与session相比无需再后台储存信息，属于无状态

## swagger-server 10004
- swagger2配置生成在线api
- json数据获取 http://localhost:10004/v2/api-docs
- markup可以生成静态文档（还没集成）
- v2

## knockout-web 10005
- 使用knockout 前端框架

## springdoc-openapi-web 10006
- https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Annotations
- springdoc-openapi 尝试集成
- 之后有空尝试webflux集成
- openapi 3.0
- /v3/api-docs  


//连个oauth2项目还有问题
## oauth2-auth-service 10007
- oauth2 认证服务器

## oauth2-resource-service 10008
- oauth2 资源服务器

## data-jpa-dto 10009
- jpa 查询服务器
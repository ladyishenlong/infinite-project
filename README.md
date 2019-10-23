# infinite-project 
- 本项目使用consul作为注册中心，可以使用docker部署

## infinite-gateway 10000 
- webflux gateway 网关
- 配合注册中心使用实现反向代理，限流等功能

## test-service 10001
- 用于测试的服务

## security-session-service 10002
- spring security 使用sessionId作为登录凭证
//package org.dows.project.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.task.AsyncTaskExecutor;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.web.servlet.config.annotation.*;
//
//import java.time.format.DateTimeFormatter;
//
///**
// * Web配置类
// *
// * @author dows
// * @version 1.0.0
// */
//@RequiredArgsConstructor
//@Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
//
////    private final CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver;
////
////    @Override
////    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
////        argumentResolvers.add(currentUserMethodArgumentResolver);
////    }
//    @Bean(name = "applicationTaskExecutor")
//    public AsyncTaskExecutor taskExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        // 核心线程数
//        executor.setCorePoolSize(10);
//        // 最大线程数
//        executor.setMaxPoolSize(50);
//        // 队列容量
//        executor.setQueueCapacity(100);
//        // 线程名称前缀
//        executor.setThreadNamePrefix("Async-Executor-");
//        // 线程存活时间（秒）
//        executor.setKeepAliveSeconds(60);
//        // 拒绝策略：当线程池和队列都满时，由调用线程处理
//        executor.setRejectedExecutionHandler((runnable, executor1) -> {
//            try {
//                // 尝试将任务放入队列，等待1秒
//                executor1.getQueue().offer(runnable, 1, java.util.concurrent.TimeUnit.SECONDS);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        });
//        // 初始化线程池
//        executor.initialize();
//        return executor;
//    }
//
//    @Override
//    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//        // 配置异步任务执行器
//        configurer.setTaskExecutor(taskExecutor());
//        // 设置异步请求超时时间（毫秒）
//        configurer.setDefaultTimeout(30000);
//    }
//
//
//
//    /**
//     * 允许匿名访问的静态资源路径列表
//     */
//    public static final String[] STATIC_WITHE_PATH_LIST = new String[]{
//            "/",
//            "/js/**",
//            "/css/**",
//            "/img/**",
//            "/fonts/**",
//            "/index.html",
//            "/favicon.ico",
//            "/doc.html",
//            "/swagger-ui.html",
//            "/swagger-ui/**",
//            "/webjars/**",
//            "/swagger-resources/**",
//            "/v3/**",
//            "/.well-known/**"
//    };
//
//    /**
//     * 允许匿名访问的静态资源存放位置列表
//     */
//    public static final String[] STATIC_WITHE_LOCATION_LIST = new String[]{
//            "classpath:/static/**",
//            "classpath:/js/**",
//            "classpath:/public/**",
//            "classpath:/META-INF/resources/**",
//            "classpath:/META-INF/resources/webjars/swagger-ui/"
//    };
//
//
//    /**
//     * 配置异步支持，解决Spring MVC默认SimpleAsyncTaskExecutor不适合生产环境的警告
//     */
//    /*@Override
//    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//        // 使用自定义的线程池代替默认的SimpleAsyncTaskExecutor
//        configurer.setTaskExecutor(threadPoolExecutor);
//        // 设置异步请求的超时时间（毫秒）
//        configurer.setDefaultTimeout(30000);
//    }*/
//
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
//        registrar.setDateTimeFormatter(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        registrar.registerFormatters(registry);
//    }
//    /**
//     * 配置CORS跨域
//     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        /*registry.addMapping("/**")
//                // 允许局域网IP网段访问
//                .allowedOrigins("http://10.0.71.*:8080/")
//                .allowedOriginPatterns("*")
//                //.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                .allowedMethods("*")
//                .allowedHeaders("*")
//                .allowCredentials(true)
//                .maxAge(3600);*/
//        // 允许所有路径（包括Swagger的接口路径，如/v3/api-docs、/swagger-ui等）
//        registry.addMapping("/**")
//                // 允许局域网内所有IP访问（开发环境可直接用"*"，生产环境需指定具体IP）
//                //.allowedOrigins("*")
//                .allowedOriginPatterns("*")
//                // 允许所有HTTP方法（GET、POST、PUT、DELETE等）
//                .allowedMethods("*")
//                // 允许所有请求头
//                .allowedHeaders("*")
//                // 允许携带凭证（如Cookie，若前端需要则开启）
//                .allowCredentials(true)
//                // 预检请求的缓存时间（避免频繁预检，单位：秒）
//                .maxAge(3600);
//    }
//
//    /**
//     * 配置静态资源处理
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//        // 静态资源映射
//        /*registry.addResourceHandler(STATIC_WITHE_PATH_LIST)
//                .addResourceLocations(STATIC_WITHE_LOCATION_LIST);*/
//
//        // 放行 Knife4j 首页（doc.html）
//        registry.addResourceHandler("/doc.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        // Swagger UI 静态资源
//        registry.addResourceHandler("/swagger-ui/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/swagger-ui/");
//
//        //放行 Knife4j 依赖的 webjars 资源（js、css、图标等）
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//
//        // 放行 OpenAPI 接口文档数据（Knife4j 会请求该路径获取接口信息）
//        registry.addResourceHandler("/v3/api-docs/**")
//                .addResourceLocations("classpath:/META-INF/resources/");
//    }
//
//
//    // 2. 若项目有自定义拦截器，需排除 Knife4j 路径（避免拦截）
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 添加自定义拦截器
//        /*registry.addInterceptor(new MyInterceptor())
//                .excludePathPatterns(
//                        "/doc.html",
//                        "/webjars/**",
//                        "/v3/api-docs/**"
//                );*/
//    }
//}
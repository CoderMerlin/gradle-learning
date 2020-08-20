# gradle-learning

## 为什么要学习Gradle

## 项目结构

--- gradle-learning
   -- hm-cms
   -- hm-platform
      -- hm-platform-web
      -- hm-platform-business
      -- hm-platform-common

hm-cms与hm-platform同级


// 添加构建插件 ,方式一
plugins {
    id 'org.springframework.boot' version '2.2.9.RELEASE'
    id 'io.spring.dependency-management' version '1.0.9.RELEASE'
}

//添加插件，方式二
apply plugin: 'java'
apply plugin: "idea"

configurations {
    //定义
    developmentOnly
    runtimeClasspath {
        extendsFrom developmentOnly
    }
    compileOnly {
        extendsFrom annotationProcessor
    }
}

// 定制项目
//jdk版本
sourceCompatibility = 1.8
//编码
[compileJava,compileTestJava,javadoc]*.options*.encoding = 'UTF-8'
//项目版本
version = '1.0'
// 设置全局变量
group = 'com.hm.platform'
//项目版本
version = '0.0.1-SNAPSHOT'






// 用于搜索以解决项目依赖关系的仓库地址
repositories {
    mavenCentral()
}


//## 闭包
ext {
    set('springCloudAlibabaVersion', "2.2.1.RELEASE")
}

// 添加项目依赖
dependencies {
    //implementation()定义编译时所需的依赖项。此配置方法称为compile。
    //testImplementation()并定义了仅用于测试（旧testCompile）所需的依赖项。
    //runtimeOnly和testRuntimeOnly。这声明了运行时提供的不需要对其进行编译的依赖项。
    implementation 'org.springframework.boot:spring-boot-starter-security'
    implementation 'org.springframework.boot:spring-boot-starter-webflux'
    implementation 'com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config'
    implementation 'com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery'
    implementation 'com.alibaba.cloud:spring-cloud-starter-alibaba-sentinel'
    compileOnly 'org.projectlombok:lombok'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    annotationProcessor 'org.springframework.boot:spring-boot-configuration-processor'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation('org.springframework.boot:spring-boot-starter-test') {
        exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
    }
    testImplementation 'io.projectreactor:reactor-test'
    testImplementation 'org.springframework.security:spring-security-test'


}


dependencyManagement {
    imports {
        mavenBom "com.alibaba.cloud:spring-cloud-alibaba-dependencies:${springCloudAlibabaVersion}"
    }
}
test {
    useJUnitPlatform()
}


//使用仓库
repositories {
    //第三方仓库
    maven{url 'http://maven.aliyun.com/nexus/content/groups/public/'}
    //maven中央仓库
    mavenCentral()
    jcenter()
}
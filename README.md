#springboot_hotdeploy
#1 参考视频来源:https://www.imooc.com/video/16070


#2 热部署的两种方式:
    + 通过插件(springloaded)
        见pom.xml
        <build>
            <plugins>
                <plugin>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-maven-plugin</artifactId>
                    <configuration>
                        <fork>true</fork>
                    </configuration>
                    <dependencies>
                        <dependency>
                            <groupId>org.springframework</groupId>
                            <artifactId>springloaded</artifactId>
                            <version>1.2.8.RELEASE</version>
                            <optional>true</optional>
                        </dependency>
                    </dependencies>
                </plugin>
            </plugins>
        </build>

        + 运行方式:
            * 我的运行方式:控制台->pom.xml所在路径->mvn spring-boot:run
            + 做为application运行
                * 需要添加VM options:-javaagent:/home/liux/.m2/repository/org/springframework/springloaded/1.2.8.RELEASE/springloaded-1.2.8.RELEASE.jar -noverify

    + 使用dev-tools
        见pom.xml::spring-boot-devtools
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter</artifactId>
            </dependency>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-web</artifactId>
            </dependency>
            <!--<dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-devtools</artifactId>
                <optional>true</optional>
            </dependency>-->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-tomcat</artifactId>
                <optional>true</optional>
            </dependency>
        
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-test</artifactId>
                <scope>test</scope>
            </dependency>
        </dependencies>


#打包方式
    + jar包,默认打包方式
        * mvn clean package
        * java -jar target/?.jar
        * 访问路径:http://localhost:8080/hello

    + war包
        * 修改SpringbootHotdeployApplication,extends SpringBootServletInitializer
            重写configure方法,相见代码
        * mvn clean package
        * 把生成war包拷入tomcat/webapps,启动tomcat
        * 访问路径:http://localhost:8080/war包名称/hello
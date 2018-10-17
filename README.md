# Scheduler-Quartz-JAR-maven
http://www.quartz-scheduler.org/

POM FILE - CREATE JAR - QUARTZ Scheduler




    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <mainClass>com.mycompany.mavenproject1.SimpleExample</mainClass>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>
    
    <build>
      <plugins>
          <plugin>
              <artifactId>maven-dependency-plugin</artifactId>
              <version>
                  2.4
              </version>
              <executions>
                  <execution>
                      <phase>install</phase>
                      <goals>
                          <goal>copy-dependencies</goal>
                      </goals>
                      <configuration>
                          <outputDirectory>${project.build.directory}/lib</outputDirectory>
                      </configuration>
                  </execution>
              </executions>
          </plugin>
          <plugin>
              <artifactId>maven-jar-plugin</artifactId>
              <version>
                  2.4
              </version>
              <configuration>
                  <archive>
                      <manifest>
                          <addClasspath>true</addClasspath>
                          <classpathPrefix>lib/</classpathPrefix>
                          <mainClass>${mainClass}</mainClass>
                      </manifest>
                  </archive>
              </configuration>
          </plugin>
      </plugins>
    </build>
    

package library.lgx.weixin.library;

import org.apache.tomcat.jni.Library;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {
	public static void mian(String[] args) {
		SpringApplication.run(Library.class, args);
	}
}

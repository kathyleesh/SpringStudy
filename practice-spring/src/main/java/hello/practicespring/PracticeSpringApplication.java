package hello.practicespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//preferences에서 Gradle >> Build and Run을 모두 IntelliJ로 변경하면 빠르게 run 가능

@SpringBootApplication
public class PracticeSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeSpringApplication.class, args);
	}

}

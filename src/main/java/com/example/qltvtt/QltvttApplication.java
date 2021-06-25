package com.example.qltvtt;


import com.example.qltvtt.entity.Account;
import com.example.qltvtt.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@RequiredArgsConstructor
//@ComponentScan("com.example.qltvtt")
public class QltvttApplication  {
//    private static final Logger LOGGER = LoggerFactory.getLogger(QltvttApplication.class);
//    //UserRepository repo;
    public static void main(String[] args) {
//        LOGGER.info(">>> Entered application...");
        ApplicationContext context = SpringApplication.run(QltvttApplication.class, args);
        System.out.println("Mời truy cập địa chỉ dưới đây:");
        System.out.println("http://localhost:1999");

//        BookRepository bookRepository = context.getBean(BookRepository.class);
//        bookRepository.findAll().forEach(System.out::println);
//
//        UserRepository userRepository = context.getBean(UserRepository.class);
//        userRepository.findAll().forEach(System.out::println);
//
//        Book book = bookRepository.save(new Book());
//        book.nhapsach();
//        System.out.println("Book vừa lưu có ID: "+book.getBookId());
//        Long bookID = book.getBookId();
//        bookRepository.save(book);

    }
//    @Bean
//    public WebMvcConfigurer CORSConfig() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/api/v1/**");
//            }
//        };
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        List<docgia> docgias = repo.findAll();
//        docgias.forEach(System.out::println);
//    }
    }


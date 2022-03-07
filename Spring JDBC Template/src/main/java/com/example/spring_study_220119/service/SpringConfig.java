package com.example.spring_study_220119.service;

import com.example.spring_study_220119.repository.JdbcMemberRepository;
import com.example.spring_study_220119.repository.JdbcTemplateMemberRepository;
import com.example.spring_study_220119.repository.MemberRepository;
import com.example.spring_study_220119.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
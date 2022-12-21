package com.globalit.account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

  @GetMapping("/sign-up")
  public String signUpForm(Model model){
    // account/sign-up 으로 이동할 때,
    // SignUpForm 객체를 생성해서
    // signUpFrom 이라는 변수에 할당해서 넘김
    // SignUpForm signUpForm = new SignUpForm();
    // model.addAttribute(변수, 객체) 메소드에 변수와 SignUpForm 객체를
    // argument 로 넣어서 호출하면 SignUpForm 객체의 주소를
    // signUpForm 이라는 변수(이름)에 할당하고
    // signUpForm 이라는 변수(이름)를 메모리에 올림
    model.addAttribute("signUpForm", new SignUpForm());
    return "account/sign-up";

    // account/sign-up.html 로 이동한 후
    // account/sign-up.html 의 th:object="${signUpForm}" 부분을 작성하면
    // 메모리에 올라간 signUpForm 변수(이름)을 찾음
    // 이 변수를 메모리에 찾게 되면
    // th:field="*{nickname}", th:field="*{email}", th:field="*{password}"
    // 에서 .... 사용자가 회원 가입하면서 화면에 입력하는 내용들이
    // signUpForm 변수(이름)(SignUpForm 객체) 의 멤버변수
    // nickname, email, password 에 저장됨
  }


}
